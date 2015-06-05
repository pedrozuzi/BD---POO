package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Funcionario;
import entity.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {
	
	private Connection c;
	
	public UsuarioDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	
	@Override
	public void inserirUsuario(Usuario u) throws SQLException {
		String query = "INSERT INTO usuario (id,username,passwor) "
				+ "VALUES (?, ?, ?) ";
		//Funcionario f = new Funcionario();
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1, u.getF().getId() );			//NAO SEI SE FUNCIONA
		//u.setF(f);							//NAO SEI SE FUNCIONA
		ps.setString(2, u.getNome() );
		ps.setString(3, u.getSenha() );
		ps.execute();
		ps.close();
		JOptionPane.showMessageDialog(null, "usuário criado com sucesso!",
				"Aviso", JOptionPane.INFORMATION_MESSAGE);
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
		rs.next();
		return rs.getBoolean("verificacao");
	}
}
