package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public void atualiza(Cliente c) {
		cDao = new ClienteDaoImpl();
		try {
			cDao.atualizarCliente(c);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
		
	}

	public List<Cliente> buscaClientePorNome(String nome) throws SQLException {
		List<Cliente> lista = new ArrayList<Cliente>();
		cDao = new ClienteDaoImpl();
		try {
			lista = cDao.listaCliente(nome);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
		return lista;
	}

	public void excluir(Cliente c) {
		cDao = new ClienteDaoImpl();
		
		try {
			cDao.excluirCliente(c);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
