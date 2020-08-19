package basico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Contador extends Application{
	
	private int contador = 0;
	
	//metodo para atualizare o label verde positivo e vermelho negativo
	private void atualizarLabelNumero(Label label) {
		
		label.setText(Integer.toString(contador));
		label.getStyleClass().remove("verde");
		label.getStyleClass().remove("vermelho");
		
		if(contador > 0) {
			label.getStyleClass().add("verde");
		} else if(contador < 0) {
			label.getStyleClass().add("vermelho");
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		Label labelTitulo = new Label("Contador");
		labelTitulo.getStyleClass().add("titulo");
		Label labelNumero = new Label("0");
		labelNumero.getStyleClass().add("numero");
		
		Button botaoIncremento = new Button("+");
		botaoIncremento.getStyleClass().add("botoes");
		botaoIncremento.setOnAction(e -> {
			contador ++;
			this.atualizarLabelNumero(labelNumero);
		});
		
		Button botaoDecremento = new Button("-");
		botaoDecremento.getStyleClass().add("botoes");
		botaoDecremento.setOnAction(e -> {
			contador --;
			this.atualizarLabelNumero(labelNumero);
		});
		
		HBox boxBotoes = new HBox();
		boxBotoes.getChildren().add(botaoDecremento);
		boxBotoes.getChildren().add(botaoIncremento);
		boxBotoes.setAlignment(Pos.CENTER);
		boxBotoes.setSpacing(10);
		
		VBox boxPrincipal = new VBox();
		//definindo layout 2
		boxPrincipal.getStyleClass().add("conteudo");
		
		boxPrincipal.getChildren().add(labelTitulo);
		boxPrincipal.getChildren().add(labelNumero);
		boxPrincipal.getChildren().add(boxBotoes);
		boxPrincipal.setAlignment(Pos.CENTER);
		boxPrincipal.setSpacing(10);
		
		//definindo o layout 1 da aplicação no arquivo .css
		String caminho = getClass().getResource("/basico/contador.css").toExternalForm();		
		Scene cenaPrincipal = new Scene(boxPrincipal, 400, 400);
		cenaPrincipal.getStylesheets().add(caminho);
		cenaPrincipal.getStylesheets().add("https://fonts.googleapis.com/css2?family=Oswald");
		
		primaryStage.setScene(cenaPrincipal);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}

}
