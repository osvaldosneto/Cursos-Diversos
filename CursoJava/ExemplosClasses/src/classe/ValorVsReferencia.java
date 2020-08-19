package classe;

public class ValorVsReferencia {
	public static void main(String[] args) {
		double a = 2;
		double b = a; //atribuição por valor
		
		a++;
		b--;
		
		System.out.println(a + " - " + b);
		
		Data d1 = new Data(1, 6, 2022);
		Data d2 = d1; //atribuição por referência
		Data d3 = new Data();
		d3 = d1;
		
		System.out.println(d1.obterDataFormatada());
		System.out.println(d2.obterDataFormatada());
		System.out.println(d3.obterDataFormatada());
		
		d1.setAno(1900);
		d3.setAno(2222);
		
		System.out.println(d1.obterDataFormatada());
		System.out.println(d2.obterDataFormatada());
		System.out.println(d3.obterDataFormatada());
	}

}
