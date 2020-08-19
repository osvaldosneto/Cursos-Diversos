package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario1 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		//alterando usuario
		
		//abrindo transação
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class, 2L);
		System.out.println(usuario.getEmail());
		
		//editando nome e email
		usuario.setEmail("osvaldo@email.com.br");
		usuario.setNome("Osvaldo");
		
		//salvando na tabela
		em.merge(usuario);
		
		//commit na tabela
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
