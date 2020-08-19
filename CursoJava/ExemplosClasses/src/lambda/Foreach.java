package lambda;

import java.util.ArrayList;

public class Foreach {
	
	public static void main(String[] args) {
		
		ArrayList<String> aprovados = new ArrayList<>();
		
		aprovados.add("Ana");
		aprovados.add("Bia");
		aprovados.add("Lia");
		aprovados.add("Gui");
		
		//metodo simples
		for(String nome: aprovados) {
			System.out.println(nome);
		}
		
		//metodo Lambda
		System.out.println("Metodo Lambda");
		aprovados.forEach((nome) -> System.out.println(nome));
		
		//method reference
		System.out.println("Method Reference");
		aprovados.forEach(System.out::println);
		
		//metodo lambda2
		System.out.println("Lambda 2");
		aprovados.forEach(nome -> meuImprimir(nome));
		
		//metodo reference 2
		//Foreach é classe e :: metodo
		System.out.println("Metodo Reference 2");
		aprovados.forEach(Foreach :: meuImprimir);
	}
	
	static void meuImprimir(String nome) {
		System.out.println("Oi!! Meu nome é "+ nome + ".");
	}

}
