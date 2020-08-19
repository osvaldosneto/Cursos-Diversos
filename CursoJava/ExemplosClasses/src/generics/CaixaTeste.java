package generics;

public class CaixaTeste {
	
	public static void main(String[] args) {
		
		Caixa<String> caixaA = new Caixa<>();
		caixaA.guardar("estrela");
		System.out.println(caixaA.abrir());
		
		Caixa<Integer> caixaB = new Caixa<>();
		caixaB.guardar(1);
		System.out.println(caixaB.abrir());
		
	}
}
