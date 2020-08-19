package oo.polimorfismoestatico;

public class Jantar {
	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(99.65);
		
		Arroz a = new Arroz(0.15);
		Feijao f = new Feijao(0.180);
		
		System.out.println("Peso pessoa :" + p1.getPeso());
		
		p1.comer(a);
		p1.comer(f);
		
		System.out.println("Peso pessoa :" + p1.getPeso());
		
		
	}

}
