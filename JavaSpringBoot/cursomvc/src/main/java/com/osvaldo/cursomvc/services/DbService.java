package com.osvaldo.cursomvc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osvaldo.cursomvc.domain.Categoria;
import com.osvaldo.cursomvc.domain.Cidade;
import com.osvaldo.cursomvc.domain.Cliente;
import com.osvaldo.cursomvc.domain.Endereco;
import com.osvaldo.cursomvc.domain.Estado;
import com.osvaldo.cursomvc.domain.ItemPedido;
import com.osvaldo.cursomvc.domain.Pagamento;
import com.osvaldo.cursomvc.domain.PagamentoComBoleto;
import com.osvaldo.cursomvc.domain.PagamentoComCartao;
import com.osvaldo.cursomvc.domain.Pedido;
import com.osvaldo.cursomvc.domain.Produto;
import com.osvaldo.cursomvc.domain.enums.EstadoPagamento;
import com.osvaldo.cursomvc.domain.enums.TipoCliente;
import com.osvaldo.cursomvc.repositories.CategoriaRepository;
import com.osvaldo.cursomvc.repositories.CidadeRepository;
import com.osvaldo.cursomvc.repositories.ClienteRepository;
import com.osvaldo.cursomvc.repositories.EnderecoRepository;
import com.osvaldo.cursomvc.repositories.EstadoRepository;
import com.osvaldo.cursomvc.repositories.ItemPedidoRepository;
import com.osvaldo.cursomvc.repositories.PagamentoRepository;
import com.osvaldo.cursomvc.repositories.PedidoRepository;
import com.osvaldo.cursomvc.repositories.ProdutoRepository;

@Service
public class DbService {

	@Autowired
	private CategoriaRepository catRep;
	@Autowired
	private ProdutoRepository prodRep;
	@Autowired
	private EstadoRepository estRep;
	@Autowired
	private CidadeRepository cidadeRep;
	@Autowired
	private ClienteRepository cliRep;
	@Autowired
	private EnderecoRepository endRep;
	@Autowired
	private PedidoRepository pedRep;
	@Autowired
	private PagamentoRepository pagRep;
	@Autowired
	private ItemPedidoRepository itemRep;

	public void instanciateTestDatabase() throws ParseException {

		Categoria cat1 = new Categoria("Informática");
		Categoria cat2 = new Categoria("Escritório");
		Categoria cat3 = new Categoria("Cama mesa e banho");
		Categoria cat4 = new Categoria("Eletrônicos");
		Categoria cat5 = new Categoria("Jardinagem");
		Categoria cat6 = new Categoria("Decoração");
		Categoria cat7 = new Categoria("Perfumaria");

		Produto p1 = new Produto("Computador", 2000.00);
		Produto p2 = new Produto("Impressora", 800.00);
		Produto p3 = new Produto("Mouse", 80.00);
		Produto p4 = new Produto("Mesa escritório", 300.00);
		Produto p5 = new Produto("Toalha", 50.00);
		Produto p6 = new Produto("Colcha", 200.00);
		Produto p7 = new Produto("Tv true color", 1200.00);
		Produto p8 = new Produto("Roçadeira", 800.00);
		Produto p9 = new Produto("Abajour", 100.00);
		Produto p10 = new Produto("Pendente", 180.00);
		Produto p11 = new Produto("Shampoo", 90.00);

		cat1.getProdutos().add(p1);
		cat1.getProdutos().add(p2);
		cat1.getProdutos().add(p3);

		cat2.getProdutos().add(p2);
		cat2.getProdutos().add(p4);

		cat3.getProdutos().add(p5);
		cat3.getProdutos().add(p6);

		cat4.getProdutos().add(p1);
		cat4.getProdutos().add(p2);
		cat4.getProdutos().add(p3);
		cat4.getProdutos().add(p7);

		cat5.getProdutos().add(p8);

		cat6.getProdutos().add(p9);
		cat6.getProdutos().add(p10);

		cat7.getProdutos().add(p11);

		p1.getCategorias().add(cat1);
		p1.getCategorias().add(cat4);

		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);

		p3.getCategorias().add(cat1);
		p3.getCategorias().add(cat4);

		p4.getCategorias().add(cat2);

		p5.getCategorias().add(cat3);

		p6.getCategorias().add(cat3);

		p7.getCategorias().add(cat4);

		p8.getCategorias().add(cat5);

		p9.getCategorias().add(cat6);

		p10.getCategorias().add(cat6);

		p11.getCategorias().add(cat7);

		catRep.save(cat1);
		catRep.save(cat2);
		catRep.save(cat3);
		catRep.save(cat4);
		catRep.save(cat5);
		catRep.save(cat6);
		catRep.save(cat7);
		prodRep.save(p1);
		prodRep.save(p2);
		prodRep.save(p3);
		prodRep.save(p4);
		prodRep.save(p5);
		prodRep.save(p6);
		prodRep.save(p7);
		prodRep.save(p8);
		prodRep.save(p9);
		prodRep.save(p10);
		prodRep.save(p11);

		// criando estados e cidades
		Estado est1 = new Estado("Minas Gerais");
		Estado est2 = new Estado("São Paulo");
		// criando cidades
		Cidade c1 = new Cidade("Uberlândia", est1);
		Cidade c2 = new Cidade("São Paulo", est2);
		Cidade c3 = new Cidade("Campinas", est2);

		est1.getCidades().add(c1);
		est2.getCidades().add(c2);
		est2.getCidades().add(c3);

		estRep.save(est1);
		estRep.save(est2);

		cidadeRep.save(c1);
		cidadeRep.save(c2);
		cidadeRep.save(c3);

		// instanciando clientes telefones e enderecos
		Cliente cli1 = new Cliente("Maria Silva", "maria@gmail.com", "00908999880", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().add("34434332");
		cli1.getTelefones().add("99888909");

		Endereco e1 = new Endereco("Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco("Avenida Matos", "105", "Sala 1433", "Centro", "87549565", cli1, c2);

		cli1.getEnderecos().add(e1);
		cli1.getEnderecos().add(e2);

		cliRep.save(cli1);
		endRep.save(e1);
		endRep.save(e2);

		// incluindo pedidos e lista de pedidos
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(sdf.parse("10/09/2019 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(sdf.parse("10/12/2019 10:32"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(EstadoPagamento.PENDENTE, ped2, sdf.parse("15/10/2019 12:00"), null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().add(ped1);
		cli1.getPedidos().add(ped2);

		pedRep.save(ped1);
		pedRep.save(ped2);

		pagRep.save(pagto1);
		pagRep.save(pagto2);

		// incluindo item pedido
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().add(ip1);
		ped1.getItens().add(ip2);

		ped2.getItens().add(ip3);

		p1.getItens().add(ip1);
		p2.getItens().add(ip3);
		p3.getItens().add(ip2);

		itemRep.save(ip1);
		itemRep.save(ip2);
		itemRep.save(ip3);

	}

}
