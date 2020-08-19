package fundamentos;

import java.util.Scanner;

public class Console {
	public static void main(String[] args) {
		
		System.out.print("Bom");
		System.out.println(" dia!!");
		
		System.out.printf("Megassena: %d %d %d %d %d %d ", 1, 2, 3, 4, 5, 6);
		
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("\nDigite o seu nome: ");
		String nome = entrada.nextLine(); //capturando string
		
		System.out.println("Informe a idade: ");
		int idade = entrada.nextInt(); //capturando um inteiro
		
		System.out.println("O nome digitado foi " + nome + " idade "+ idade + ".");
	}

}
