package control;

import java.sql.Connection;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Login;

public class CtrlLogin {
	
	private Connection c;
	
	public CtrlLogin() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	
	public void realizarLogin(Login l) {
		//TODO
	}

}
