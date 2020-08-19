package colecoes;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoBaguncado {
	public static void main(String[] args) {
		
		HashSet conjunto = new HashSet();
		
		conjunto.add(1.2);
		conjunto.add(true);
		conjunto.add("Teste");
		conjunto.add("novo");
		conjunto.add(1);
		
		System.out.println("O tamanho do conjunto é "+conjunto.size());
		
		System.out.println(conjunto.contains("Teste"));
		System.out.println(conjunto.contains(5));
		
		System.out.println(conjunto);
		
		Set nums = new HashSet();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		
		//adição de conjuntos
		conjunto.addAll(nums);
		System.out.println(conjunto);
		
		//intersecção de conjunto
		conjunto.retainAll(nums);
		System.out.println(conjunto);
		
	}

}
