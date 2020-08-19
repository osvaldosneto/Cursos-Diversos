package arrays;

import java.util.Arrays;
import java.util.Scanner;


public class Matriz {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe o número de alunos: ");
		int alunos = entrada.nextInt();
		
		System.out.println("Informe o número de notas por aluno: ");
		int notas = entrada.nextInt();
		
		double notasDaTurma [][] = new double [alunos][notas];
		
		for(int i=0; i<notasDaTurma.length; i++) {	
			for(int j=0; j<notasDaTurma[i].length; j++) {
				System.out.println("Informe a nota " +(int)(j+1)+ " do aluno "+ (int)(i+1) + " :");
				notasDaTurma[i][j] = entrada.nextDouble();
			}
		}
		
		for(int i=0; i<notasDaTurma.length; i++) {	
			for(int j=0; j<notasDaTurma[i].length; j++) {
				System.out.println("A nota " + (int)(j+1) + " do aluno "+ (int)(i+1) + " é :" + notasDaTurma[i][j] );
			}
		}
		
		for(double[] nota : notasDaTurma) {
			System.out.println(Arrays.toString(nota));
		}
		
		entrada.close();
	}

}
