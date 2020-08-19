package modelo.basico;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id //id da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) //gerando valores com auto encremento
	private Long id;
	private String nome;
	private String email;
	
	/*definindo padrões
	@colum(name = "...", nullable = false) coluna com o nome "..." e não nula
	@transient quando não será mapeado no banco de dados
	*/
	
	//necessário construtor em branco
	public Usuario() {
		
	}
	
	public Usuario(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
