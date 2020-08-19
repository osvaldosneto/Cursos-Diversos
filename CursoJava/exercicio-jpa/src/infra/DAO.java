package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class DAO<E> {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	
	//roda apenas uma vez ao iniciar a classe
	static {
		try {
			emf = Persistence.createEntityManagerFactory("exercicios-jpa"); //está na linha 7 arquivo persistence.xml		
		} catch(Exception e) {
			
		}
	}
	
	//construtor sem classe
	public DAO() {
		this(null);
	}
	
	//construtor com a classe
	public DAO(Class<E> classe){
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	//metodo abrir transação
	public DAO<E> abrirTransacao(){
		em.getTransaction().begin();
		return this;
	}
	
	//commit e fachar a transação
	public DAO<E> fecharTransacao(){
		em.getTransaction().commit();
		return this;
	}
	
	//metodo incluir dado tabela
	public DAO<E> incluir(E entidade){
		em.persist(entidade);
		return this;
	}
	
	//faz a inclusão completa
	public DAO<E> incluirAtomico(E entidade){
		return this.abrirTransacao().incluir(entidade).fecharTransacao();
	}
	
	//consulta com uma quantidade na lista
	public List<E> obterTodos(int qtde, int deslocamento){
		if(classe == null) {
			throw new UnsupportedOperationException("Classe inexistente ou nula");
		}
		
		String jpql = "SELECT e FROM " + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(qtde); //setando numero máximo de elementos da lista
		query.setFirstResult(deslocamento); //escolhendo o primeiro elemento da lista
		
		return query.getResultList();	
	}
	
	//consulta obter todos mostrando os 10 primeiros
	public List<E> obterTodos(){
		return this.obterTodos(10,0);
	}
	
	//consulta apenas um único objeto
	public E obter(Object id){
		return em.find(this.classe, id);
	}
	
	//remover passo a passo
	public DAO<E> removerItem(E entidade) {
		em.remove(entidade);
		return this;
	}
	
	//remover atomicamente
	public DAO<E> removerItemAtomico(E entidade) {
		this.removerItem(entidade).fecharTransacao();
		return this;
	}
	
	//removendo pela id
	public DAO<E> remover(Long id){
		E entidade = this.obter(id);
		
		if(entidade != null) {
			this.removerItemAtomico(entidade);
			return this;
		} else {
			throw new UnsupportedOperationException("Classe inexistente ou nula");
		}
	}
	
	//fechar a comunicação
	public void fechar() {
		em.close();
	}
	
	//executando conculta através da Named query
	//nome consulta vem do arquivo consulta.xml em META-INF
	//params são os parametros
	public List<E> consultar (String nomeConsulta, Object... params){
		TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);
		
		//setando os parametros - laço for captura os parametros
		for(int i=0; i<params.length; i+=2) {
			query.setParameter(params[i].toString(), params[i+1]);
			
		}
		return query.getResultList();
	}
	
	//consulta por nome usando named query
	public List<E> consultarNome (String nomeConsulta, Object... params){
		TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);
		
		//setando os parametros - laço for captura os parametros
		for(int i=0; i<params.length; i+=2) {
			query.setParameter(params[i].toString(), params[i+1]);
		}
		return query.getResultList();
	}
	
	//consultar media native consulta
	public E consultarMedia(String nomeConsulta, Object... params) {
		List<E> lista = consultar(nomeConsulta, params);
		return lista.isEmpty() ? null : lista.get(0);
	}
	

}
