package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.Lote;
import entity.Produto;
import entity.Venda;
import persistence.ProdutoDao;
import persistence.ProdutoDaoImpl;
import persistence.VendaDao;
import persistence.VendaDaoImpl;

/**
 * 
 * @author Hury
 *
 */
public class CtrlVenda implements ActionListener {

	private VendaDao vDao;

	public CtrlVenda() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String acao = e.getActionCommand();

		if (acao.equalsIgnoreCase("ACAOSALVA")) {

		} else if (acao.equalsIgnoreCase("ACAOGRAVA")) {

		} else if (acao.equalsIgnoreCase("ACAOSEXCLUI")) {

		} else if (acao.equalsIgnoreCase("ACAOPESQUISA")) {
			
		}

	}

	public void insereVenda(Venda vend) {
		vDao = new VendaDaoImpl();

		try {
			vDao.insereVenda(vend);
			System.out.println("Venda incluida");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO - Venda",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void excluiVenda(Venda vend) {
		vDao = new VendaDaoImpl();
		try {
			vDao.excluiVenda(vend);
			System.out.println("Venda Excluida");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO - Venda",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void atualizaVenda(Venda vend) {
		vDao = new VendaDaoImpl();
		try {
			vDao.atualizaVenda(vend);
			JOptionPane.showMessageDialog(null,
					"Venda Atualizado com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO - Venda",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public List<Venda> buscaVenda(Venda vend) throws SQLException {
		List<Venda> lista = new ArrayList<Venda>();
		vDao = new VendaDaoImpl();
		try {
			lista = vDao.pesquisaVenda(vend);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO - Venda",
					JOptionPane.ERROR_MESSAGE);
		}
		return lista;
	}

}
