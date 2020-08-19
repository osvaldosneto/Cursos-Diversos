package teste.basico;

import java.util.List;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {
	
	public static void main(String[] args) {
		
		DAO<Produto> dao = new DAO<>(Produto.class);
		
		Produto p1 = new Produto("Tv", 1342.42);
		Produto p2 = new Produto("Macbook", 4342.42);


	//abrindo incluindo e fechando a transaçao
		dao.abrirTransacao().incluir(p1).fecharTransacao();
		
		dao.incluirAtomico(p2);
		
		
		List<Produto> produto = dao.obterTodos();
		
		for(Produto p : produto) {
			System.out.println(p.getNome() + " - " + p.getPreco());
		}
		
	}

}
