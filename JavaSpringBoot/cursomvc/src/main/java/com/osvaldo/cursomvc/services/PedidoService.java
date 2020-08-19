package com.osvaldo.cursomvc.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osvaldo.cursomvc.domain.ItemPedido;
import com.osvaldo.cursomvc.domain.PagamentoComBoleto;
import com.osvaldo.cursomvc.domain.Pedido;
import com.osvaldo.cursomvc.domain.enums.EstadoPagamento;
import com.osvaldo.cursomvc.repositories.ItemPedidoRepository;
import com.osvaldo.cursomvc.repositories.PedidoRepository;
import com.osvaldo.cursomvc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private ProdutoServico produtoService;
	
	@Autowired
	private ItemPedidoRepository itemRepo;
	
	public Pedido find(Long id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		//verificação boleto ou cartão
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repo.save(obj);
		for(ItemPedido ip : obj.getItens()) {
			ip.setPedido(obj);
			ip.setDesconto(0.0);
			ip.setProduto(produtoService.find(ip.getProduto().getId()));
			ip.setPreco(ip.getProduto().getPreco());
		}
		itemRepo.saveAll(obj.getItens());
		return obj;
	}

}
