package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Usuario;

public class LoginDaoImpl implements LoginDao{
	
	private Connection c;
	
	public LoginDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public boolean realizarLogin( Usuario u ) throws SQLException {
		String query = "select username, passwor "
						+"from usuario "
						+ "where username = ? and passwor = ?";
		
		PreparedStatement ps = c.prepareStatement(query);
		
		ps.setString(1, u.getNome() );
		ps.setString(2, u.getSenha() );
		
		ResultSet rs = ps.executeQuery();
		
		if ( rs.next() ) {
			u.setNome( rs.getString("username"));
			u.setSenha( rs.getString("passwor"));
			ps.close();
			return true;
		}
		
		return false;
	}

}
