package Streams;

public class Aluno {
	
	String nome;
	double nota;
	
	public Aluno (String aluno, double nota) {
		this.nome = aluno;
		this.nota = nota;
	}
	
	public String toString() {
		return nome + " : " + nota;
	}

}
