package fundamentos;

public class Wrapper {
	public static void main(String[] args) {
		//byte
		Byte b = 100;
		Short s = 1000;
		Integer i = 10000;
		Long l = 100000L;
		
		System.out.println(b.doubleValue());
		System.out.println(s.toString());
		
		Boolean bo = Boolean.parseBoolean("true");
		
		System.out.println(bo);
		
		Character c = '#';
		System.out.println(c.charValue());
	}

}
