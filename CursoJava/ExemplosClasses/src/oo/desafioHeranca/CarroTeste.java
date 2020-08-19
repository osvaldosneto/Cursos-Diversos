package oo.desafioHeranca;

public class CarroTeste {
	public static void main(String[] args) {
		
		Carro ferrari = new Ferrari();
		Carro fusca = new Fusca();
		
		System.out.println(ferrari.velocidade);
		ferrari.acelerar();
		System.out.println(ferrari.velocidade);
		ferrari.acelerar();
		ferrari.acelerar();
		System.out.println(ferrari.velocidade);
		
		ferrari.frear();
		System.out.println(ferrari.velocidade);
		
		fusca.acelerar();
		System.out.println(fusca.velocidade);
	}

}
