package layout;

import javafx.geometry.Insets;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Quadrado extends Rectangle {
	
	private static int cor = 0;
	private String[] cores = {"#c33c5e", "#39aac6", "#28d79a", 
			"#fb750e", "#6657a8", "#f9060e"};
	
	public Quadrado() {
		this(100,100);
		
	}
	
	public Quadrado(int largura, int altura) {
		
		setWidth(largura);
		setHeight(altura);
		
		BackgroundFill fill = new BackgroundFill(Color.web(cores[cor]), CornerRadii.EMPTY, Insets.EMPTY);
		setFill(Color.web(cores[cor]));
		
		cor ++;
		if(cor == 6) cor = 0;
		
	}

}
