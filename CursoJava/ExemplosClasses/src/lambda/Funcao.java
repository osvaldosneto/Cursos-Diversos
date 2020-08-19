package lambda;

import java.util.function.Function;

public class Funcao {
	
	public static void main(String[] args) {
		
		//emtrada integer saida string
		Function<Integer, String> parOuImpar = numero -> numero%2 ==0 ? "Par" : "Ímpar";
		System.out.println(parOuImpar.apply(32));	
		
		//entra string e sai string
		Function<String, String> oResultado = valor -> "O resultado é : " + valor;
		String resultado = parOuImpar.apply(23);
		String resultadoFinal = oResultado.apply(resultado);
		
		System.out.println("O resultado final é " + resultadoFinal );
		
		Function<Integer, Boolean> isPar = num -> num%2 == 0 ? true:false;
		System.out.println(isPar.apply(2));
		System.out.println(isPar.apply(3));
	}
}