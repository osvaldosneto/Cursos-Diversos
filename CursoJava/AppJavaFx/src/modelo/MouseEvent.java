package modelo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MouseEvent extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FlowPane noRaiz = new FlowPane();
		
		Scene minhaCena = new Scene(noRaiz, 300, 200);
		
		minhaCena.setOnMouseClicked(e ->{
			System.out.println("Pos x: " + e.getSceneX() + " - Pos y: " + e.getSceneY());
			int click = e.getClickCount();
			System.out.println("Quantidade de click : " + click);
			switch(e.getButton()) {
				case PRIMARY: System.out.println("Botão 1");
				break;
				case MIDDLE: System.out.println("Botão 2");
				break;
				case SECONDARY: System.out.println("Botão 3");
				break;
			}
			System.out.println(e.getButton());
			
		});
		
		primaryStage.setScene(minhaCena);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}

}
