package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {
	
	private Connection c;
	
	public UsuarioDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	
	@Override
	public void inserirUsuario(Usuario u) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void alterarUsuario(Usuario u) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluirUsuario(Usuario u) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean buscarUsario(String nome) throws SQLException {
		boolean verifica;
		
		String query = "select "
				+ "case "
				+ "when exists (select * from usuario where username = ?) then "
				+ "cast(1 AS bit) "
				+ "else "
				+ "cast(0 AS bit) "
				+ "end as verificacao";
		
		PreparedStatement ps = c.prepareStatement( query );
		ps.setString(1, nome);
		ResultSet rs = ps.executeQuery();
		
		verifica = rs.getBoolean("verificacao");
		return verifica;
	}



}
