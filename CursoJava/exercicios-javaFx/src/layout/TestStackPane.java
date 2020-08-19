package layout;

import javafx.scene.layout.StackPane;

public class TestStackPane extends StackPane{
	
	public TestStackPane() {
		
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
		
	}

}
