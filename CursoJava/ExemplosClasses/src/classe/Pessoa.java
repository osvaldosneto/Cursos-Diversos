package classe;

public class Pessoa {
	String nome;
	double peso;
	
	public Pessoa(String nome, double peso) {
		this.nome = nome;
		this.peso = peso;
		this.apresentar();
	}
	
	public double getPeso() {
		return this.peso;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public boolean comer(Comida c) {
		if(c != null) {
			this.peso += c.getPeso();
			return true;
		} return false;
	}
	
	public String apresentar() {
		return "Olá eu sou o "+ this.nome + " e tenho " + this.peso + " Kg.";
	}
}
