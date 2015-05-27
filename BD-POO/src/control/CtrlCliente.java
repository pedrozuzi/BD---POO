package control;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import persistence.ClienteDao;
import persistence.ClienteDaoImpl;
import persistence.PessoaDao;
import persistence.PessoaDaoImpl;
import entity.Cliente;

public class CtrlCliente {
	
	private PessoaDao pDao;
	private ClienteDao cDao;
	
	public void inserir(Cliente c) {
		pDao = new PessoaDaoImpl();
		cDao = new ClienteDaoImpl();
		try {
			pDao.inserePessoa(c);
			cDao.inserirCliente(c);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
