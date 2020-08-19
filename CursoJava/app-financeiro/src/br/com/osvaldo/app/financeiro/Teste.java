package br.com.osvaldo.app.financeiro;

import br.com.osvaldo.app.calculo.Calculadora;

public class Teste {
	
	public static void main(String[] args) {
		
		//ver em module-info.java
		Calculadora calc = new Calculadora();
		
		System.out.println(calc.soma(2,3,5));
		
		System.out.println(calc.sub(10, 6, 2, 4));
		
	}

}
