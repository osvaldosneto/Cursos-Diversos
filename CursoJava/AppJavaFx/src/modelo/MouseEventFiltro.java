package modelo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MouseEventFiltro extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FlowPane noRaiz = new FlowPane();
		
		Scene minhaCena = new Scene(noRaiz, 300, 200);
		
		//adicionando filtro
		minhaCena.addEventFilter(MouseEvent.MOUSE_CLICKED, e ->{
			switch(e.getButton()) {
				case MIDDLE: e.consume(); //System.out.println("Filtro Middle");
				break;
				case SECONDARY: e.consume();// System.out.println("Filtro Secondary");
				break;
			}
		});
		
		
		minhaCena.setOnMouseClicked(e ->{
			System.out.println("Pos x: " + e.getSceneX() + " - Pos y: " + e.getSceneY());
			int click = e.getClickCount();
			System.out.println("Quantidade de click : " + click);
		});
		
		primaryStage.setScene(minhaCena);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}


}
