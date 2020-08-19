package swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Observador {
	public static void main(String[] args) {
		
		int i = 0;
		
		JFrame janela = new JFrame("Observador");
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //necessário para encerrar a aplicaçao ao fechar janela
		janela.setSize(600,200);
		janela.setLayout(new FlowLayout()); //selecionando layout
		janela.setLocationRelativeTo(null); //abrindo janela no centro da tela
		
		JButton botao = new JButton("Clicar"); //criando botao
		janela.add(botao); //adicionando botao na tela
		
		JTextArea texto = new JTextArea();
		janela.add(texto);
		
		/*botao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// função ao clicar no botão
				System.out.println("Evento ocorreu...");
				
			}
		}); */
		
		botao.addActionListener(e -> {
			//função ao clicar com lambda
			String aux = Integer.toString(i);
			texto.append(aux);
			System.out.println("Evento ocorreu...");
		});
		
		
		janela.setVisible(true);
		
	}
}
