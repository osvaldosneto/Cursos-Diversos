package controle;

import java.util.Scanner;

public class If {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe a média:");
		
		double media = entrada.nextDouble();
		
		if(media >= 7.0) {
			System.out.println("Parabéns você passou!!!");
		} else {
			System.out.println("Ops, você reprovou!!!");
		}
	}
}
