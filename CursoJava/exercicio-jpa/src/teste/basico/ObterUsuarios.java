package teste.basico;

import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class ObterUsuarios {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select u from Usuario u";
		
		//guardando todos os usuarios na pilha
		TypedQuery<Usuario> pilha = em.createQuery(jpql, Usuario.class);
		
		List<Usuario> usuarios = pilha.getResultList();
		
		for(Usuario u : usuarios) {
			System.out.print(u.getNome() + " - ");
			System.out.println(u.getEmail());
		}
		
		em.close();
		emf.close();
	}

}
