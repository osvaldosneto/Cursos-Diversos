package controle;

import java.util.Scanner;

public class DesafioDiaSemana {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe um dia da semana:");
		String dia = entrada.next();
		
		if(dia.equalsIgnoreCase("domingo")) {
			System.out.println("O dia é 1.");
		}else if(dia.equalsIgnoreCase("segunda")) {
			System.out.println("O dia é 2.");
		}else if(dia.equalsIgnoreCase("terca")) {
			System.out.println("O dia é 3.");
		}else if(dia.equalsIgnoreCase("quarta")) {
			System.out.println("O dia é 4.");
		}else if(dia.equalsIgnoreCase("quinta")) {
			System.out.println("O dia é 5.");
		}else if(dia.equalsIgnoreCase("sexta")) {
			System.out.println("O dia é 6.");
		} else {
			System.out.println("O dia é 7.");
		}	
	}
}
