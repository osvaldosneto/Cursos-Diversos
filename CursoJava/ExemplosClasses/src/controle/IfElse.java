package controle;

import javax.swing.JOptionPane;

public class IfElse {
	public static void main(String[] args) {
		
		String valor = JOptionPane.showInputDialog("Informe o número:");
		int num = Integer.parseInt(valor);
		
		if(num % 2 == 0) {
			System.out.println("O número é par!!!");
		} else {
			System.out.println("O número é impar!!!");
		}	
	}
}
