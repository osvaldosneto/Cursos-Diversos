package oo;

public class CarroTeste {
	public static void main(String[] args) {
		
		Carro c1 = new Carro();
		System.out.println("Está ligado: " + c1.estaLigado());
		
		c1.ligar();
		System.out.println("Está ligado: " + c1.estaLigado());
		
		c1.acelerar();
		c1.acelerar();
		
		System.out.println("Acelerando :" + c1.motor.giros());
		
	}
}
