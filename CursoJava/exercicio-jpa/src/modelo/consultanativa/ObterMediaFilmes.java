package modelo.consultanativa;

import infra.DAO;
import modelo.muitospramuitos.Filme;

public class ObterMediaFilmes {
	
	public static void main(String[] args) {
		
		DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
		
		NotaFilme nota = dao.consultarMedia("obterMediaFilmes");
		
		System.out.println(nota.getMedia());
		
	}

}
