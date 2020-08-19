package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;


public class SuplierFornecedor {
	public static void main(String[] args) {
		
		Supplier<List<String>> lista = () -> Arrays.asList("Ana", "Bia", "Gui");
			
		System.out.println(lista.get());
		
	}
}
