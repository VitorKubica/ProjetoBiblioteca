package com.porto.fiap.ddd.biblioteca.cadastro;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public abstract class Formulario {
	
	private JFrame formulario;
	private JFrame previousFrame;
	
	public Formulario(String tituloJanela, int x, int y, int width, int height) {
		criarFormulario(tituloJanela, x, y, width, height);
	}

	public JButton getBotaoAcesso(String nomeBotao, int x, int y, int width, int height, JFrame previousFrame) {
		JButton botaoAcesso = new JButton(nomeBotao);
		botaoAcesso.setBounds(x, y, width, height);  
		botaoAcesso.addActionListener(e -> {
			formulario.setVisible(true);
			this.previousFrame = previousFrame;
			iniciarFormulario();
		});
		
		return botaoAcesso;
	}

	protected abstract void iniciarFormulario();

	private void criarFormulario(String tituloJanela, int x, int y, int width, int height) {
		formulario = new JFrame(tituloJanela);
		formulario.setBounds(x, y, width, height);
		formulario.setLayout(null);
		formulario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		formulario.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				limparCampos();
			}

			@Override
			public void windowClosed(WindowEvent e) {				
			}

			@Override
			public void windowIconified(WindowEvent e) {				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				
			}
			
		});
		
		popularFormulario(formulario);
	}

	protected void voltar() {
		limparCampos();
		this.formulario.setVisible(false);
		this.previousFrame.setVisible(true);
	}

	protected abstract void popularFormulario(JFrame formulario);

	protected abstract void limparCampos();	
}
