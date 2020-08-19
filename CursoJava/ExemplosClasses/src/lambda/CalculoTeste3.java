package lambda;

import java.util.function.BinaryOperator;

public class CalculoTeste3 {
	
	//utilizando funcao java util function Binary Operator
	public static void main(String[] args) {
		
		BinaryOperator<Double> calc = (x, y) -> {return x+y; };
		System.out.println(calc.apply(2.0, 3.0));
		
		calc = (x, y) -> x*y;
		System.out.println(calc.apply(2.0, 3.0));
		
		BinaryOperator<String> concat = (x,y) -> {return x+y;};
		System.out.println(concat.apply("Ola ", "mundo"));
	}
}