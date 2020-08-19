package oo;

public class Carro {
	
	Motor motor = new Motor();
	
	void acelerar() {
		motor.fatorInjecao += 0.4;
	}
	
	void frear() {
		motor.fatorInjecao -= 0.4;
	}
	
	void ligar() {
		motor.ligado = true;
	}
	
	void desligar() {
		motor.ligado = false;
	}
	
	boolean estaLigado() {
		return motor.ligado;
	}

}
