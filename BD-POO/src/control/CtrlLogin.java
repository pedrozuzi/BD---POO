package control;

import java.sql.SQLException;

import persistence.LoginDao;
import persistence.LoginDaoImpl;
import entity.Usuario;

public class CtrlLogin {
	
	private LoginDao lDao;
	
	public boolean realizarLogin(Usuario u) {
		lDao = new LoginDaoImpl();
		try {
			return lDao.realizarLogin(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
