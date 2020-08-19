package basico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TrocandoScene extends Application{
	
	private Stage janela;
	private Scene passo1;
	private Scene passo2;
	private Scene passo3;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		janela = primaryStage;
		
		this.criarPasso1();
		this.criarPasso2();
		this.criarPasso3();
		
		janela.setScene(passo1);
		janela.setTitle("Wizard");
		janela.show();
	}
	
	private void criarPasso1() {
		
		Button nextStep = new Button("Próximo >>");
		nextStep.setOnAction(e -> {
			janela.setScene(passo2);
			janela.setTitle("Wizard passo 2");
		});
		
		HBox box = new HBox();
		box.setAlignment(Pos.CENTER);
		box.getChildren().add(nextStep);
		
		passo1 = new Scene(box, 400, 400);
	}
	
	private void criarPasso2() {
		Button nextStep = new Button("Próximo >>");
		nextStep.setOnAction(e -> {
			janela.setScene(passo3);
			janela.setTitle("Wizard passo 3");
		});
		
		Button backStep = new Button("<< Anterior");
		backStep.setOnAction(e -> {
			janela.setScene(passo1);
		});
		
		HBox box = new HBox();
		box.setAlignment(Pos.CENTER);
		box.getChildren().add(backStep);
		box.getChildren().add(nextStep);
		box.setSpacing(10);
		passo2 = new Scene(box, 400, 400);
	}
	
	private void criarPasso3() {
		Button nextStep = new Button("Finalizar >>");
		nextStep.setOnAction(e -> {
			System.exit(0);
		});
		
		Button backStep = new Button("<< Anterior");
		backStep.setOnAction(e -> {
			janela.setScene(passo2);
		});
		
		HBox box = new HBox();
		box.setAlignment(Pos.CENTER);
		box.getChildren().add(backStep);
		box.getChildren().add(nextStep);
		box.setSpacing(10);
		passo3 = new Scene(box, 400, 400);
	}
	
	
	public static void main(String[] args) {
		
		launch(args);
		
	}

}
