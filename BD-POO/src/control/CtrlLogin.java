package control;

import java.sql.Connection;
import java.sql.SQLException;

import persistence.LoginDao;
import persistence.LoginDaoImpl;
import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Usuario;

public class CtrlLogin {
	
	private Connection c;
	private LoginDao lDao;
	
	public CtrlLogin() {
		
	}
	
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
