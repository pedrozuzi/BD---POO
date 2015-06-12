package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Pessoa;

public class PessoaDaoImpl implements PessoaDao {
	
private Connection c;
	
	public PessoaDaoImpl() {
		GenericConnection gDao = new ConnectionImpl();
		c = gDao.getConnection();
	}

	@Override
	public void inserePessoa(Pessoa pes) throws SQLException { 
		String sql = "insert into pessoa (idTipo) values (?)";
		PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, pes.getIdTipo() );
		ps.execute();
		
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		pes.setId(rs.getInt(1));
		
		ps.close();

	}
		
	@Override
	public void atualizaPessoa(Pessoa pes) throws SQLException {
		String query = "update pessoa set "
				+ "idTipo = ?"
				+ "where idPessoa = ?";
				
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1, pes.getIdTipo() );
		ps.setInt(2, pes.getId() );
		ps.execute();
		ps.close();
		
	}

	@Override
	public void excluiPessoa(Pessoa pes) throws SQLException {
		String sql = "delete pessoa "
				+ "where idPessoa = ?";
		
		PreparedStatement ps = c.prepareStatement( sql );
		ps.setInt(1, pes.getId() );
		ps.execute();
		ps.close();
		
	}

	@Override
	public Pessoa consultaPessoa(Pessoa pes) throws SQLException {
		
		return null;
	}

	@Override
	public List<Pessoa> listaPessoa() throws SQLException {
		
		return null;
	}

}
