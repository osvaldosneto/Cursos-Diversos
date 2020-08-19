import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Tela extends JPanel implements ActionListener{
	
	private final Color COR_CINZA_ESCURO = new Color(68,68,68);
	private final Color COR_CINZA_CLARO = new Color(99,99,99);
	
	public Tela(){
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		//adicionando botões através da função
		setLayout(layout);
		
		c.weightx = 1; //preenchendo o espaço vazio em x
		c.weighty = 1; //preenchendo o espaço vazio em y
		c.fill = GridBagConstraints.BOTH; //preenchendo espaço de cada botão
		
		c.gridx = 0;
		c.gridy = 0;
		Botao b1 = new Botao("+", COR_CINZA_ESCURO);
		b1.addActionListener(this);
		add(b1, c);	
		
		c.gridx = 1;
		c.gridy = 0;
		Botao b2 = new Botao("-", COR_CINZA_CLARO);
		b2.addActionListener(this); //adicionando escuta teclado
		add(b2, c);	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		Memoria.getInstancia().processarComando(b.getText());
		//System.out.println(b.getText());
		
	}
	
	
	
	

}
