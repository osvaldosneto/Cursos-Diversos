package lambda;

public class CalculoTeste2 {
	
	//utilizando funcao lambda
	public static void main(String[] args) {
		
		//utiliza somente classe abstracta calculo
		 Calculo calculo = (x, y) -> { return x + y; };
		
		 System.out.println(calculo.executar(2, 3));
		 
		 calculo = (x, y) -> x * y;
		 System.out.println(calculo.executar(2, 3));
	}
}