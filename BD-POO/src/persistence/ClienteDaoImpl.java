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
import entity.Cliente;

public class ClienteDaoImpl implements ClienteDao{
	
	private Connection con;
	
	public ClienteDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		con = gc.getConnection();
	}
	
	@Override
	public void inserirCliente(Cliente c) throws SQLException {
		String query = "insert into cliente values (?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt( 1, c.getId() );
		ps.setString( 2, c.getNome() );
		ps.setString( 3 , c.getLogradouro() );
		ps.setInt( 4 , c.getNumero() );
		ps.setString( 5 , c.getBairro() );
		ps.setInt( 6 , c.getTelefone() );
		ps.execute();
		ps.close();
		JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!",
				"Aviso", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void atualizarCliente(Cliente c) throws SQLException {
		String sql = "update cliente set "
				+ "nome = ?,"
				+ "logradouro = ?,"
				+ "numero = ?,"
				+ "bairro = ?,"
				+ "telefone = ?"
				+ "where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt( 1, c.getId() );
		ps.setString( 2, c.getNome() );
		ps.setString( 3 , c.getLogradouro() );
		ps.setInt( 4 , c.getNumero() );
		ps.setString( 5 , c.getBairro() );
		ps.setInt( 6 , c.getTelefone() );
		ps.execute();
		JOptionPane.showMessageDialog(null, "Dados atualizados");
		ps.close();
	}

	@Override
	public void excluirCliente(Cliente c) throws SQLException {
		String sql = "delete cliente where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt( 1, c.getId() );
		ps.execute();
		JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
		ps.close();
		
	}

	@Override
	public List<Cliente> listaCliente(String nome) throws SQLException {
		List<Cliente> lista = new ArrayList<Cliente>();
		
		String sql = "SELECT * FROM cliente WHERE nome like ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString( 1 , "%" + nome + "%");
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ) {
			Cliente c = new Cliente();
			c.setId( rs.getInt("id") );
			c.setNome( rs.getString("nome") );
			c.setLogradouro( rs.getString("logradouro") );
			c.setNumero( rs.getInt("numero") );
			c.setTelefone( rs.getInt("telefone") );
			lista.add( c );
		}
		ps.close();
		return lista;
	}


}
