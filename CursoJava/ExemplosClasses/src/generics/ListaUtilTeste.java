package generics;

import java.util.Arrays;
import java.util.List;

public class ListaUtilTeste {
	public static void main(String[] args) {
		
		List<String> listaString = Arrays.asList("Js", "PHP", "Java", "C++");
		
		List<Integer> listaInt = Arrays.asList(1, 2, 3, 4);
		
		String ultimoListaString = (String)ListaUtil.getUltimo1(listaString);
		System.out.println(ultimoListaString);
		
		int ultimoListaInt = (Integer)ListaUtil.getUltimo1(listaInt);
		System.out.println(ultimoListaInt);
		
		//efetuando a operação sem cast
		ultimoListaString = ListaUtil.getUltimo2(listaString);
		System.out.println(ultimoListaString);
		
		ultimoListaInt = ListaUtil.getUltimo2(listaInt);
		System.out.println(ultimoListaInt);
	}

}
