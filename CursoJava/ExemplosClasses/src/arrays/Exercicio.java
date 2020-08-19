package arrays;

import java.util.Arrays;

public class Exercicio {
	public static void main(String[] args) {
		double notasAlunoA[] = new double[3];
		
		notasAlunoA[0] = 7.9;
		notasAlunoA[1] = 9;
		notasAlunoA[2] = 10;
		
		//imprimindo as notas
		System.out.println(Arrays.toString(notasAlunoA));
		
		for (int i=0; i<notasAlunoA.length; i++) {
			System.out.println(i+1 + "-" + notasAlunoA[i]);
			
		}
	}
}
