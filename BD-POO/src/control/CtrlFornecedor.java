package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import persistence.FornecedorDAO;
import persistence.FornecedorDAOImpl;
import persistence.PessoaDao;
import persistence.PessoaDaoImpl;
import entity.Fornecedor;
import entity.Pessoa;

public class CtrlFornecedor implements CtrlTableFornecedor{
	
	private FornecedorDAO daoF;
	private PessoaDao daoP;
	
	public void inserir(Fornecedor f) {
		daoP = new PessoaDaoImpl();
		daoF = new FornecedorDAOImpl();
		try {
			daoP.inserePessoa(f);
			daoF.inserirFornecedor(f);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void atualiza(Fornecedor f) {
		daoF = new FornecedorDAOImpl();
		try {
			daoF.atualizarFornecedor(f);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void excluir(Fornecedor f) {
		daoF = new FornecedorDAOImpl();
		try {
			daoF.excluirFornecedor(f);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public List<Fornecedor> buscaFornecedorPorNome(String nome) throws SQLException {
		List<Fornecedor> lista = new ArrayList<Fornecedor>();
		daoF = new FornecedorDAOImpl();
		try {
			lista = daoF.listaFornecedor(nome);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
		
		return lista;
	}

	@Override
	public Fornecedor consultaFornecedorId(String id) throws SQLException {
		Fornecedor f = new Fornecedor();
		daoF = new FornecedorDAOImpl();
		f = daoF.consultarFornecedor(id);
		return f;
	}
	
	

}
