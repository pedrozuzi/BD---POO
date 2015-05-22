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
import entity.Fornecedor;

public class FornecedorDAOImpl implements FornecedorDAO {
	
	public FornecedorDAOImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	
	private Connection c;

	@Override
	public void inserirFornecedor(Fornecedor f) throws SQLException {
		String query = "insert into fornecedor values (?, ?)";
		PreparedStatement ps = c.prepareStatement( query );
		ps.setString(1, f.getNome() );
		ps.setInt(2, f.getTelefone() );
		ps.execute();
		ps.close();
		JOptionPane.showMessageDialog(null, "Fornecedor inserido com sucesso!");
	}

	@Override
	public void atualizarFornecedor(Fornecedor f) throws SQLException {
		String query = "update fornecedor set "
				+ "nome = ?,"
				+ "telefone = ?"
				+ "where id = ?";
		
		PreparedStatement ps = c.prepareStatement( query );
		ps.setString(1, f.getNome() );
		ps.setInt(2, f.getTelefone() );
		ps.setInt(3, f.getId() );
		ps.execute();
		JOptionPane.showMessageDialog(null, "Dados atualizados");
		ps.close();
		
	}

	@Override
	public void excluirFornecedor(Fornecedor f) throws SQLException {
		String query = "delete fornecedor "
				+ " where id = ?";
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1, f.getId());
		ps.execute();
		JOptionPane.showMessageDialog(null, "Fornecedor excluido com sucesso!");
		ps.close();
		
	}

	@Override
	public Fornecedor consultarFornecedor(Fornecedor f) throws SQLException {
		String query = "select id, nome, telefone "
				+ "from fornecedor where id = ?";
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1,  f.getId() );
		ResultSet rs = ps.executeQuery();
		if( rs.next() ){
			f.setId( rs.getInt("id") );
			f.setNome( rs.getString("nome") );	
			f.setTelefone( rs.getInt("telefone"));
		}
		ps.close();
		return f;
	}

	@Override
	public List<Fornecedor> listaFornecedor(String nome) throws SQLException {
		List<Fornecedor> lista = new ArrayList<Fornecedor>();
		
		String query = "SELECT * FROM fornecedor WHERE nome like ?";
		PreparedStatement ps = c.prepareStatement( query );
		ps.setString( 1, "%" + nome + "%" );
		ResultSet rs = ps.executeQuery();
		
		while( rs.next() ){
			Fornecedor f = new Fornecedor();
			f.setId( rs.getInt( "id") );
			f.setNome( rs.getString( "nome" ) );
			f.setTelefone( rs.getInt( "telefone" ) );
			lista.add( f );
		}
		c.close();
		return lista;
	}

}
