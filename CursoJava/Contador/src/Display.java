import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Display extends JPanel implements MemoriaObservador {
	
	private JLabel label;
	
	public Display() {
		this.label = new JLabel();
		label = new JLabel(Memoria.getInstancia().getTexto());
		setPreferredSize(new Dimension(233,60));
		setBackground(new Color(46,49,50));
		label.setForeground(Color.white); //editando cor da fonte
		label.setFont(new Font("courier", Font.PLAIN, 30)); //editando fonte
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25)); //alinhando no campo
		add(label);
		
		Memoria.getInstancia().adicionarObservador(this);
	}

	@Override
	public void valorAlterado(String novoValor) {
		label.setText(novoValor);	
	}
}