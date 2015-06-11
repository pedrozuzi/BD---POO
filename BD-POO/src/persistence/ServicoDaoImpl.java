package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Cliente;
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

	@Override
	public List<Servico> buscarServicosAgendados() throws SQLException {
		List<Servico> lista = new ArrayList<Servico>();
		
		String query = "select s.id as codigo_servico, CONVERT(CHAR(5), a.hora, 108) as hora, "
				+ "s.nome as nome_servico, "
				+ "s.id_cliente as codigo_cliente, "
				+ "c.nome as nome_cliente "
				+ "from cliente c "
				+ "inner join servico s "
				+ "on c.id = s.id_cliente "
				+ "inner join agenda a "
				+ "on s.id = a.id_servico "
				+ "where hora > CONVERT(CHAR(5), GETDATE()-'14:00', 108)";		
		PreparedStatement ps = c.prepareStatement( query );
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()){
			System.out.println("ENTROU");
			Servico s = new Servico();
			Cliente c = new Cliente();
			c.setId( rs.getInt("codigo_cliente") );
			c.setNome( rs.getString("nome_cliente") );
			s.setCodigo( rs.getInt("codigo_servico") );
			s.setNome( rs.getString("nome_servico") );
			s.setCliente(c);
			System.out.println(s.getNomeCliente());
			lista.add(s);
		}
		return lista;
	}

}
