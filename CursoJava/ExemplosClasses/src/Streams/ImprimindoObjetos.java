package Streams;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ImprimindoObjetos {
	
	public static int total = 0;
	
	public static void main(String[] args) {
		
		List<String> aprovados = new ArrayList<>();
		
		aprovados.add("Lu");
		aprovados.add("Gui");
		aprovados.add("Luca");
		aprovados.add("Ana");
		
		//utilizando for each
		System.out.println("For Each");
		for(String nome : aprovados) {
			System.out.println(nome);
		}
		
		//utilizando iterador
		System.out.println("\nUsando Interator");
		Iterator<String> iterador = aprovados.iterator();
		while(iterador.hasNext()) {
			System.out.println(iterador.next());
		}
		
		//utilizando stream
		System.out.println("\nUsando Stream");
		Stream<String> stream = aprovados.stream();
		stream.forEach(System.out::println);
		
		//testando outras funções
		List<Integer> listaInteiros  = new ArrayList<>();
		listaInteiros.add(2);
		listaInteiros.add(4);
		listaInteiros.add(2);
		listaInteiros.add(4);
		listaInteiros.add(12);
		
		//stream
		Stream<Integer> teste = listaInteiros.stream();
		teste.forEach(n -> soma(n));
		System.out.println(total);
		
	}
	
	public static void soma(int n) {
		total += n;
	}

}
