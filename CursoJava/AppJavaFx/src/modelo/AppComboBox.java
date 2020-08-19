package modelo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class AppComboBox extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//layout
		FlowPane noRaiz = new FlowPane();
		
		//criando cena
		Scene  minhacena = new Scene(noRaiz, 300, 300);
		
		
		
		//criando nó
		//botao
		Button botao = new Button("Olá mundo!!");
		//combobox
		ObservableList<String> frutas = FXCollections.observableArrayList();
		frutas.addAll("maçã", "laranja", "pera", "uva");
		
		ComboBox<String> combo = new ComboBox(frutas);
		
		//edicionando listener no combo
		combo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println(newValue);
				//capturando o valor da chave
				System.out.println(combo.getValue());
			}
		});
		
		
		
		//adicionando evento
		botao.setOnAction(e -> {
			System.out.println("Ola Mundo set!!!");
		});
		
		
		
		
		
		//adicionando elementos a cena
		noRaiz.getChildren().add(botao);
		noRaiz.getChildren().add(combo);
		
		//adicionando cena ao palco
		primaryStage.setScene(minhacena);
		
		//exibindo o palco
		primaryStage.show();
		
		
	}
	
	
	public static void main(String[] args) {
		
		launch(args);
		
	}


}
