package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

//TODO
public class CtrlTelaProduto implements ActionListener {
	 private JTextField txtIdProduto, txtNome,
	   txtDescricao, txtValorVenda, txtValorCompra,txtIdFornecedor, txtIdLote, txtDataValidadeLote;
	 private JButton btnIncluir,btnAlterar,btnExcluir,btnPesquisar,btnRewind, btnBack, btnNext,
	 btnfoward, btnPesquisaProduto, btnPesquisaFornecedor, btnVolta, btnLimpa, btnSalva;
	 private JPanel panAcoes;

	 
	 public CtrlTelaProduto(JTextField txtIdProduto, JTextField txtNome,
			JTextField txtDescricao, JTextField txtValorVenda,
			JTextField txtValorCompra, JTextField txtIdFornecedor,
			JTextField txtIdLote, JTextField txtDataValidadeLote,
			JButton btnIncluir, JButton btnAlterar, JButton btnExcluir,
			JButton btnPesquisar, JButton btnRewind, JButton btnBack,
			JButton btnNext, JButton btnfoward, JButton btnPesquisaProduto,
			JButton btnPesquisaFornecedor, JButton btnVolta, JButton btnLimpa,
			JButton btnSalva, JPanel panAcoes) {
		super();
		this.txtIdProduto = txtIdProduto;
		this.txtNome = txtNome;
		this.txtDescricao = txtDescricao;
		this.txtValorVenda = txtValorVenda;
		this.txtValorCompra = txtValorCompra;
		this.txtIdFornecedor = txtIdFornecedor;
		this.txtIdLote = txtIdLote;
		this.txtDataValidadeLote = txtDataValidadeLote;
		this.btnIncluir = btnIncluir;
		this.btnAlterar = btnAlterar;
		this.btnExcluir = btnExcluir;
		this.btnPesquisar = btnPesquisar;
		this.btnRewind = btnRewind;
		this.btnBack = btnBack;
		this.btnNext = btnNext;
		this.btnfoward = btnfoward;
		this.btnPesquisaProduto = btnPesquisaProduto;
		this.btnPesquisaFornecedor = btnPesquisaFornecedor;
		this.btnVolta = btnVolta;
		this.btnLimpa = btnLimpa;
		this.btnSalva = btnSalva;
		this.panAcoes = panAcoes;
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
			panAcoes.setEnabled(false);
	 }
	 
	 public void resetarTela(){
		 
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		limpaCampos();
		
	}
	
}
