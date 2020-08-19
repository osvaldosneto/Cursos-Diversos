package Streams;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CriandoStreams {
	
	public static void main(String[] args) {
		
		Consumer<String> print = System.out::print;
		

		Stream<String> langs = Stream.of("java ", "Lisp ", "Perl ", "Go\n");		
		langs.forEach(print);
		
		String[] maisLangs = {"Python ", "Lisp ", "Perl ", "Go\n"};
		Stream.of(maisLangs).forEach(print);
		
		//utilizando Arrays
		System.out.println("Utilizando Arrays");
		Arrays.stream(maisLangs).forEach(print);
		//selecionando posicões
		Arrays.stream(maisLangs, 1, 3).forEach(print);
		
	}

}
