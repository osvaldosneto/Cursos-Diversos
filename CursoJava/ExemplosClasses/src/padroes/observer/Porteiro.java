package padroes.observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Porteiro {
	
	private List<ObservadorChegadaAniversariante> observadores = new ArrayList<>();
	
	public void registrarObservador(ObservadorChegadaAniversariante observador) {
		observadores.add(observador);
	}
	
	public void monitorar() {
		Scanner in = new Scanner(System.in);
		String valor = " ";
		
		while(! valor.equals("sair")) {
			System.out.println("Aniverdsariante chegou??");
			valor = in.nextLine();
			
			if(valor.equalsIgnoreCase("sim")) {
				//notificar os observadores
				EventoChegadaAniversariante evento = new EventoChegadaAniversariante(new Date());		
				observadores.stream()
					.forEach(o -> o.chegrou(evento));
				
			} else {
				System.out.println("Alarme falso...");
			}
			
		}	
	}
}
