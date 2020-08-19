package modelo.umpraum;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "assento_id", unique = true) //definindo como unica id do assento
	private Assento assento;
	
	public Cliente() {
		
	}

	public Cliente(String nome, Assento assento) {
		this.id = id;
		this.nome = nome;
		this.assento = assento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}
	
	
	
	
}
