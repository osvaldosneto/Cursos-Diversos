package colecoes;

import java.util.ArrayList;

public class Lists {
	public static void main(String[] args) {
		ArrayList<Usuario> lista = new ArrayList<>();
		
		Usuario u1 = new Usuario("Ana");
		Usuario u2 = new Usuario("Carlos");
		Usuario u3 = new Usuario("Bia");
		
		lista.add(u1);
		lista.add(u2);
		lista.add(u3);
		
		for(Usuario u : lista) {
			System.out.println(u.nome);
		}
		
		
	}

}
