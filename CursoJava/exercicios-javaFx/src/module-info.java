module exerciciosFx {
	requires javafx.controls;
	requires javafx.fxml;
	requires org.controlsfx.controls;
	
	opens basico; //abrindo o pacote do projeto
	opens layout;
	opens fxml;
}