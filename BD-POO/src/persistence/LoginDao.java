package persistence;

import java.sql.SQLException;

import entity.Usuario;

public interface LoginDao {
	
	boolean realizarLogin(Usuario u) throws SQLException;

}
