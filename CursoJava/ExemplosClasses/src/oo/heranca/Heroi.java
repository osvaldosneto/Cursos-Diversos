package oo.heranca;

public class Heroi extends Jogador{
	
	public Heroi(){
		this.vida = 250;
	}
	
	//para heroi atacar mais forte que monstro
	boolean atacar(Jogador jogador) {
		//copiando o metodo e modificando parâmetros atua de forma diferente
		int difx = Math.abs(x - jogador.x);
		int dify = Math.abs(y - jogador.y);
		
		if(difx == 0 && dify == 1) {
			jogador.vida -=20;
			return true;
		} else if (difx == 1 && dify == 0) {
			jogador.vida -=20;
			return true;
		} else {
			return false;
		}
	}

}
