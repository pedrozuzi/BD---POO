package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.Servico;
import persistence.ServicoDao;
import persistence.ServicoDaoImpl;

/**
 * Classe para controle das funcionalidades da 
 * tela de serviço
 * @author Pedro Afonso
 *
 */
public class CtrlServico {

	ServicoDao sDao;
	
	/**
	 * Método que inclui um serviço realizado
	 * @param servico dados do serviço realizado
	 */
	public void incluirServico(Servico servico) {
		sDao = new ServicoDaoImpl();
		
		try {
			sDao.adicionarServico(servico);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Método que busca a nova entrada para o serviço
	 * a ser realizado
	 * @return código do serviço
	 */
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
	
	/**
	 * Método que busca os serviços já agendados
	 * @return lista de serviços
	 */
	public List<Servico> buscarServicosAgendados(){
		sDao = new ServicoDaoImpl();
		List<Servico> lista = new ArrayList<Servico>();
		
		try {
			lista = sDao.buscarServicosAgendados();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
		
		return lista;
	}
	
	/**
	 * Método que inclui um serviço na agenda
	 * @param s dados do serviço a ser incluido
	 */
	public void incluiServicoAgenda(Servico s) {
		sDao = new ServicoDaoImpl();
		
		try {
			sDao.adicionaServicoAgenda(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
