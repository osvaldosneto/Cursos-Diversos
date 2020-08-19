package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Reduce1 {
	
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		BinaryOperator<Integer> soma = (ac, n) -> ac + n;
		
		//iniciando com valor 0
		int total = nums.stream().reduce(soma).get();
		System.out.println(total);
		
		//iniciando com valor setado por isto sem o get
		int total2 = nums.stream().reduce(100, soma);
		System.out.println(total2);
		
		//stream paralel para cada numero da lista soma 100
		int total3 = nums.parallelStream().reduce(100, soma);
		System.out.println(total3);
		
		//se existe algum item na lista ele executa a função
		nums.stream().filter(n -> n>5).reduce(soma)
			.ifPresent(System.out::println);
	}
}
