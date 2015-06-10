package control;

import java.sql.SQLException;

import persistence.ServicoDao;
import persistence.ServicoDaoImpl;

public class CtrlServico {

	ServicoDao sDao;
	
	public void incluirServico() {
		
	}
	
	public int buscarNovaEntrada(){
		sDao = new ServicoDaoImpl();
		int auxiliar = 0;
		try {
			auxiliar = sDao.buscarNovaEntrada();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return auxiliar;
	}
	
}
