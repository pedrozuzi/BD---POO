package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistence.AgendaDao;
import persistence.AgendaDaoImpl;
import entity.Agenda;
import entity.ClienteAgenda;

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
	
	public List<ClienteAgenda> buscarServicoMarcado() {
		aDao = new AgendaDaoImpl();
		List<ClienteAgenda> lista = new ArrayList<ClienteAgenda>();
		try {
			lista = aDao.buscaServicoMarcado();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
		
	}

}
