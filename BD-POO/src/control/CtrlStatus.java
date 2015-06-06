package control;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import persistence.StatusDao;
import persistence.StatusDaoImpl;

public class CtrlStatus {

	private StatusDao sDao;
	
	public String verificaStatus(){
		String status = "OFFLINE";
		
		sDao = new StatusDaoImpl();
		try {
			status = sDao.status();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
		
		return status; 
	}
	
}
