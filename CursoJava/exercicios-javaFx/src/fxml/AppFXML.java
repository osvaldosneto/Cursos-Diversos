package fxml;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AppFXML extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//carregando css
		String arquivoCss = getClass().getResource("/fxml/login.css").toExternalForm();
		
		//carreando arquivo fxml
		URL arquivoFXML = getClass().getResource("/fxml/Login.fxml");
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene cena = new Scene(raiz, 350, 400);
		//carregando css
		cena.getStylesheets().add(arquivoCss);
		
		primaryStage.setTitle("Tela de Login");
		primaryStage.setResizable(false);
		primaryStage.setScene(cena);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
}
