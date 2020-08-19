package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Filter {
	
	public static void main(String[] args) {
		
		Aluno a1 = new Aluno("Ana", 7.8);
		Aluno a2 = new Aluno("Bia", 5.8);
		Aluno a3 = new Aluno("Daniel", 9.8);
		Aluno a4 = new Aluno("Gui", 6.8);
		Aluno a5 = new Aluno("Rebeca", 7.1);
		Aluno a6 = new Aluno("Pedro", 8.8);
		
		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4, a5, a6);
		
		//filtrando os aprovados acima de 7
		System.out.println("\n\nPrimeira forma");
		alunos.stream().filter(a -> a.nota >= 7) //retorna boleano
		.map(a -> "\nParabéns " + a.nome + "! Você foi aprovado!!")
		.forEach(System.out::print);
		
		//outra forma
		System.out.println("\n\nOutra forma");
		Predicate<Aluno> aprovado = a -> a.nota >= 7;
		Function<Aluno, String> resultado = a -> "Parabéns " + a.nome + "!";
		
		alunos.stream()
			.filter(aprovado)
			.map(resultado)
			.forEach(System.out::println);
		
		
		
	}

}
