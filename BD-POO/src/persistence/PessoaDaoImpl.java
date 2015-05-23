package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
	public void inserePessoa(Pessoa pes) throws SQLException { //FIXME
				
		String sql = "INSERT INTO pessoa (id_tipo)"+
				"VALUES(?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, pes.getIdTipo());
		ps.execute();
		ps.close();
		
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
