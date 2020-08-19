package lambda;

public class CalculoTeste {
	public static void main(String[] args) {
		
		Calculo soma = new Soma();
		Calculo multiplica = new Multiplicar();
		
		System.out.println(soma.executar(3,2));
		
		System.out.println(multiplica.executar(2,  3));
		
	}

}
