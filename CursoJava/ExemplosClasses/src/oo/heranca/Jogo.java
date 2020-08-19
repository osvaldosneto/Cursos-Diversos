package oo.heranca;

public class Jogo {
	
	public static void main(String[] args) {
		
		//conceito de herança
		Jogador j1 = new Heroi();
		j1.x = 10;
		j1.y = 10;
		
		//conceito de herança
		Monstro j2 = new Monstro();
		j2.x = 10;
		j2.y = 11;
		
		System.out.println("Jogarod 01 :" + j1.vida);
		System.out.println("Jogarod 02 :" + j2.vida);
		
		j1.atacar(j2);
		System.out.println("Jogarod 01 :" + j1.vida);
		System.out.println("Jogarod 02 :" + j2.vida);
		
		j2.atacar(j1);
		System.out.println("Jogarod 01 :" + j1.vida);
		System.out.println("Jogarod 02 :" + j2.vida);
		
	}

}
