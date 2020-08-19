package colecoes;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoComportado {
	public static void main(String[] args) {
		Set<String> lista = new HashSet<>();
		
		lista.add("teste");
		lista.add("Ana");
		lista.add("Ana");
		lista.add("Pedro");
		
		System.out.println(lista);
		
		for(String list : lista) {
			System.out.println(list);
		}
		
	}

}
