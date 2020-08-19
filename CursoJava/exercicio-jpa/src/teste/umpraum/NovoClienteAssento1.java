package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento1 {
	
	public static void main(String[] args) {
		
		Assento a1 = new Assento("8L");
		
		Cliente cliente = new Cliente("Carlos", a1);
		
		DAO<Object> dao = new DAO();
		
		dao.abrirTransacao()
			.incluir(a1)
			.incluir(cliente)
			.fecharTransacao()
			.fechar();
	}

}
