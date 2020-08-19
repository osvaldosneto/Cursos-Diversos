package classe;

public class Usuario {
	
	String nome;
	String email;
	
	Usuario(String nome, String email){
		this.nome = nome;
		this.email = email;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Usuario) {
			Usuario outro = (Usuario)obj;
		
			boolean nomeIgual = outro.nome.equals(this.nome);
			boolean emailIgual = outro.email.equals(this.email);
		
			return nomeIgual && emailIgual;
		} else {
			return false;
		} 
	}
}
