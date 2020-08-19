package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import arrays.ForEach;

public class Map {

	public static void main(String[] args) {
		
		Consumer<String> print = System.out::print;
		
		List<String> marcas = Arrays.asList("BMW ", "Audi ", "Honda");
		
		//primeiro map
		System.out.println("Chamando primeiro map:");
		marcas.stream().map(m -> m.toUpperCase()).forEach(print);
		
		//segundo map
		System.out.println("\n\nChamando segundo map");
		UnaryOperator<String> maiuscula = n -> n.toUpperCase();
		UnaryOperator<String> primeiraLetra = n -> n.charAt(0)+"";
		UnaryOperator<String> grito = n -> n + "!!! ";
		
		marcas.stream().map(maiuscula).forEach(print);
		
		System.out.println("\n\n");
		
		//composição
		marcas.stream()
				.map(maiuscula)
				.map(primeiraLetra)
				.map(grito).forEach(print);
	}
}
