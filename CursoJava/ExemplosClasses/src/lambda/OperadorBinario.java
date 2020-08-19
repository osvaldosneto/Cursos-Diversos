package lambda;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class OperadorBinario {
	
	public static void main(String[] args) {
		
		BinaryOperator<Double> media = (n1, n2) -> (n1 + n2)/2;		
		System.out.println(media.apply(2.0, 2.0));	
		Function<Double, String> resultadoCascata = m -> m >= 7 ? "Aprovado" : "Reprovado";
		double r = media.apply(7.0, 8.0);
		System.out.println(resultadoCascata.apply(r));
		r = media.apply(2.0, 2.0);
		System.out.println(resultadoCascata.apply(r));
		
		
		//recebendio numeros e retornando string
		BiFunction<Double, Double, String> resultado = (n1, n2) -> {
			double notafinal = (n1+n2) /2;
			//if(notafinal >= 7.0) {
			//	return "Aprovado";
			//} else {
			//	return "Reprovado";
			//}
			double notaFinal = (n1 + n2) / 2;
			return notaFinal >= 7 ? "Aprovado" : "Reprovado";
		};
		
		System.out.println(resultado.apply(6.0, 6.0));	
		System.out.println(resultado.apply(8.0, 8.0));
		
		int a = 6;
		System.out.println(a > 4 ? "maior" : "menor");
	}
}
