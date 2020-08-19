package desafioFilter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import Streams.Aluno;

public class DesafioFilter {
	
	public static void main(String[] args) {
		
		Veiculo v1 = new Veiculo("Fusca", 140, true);
		Veiculo v2 = new Veiculo("titan", 110, false);
		Veiculo v3 = new Veiculo("Gran", 150, true);
		Veiculo v4 = new Veiculo("Palio", 180, true);
		Veiculo v5 = new Veiculo("Biz", 100, false);
		Veiculo v6 = new Veiculo("Tenere", 140, false);
		Veiculo v7 = new Veiculo("Corcel", 120, true);
		Veiculo v8 = new Veiculo("Gol", 140, true);
		Veiculo v9 = new Veiculo("Ferrari", 280, true);
		Veiculo v10 = new Veiculo("Crypton", 80, false);
		
		List<Veiculo> veiculos = Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10);
		
		Predicate<Veiculo> altaVelocidade = v -> v.velocidade >= 115;
		Predicate<Veiculo> tipo = v -> v.tipo;
		Function<Veiculo, String> toStringMarca = v -> v.marca;
		
		veiculos.stream()
			.filter(altaVelocidade)
			.filter(tipo)
			.map(toStringMarca)
			.forEach(System.out::println);

	}

}
