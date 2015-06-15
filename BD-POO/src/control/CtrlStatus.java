package control;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import persistence.StatusDao;
import persistence.StatusDaoImpl;

/**
 * Classe que controla a verificação do 
 * status do banco
 * @author Hury
 *
 */
public class CtrlStatus {

	private StatusDao sDao;
	
	/**
	 * Método que busca o status do banco
	 * @return o status do banco
	 */
	public String verificaStatus(){
		String status = "OFFLINE";
		sDao = new StatusDaoImpl();
		
		try {
			status = sDao.status(status);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
		
		return status; 
	}
	
}
