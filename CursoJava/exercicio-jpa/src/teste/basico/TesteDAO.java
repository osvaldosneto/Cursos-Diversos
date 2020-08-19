package teste.basico;

import java.util.List;

import infra.DAO;
import modelo.basico.Produto;

public class TesteDAO {
	
	public static void main(String[] args) {
		
		DAO<Produto> dao = new DAO<>(Produto.class);
		
		
		//Produto p1 = dao.obter(6L);
		
		//System.out.println(p1.getNome());

		//dao.removerItemAtomico(p1);
		
		dao.remover(11L);
		
		
	}

}
