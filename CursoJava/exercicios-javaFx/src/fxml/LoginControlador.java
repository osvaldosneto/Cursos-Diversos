package fxml;

import org.controlsfx.control.Notifications;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginControlador {
	
	@FXML
	private TextField campoEmail;  //vem do arquivo .fxml
	
	@FXML
	private PasswordField campoSenha; //vem do arquivo .fxml
	
	public void entrar() {
		
		//validação email e senha
		boolean emailValido = campoEmail.getText().equals("aluno@silva.com");
		boolean senhaValida = campoSenha.getText().equals("123456");
		
		if(emailValido && senhaValida) {
			System.out.println("Sucesso");
			Notifications.create()
				.title("Login FXML")
				.position(Pos.CENTER_RIGHT)
				.text("Login efetuado com sucesso!!")
				.showInformation();
		} else {
			System.out.println("Falha");
			Notifications.create()
				.title("Login FXML")
				.position(Pos.CENTER_RIGHT)
				.text("Falha ao logar!!")
				.showError();
		}
	}
	
}
