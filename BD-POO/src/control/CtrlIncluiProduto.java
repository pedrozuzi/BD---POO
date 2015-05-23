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

import persistence.LoteDao;
import persistence.LoteProdutoDao;
import persistence.ProdutoDao;
import persistence.ProdutoDaoImpl;
import entity.Lote;
import entity.LoteProduto;
import entity.Produto;

public class CtrlIncluiProduto implements ActionListener{
   private JTextField txtIdProduto, txtNome,
   txtDescricao, txtValorVenda, txtValorCompra,txtIdFornecedor, txtIdLote, txtDataValidadeLote;
	

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
		
	//	prod.setId(Integer.parseInt(txtIdProduto.getText())); //TODO Este valor é automatico, não deve ser chumbado.
		prod.setNome(txtNome.getText());
		prod.setDescricao(txtDescricao.getText());
		prod.setValor_venda(Integer.parseInt(txtValorVenda.getText()));
		prod.setValor_compra(Integer.parseInt(txtValorCompra.getText()));
		prod.setId_fornecedor(Integer.parseInt(txtIdFornecedor.getText())); //TODO Este valor deve ser pesquisado.
		
	//	lot.setId(Integer.parseInt(txtIdLote.getText())); //TODO Este valor é automatico, não deve ser chumbado.
		
        //data
        try {
    		String data =txtDataValidadeLote.getText();
    		java.sql.Date date = null; 
    		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			date = new java.sql.Date( ((java.util.Date)formatter.parse(data)).getTime() );
			lot.setData_validade(date); //FIXME 
		} catch (ParseException e1) {
			e1.printStackTrace();
			
		}
       		
		//TODO SELECT IDENT_CURRENT('produto'); SELECT IDENT_CURRENT('lote');
		//lotprod.setIdProduto(prod.getId()); 
		//lotprod.setIdLote(lot.getId());
		
        //XXX temporario 
		lotprod.setIdProduto(Integer.parseInt(txtIdProduto.getText())); 
		lotprod.setIdLote(Integer.parseInt(txtIdLote.getText()));
		
	//	insereProduto(prod);
	//	insereLote(lot);
		insereLoteProduto(lotprod);
		
		System.out.println("prod: "+prod.getId()+" lot: "+lot.getId());
		
	}

	public void insereProduto(Produto prod){
		ProdutoDao pDao = new ProdutoDaoImpl();
		try {
			pDao.insereProduto(prod);
			System.out.println("Produto Incluido");

			//TODO limpa campos
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"ERRO - Produto", JOptionPane.ERROR_MESSAGE);
		}	
	}
	
	public void insereLote(Lote lot){
		LoteDao lDao = new ProdutoDaoImpl();
		try {
			lDao.insereLote(lot);
			System.out.println("Lote incluido!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"ERRO - Lote", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void insereLoteProduto(LoteProduto lotprod){
		LoteProdutoDao lpDao = new ProdutoDaoImpl();
		try {
			lpDao.insereLoteProduto(lotprod);
			System.out.println("LoteProduto Incluido!");
			JOptionPane.showMessageDialog(null, 
					"Produto incluido com Sucesso","Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"ERRO - LoteProduto", JOptionPane.ERROR_MESSAGE);
		}
	}
}
