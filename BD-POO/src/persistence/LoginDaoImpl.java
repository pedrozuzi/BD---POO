package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import boundary.FrmLogin;
import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Funcionario;
import entity.Usuario;

public class LoginDaoImpl implements LoginDao{
	
	private Connection c;
	
	public LoginDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public boolean realizarLogin( Usuario u ) throws SQLException {
//		String query = "select username, passwor "
//						+"from usuario "
//						+ "where username = ? and passwor = ?";
		
		String query = "select f.nome, u.username, u.passwor, t.id, "
				+ "t.descricao "
				+ "from usuario u "
				+ "inner join funcionario f "
				+ "on u.id = f.id "
				+ "inner join pessoa p "
				+ "on f.id = p.idPessoa "
				+ "inner join tipo t "
				+ "on p.idtipo = t.id "
				+ "where username = ?	and passwor = ?";
		
		PreparedStatement ps = c.prepareStatement(query);
		
		ps.setString(1, u.getNome() );
		ps.setString(2, u.getSenha() );
		
		ResultSet rs = ps.executeQuery();
		
		if ( rs.next() ) {
			Funcionario f = new Funcionario();
			u.setNome( rs.getString("username"));
			u.setSenha( rs.getString("passwor"));
			f.setIdTipo( rs.getInt("id"));
			FrmLogin.ID_TIPO = f.getIdTipo();
			ps.close();
			return true;
		}
		
		return false;
	}

}