package modelo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TabelaApp extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane noRaiz = new BorderPane();
		Scene cena = new Scene(noRaiz, 300, 2000);
		
		//criação tabela
		TableView<Contato> tabela = new TableView<Contato>();
		//lista de dados
		ObservableList<Contato> dados = FXCollections.observableArrayList();
		//adicionando contatos a lista
		dados.add( new Contato("Joao", "Silva", "silva@silva.com"));
		dados.add( new Contato("Antonio", "Silva", "antonio@silva.com"));
		dados.add( new Contato("Marcia", "Silva", "marcia@silva.com"));
		tabela.setItems(dados);
		
		//criando colunas da tabela
		TableColumn<Contato, String> colunaNome = new TableColumn<>("Primeiro Nome");
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		TableColumn<Contato, String> colunaSobrenome = new TableColumn<>("Ultimo Nome");
		colunaSobrenome.setCellValueFactory(new PropertyValueFactory<>("sobrenome"));
		TableColumn<Contato, String> colunaEmail = new TableColumn<>("Email");
		colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		tabela.getColumns().addAll(colunaNome, colunaSobrenome, colunaEmail);
		
		noRaiz.setCenter(tabela);
		
		primaryStage.setScene(cena);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}

}
