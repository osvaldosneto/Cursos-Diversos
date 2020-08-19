package teste.umpramuitos;

import infra.DAO;
import modelo.umpramuitos.ItemPedido;
import modelo.umpramuitos.Pedido;

public class ObterPedido {
	public static void main(String[] args) {
		
		DAO<Pedido> dao = new DAO<>(Pedido.class);
		
		//capturando os pedidos do item
		Pedido pedido = dao.obter(1L);
		
		for(ItemPedido item : pedido.getItens()) {
			System.out.println(item.getQuantidade() + " - " + item.getPreco());
			System.out.println(item.getProduto().getNome());
		}
		
		dao.fechar();
	}
}
