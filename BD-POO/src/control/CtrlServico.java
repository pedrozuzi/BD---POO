package control;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import entity.Servico;
import persistence.ServicoDao;
import persistence.ServicoDaoImpl;

public class CtrlServico {

	ServicoDao sDao;
	
	public void incluirServico(Servico servico) {
		sDao = new ServicoDaoImpl();
		
		try {
			sDao.adicionarServico(servico);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public int buscarNovaEntrada(){
		sDao = new ServicoDaoImpl();
		int auxiliar = 0;
		try {
			auxiliar = sDao.buscarNovaEntrada();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
		
		return auxiliar;
	}
	
}
