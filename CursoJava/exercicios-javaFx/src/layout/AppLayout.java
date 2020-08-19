package layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppLayout extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//criando objeto caixa
		//VBox temp = new VBox();
		//temp.getChildren().add(new Caixa().comTexto("caixa 1"));
		//temp.getChildren().add(new Caixa().comTexto("caixa 2"));
		//temp.getChildren().add(new Caixa().comTexto("caixa 3"));
		//temp.getChildren().add(new Caixa().comTexto("caixa 4"));
		
		//criandop quadrado tamanho 100x100
	//	temp.getChildren().add(new Quadrado());
	//	temp.getChildren().add(new Quadrado());
	//	temp.getChildren().add(new Quadrado());
	//	temp.getChildren().add(new Quadrado());
		
		//teste de ancoragem
		//Scene principal = new Scene(new TesteAncoragem(), 800, 600);
		
		
		//teste de border pane
		//Scene principal = new Scene(new TestBorderPane(), 800, 600);
		
		//teste flow pane
		//Scene principal = new Scene(new TestFlowPane(), 800, 600);
		
		//teste Grid Pane
		//Scene principal = new Scene(new TestGridPane(), 800, 600);
		
		//teste Stack Pane
		//Scene principal = new Scene(new TestStackPane(), 800, 600);
		Scene principal = new Scene(new TestStackPaneThread(), 800, 600);		
		
		
		primaryStage.setScene(principal);
		primaryStage.setTitle("Gerenciador de Layout");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}

}
