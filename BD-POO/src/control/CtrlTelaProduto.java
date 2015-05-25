package control;

import java.awt.Component;
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
	 btnFoward, btnPesquisaProduto, btnPesquisaFornecedor, btnVolta, btnLimpa, btnSalva;
	 private JPanel panAcoes, panInferior, panSuperior, panAcoes2,panProduto, panLote;

	public CtrlTelaProduto(JTextField txtIdProduto, JTextField txtNome,
			JTextField txtDescricao, JTextField txtValorVenda,
			JTextField txtValorCompra, JTextField txtIdFornecedor,
			JTextField txtIdLote, JTextField txtDataValidadeLote,
			JButton btnIncluir, JButton btnAlterar, JButton btnExcluir,
			JButton btnPesquisar, JButton btnRewind, JButton btnBack,
			JButton btnNext, JButton btnFoward, JButton btnPesquisaProduto,
			JButton btnPesquisaFornecedor, JButton btnVolta, JButton btnLimpa,
			JButton btnSalva, JPanel panAcoes, JPanel panInferior,
			JPanel panSuperior, JPanel panAcoes2, JPanel panProduto,
			JPanel panLote) {
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
		this.btnFoward = btnFoward;
		this.btnPesquisaProduto = btnPesquisaProduto;
		this.btnPesquisaFornecedor = btnPesquisaFornecedor;
		this.btnVolta = btnVolta;
		this.btnLimpa = btnLimpa;
		this.btnSalva = btnSalva;
		this.panAcoes = panAcoes;
		this.panInferior = panInferior;
		this.panSuperior = panSuperior;
		this.panAcoes2 = panAcoes2;
		this.panProduto = panProduto;
		this.panLote = panLote;
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
	 
	 public void resetaTela(){
		 System.out.println("resetado");
		 Component[] c = panProduto.getComponents();  
         for (int i = 0; i < c.length; i++) {  
             c[i].setEnabled(!c[i].isEnabled());  
         }  
         c= panLote.getComponents(); 
         for (int i = 0; i < c.length; i++) {  
             c[i].setEnabled(!c[i].isEnabled());  
         } 
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();
			if (acao.equalsIgnoreCase("LIMPA")) {
				limpaCampos();
			} else if (acao.equalsIgnoreCase("VOLTA")) {
				resetaTela();
			}
	
	}
	
}
