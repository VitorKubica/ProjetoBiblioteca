package com.porto.fiap.ddd.biblioteca.cadastro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.fiap.ddd.biblioteca.aplicacao.CadastrarLivro;
import com.fiap.ddd.biblioteca.aplicacao.LivroDTO;

public class FormularioCadastroNovoLivro extends Formulario {
	private JTextField textoTitulo;
	private JTextField textoAutor;
	private JTextField textoISBN;
	private CadastrarLivro cadastrarLivro;
	
	public FormularioCadastroNovoLivro(
			String titulo, int x, int y, int width, int height, 
			CadastrarLivro cadastrarLivro) {
		super(titulo, x, y, width, height);
		this.cadastrarLivro = cadastrarLivro;
	}

	private void cadastrarNovoLivro() {
		try {
			String titulo = this.textoTitulo.getText();
			String isbn = this.textoISBN.getText();
			String autor = this.textoAutor.getText();
			LivroDTO livroDTO = new LivroDTO();
			livroDTO.setTitulo(titulo);
			livroDTO.setIsbn(isbn);
			livroDTO.setAutor(autor);
			this.cadastrarLivro.cadastrar(livroDTO);
			JOptionPane.showMessageDialog(null, "Novo livro cadastrado");
			voltar();
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar livro: " + ex.getMessage());
		}
	}

	private JLabel getTitulo() {
		JLabel titulo = new JLabel("Cadastro de novo livro");
		titulo.setBounds(30, 20, 300, 20);
		titulo.setFont(new Font("Verdana", Font.PLAIN, 20));
		titulo.setPreferredSize(new Dimension(300, 100));
		titulo.setForeground(new Color(120, 90, 40));
		titulo.setBackground(new Color(100, 20, 70));
		return titulo;
	}


	
	private JLabel getLabelTitulo() {
		JLabel titulo = new JLabel("Titulo:");
		titulo.setBounds(20, 80, 60, 20);
		titulo.setFont(new Font("Verdana", Font.PLAIN, 12));
		titulo.setForeground(new Color(120, 90, 40));
		titulo.setBackground(new Color(100, 20, 70));
		return titulo;
	}
	

	private JTextField getTextBoxTitulo() {
		textoTitulo = new JTextField();
		textoTitulo.setBounds(65, 80, 200, 20);	
		return textoTitulo;
	}
	
	
	private JLabel getLabelAutor() {
		JLabel documento = new JLabel("Autor:");
		documento.setBounds(20, 110, 60, 20);
		documento.setFont(new Font("Verdana", Font.PLAIN, 12));
		documento.setForeground(new Color(120, 90, 40));
		documento.setBackground(new Color(100, 20, 70));
		return documento;
	}
	
	private JTextField getTextBoxAutor() {
		textoAutor = new JTextField();
		textoAutor.setBounds(65, 110, 200, 20);	
		return textoAutor;
	}
	
	private JLabel getLabelISBN() {
		JLabel email = new JLabel("ISBN:");
		email.setBounds(20, 140, 60, 20);
		email.setFont(new Font("Verdana", Font.PLAIN, 12));
		email.setForeground(new Color(120, 90, 40));
		email.setBackground(new Color(100, 20, 70));
		return email;
	}
	
	private JTextField getTextBoxISBN() {
		textoISBN = new JTextField();
		textoISBN.setBounds(65, 140, 200, 20);	
		return textoISBN;
	}
	
	private JButton getBotaoCadastrar() {
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.setBounds(140, 200, 120, 20);
		cadastrar.addActionListener(e -> {
			cadastrarNovoLivro();
		});
		
		return cadastrar;
	}
	
	private JButton getBotaoCancelar() {
		JButton voltar = new JButton("Cancelar");
		voltar.setBounds(30, 200, 100, 20);
		voltar.addActionListener(e -> {
			voltar();
		});
		
		return voltar;
	}

	@Override
	protected void popularFormulario(JFrame formularioCadastroNovoSocio) {
		formularioCadastroNovoSocio.add(getTitulo());
		formularioCadastroNovoSocio.add(getLabelTitulo());
		formularioCadastroNovoSocio.add(getTextBoxTitulo());
		formularioCadastroNovoSocio.add(getLabelAutor());
		formularioCadastroNovoSocio.add(getTextBoxAutor());
		formularioCadastroNovoSocio.add(getLabelISBN());
		formularioCadastroNovoSocio.add(getTextBoxISBN());
		formularioCadastroNovoSocio.add(getBotaoCadastrar());
		formularioCadastroNovoSocio.add(getBotaoCancelar());
	}

	@Override
	protected void limparCampos() {
		this.textoAutor.setText("");
		this.textoTitulo.setText("");
		this.textoISBN.setText("");
	}

	@Override
	protected void iniciarFormulario() {
		// TODO Auto-generated method stub
		
	}

	
	
}
