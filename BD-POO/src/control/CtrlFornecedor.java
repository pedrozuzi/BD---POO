package control;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import persistence.FornecedorDAO;
import persistence.FornecedorDAOImpl;
import persistence.PessoaDao;
import persistence.PessoaDaoImpl;
import entity.Fornecedor;
import entity.Pessoa;

public class CtrlFornecedor {
	
	private FornecedorDAO daoF;
	private PessoaDao daoP;
	
	public void inserir(Fornecedor f) {
		Pessoa p = new Pessoa();
		daoP = new PessoaDaoImpl();
		daoF = new FornecedorDAOImpl();
		try {
			int id = daoP.inserePessoa(p);
			daoF.inserirFornecedor(f, id);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
