package oo;

public class Motor {
	
	double fatorInjecao = 1;
	boolean ligado = false;
	
	int giros() {
		if(ligado) {
			return (int)Math.round(fatorInjecao * 3000);
		} else {
			return 0;
		}
		
	}

}
