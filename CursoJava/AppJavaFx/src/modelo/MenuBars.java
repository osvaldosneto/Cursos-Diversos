package modelo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuBars extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Layout
		BorderPane noRaiz = new BorderPane();
		
		Scene cena = new Scene(noRaiz, 300, 200);
		
		//criando barra de menu
		MenuBar menu = new MenuBar();
		
		//criando menu arquivo
		Menu menuArquivo = new Menu("Arquivo");
		//itens menu arquivo
		MenuItem novo = new MenuItem("Novo");
		MenuItem abrir = new MenuItem("Abrir");
		MenuItem sair = new MenuItem("Sair");
		//adicionando itens ao menu arquivo
		menuArquivo.getItems().addAll(novo, abrir, sair);
		//adicionando arquivos a barra de menu
		menu.getMenus().add(menuArquivo);
		//adicionando ao menu bar
		//noRaiz.setTop(menu);
		
		//criando menu formatar
		Menu menuFormatar = new Menu("Formatar");
		MenuItem sair2 = new MenuItem("Sair");
		menuFormatar.getItems().addAll(abrir, sair2);
		menu.getMenus().add(menuFormatar);
		noRaiz.setTop(menu);
		
		
		
		//adicionando evento sair
		sair.setOnAction(e -> {
			System.exit(0);
		});
		
		
		
		primaryStage.setScene(cena);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}

}
