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

import com.fiap.ddd.biblioteca.aplicacao.PesquisarSocios;
import com.fiap.ddd.biblioteca.aplicacao.SocioDTO;

public class FormularioPesquisaSocio extends Formulario {

	private static final String[] COLUNAS = new String[] { "Nome", "CPF", "Email" };
	private JTextField textoDocumento;
	private JTable tabelaResultadoPesquisa;
	private String[][] resultadoPesquisa = {{"Daniel", "123", "daniel@teste.com"}};
	private PesquisarSocios pesquisarSocios;
	
	public FormularioPesquisaSocio(
			String tituloJanela, 
			int x, 
			int y, 
			int width, 
			int height, 
			PesquisarSocios pesquisarSocio) {
		super(tituloJanela, x, y, width, height);
		this.pesquisarSocios = pesquisarSocio;
	}

	@Override
	protected void popularFormulario(JFrame formulario) {
		formulario.add(getTitulo());
		formulario.add(getLabelPesquisaPorCPF());
		formulario.add(getTextoPesquisaPorCPF());
		formulario.add(getBotaoPesquisar());
		formulario.add(getBotaoLimparPesquisa());
		formulario.add(getTabelaResultadoPesquisa());
	}

	private Component getTitulo() {
		JLabel titulo = new JLabel("Pesquisar socios");
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
			pesquisarSocios();
		});
		
		return cadastrar;
	}

	private Component getBotaoPesquisar() {
		JButton cadastrar = new JButton("Pesquisar");
		cadastrar.setBounds(170, 60, 95, 20);
		cadastrar.addActionListener(e -> {
			pesquisarSocios();
		});
		
		return cadastrar;
	}

	private void pesquisarSocios() {
		if (textoDocumento.getText() == null || textoDocumento.getText().isBlank()) {
			listarTodosSocios();
		} else {
			pesquisarPorCpf();
		}
		
		atualizarTabela();
	}

	private void pesquisarPorCpf() {
		String cpf = textoDocumento.getText();
		SocioDTO socioDTO = this.pesquisarSocios.pesquisarPorCPF(cpf);
		
		List<SocioDTO> lista = new ArrayList<>();
		
		if (socioDTO != null) {
			lista.add(socioDTO);
		}
		
		atualizarTabela(lista);
	}

	private void listarTodosSocios() {
		List<SocioDTO> socios = this.pesquisarSocios.listarTodosSocios();
		atualizarTabela(socios);
	}
	
	private void atualizarTabela(List<SocioDTO> socios) {
		
		if (socios.size() == 0) {
			this.resultadoPesquisa = new String[][] {};
		} else {
			this.resultadoPesquisa = new String[socios.size()][3];
			
			for (int i = 0; i < socios.size(); i++) {
				SocioDTO socio = socios.get(i);
				this.resultadoPesquisa[i][0] = socio.getNome();
				this.resultadoPesquisa[i][1] = socio.getCpf();
				this.resultadoPesquisa[i][2] = socio.getEmail();
			}
		}		
	}

	private void atualizarTabela() {
		tabelaResultadoPesquisa.setModel(new DefaultTableModel(resultadoPesquisa, COLUNAS));
	}

	private Component getTextoPesquisaPorCPF() {
		textoDocumento = new JTextField();
		textoDocumento.setBounds(65, 60, 100, 20);	
		return textoDocumento;
	}

	private Component getLabelPesquisaPorCPF() {
		JLabel titulo = new JLabel("CPF:");
		titulo.setBounds(20, 60, 60, 20);
		titulo.setFont(new Font("Verdana", Font.PLAIN, 12));
		titulo.setForeground(new Color(120, 90, 40));
		titulo.setBackground(new Color(100, 20, 70));
		return titulo;
	}

	@Override
	protected void limparCampos() {
		textoDocumento.setText("");
	}

	@Override
	protected void iniciarFormulario() {
		pesquisarSocios();
	}

}
