package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Agenda;
import entity.ClienteAgenda;

public interface AgendaDao {
	
	List<Agenda> BuscarAgenda() throws SQLException;
	List<ClienteAgenda> buscaServicoMarcado() throws SQLException;
}
