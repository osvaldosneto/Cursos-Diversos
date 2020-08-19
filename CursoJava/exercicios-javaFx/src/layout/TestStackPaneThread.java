package layout;

import javafx.application.Platform;
import javafx.scene.layout.StackPane;

public class TestStackPaneThread extends StackPane{
	
	public TestStackPaneThread() {
		
		Caixa c1 = new Caixa().comTexto("1");
		Caixa c2 = new Caixa().comTexto("2");
		Caixa c3 = new Caixa().comTexto("3");
		Caixa c4 = new Caixa().comTexto("4");
		Caixa c5 = new Caixa().comTexto("5");
		Caixa c6 = new Caixa().comTexto("6");
		
		getChildren().addAll(c2, c3, c4, c5, c6, c1);
		
		setOnMouseClicked( e -> {
			//alterando cenas
			//clicando lado direito
			if(e.getSceneX() > getScene().getWidth()/2) {
				//enviando o indice zero para a frente
				getChildren().get(0).toFront();
			} else {
				getChildren().get(0).toBack();
			}
		});
		
		//disprando thread
		Thread t = new Thread (() -> {
			while(true) {
				try {
					Thread.sleep(3000);			
					//para disparar a thread em java FX
					Platform.runLater(() -> {
						getChildren().get(0).toFront();
					});
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		t.setDaemon(true); //fecha thread ao finalizar app
		t.start();
		
	}

}
