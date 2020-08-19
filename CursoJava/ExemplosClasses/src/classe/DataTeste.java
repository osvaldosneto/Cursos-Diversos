package classe;

public class DataTeste {
	public static void main(String[] args) {
		
		Data d1 = new Data();
		Data d2 = new Data(2, 2, 1983);
		
		System.out.println("Construtor sem parametros: " + d1.obterDataFormatada());
		System.out.println("Construtor com parametros: " + d2.obterDataFormatada());
	}

}
