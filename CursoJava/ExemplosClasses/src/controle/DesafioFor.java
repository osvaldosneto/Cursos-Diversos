package controle;

public class DesafioFor {
	public static void main(String[] args) {
		String valor = "#";
		
		for(valor = "#"; !valor.equals("######"); valor = valor+"#") {
			System.out.println(valor);
		}	
	}
}
