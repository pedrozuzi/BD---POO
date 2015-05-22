package control;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import persistence.FornecedorDAO;
import persistence.FornecedorDAOImpl;
import entity.Fornecedor;

public class CtrlFornecedor {
	
	private FornecedorDAO dao;
	
	public void inserir(Fornecedor f) {
		dao = new FornecedorDAOImpl();
		try {
			dao.inserirFornecedor(f);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
