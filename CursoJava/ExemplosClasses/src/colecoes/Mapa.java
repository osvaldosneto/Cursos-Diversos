package colecoes;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Mapa {
	public static void main(String[] args) {
		Map<Integer, String> usuarios = new HashMap<>();
		
		usuarios.put(1,  "Roberto");
		usuarios.put(2,  "Pedro");
		usuarios.put(5,  "Ricardo");
		
		System.out.println(usuarios.size());
		
		//pegando as chaves
		System.out.println(usuarios.keySet());
		
		//valores das chaves
		System.out.println(usuarios.values());
		
		//todos
		System.out.println(usuarios.entrySet());
		
		//percorrendo as chaves
		for(int chave: usuarios.keySet()) {
			System.out.println(chave);
		}
		
		//percorrendo os valores
		for(String valores: usuarios.values()) {
			System.out.println(valores);
		}
		
		//percorrendo os dois
		for( Entry<Integer, String> registro : usuarios.entrySet()) {
			System.out.print(registro.getKey());
			System.out.println(registro.getValue());
		}
		
		
	}

}
