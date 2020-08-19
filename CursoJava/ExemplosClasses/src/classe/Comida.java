package classe;

public class Comida {
	
	String nome;
	double peso;
	
	public Comida(String nome, double peso) {
		this.nome = nome;
		this.peso = peso;
	}
	
	public double getPeso() {
		return this.peso;
	}
	
	public String getNome() {
		return this.nome;
	}

}
