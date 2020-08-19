package modelo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class AppJavaFx extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//layout
		FlowPane noRaiz = new FlowPane();
		
		//criando cena
		Scene  minhacena = new Scene(noRaiz, 300, 300);
		
		//criando nó
		Button botao = new Button("Olá mundo!!");
		
		//adicionando evento
		//método 1
		botao.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Ola mundo!!!");
			}	
		});
		//metodo 2
		botao.setOnAction(e -> {
			System.out.println("Ola Mundo set!!!");
		});
		
		//adicionando elementos a cena
		noRaiz.getChildren().add(botao);
		
		//adicionando cena ao palco
		primaryStage.setScene(minhacena);
		
		//exibindo o palco
		primaryStage.show();
		
		
	}
	
	
	public static void main(String[] args) {
		
		launch(args);
		
	}

}
