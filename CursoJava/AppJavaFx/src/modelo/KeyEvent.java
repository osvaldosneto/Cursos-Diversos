package modelo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class KeyEvent extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FlowPane noRaiz = new FlowPane();
		
		Scene minhaCena = new Scene(noRaiz, 300, 200);
		
		minhaCena.setOnKeyTyped(e -> {
			System.out.println(e.getCharacter());
		});
		
		
		primaryStage.setScene(minhaCena);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
