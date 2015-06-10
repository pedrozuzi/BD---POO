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
		
		String query = "select COUNT(id) as codigo "
				+ "from servico";
		
		PreparedStatement ps = c.prepareStatement( query );

		ResultSet rs = ps.executeQuery();
		rs.next();

		return rs.getInt(1)+100;
	}

}
