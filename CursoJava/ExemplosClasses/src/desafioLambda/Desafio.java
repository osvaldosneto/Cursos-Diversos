package desafioLambda;

import java.text.DecimalFormat;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Desafio {
	public static void main(String[] args) {
		
		//Function recebe produto e retorna double
		Function<Produto, Double> precoFinal = p -> p.preco * (1-p.desconto);
		
		//recebe double e retorna double
		UnaryOperator<Double> impostoMunicipal = n -> n >= 2500 ? (n*0.085)+n : n;
	
		//recebe preco sem ou com frete
		UnaryOperator<Double> frete = f -> f <= 3000 ? f + 100 : f + 50;
		
		//formatar
		Function<Double, String> formatar = preco -> ("R$" + preco).replace(".", ",") ;
		
		Produto p = new Produto("Ipad", 3000.89, 0.1);
		
		String preco = precoFinal
				.andThen(impostoMunicipal)
				.andThen(frete)
				.andThen(formatar)
				.apply(p);
		
		System.out.println(preco);
	}
}
