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
import entity.ClienteAgenda;
import entity.Servico;

public class AgendaDaoImpl implements AgendaDao{
	
	private Connection c;
	
	public AgendaDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public List<Agenda> BuscarAgenda() throws SQLException {
		List<Agenda> lista = new ArrayList<Agenda>();
		String sql = "select CONVERT(CHAR(5), hora, 108) as hora, disponibilidade"
					+ " from agenda";
		
		PreparedStatement ps = c.prepareStatement( sql );
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ){
			Agenda a = new Agenda();
			Servico s = new Servico();
			a.setHorario( rs.getString("hora"));
			a.setAuxiliar( rs.getInt("disponibilidade") );
//			s.setNome( rs.getString("nome"));
//			a.setServico(s);
			lista.add(a);
		}
		ps.close();
		return lista;
	}
	
	@Override
	public List<ClienteAgenda> buscaServicoMarcado() throws SQLException {
		List<ClienteAgenda> lista = new ArrayList<ClienteAgenda>();
		String sql = "";
		
		PreparedStatement ps = c.prepareStatement( sql );
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ){
			//TODO
		}
		ps.close();
		return lista;
		
	}

}
