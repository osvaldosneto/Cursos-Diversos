package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Match {
	
	public static void main(String[] args) {
		
		Aluno a1 = new Aluno("Ana", 7.1);
		Aluno a2 = new Aluno("Luna", 6.1);
		Aluno a3 = new Aluno("Gui", 8.1);
		Aluno a4 = new Aluno("Gabi", 10);
		
		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4);
		
		Predicate<Aluno> aprovado = a -> a.nota >= 7.0;
		
		//comparando se todos os alunos foram aprovados
		System.out.println(alunos.stream().allMatch(aprovado));
		
		//algum match
		System.out.println(alunos.stream().anyMatch(aprovado));
		
		//nenhum match
		System.out.println(alunos.stream().noneMatch(aprovado));
		
	}

}
