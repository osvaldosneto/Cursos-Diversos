import java.util.ArrayList;
import java.util.List;

public class Memoria {
	
	String texto = "0";
	private static final Memoria instancia = new Memoria();
	private final List<MemoriaObservador> observadores = new ArrayList<>();;
	
	private Memoria() {}
	
	public static Memoria getInstancia() {
		return instancia;
	}
	
	public String getTexto() {
		return texto.isEmpty() ? "0" : texto;
	}
	
	public void adicionarObservador(MemoriaObservador observador) {
		observadores.add(observador);
	}
	
	public void processarComando(String comando) {
		int total = Integer.parseInt(texto);
		if(comando.equals("+")) {
			total ++;
		} else if (comando.equals("-")) {
			total --;
		}
		texto = Integer.toString(total);
		observadores.forEach(o -> o.valorAlterado(texto));
	}
}