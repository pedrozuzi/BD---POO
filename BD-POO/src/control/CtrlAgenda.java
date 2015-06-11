package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistence.AgendaDao;
import persistence.AgendaDaoImpl;
import entity.Agenda;

public class CtrlAgenda {
	
	private AgendaDao aDao;
	
	public List<Agenda> buscarAgenda() {
		aDao = new AgendaDaoImpl();
		List<Agenda> lista = new ArrayList<Agenda>();
		try {
			lista = aDao.BuscarAgenda();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Boolean> buscaDisp() {
		List<Boolean> disp = new ArrayList<Boolean>();
		aDao = new AgendaDaoImpl();
		//disp = aDao.
		return null;
		
	}
}
