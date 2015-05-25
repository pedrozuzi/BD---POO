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
	public int inserePessoa(Pessoa pes) throws SQLException { //FIXME
		String sql = "insert into pessoa (idTipo) values (?)";
		PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, 4);
		ps.execute();
		
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		
		int id = rs.getInt(1);
		pes.setId(id);
		
		ps.close();
		return id;
		
//		String sql = "insert into pessoa (idTipo) values (?)";
//		PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//		
////		System.out.println("Teste"+pes.getClass());
////		System.exit(0);
//		
//		ps.setInt(1, pes.getIdTipo() );
//		ps.execute();
//		
//		ResultSet rs = ps.getGeneratedKeys();
//		rs.next();
//		
//		int id = rs.getInt(1);
//		pes.setId(id);
//		System.out.println("ID... "+pes.getId());
//		ps.close();
//		return id;
	}
				
//		String sql = "INSERT INTO pessoa (id_tipo)"+
//				"VALUES(?)";
//		PreparedStatement ps = c.prepareStatement(sql);
//		ps.setInt(1, pes.getIdTipo());
//		ps.execute();
//		ps.close();
		
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
