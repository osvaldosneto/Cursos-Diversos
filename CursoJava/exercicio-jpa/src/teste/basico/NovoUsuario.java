package teste.basico;
import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NovoUsuario {
	
	public static void main(String[] args) {
		
		//conectando a um banco de dados
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa"); //como parâmetro nome do projeto
		EntityManager em = emf.createEntityManager();
		
		Usuario u1 = new Usuario("Pedro", "pedro@lanche.com.br");
		Usuario u2 = new Usuario("Augusto", "Augusto@lanche.com.br");
		Usuario u3 = new Usuario("Tadeu", "tadeu@lanche.com.br");
		Usuario u4 = new Usuario("Rafa", "rafa@lanche.com.br");
		Usuario u5 = new Usuario("Nilza", "nilza@lanche.com.br");
		Usuario u6 = new Usuario("Joana", "joana@lanche.com.br");
		Usuario u7 = new Usuario("Tereza", "tereza@lanche.com.br");
		Usuario u8 = new Usuario("Marcio", "marcio@lanche.com.br");
		Usuario u9 = new Usuario("Antonia", "antonia@lanche.com.br");
		
		
		//passo para gravar em banco de dados
		em.getTransaction().begin();
		em.persist(u1);
		em.persist(u2);
		em.persist(u3);
		em.persist(u4);
		em.persist(u5);
		em.persist(u6);
		em.persist(u7);
		em.persist(u8);
		em.persist(u9);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
