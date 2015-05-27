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
	
	private FornecedorDAO fDao;
	private PessoaDao pDao;
	
	public void inserir(Fornecedor f) {
		pDao = new PessoaDaoImpl();
		fDao = new FornecedorDAOImpl();
		try {
			pDao.inserePessoa(f);
			fDao.inserirFornecedor(f);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void atualiza(Fornecedor f) {
		fDao = new FornecedorDAOImpl();
		try {
			fDao.atualizarFornecedor(f);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void excluir(Fornecedor f) {
		fDao = new FornecedorDAOImpl();
		try {
			fDao.excluirFornecedor(f);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public List<Fornecedor> buscaFornecedorPorNome(String nome) throws SQLException {
		List<Fornecedor> lista = new ArrayList<Fornecedor>();
		fDao = new FornecedorDAOImpl();
		try {
			lista = fDao.listaFornecedor(nome);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
		
		return lista;
	}

	@Override
	public Fornecedor consultaFornecedorId(String id) throws SQLException {
		Fornecedor f = new Fornecedor();
		fDao = new FornecedorDAOImpl();
		f = fDao.consultarFornecedor(id);
		return f;
	}
	
	

}
