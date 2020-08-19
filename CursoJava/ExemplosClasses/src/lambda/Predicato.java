package lambda;

import java.util.function.Predicate;

public class Predicato {
	
	public static void main(String[] args) {
		
		//verificando se produto é maior que 750 retorna true
		Predicate<Produto> isCaro = prod -> prod.preco >= 750;
		
		Produto produto = new Produto("Notebook", 3500.00, 0.15);
		
		//testando arrow function
		System.out.println(isCaro.test(produto));
	}
}