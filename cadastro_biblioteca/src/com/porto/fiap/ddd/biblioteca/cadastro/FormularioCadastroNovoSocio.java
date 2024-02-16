package com.porto.fiap.ddd.biblioteca.cadastro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.fiap.ddd.biblioteca.aplicacao.CadastrarSocio;

public class FormularioCadastroNovoSocio extends Formulario {
	private JTextField textoNome;
	private JTextField textoDocumento;
	private JTextField textoEmail;
	private CadastrarSocio cadastrarSocio;
	
	public FormularioCadastroNovoSocio(
			String titulo, int x, int y, int width, int height, 
			CadastrarSocio cadastrarSocio) {
		super(titulo, x, y, width, height);
		this.cadastrarSocio = cadastrarSocio;
	}

	private void cadastrarNovoSocio() {
		try {
			String nome = this.textoNome.getText();
			String email = this.textoEmail.getText();
			String cpf = this.textoDocumento.getText();
			
			this.cadastrarSocio.cadastrar(nome, email, cpf);
			JOptionPane.showMessageDialog(null, "Novo socio cadastrado");
			voltar();
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar socio: " + ex.getMessage());
		}
	}

	private JLabel getTitulo() {
		JLabel titulo = new JLabel("Cadastro de novo socio");
		titulo.setBounds(30, 20, 300, 20);
		titulo.setFont(new Font("Verdana", Font.PLAIN, 20));
		titulo.setPreferredSize(new Dimension(300, 100));
		titulo.setForeground(new Color(120, 90, 40));
		titulo.setBackground(new Color(100, 20, 70));
		return titulo;
	}


	
	private JLabel getLabelNome() {
		JLabel titulo = new JLabel("Nome:");
		titulo.setBounds(20, 80, 60, 20);
		titulo.setFont(new Font("Verdana", Font.PLAIN, 12));
		titulo.setForeground(new Color(120, 90, 40));
		titulo.setBackground(new Color(100, 20, 70));
		return titulo;
	}
	

	private JTextField getTextBoxNome() {
		textoNome = new JTextField();
		textoNome.setBounds(65, 80, 200, 20);	
		return textoNome;
	}
	
	
	private JLabel getLabelDocumento() {
		JLabel documento = new JLabel("CPF:");
		documento.setBounds(20, 110, 60, 20);
		documento.setFont(new Font("Verdana", Font.PLAIN, 12));
		documento.setForeground(new Color(120, 90, 40));
		documento.setBackground(new Color(100, 20, 70));
		return documento;
	}
	
	private JTextField getTextBoxDocumento() {
		textoDocumento = new JTextField();
		textoDocumento.setBounds(65, 110, 200, 20);	
		return textoDocumento;
	}
	
	private JLabel getLabelEmail() {
		JLabel email = new JLabel("Email:");
		email.setBounds(20, 140, 60, 20);
		email.setFont(new Font("Verdana", Font.PLAIN, 12));
		email.setForeground(new Color(120, 90, 40));
		email.setBackground(new Color(100, 20, 70));
		return email;
	}
	
	private JTextField getTextBoxEmail() {
		textoEmail = new JTextField();
		textoEmail.setBounds(65, 140, 200, 20);	
		return textoEmail;
	}
	
	private JButton getBotaoCadastrar() {
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.setBounds(140, 200, 120, 20);
		cadastrar.addActionListener(e -> {
			cadastrarNovoSocio();
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
		formularioCadastroNovoSocio.add(getLabelNome());
		formularioCadastroNovoSocio.add(getTextBoxNome());
		formularioCadastroNovoSocio.add(getLabelDocumento());
		formularioCadastroNovoSocio.add(getTextBoxDocumento());
		formularioCadastroNovoSocio.add(getLabelEmail());
		formularioCadastroNovoSocio.add(getTextBoxEmail());
		formularioCadastroNovoSocio.add(getBotaoCadastrar());
		formularioCadastroNovoSocio.add(getBotaoCancelar());
	}

	@Override
	protected void limparCampos() {
		this.textoDocumento.setText("");
		this.textoNome.setText("");
		this.textoEmail.setText("");
	}

	@Override
	protected void iniciarFormulario() {
		// TODO Auto-generated method stub
		
	}

	
	
}
