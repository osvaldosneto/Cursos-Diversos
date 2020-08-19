package fundamentos;

public class Temperatura {
	public static void main(String[] args) {
		//(f -32) x 5/9 = C
		final double constante = 5/9.0;
		final int constante2 = 32;
		
		double temperaturaF = 65;
		
		double result = (temperaturaF - constante2) * constante;
		
		System.out.print("A temperatura em c é " + result);
		
	}
}
