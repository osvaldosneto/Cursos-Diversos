package lambda;

import java.util.function.UnaryOperator;

public class OperadorUnario {
	
	public static void main(String[] args) {
		
		UnaryOperator<Integer> maisDois = n -> n+2;
		UnaryOperator<Integer> vezesDois = n -> n*2;
		UnaryOperator<Integer> quadrado = n -> n*n;
		
		int resultado1 = maisDois.apply(2);
		
		System.out.println(resultado1);
		
		int resultado2 = maisDois.andThen(vezesDois).andThen(quadrado).apply(2);
		
		System.out.println(resultado2);
		
	}
}
