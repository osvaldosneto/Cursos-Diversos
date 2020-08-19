package fundamentos;

public class TipoString {
	public static void main(String[] args) {
		System.out.println("Olá pessoal. ".charAt(2));
		
		//verificando se stirng começa com
		
		String a = "Bom Dia";
		System.out.println(a.startsWith("B"));
		System.out.println(a.endsWith("."));
		System.out.println(a.endsWith("a"));
	}
}
