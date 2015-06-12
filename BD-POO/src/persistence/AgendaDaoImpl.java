package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Agenda;

public class AgendaDaoImpl implements AgendaDao{
	
	private Connection c;
	
	public AgendaDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public List<Agenda> BuscarAgenda() throws SQLException {
		List<Agenda> lista = new ArrayList<Agenda>();
		
		String sql = "select CONVERT(CHAR(5), a.hora, 108) as hora, a.disponibilidade, s.nome"
				+ " from servico s"
				+ " right outer join agenda a"
				+ " on s.id = a.id_servico"
				+ " where id_servico is null";
		
		PreparedStatement ps = c.prepareStatement( sql );
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ){
			Agenda a = new Agenda();
			a.setHorario( rs.getString("hora"));
			a.setAuxiliar( rs.getInt("disponibilidade") );
			lista.add(a);
		}
		ps.close();
		return lista;
	}

	@Override
	public void atualizaAgenda( Agenda a ) throws SQLException {
		String sql = "update agenda set disponibilidade = 1, "
				+ "id_servico = ? "
				+ "where hora = ?";
		PreparedStatement ps = c.prepareStatement( sql );
		ps.setInt(1, a.getServico().getCodigo() );
		ps.setString(2, a.getHorario() );
		ps.execute();
		ps.close();
	}

	@Override
	public void encerraAgenda() throws SQLException {
		String sql = "delete agenda";
		PreparedStatement ps = c.prepareStatement( sql );
		ps.execute();
		ps.close();
	}

	@Override
	public void montaNovaAgenda() throws SQLException {
		String sql = "insert into agenda(hora, disponibilidade, id_servico) values "
					+ "('10:00',0, null),"
					+ "('10:30',0, null),"
					+ "('11:00',0, null),"
					+ "('11:30',0, null),"
					+ "('12:00',0, null),"
					+ "('12:30',0, null),"
					+ "('13:00',0, null),"
					+ "('13:30',0, null),"
					+ "('14:00',0, null),"
					+ "('14:30',0, null),"
					+ "('15:00',0, null),"
					+ "('15:30',0, null),"
					+ "('16:00',0, null),"
					+ "('16:30',0, null),"
					+ "('17:00',0, null),"
					+ "('17:30',0, null),"
					+ "('18:00',0, null),"
					+ "('18:30',0, null),"
					+ "('19:00',0, null)";
		PreparedStatement ps = c.prepareStatement( sql );
		ps.execute();
		ps.close();
	}

}
