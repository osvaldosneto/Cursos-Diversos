package oo.abstrato;

public abstract class Animal {
	
	public String respirar() {
		return "CO2";
	}
	
	//forma generica se mover os animais portanto defini-se a classe como abstrato
	public abstract double mover();

}
