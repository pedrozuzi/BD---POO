package control;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import persistence.FuncionarioDao;
import persistence.FuncionarioDaoImpl;
import entity.Funcionario;

public class CtrlFuncionario {

	private FuncionarioDao fDao;
	
	public void incluir(Funcionario f){
		fDao = new FuncionarioDaoImpl();
		try {
			fDao.inserirFuncionario(f);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public int pegarCodigo(){
		return 0;
	}
	
	
}
