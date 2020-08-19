package fundamentos;

public class DesafioAritmetico {
	public static void main(String[] args) {
		
		//Math.pow
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 5;
		int e = 6;
		int f = 10;
		
		double g = (e*(c+2));
		g = Math.pow(g, 2)/(b*c);
		
		double h = Math.pow((((a-d)*(b-7))/2), 2);
		
		double i = Math.pow((g-h), 3);
		i = i/Math.pow(f, 3);	
		System.out.println(i);
	}
}
