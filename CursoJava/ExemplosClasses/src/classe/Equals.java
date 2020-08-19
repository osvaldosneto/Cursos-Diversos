package classe;

import java.util.Date;

public class Equals {
	public static void main(String[] args) {
		Usuario u1 = new Usuario("Pedro Silva", "pedro.silva@zemail.com.br");
		Usuario u2 = new Usuario("Pedro Silva", "pedro.silva@zemail.com.br");
		Usuario u3 = new Usuario("Pedro Silva", "pedro.silva@zemail.com.br");
		
		System.out.println("É igual :"+ (u1 == u2));
		System.out.println("Equals :" + u1.equals(u2));
		System.out.println("Equals :" + u1.equals(new Date()));
		
	}
	
	
	
	
}