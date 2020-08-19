package controle;

import java.util.Scanner;

public class DesafioWhile {
	public static void main(String[] args) {
		int cont = -1;
		double nota = 0, total = 0;
		
		Scanner entrada = new Scanner(System.in);
		
		while(nota != -1) {
			cont ++;
			total = total + nota;
			System.out.println("Informe a nota:");
			nota = entrada.nextDouble();
		}
		
		System.out.println("A média é " + total/cont);
		
		entrada.close();
	}

}
