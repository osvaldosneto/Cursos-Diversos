package classe;

public class Jantar {
	public static void main(String[] args) {
		Comida c1 = new Comida("Arroz", 0.250);
		Comida c2 = new Comida("feijão", 0.450);
		
		Pessoa p1 = new Pessoa("João", 88.9);
		System.out.println(p1.apresentar());
		p1.comer(c1);
		System.out.println(p1.apresentar());
		p1.comer(c2);
		System.out.println(p1.apresentar());
	
	}

}
