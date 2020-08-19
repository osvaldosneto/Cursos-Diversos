package classe;

public class PrimeiroTrauma {
	
	int a = 3;
	
	public static void main(String[] args) {
		
		PrimeiroTrauma p = new PrimeiroTrauma();
		System.out.println(p.a);
		p.editA(5);
		System.out.println(p.a);
		
	}
	
	public void editA(int a) {
		this.a = a;
	}
}
