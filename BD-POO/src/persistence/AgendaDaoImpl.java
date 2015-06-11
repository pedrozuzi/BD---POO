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
import entity.Animal;
import entity.Cliente;
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
	public List<ClienteAgenda> buscaServicoMarcado() throws SQLException {
		List<ClienteAgenda> lista = new ArrayList<ClienteAgenda>();
		String sql = "select an.nome, "
				+ "s.nome as nome_servico, c.nome as nome_cliente "
				+ ",CONVERT(CHAR(5), a.hora, 108) as hora "
				+ "from animal an "
				+ "inner join cliente c "
				+ "on an.id = c.id "
				+" inner join servico s "
				+ "on c.id = s.id "
				+ "inner join agenda a "
				+ "on s.id = a.id_servico";
		
		PreparedStatement ps = c.prepareStatement( sql );
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ){
			Animal an = new Animal();
			Servico s = new Servico();
			Cliente c = new Cliente();
			ClienteAgenda ca = new ClienteAgenda();
			
			an.setNome( rs.getString("nome") );
			s.setNome( rs.getString("nome_servico") );
			c.setNome( rs.getString("nome_cliente") );
			ca.setHora(rs.getString("hora") );
			ca.setAnimal(an);
			ca.setCliente(c);
			ca.setServico(s);
			lista.add(ca);
		}
		ps.close();
		return lista;
		
	}
	
	public List<Boolean> buscaDisp() throws SQLException {
		List<Boolean> disp = new ArrayList<Boolean>();
		String sql = "select disponibilidade from agenda";
		
		PreparedStatement ps = c.prepareStatement( sql );
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ){
			Agenda a = new Agenda();
			a.setEscolhaHorario( rs.getBoolean("disponibilidade"));
			//disp.add(a);
		}
		return disp;
		
	}
	
	public List<Agenda> buscaAgendaVazia() throws SQLException {
		List<Agenda> lista = new ArrayList<Agenda>();
		String sql = "select CONVERT(CHAR(5), hora, 108) as hora, disponibilidade"
				+ " from agenda";
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

}
