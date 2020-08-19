package teste.muitospramuitos;

import infra.DAO;
import modelo.muitospramuitos.Sobrinho;
import modelo.muitospramuitos.Tio;

public class NovoTest {
	
	public static void main(String[] args) {
		
		Tio tia1 = new Tio("Maria");
		Tio tio2 = new Tio("João");
		
		Sobrinho s1 = new Sobrinho("Junior");
		Sobrinho s2 = new Sobrinho("Ana");
		
		//relacao bidirecional
		tia1.getSobrinhos().add(s1);
		s1.getTios().add(tia1);
		
		tia1.getSobrinhos().add(s2);
		s2.getTios().add(tia1);
		
		tio2.getSobrinhos().add(s1);
		s1.getTios().add(tio2);
		
		tio2.getSobrinhos().add(s2);
		s2.getTios().add(tio2);
		
		DAO<Object> dao = new DAO<>();
		dao.abrirTransacao()
			.incluir(tia1)
			.incluir(tio2)
			.incluir(s1)
			.incluir(s2)
			.fecharTransacao()
			.fechar();
			
		
	}

}
