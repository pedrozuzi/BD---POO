package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Funcionario;
import entity.Usuario;

/**
 * Classe para comunicação com o banco de
 * dados para verificação de um Usuário
 * @author Pedro Zuzi
 *
 */
public class LoginDaoImpl implements LoginDao{
	
	private Connection c;
	
	/**
	 * Construtor
	 */
	public LoginDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	/**
	 * Método para verficar as credenciais do usuário
	 * @param u Objeto Usuário
	 * @return true se usuário existe, false se não existe
	 * @throws SQLException exceção do banco de dados
	 */
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
