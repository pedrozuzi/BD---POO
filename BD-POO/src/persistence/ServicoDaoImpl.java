package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Servico;

public class ServicoDaoImpl implements ServicoDao {

	private Connection c;
	
	public ServicoDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	
	@Override
	public void adicionarServico(Servico servico) throws SQLException {

	}

	@Override
	public int buscarNovaEntrada() throws SQLException {
		
		String query = "select IDENT_CURRENT('servico') as codigo";
		
		PreparedStatement ps = c.prepareStatement( query, Statement.RETURN_GENERATED_KEYS );
		ps.execute();
		
//		ResultSet rs = ps.getGeneratedKeys();
		ResultSet rs = ps.executeQuery();
		rs.next();
		return 0;
	}

}
