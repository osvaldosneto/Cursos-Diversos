package padroes.observer;

public class FestaSurpresa {
	public static void main(String[] args) {
		
		Namorada namorada = new Namorada();
		Porteiro porteiro = new Porteiro();
		
		porteiro.registrarObservador(namorada);
		porteiro.monitorar();	
	}
}
