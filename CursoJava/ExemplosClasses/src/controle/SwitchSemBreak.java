package controle;

public class SwitchSemBreak {
	public static void main(String[] args) {
		
		String faixa = "amarela";
		
		switch(faixa.toLowerCase()) {
		
		case "preta":
			System.out.println("Sei o Bassai-Dai...");
		case "marrom":
			System.out.println("Sei o Tekki Shotan...");
		case "roxa":
			System.out.println("Sei o Heian Godan...");
		case "verde":
			System.out.println("Sei o Heian Yodan...");
		case "amarela":
			System.out.println("Sei o Heian Shodan...");
			break;
		default:
			System.out.println("Não sei nada...");		
		}
	}
}
