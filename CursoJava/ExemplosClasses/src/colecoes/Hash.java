package colecoes;

import java.util.HashSet;

public class Hash {
	public static void main(String[] args) {
		
		HashSet <Usuario> usuarios = new HashSet<>();
		
		Usuario u1 = new Usuario("Pedro");
		Usuario u2 = new Usuario("João");
		Usuario u3 = new Usuario("Tonho");
		Usuario u4 = new Usuario("Ana");
		
		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);
		usuarios.add(u4);
		
		//verificando hash deve ter implementado na classe usuário hashequals
		Usuario u5 = new Usuario("Pedro");
		boolean resultado = usuarios.contains(u5);
		System.out.println(resultado);
		
	}

}
