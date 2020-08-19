package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class ObterClienteAssento {
	
	public static void main(String[] args) {
			
		//buscando cliente em determinado assento
		DAO<Cliente> daoCliente = new DAO<>(Cliente.class);
		Cliente cliente = daoCliente.obter(1L);
		System.out.println(cliente.getAssento().getNome());
		daoCliente.fechar();
		
		DAO<Assento> daoAssento = new DAO<>(Assento.class);
		Assento assento = daoAssento.obter(4L);
		System.out.println(assento.getCliente().getNome());
		daoAssento.fechar();
		
	}

}
