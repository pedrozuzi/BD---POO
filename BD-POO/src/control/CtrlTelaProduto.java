package control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import boundary.FrmProduto;

//TODO
public class CtrlTelaProduto implements ActionListener {
	private JTextField txtIdProduto, txtNome, txtDescricao, txtValorVenda,
			txtValorCompra, txtIdFornecedor, txtIdLote, txtDataValidadeLote;
	private JButton btnIncluir, btnAlterar, btnExcluir, btnPesquisar,
			btnRewind, btnBack, btnNext, btnFoward, btnPesquisaProduto,
			btnPesquisaFornecedor, btnVolta, btnLimpa, btnSalva;
	private JPanel panAcoes, panInferior, panSuperior, panAcoes2, panProduto,
			panLote;
	private JLabel lblAcao;

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
			JPanel panLote, JLabel lblAcao) {
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
		this.lblAcao = lblAcao;
	}

	public void limpaCampos() {
		txtIdProduto.setText("");
		;
		txtNome.setText("");
		txtDescricao.setText("");
		txtValorVenda.setText("");
		txtValorCompra.setText("");
		txtIdFornecedor.setText("");
		txtIdLote.setText("");
		txtDataValidadeLote.setText("");
	}

	// recebe um component e desabibita/reabilita for each compound
	public void comp(Component[] c) {
		for (int i = 0; i < c.length; i++) {
			c[i].setEnabled(!c[i].isEnabled());
		}
	}
	
	public void tfalse(Component[] c){ //desabilita os components
		for (int i = 0; i < c.length; i++) {
			c[i].setEnabled(false);
		}
	}

	public void botoesCrud() {
		Component[] c;
		comp(c = panAcoes.getComponents());
	}

	public void resetaTela() {
		//System.out.println("resetado");
		Component[] c;
		comp(c = panProduto.getComponents());
		comp(c = panLote.getComponents());
		comp(c = panAcoes2.getComponents());
	}

	public void acao() {
		System.out.println("acao");
		Component[] c;
		comp(c = panAcoes.getComponents());
	}
	
	public void incluiLote(){
		Component[] c;
		comp(c = panProduto.getComponents());
		txtNome.setEnabled(true);
	}
	public void incluiProduto(){
		Component[] c;
		comp(c = panLote.getComponents());
	}

	public void inicio() {
		System.out.println("Inicio");
		Component[] c;
		comp(c = panProduto.getComponents());
		comp(c = panLote.getComponents());
		comp(c = panAcoes2.getComponents());

	}

	public void pesquisa(boolean status) {
		btnPesquisaProduto.setEnabled(status);
		btnPesquisaFornecedor.setEnabled(status);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		// acoes basicas de tela
		if (acao.equalsIgnoreCase("LIMPA")) {
			limpaCampos();
		} else if (acao.equalsIgnoreCase("VOLTA")) {
			Component[] c;
			botoesCrud();
			resetaTela();
			limpaCampos();
			pesquisa(false);
            tfalse(c = panLote.getComponents());
            tfalse(c = panProduto.getComponents());
			
		}

		// botao de acoes
		else if (acao.equalsIgnoreCase("ACAOSALVA")) {
			botoesCrud();
			resetaTela();
		} else if (acao.equalsIgnoreCase("ACAOGRAVA")) {
			botoesCrud();
			resetaTela();
		} else if (acao.equalsIgnoreCase("ACAOEXCLUI")) {
			botoesCrud();
			resetaTela();
		} else if (acao.equalsIgnoreCase("ACAOPESQUISA")) {
			botoesCrud();
			resetaTela();
		}

		// panAcaoes
		else if (acao.equalsIgnoreCase("INCLUIR")) {
			acao();
			resetaTela();
			lblAcao.setText("Salvar");
			btnSalva.setIcon(new ImageIcon(FrmProduto.class
					.getResource("/img/MiniSalvar.png")));
			btnSalva.setActionCommand("ACAOSALVA");
			pesquisa(false);
		} else if (acao.equalsIgnoreCase("INCLUIRPRODUTO")) {
			
			acao();
			resetaTela();
			
			incluiProduto();
			
			lblAcao.setText("Salvar");
			btnSalva.setIcon(new ImageIcon(FrmProduto.class
					.getResource("/img/MiniSalvar.png")));
			btnSalva.setActionCommand("ACAOSALVAPRODUTO");
			
			pesquisa(false);

		} else if (acao.equalsIgnoreCase("INCLUIRLOTE")) {
			
			acao();
			resetaTela();
			
			incluiLote();
			
			lblAcao.setText("Salvar novo lote a produto");
			btnSalva.setIcon(new ImageIcon(FrmProduto.class
					.getResource("/img/MiniSalvar.png")));
			btnSalva.setActionCommand("ACAOSALVALOTE");
			
			pesquisa(true);

		} else if (acao.equalsIgnoreCase("ALTERAR")) {
			acao();
			resetaTela();
			lblAcao.setText("Gravar");
			btnSalva.setIcon(new ImageIcon(FrmProduto.class
					.getResource("/img/MiniSalvar.png")));
			btnSalva.setActionCommand("ACAOGRAVA");

		} else if (acao.equalsIgnoreCase("EXCLUIR")) {
			acao();
			resetaTela();
			lblAcao.setText("Excluir");
			btnSalva.setIcon(new ImageIcon(FrmProduto.class
					.getResource("/img/trash.png")));
			btnSalva.setActionCommand("ACAOEXCLUI");

		} else if (acao.equalsIgnoreCase("PESQUISAR")) {
			acao();
			resetaTela();
			lblAcao.setText("Pesquisar");
			btnSalva.setIcon(new ImageIcon(FrmProduto.class
					.getResource("/img/MiniLupa.png")));
			btnSalva.setActionCommand("ACAOPESQUISA");
		}
	}

}
