package br.com.osvaldo.app.calculo;

import br.com.osvaldo.app.calculo.interno.OperacoesAritmeticas;
import br.com.osvaldo.logging.Logger;

public class Calculadora {
	
	private OperacoesAritmeticas op = new OperacoesAritmeticas();

	public double soma(double... nums) {
		Logger.info("Somando...");
		return op.soma(nums);
	}

	public double sub(double... nums) {
		Logger.info("Subtraindo...");
		double total = nums[0];
		for(int i=1; i<nums.length; i++) {
			total -= nums[i];
		}
		return total;
	}
	
	
	

}
