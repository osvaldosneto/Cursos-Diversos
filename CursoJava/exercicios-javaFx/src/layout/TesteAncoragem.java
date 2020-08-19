package layout;

import javafx.scene.layout.AnchorPane;

public class TesteAncoragem extends AnchorPane{
	
	public TesteAncoragem() {
		
		Quadrado q1 = new Quadrado();
		setTopAnchor(q1, 10.0);
		setLeftAnchor(q1, 10.0);
		
		Quadrado q2 = new Quadrado();
		setTopAnchor(q2, 10.0);
		setRightAnchor(q2, 10.0);
		
		Quadrado q3 = new Quadrado();
		setBottomAnchor(q3, 10.0);
		setLeftAnchor(q3, 10.0);
		
		Quadrado q4 = new Quadrado();
		setBottomAnchor(q4, 10.0);
		setRightAnchor(q4, 10.0);
		
		getChildren().addAll(q1, q2, q3, q4);
		
	}
	
}
