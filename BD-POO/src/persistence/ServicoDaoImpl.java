package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

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
		String query = "insert into servico (id, nome, valor, id_cliente) values"
				+ " (?, ?, ?, ?)";
		
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1, servico.getCodigo());
		ps.setString(2, servico.getNome());
		ps.setInt(3, servico.getValor());
		ps.setInt(4, servico.getCliente().getId());
		ps.execute();
		ps.close();
		

	}

	@Override
	public int buscarNovaEntrada() throws SQLException {
		
		String query = "select max(id) from servico";
		
		PreparedStatement ps = c.prepareStatement( query );

		ResultSet rs = ps.executeQuery();
		rs.next();

		return rs.getInt(1) == 0 ? 1 : rs.getInt(1)+1;
	}

}
