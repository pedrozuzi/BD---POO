package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1, u.getF().getId() );			//NAO SEI SE FUNCIONA
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
	public boolean verificarUsuario(String nome) throws SQLException {
		
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

	@Override
	public List<Usuario> pesquisarUsuario(String nome) throws SQLException {
		
		List<Usuario> lista = new ArrayList<Usuario>();
		
		String query = "select  f.id, u.username, u.passwor, f.nome, f.cpf, f.salario, f.telefone "
				+ "from usuario u "
				+ "inner join funcionario f "
				+ "on u.id = f.id"
				+ "where f.nome like ? ";
		
		PreparedStatement ps = c.prepareStatement( query );
		ps.setString(1, "%" + nome + "%");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			Usuario u = new Usuario();
			Funcionario f = new Funcionario();
			f.setId( rs.getInt("id") );
			f.setCpf( rs.getString("cpf"));
			f.setSalario( rs.getInt("salario"));
			f.setNome( rs.getString("nome") );
			f.setTelefone( rs.getInt("telefone"));
			u.setF(f);
			u.setNome( rs.getString("username") );
			u.setSenha( rs.getString("senha") );
			lista.add(u);
		}
		
		return lista;
	}
}
