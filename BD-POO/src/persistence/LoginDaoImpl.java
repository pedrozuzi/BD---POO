package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		String query = "select f.nome, f.cpf, f.salario, u.username, u.passwor, t.id,  "
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
			f.setCpf( rs.getString("cpf") );
			f.setSalario( rs.getDouble("salario"));
			u.setF(f);
			ps.close();
			return true;
		}
		
		return false;
	}

}
