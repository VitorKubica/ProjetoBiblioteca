package com.porto.fiap.ddd.biblioteca.cadastro;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.fiap.ddd.biblioteca.aplicacao.LivroDTO;
import com.fiap.ddd.biblioteca.aplicacao.PesquisarLivros;
import com.fiap.ddd.biblioteca.aplicacao.PesquisarSocios;
import com.fiap.ddd.biblioteca.aplicacao.SocioDTO;

public class FormularioPesquisaLivro extends Formulario {

	private static final String[] COLUNAS = new String[] { "ISBN", "Titulo", "Autor" };
	private JTextField textoTitulo;
	private JTable tabelaResultadoPesquisa;
	private String[][] resultadoPesquisa = {{"Daniel", "123", "daniel@teste.com"}};
	private PesquisarLivros pesquisarLivros;
	
	public FormularioPesquisaLivro(
			String tituloJanela, 
			int x, 
			int y, 
			int width, 
			int height, 
			PesquisarLivros pesquisarLivros) {
		super(tituloJanela, x, y, width, height);
		this.pesquisarLivros = pesquisarLivros;
	}

	@Override
	protected void popularFormulario(JFrame formulario) {
		formulario.add(getTitulo());
		formulario.add(getLabelPesquisaPorTitulo());
		formulario.add(getTextoPesquisaPorTitulo());
		formulario.add(getBotaoPesquisar());
		formulario.add(getBotaoLimparPesquisa());
		formulario.add(getTabelaResultadoPesquisa());
	}

	private Component getTitulo() {
		JLabel titulo = new JLabel("Pesquisar livros");
		titulo.setBounds(30, 20, 300, 20);
		titulo.setFont(new Font("Verdana", Font.PLAIN, 20));
		titulo.setPreferredSize(new Dimension(300, 100));
		titulo.setForeground(new Color(120, 90, 40));
		titulo.setBackground(new Color(100, 20, 70));
		return titulo;
	}

	private Component getTabelaResultadoPesquisa() {
		
		tabelaResultadoPesquisa = new JTable(new String [][]{}, COLUNAS) ;
		tabelaResultadoPesquisa.setBounds(20, 120, 330, 100);
		JScrollPane pane = new JScrollPane(tabelaResultadoPesquisa);
		pane.setBounds(20, 120, 330, 120);
		return pane;
	}

	private Component getBotaoLimparPesquisa() {
		JButton cadastrar = new JButton("Limpar");
		cadastrar.setBounds(270, 60, 80, 20);
		cadastrar.addActionListener(e -> {
			limparCampos();
			pesquisarLivros();
		});
		
		return cadastrar;
	}

	private Component getBotaoPesquisar() {
		JButton cadastrar = new JButton("Pesquisar");
		cadastrar.setBounds(170, 60, 95, 20);
		cadastrar.addActionListener(e -> {
			pesquisarLivros();
		});
		
		return cadastrar;
	}

	private void pesquisarLivros() {
		if (textoTitulo.getText() == null || textoTitulo.getText().isBlank()) {
			listarTodosSocios();
		} else {
			pesquisarPorTituloOuAutor();
		}
		
		atualizarTabela();
	}

	private void pesquisarPorTituloOuAutor() {
		String cpf = textoTitulo.getText();
		List<LivroDTO> livros = this.pesquisarLivros.pesquisarPorTituloOuAutor(cpf);
			
		
		atualizarTabela(livros);
	}

	private void listarTodosSocios() {
		List<LivroDTO> livros = this.pesquisarLivros.listarTodos();
		atualizarTabela(livros);
	}
	
	private void atualizarTabela(List<LivroDTO> livros) {
		
		if (livros.size() == 0) {
			this.resultadoPesquisa = new String[][] {};
		} else {
			this.resultadoPesquisa = new String[livros.size()][3];
			
			for (int i = 0; i < livros.size(); i++) {
				LivroDTO livro = livros.get(i);
				this.resultadoPesquisa[i][0] = livro.getIsbn();
				this.resultadoPesquisa[i][1] = livro.getTitulo();
				this.resultadoPesquisa[i][2] = livro.getAutor();
			}
		}		
	}

	private void atualizarTabela() {
		tabelaResultadoPesquisa.setModel(new DefaultTableModel(resultadoPesquisa, COLUNAS));
	}

	private Component getTextoPesquisaPorTitulo() {
		textoTitulo = new JTextField();
		textoTitulo.setBounds(65, 60, 100, 20);	
		return textoTitulo;
	}

	private Component getLabelPesquisaPorTitulo() {
		JLabel titulo = new JLabel("Titulo:");
		titulo.setBounds(20, 60, 60, 20);
		titulo.setFont(new Font("Verdana", Font.PLAIN, 12));
		titulo.setForeground(new Color(120, 90, 40));
		titulo.setBackground(new Color(100, 20, 70));
		return titulo;
	}

	@Override
	protected void limparCampos() {
		textoTitulo.setText("");
	}

	@Override
	protected void iniciarFormulario() {
		pesquisarLivros();
	}

}
