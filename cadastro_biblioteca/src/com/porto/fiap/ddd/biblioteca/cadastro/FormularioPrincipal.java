package com.porto.fiap.ddd.biblioteca.cadastro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FormularioPrincipal {
	private JFrame formularioPrincipal;
	
	public FormularioPrincipal(
			String titulo, int x, int y, int width, int height, 
			FormularioCadastroNovoSocio formularioCadastroNovoSocio, 
			FormularioPesquisaSocio formularioPesquisaSocio,
			FormularioCadastroNovoLivro formularioNovoLivro,
			FormularioPesquisaLivro formularioPesquisaLivro) {
		formularioPrincipal=new JFrame(titulo);
		formularioPrincipal.setBounds(x, y, width, height);
		formularioPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		formularioPrincipal.setLayout(null);
		formularioPrincipal.add(getTitulo());
		formularioPrincipal.add(formularioCadastroNovoSocio.getBotaoAcesso("Cadastrar novo socio", 100, 100, 200, 40, formularioPrincipal));
		formularioPrincipal.add(formularioPesquisaSocio.getBotaoAcesso("Pesquisar socios", 100, 150, 200, 40, formularioPrincipal));
		formularioPrincipal.add(formularioNovoLivro.getBotaoAcesso("Novo livro", 100, 200, 200, 40, formularioPrincipal));
		formularioPrincipal.add(formularioPesquisaLivro.getBotaoAcesso("Pesquisar livros", 100, 250, 200, 40, formularioPrincipal));
	}

	private JLabel getTitulo() {
		JLabel titulo = new JLabel("Biblioteca");
		titulo.setBounds(120, 20, 200, 40);
		titulo.setFont(new Font("Verdana", Font.PLAIN, 30));
		titulo.setPreferredSize(new Dimension(250, 100));
		titulo.setForeground(new Color(120, 90, 40));
		titulo.setBackground(new Color(100, 20, 70));
		return titulo;
	}
	
	public void ativar() {
		formularioPrincipal.setVisible(true);
	}
}
