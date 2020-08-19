package oo.desafioHeranca;


//chamando a interface
public class Ferrari extends Carro implements Esportivo {
	
	boolean acelerar() {
		this.velocidade += 15;
		return true;
	}
	
	boolean frear() {
		if(velocidade > 0) {
			this.velocidade -= 15;		
			if (velocidade <= 0 ) {
				velocidade = 0;
			}
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void ligarTurbo() {
		
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void desligarTurbo() {
		// TODO Auto-generated method stub
		
	}
	
}
