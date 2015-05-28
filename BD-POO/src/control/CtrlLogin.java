package control;

import java.sql.Connection;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Usuario;

public class CtrlLogin {
	
	private Connection c;
	
	public CtrlLogin() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	
	public void realizarLogin(Usuario l) {
		System.out.println(l.getSenha());
		//TODO
	}

}
