package persistence;

import java.sql.SQLException;
import java.util.List;
import entity.Agenda;

public interface AgendaDao {
	
	List<Agenda> BuscarAgenda() throws SQLException;
	void atualizaAgenda( Agenda a) throws SQLException;
}
