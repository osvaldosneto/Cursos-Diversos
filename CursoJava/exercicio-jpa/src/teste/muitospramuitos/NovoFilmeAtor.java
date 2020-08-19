package teste.muitospramuitos;

import infra.DAO;
import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.Filme;

public class NovoFilmeAtor {
	
	public static void main(String[] args) {
		
		Filme filmeA = new Filme("Star", 8.7);
		Filme filmeB = new Filme("Cascade", 9.2);
		
		Ator atora = new Ator("Harry");
		Ator atorb = new Ator("Carrie");
		
		filmeA.adicionarAtor(atora);
		filmeA.adicionarAtor(atorb);
		
		DAO<Filme> dao = new DAO<Filme>();
		
		dao.incluirAtomico(filmeA);
		
		
		
	}

}
