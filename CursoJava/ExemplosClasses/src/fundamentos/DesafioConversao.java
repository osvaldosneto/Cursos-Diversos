package fundamentos;

import java.util.Scanner;

public class DesafioConversao {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe o primeiro salario :");
		String valor1 = entrada.next();
		valor1 = valor1.replace(",", ".");
		double salario1 = Double.parseDouble(valor1);
		
		System.out.println("Informe o segundo salario :");
		String valor2 = entrada.next();
		valor2 = valor2.replace(",", ".");
		double salario2 = Double.parseDouble(valor2);
		
		System.out.println("Informe o terceiro salario :");
		String valor3 = entrada.next();
		valor3 = valor3.replace(",", ".");
		double salario3 = Double.parseDouble(valor3);
		
		double media = (salario1 + salario2 + salario3)/3.0;
		System.out.println("A média dos salários é " + media);
		
		entrada.close();
		
		
	}
}
