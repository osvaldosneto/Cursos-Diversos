import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Principal extends JFrame {
	
	public Principal() {
		this.organizarLayout();
		setSize(232,322);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //fechando aplicação ao fechar janela
		setLocationRelativeTo(null); //abrir no centro da tela
		setVisible(true); //setando visivel janela
	}
	
	private void organizarLayout() {
		// regionalizando layout
		this.setLayout(new BorderLayout());
		
		Display d1 = new Display();
		this.add(d1, BorderLayout.NORTH);
		
		Tela tela = new Tela();
		this.add(tela, BorderLayout.CENTER);
	}
	
	
	
	public static void main(String[] args) {
		new Principal();
	}

}
