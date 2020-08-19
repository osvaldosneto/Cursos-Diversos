package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class DesafioMap {
	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		//invertendo string
		UnaryOperator<String> inverter = s -> new StringBuilder(s).reverse().toString();		
		Function<String, Integer> binarioParaInteiro = s -> Integer.parseInt(s, 2);
		
		nums.stream()
			.map(Integer::toBinaryString)
			.map(inverter)
			.map(binarioParaInteiro)
			.forEach(System.out::println);
		
	}

}
