package arrays;

import java.util.Scanner;

public class DesafioArray {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe a quantidade de notas: ");
		int n = entrada.nextInt();
		
		double notas[] = new double[n];
		
		for(int i=0; i<n; i++) {
			System.out.println("Informe a nota " + (int)(i+1) + " do aluno:");
			notas[i] = entrada.nextDouble();
		}
		
		double total = 0;
		for(double nota: notas) {
			total += nota;
		}
		
		System.out.println("A média é "+ total/n + ".");
		
		entrada.close();
	}

}
