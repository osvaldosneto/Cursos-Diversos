package layout;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;

public class TestFlowPane extends FlowPane {
	
	public TestFlowPane() {
		
		Quadrado q1 = new Quadrado();
		Quadrado q2 = new Quadrado();
		Quadrado q3 = new Quadrado();
		Quadrado q4 = new Quadrado();
		Quadrado q5 = new Quadrado();
		
		setHgap(10); //setando espaço horizontal
		setVgap(10); //setando espaço vertical
		setPadding(new Insets(10)); //espaçamento geral em toda a aplicação
		
		//setOrientation(Orientation.VERTICAL);//setando posisionamento vertical
		//setAlignment(Pos.CENTER_RIGHT); //setando alinhamento
		
		getChildren().addAll(q1, q2, q3, q4, q5);
		
	}
}
