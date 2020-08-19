package desafiofilterII;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import desafioFilter.Veiculo;

public class Desafio2 {
	
	public static void main(String[] args) {
		
		Produto p0 = new Produto("Lapis", 0.4, false);
		Produto p1 = new Produto("Notebook", 0.5, true);
		Produto p2 = new Produto("Lapiseira", 0.1, false);
		Produto p3 = new Produto("Caderno", 0.1, true);
		Produto p4 = new Produto("Livro", 0.2, true);
		Produto p5 = new Produto("Papel", 0.15, false);
		Produto p6 = new Produto("Sacola", 0.15, false);
		Produto p7 = new Produto("Borracha", 0.10, true);
		Produto p8 = new Produto("Celular", 0.25, true);
		Produto p9 = new Produto("Mochila", 0.4, true);
		
		List<Produto> produtos = Arrays.asList(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
	
		Predicate<Produto> freteGratis = pr -> pr.frete == true;
		Predicate<Produto> desconto = pr -> pr.desconto >= 0.1;
		
		Function<Produto, String> toString = pr -> "O " + pr.nome + " está com desconto de "+ pr.desconto*100 + "%.";

		produtos.stream()
			.filter(freteGratis)
			.filter(desconto)
			.map(toString)
			.forEach(System.out::println);
	}
}
