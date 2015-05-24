package control;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import persistence.FuncionarioDao;
import persistence.FuncionarioDaoImpl;
import persistence.PessoaDao;
import persistence.PessoaDaoImpl;
import entity.Funcionario;

public class CtrlFuncionario {

	private FuncionarioDao fDao;
	private PessoaDao pDao;
	
	public void incluir(Funcionario f){
		fDao = new FuncionarioDaoImpl();
		pDao = new PessoaDaoImpl();
		try {
			fDao.inserirFuncionario(f);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
