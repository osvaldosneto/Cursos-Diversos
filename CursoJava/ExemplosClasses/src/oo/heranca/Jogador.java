package oo.heranca;

public class Jogador {
	
	int x;
	int y;
	int vida = 100;
	
	boolean atacar(Jogador jogador) {
		int difx = Math.abs(x - jogador.x);
		int dify = Math.abs(y - jogador.y);
		
		if(difx == 0 && dify == 1) {
			jogador.vida -=10;
			return true;
		} else if (difx == 1 && dify == 0) {
			jogador.vida -=10;
			return true;
		} else {
			return false;
		}
	}
	
	boolean andar(Direcao direcao) {
		if(direcao == Direcao.NORTE) {
			y++;
		} else if (direcao == Direcao.SUL) {
			y--;
		} else if (direcao == Direcao.LESTE) {
			x++;
		} else if (direcao == Direcao.OESTE) {
			x--;
		} else {
			return false;
		}
		return true;
	}

}
