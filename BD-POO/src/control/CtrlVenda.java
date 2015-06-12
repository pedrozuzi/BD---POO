package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;








//import entity.Lote;
//import entity.Produto;
import entity.Venda;
import entity.VendaProduto;
//import persistence.ProdutoDao;
//import persistence.ProdutoDaoImpl;
import persistence.VendaDao;
import persistence.VendaDaoImpl;

/**
 * 
 * @author Hury
 *
 */
public class CtrlVenda implements ActionListener {

	private JTextField txtIdVenda;
	private JTextField txtIdCliente;
	private JTextField txtIdVendedor;
	private JTextField txtDataVenda;
	@SuppressWarnings("unused")
	private JTextField txtNomeCli;
	@SuppressWarnings("unused")
	private JTextField txtCodProdServ;
	@SuppressWarnings("unused")
	private JTextField txtNomeProdServ;
	@SuppressWarnings("unused")
	private JTextField txtQtdeProdServ;
	@SuppressWarnings("unused")
	private JTextField txtDinheiroRecebido;

	private JLabel lblTotal;
	@SuppressWarnings("unused")
	private JLabel lblData;

	@SuppressWarnings("unused")
	private Object[] objetosTela = new Object[25];

	private VendaDao vDao;

	public CtrlVenda(Object[] objetosTela) {

		this.txtIdVenda = (JTextField) objetosTela[0];
		this.txtIdCliente = (JTextField) objetosTela[1];
		this.txtIdVendedor = (JTextField) objetosTela[2];
		this.txtDataVenda = (JTextField) objetosTela[3];
		this.txtNomeCli = (JTextField) objetosTela[4];
		this.txtCodProdServ = (JTextField) objetosTela[5];
		this.txtNomeProdServ = (JTextField) objetosTela[6];
		this.txtQtdeProdServ = (JTextField) objetosTela[7];
		this.txtDinheiroRecebido = (JTextField) objetosTela[8];
		this.lblTotal = (JLabel) objetosTela[9];
		this.lblData = (JLabel) objetosTela[10];

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String acao = e.getActionCommand();

		if (acao.equalsIgnoreCase("ACAOSALVA")) {

			Venda vend = new Venda();
			vend.setId(Integer.parseInt(txtIdVenda.getText()));
			vend.setIdcliente(Integer.parseInt(txtIdCliente.getText()));
			vend.setIdfuncionario(Integer.parseInt(txtIdVendedor.getText()));
			vend.setTotal(Double.parseDouble(lblTotal.getText()));

			VendaProduto vprod = new VendaProduto();
			// data
			try {
				String data = txtDataVenda.getText();
				java.sql.Date date = null;
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				date = new java.sql.Date(
						((java.util.Date) formatter.parse(data)).getTime());
				vprod.setData(date);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			//FIXME
			//vprod.setIdproduto();
			vprod.setIdvenda(Integer.parseInt(txtIdVenda.getText()));
			//vprod.setQuantidade();
			
				insereVenda(vend);

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
