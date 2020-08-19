package oo.polimorfismoestatico;

public class Pessoa {
	
	private double peso;
	
	public Pessoa(double peso) {
		this.peso = peso;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		if(peso >= 0) {
			this.peso = peso;
		}
	}
	
	public void comer(Comida c) {
		System.out.println(c.getPeso());
		this.peso += c.getPeso();
	}
	
}
