import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Botao extends JButton{
	
	public Botao(String texto, Color cor) {
		setBackground(cor);
		setOpaque(true);
		setText(texto);
		setFont(new Font("courier", Font.PLAIN, 25));
		setForeground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}

	
}
