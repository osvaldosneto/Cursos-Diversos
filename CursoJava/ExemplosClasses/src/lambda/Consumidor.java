package lambda;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Consumidor {
	
	public static void main(String[] args) {
		
		Consumer<Produto> imprimir = p -> System.out.println(p.nome);
		
		Produto p1 = new Produto("caneta", 12.50, 0.15);
		Produto p2 = new Produto("Lapis", 1.5, 0.1);
		Produto p3 = new Produto("Caderno", 15.7, 0.25);
		
		imprimir.accept(p1);
		
		ArrayList<Produto> lista = new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		
		//imprimindo nome
		lista.forEach(imprimir);
		
		//imprimindo preco lambda
		lista.forEach(p -> System.out.println(p.preco));
		
		
	}

}
