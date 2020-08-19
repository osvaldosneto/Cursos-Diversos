package generics;

public class Caixa<T> {
	
	private T coisa;
	
	public void guardar(T coisa) {
		this.coisa = coisa;
	}
	
	public Object abrir() {
		return coisa;
	}

}
