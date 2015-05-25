package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import persistence.FornecedorDAOImpl;
import persistence.LoteDao;
import persistence.LoteProdutoDao;
import persistence.PessoaDaoImpl;
import persistence.ProdutoDao;
import persistence.ProdutoDaoImpl;
import entity.Fornecedor;
import entity.Lote;
import entity.LoteProduto;
import entity.Pessoa;
import entity.Produto;

public class CtrlIncluiProduto implements ActionListener {
	private JTextField txtIdProduto, txtNome, txtDescricao, txtValorVenda,
			txtValorCompra, txtIdFornecedor, txtIdLote, txtDataValidadeLote;

	private ProdutoDao pDao;
	private LoteDao lDao;
	private LoteProdutoDao lpDao;

	public CtrlIncluiProduto(JTextField txtIdProduto, JTextField txtNome,
			JTextField txtDescricao, JTextField txtValorVenda,
			JTextField txtValorCompra, JTextField txtIdFornecedor,
			JTextField txtIdLote, JTextField txtDataValidadeLote) {
		super();
		this.txtIdProduto = txtIdProduto;
		this.txtNome = txtNome;
		this.txtDescricao = txtDescricao;
		this.txtValorVenda = txtValorVenda;
		this.txtValorCompra = txtValorCompra;
		this.txtIdFornecedor = txtIdFornecedor;
		this.txtIdLote = txtIdLote;
		this.txtDataValidadeLote = txtDataValidadeLote;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Produto prod = new Produto();
		Lote lot = new Lote();
		LoteProduto lotprod = new LoteProduto();

		prod.setNome(txtNome.getText());
		prod.setDescricao(txtDescricao.getText());
		prod.setValor_venda(Integer.parseInt(txtValorVenda.getText()));
		prod.setValor_compra(Integer.parseInt(txtValorCompra.getText()));
		prod.setId_fornecedor(Integer.parseInt(txtIdFornecedor.getText()));

		// data
		try {
			String data = txtDataValidadeLote.getText();
			java.sql.Date date = null;
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			date = new java.sql.Date(
					((java.util.Date) formatter.parse(data)).getTime());
			lot.setData_validade(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		try {
			lotprod.setIdProduto(insereProduto(prod));
			lotprod.setIdLote(insereLote(lot));
			insereLoteProduto(lotprod);
			
		} catch (Exception e2) {
			// TODO: handle exception
		}

		System.out.println("prod: " + prod.getId() + " lot: " + lot.getId());

	}

	public int insereProduto(Produto prod) {
		pDao = new ProdutoDaoImpl();
		int id = 0;
		try {
			id = pDao.insereProduto(prod);
			System.out.println("Produto Incluido");

			// TODO limpa campos

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"ERRO - Produto", JOptionPane.ERROR_MESSAGE);
		}
		return id;
	}

	public int insereLote(Lote lot) {
		lDao = new ProdutoDaoImpl();
		int id = 0;
		try {
			id = lDao.insereLote(lot);
			System.out.println("Lote incluido!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO - Lote",
					JOptionPane.ERROR_MESSAGE);
		}
		return id;
	}

	public void insereLoteProduto(LoteProduto lotprod) {
		lpDao = new ProdutoDaoImpl();
		try {
			lpDao.insereLoteProduto(lotprod);
			System.out.println("LoteProduto Incluido!");
			JOptionPane.showMessageDialog(null, "Produto incluido com Sucesso",
					"Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"ERRO - LoteProduto", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void insereLoteProduto(LoteProduto lotprod, int codprod, int codlot) {
		lpDao = new ProdutoDaoImpl();
		try {
			lotprod.setIdProduto(codprod);
			lotprod.setIdLote(codlot);
			lpDao.insereLoteProduto(lotprod);
			System.out.println("LoteProduto Incluido!");
			JOptionPane.showMessageDialog(null, "Produto incluido com Sucesso",
					"Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"ERRO - LoteProduto", JOptionPane.ERROR_MESSAGE);
		}
	}

}
