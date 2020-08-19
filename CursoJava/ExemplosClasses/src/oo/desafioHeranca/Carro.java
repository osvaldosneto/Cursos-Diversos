package oo.desafioHeranca;

public class Carro {
	
	int velocidade;
	
	boolean acelerar() {
		this.velocidade += 5;
		return true;
	}
	
	boolean frear() {
		if(velocidade > 0) {
			this.velocidade -= 5;		
			if (velocidade <= 0 ) {
				velocidade = 0;
			}
			return true;
		} else {
			return false;
		}
	}

}
