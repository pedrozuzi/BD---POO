package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

//TODO
public class CtrlTelaProduto implements ActionListener {
	 private JTextField txtIdProduto, txtNome,
	   txtDescricao, txtValorVenda, txtValorCompra,txtIdFornecedor, txtIdLote, txtDataValidadeLote;
	 private JButton btnIncluir,btnAlterar,btnExcluir,btnPesquisar//TODO

	public CtrlTelaProduto(JTextField txtIdProduto, JTextField txtNome,
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
	 
	 public void limpaCampos(){
			txtIdProduto.setText("");;
			txtNome.setText("");
			txtDescricao.setText("");
			txtValorVenda.setText("");
			txtValorCompra.setText("");
			txtIdFornecedor.setText("");
			txtIdLote.setText("");
			txtDataValidadeLote.setText("");
	 }
	 
	 public void resetarTela(){
		 
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
