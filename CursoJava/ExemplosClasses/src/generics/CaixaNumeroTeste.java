package generics;

public class CaixaNumeroTeste {
	public static void main(String[] args) {
		
		CaixaNumero<Double> caixaA = new CaixaNumero<Double>();
		caixaA.guardar(2.1);
		
		CaixaNumero<Integer> caixaB = new CaixaNumero<Integer>();
		caixaB.guardar(3);
		
		
	}

}
