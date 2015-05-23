package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Fornecedor;
import entity.Pessoa;

public class FornecedorDAOImpl implements FornecedorDAO,PessoaDao {
	
	public FornecedorDAOImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	
	private Connection c;

	@Override
	public void inserirFornecedor(Fornecedor f, int id) throws SQLException {
		String query = "insert into fornecedor values (?, ?, ?)";
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1, id);
		ps.setString(2, f.getNome() );
		ps.setInt(3, f.getTelefone() );
		ps.execute();
		ps.close();
		JOptionPane.showMessageDialog(null, "Fornecedor inserido com sucesso!",
				"Aviso", JOptionPane.INFORMATION_MESSAGE);
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
		ps.close();
		return lista;
	}

	@Override
	public int inserePessoa(Pessoa pes) throws SQLException {
		String sql = "insert into pessoa (idTipo) values (?)";
		PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, 4);
		ps.execute();
		
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		
		int id = rs.getInt(1);
		pes.setIdPessoa(id);
		
		ps.close();
		return id;
	}

	@Override
	public void atualizaPessoa(Pessoa pes) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluiPessoa(Pessoa pes) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pessoa consultaPessoa(Pessoa pes) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> listaPessoa() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
