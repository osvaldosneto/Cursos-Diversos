package layout;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class TestGridPane extends GridPane{
	
	public TestGridPane() {
		
		Caixa c1 = new Caixa().comTexto("1");
		Caixa c2 = new Caixa().comTexto("2");
		Caixa c3 = new Caixa().comTexto("3");
		Caixa c4 = new Caixa().comTexto("4");
		Caixa c5 = new Caixa().comTexto("5");
		Caixa c6 = new Caixa().comTexto("6");
		
		setGridLinesVisible(true);
		
		//criando colunas
		getColumnConstraints().addAll(colunaContraints(20), colunaContraints(20), colunaContraints(20),
				colunaContraints(20), colunaContraints(20), colunaContraints(20));
		
		//criando linhas
		getRowConstraints().addAll(linhaConstraints(20), linhaConstraints(20), linhaConstraints(20),
				linhaConstraints(20), linhaConstraints(20), linhaConstraints(20));
		
		//adicionando elemento c1 na linha 0 coluna 0
		add(c1, 0, 0);
		add(c2, 1, 0, 2, 2);
		
		
	}
	
	public ColumnConstraints colunaContraints(int size) {
		ColumnConstraints cc = new ColumnConstraints();
		cc.setPercentWidth(size);
		cc.setFillWidth(true);
		return cc;
	}
	
	public RowConstraints linhaConstraints(int size) {
		RowConstraints rc = new RowConstraints();
		rc.setPercentHeight(size);
		rc.setFillHeight(true);
		return rc;
	}
	
}
