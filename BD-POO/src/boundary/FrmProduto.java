package boundary;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

import control.ConfigTelas;
import control.CtrlIncluiProduto;

/**
 * 
 * @author Hury
 *
 */

public class FrmProduto {

	private JFrame janela = new JFrame("Produto");
	private JTextField txtIdProduto;
	private JTextField txtIdLote;
	private JTextField txtDataValidadeLote;
	private JTextField txtNome;
	private JPanel panLote;
	private JPanel panProduto;
	private JLabel lblNome;
	private JLabel lblNewLabel_1;
	private JLabel lblId_1;
	private JLabel lblDataDeValidade;
	private JTextField txtDescricao;
	private JTextField txtValorVenda;
	private JTextField txtValorCompra;
	private JTextField txtIdFornecedor;
	private JTable tableProduto;

	public FrmProduto(){
		
		JPanel panPrincipal = new JPanel();
		JPanel panForm = new JPanel();
		
		JMenuBar menuBar = new JMenuBar();
		janela.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem);
		
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		
		JPanel panAcoes = new JPanel();
		panAcoes.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panAcoes.setBounds(179, 0, 426, 84);
		panPrincipal.add(panAcoes);
		panAcoes.setLayout(null);
		panAcoes.setOpaque(false);
		
		JButton btnIncluir = new JButton("");
		btnIncluir.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/Insert.png")));
		btnIncluir.setBounds(49, 11, 69, 41);
		panAcoes.add(btnIncluir);
		
		JLabel label = new JLabel("Incluir");
		label.setBounds(59, 58, 40, 19);
		panAcoes.add(label);
		
		JButton btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/Edit.png")));
		btnAlterar.setBounds(143, 11, 69, 41);
		panAcoes.add(btnAlterar);
		
		JLabel label_1 = new JLabel("Alterar");
		label_1.setBounds(163, 58, 40, 19);
		panAcoes.add(label_1);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/Delete.png")));
		btnExcluir.setBounds(232, 11, 69, 41);
		panAcoes.add(btnExcluir);
		
		JLabel label_2 = new JLabel("Excluir");
		label_2.setBounds(242, 58, 40, 19);
		panAcoes.add(label_2);
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/View.png")));
		btnPesquisar.setBounds(326, 11, 69, 41);
		panAcoes.add(btnPesquisar);
		
		JLabel label_3 = new JLabel("Pesquisar");
		label_3.setBounds(336, 58, 59, 19);
		panAcoes.add(label_3);
		
		JPanel panSuperior = new JPanel();
		panSuperior.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panSuperior.setBounds(20, 86, 741, 170);
		panPrincipal.add(panSuperior);
		panSuperior.setLayout(null);
		panSuperior.setOpaque(false);
		
		JButton button_1 = new JButton("");
		button_1.setBounds(241, 152, 69, 18);
		panSuperior.add(button_1);
		button_1.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniRewind.png")));
		
		JButton button_2 = new JButton("");
		button_2.setBounds(309, 152, 69, 18);
		panSuperior.add(button_2);
		button_2.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniBack.png")));
		
		JButton button_3 = new JButton("");
		button_3.setBounds(379, 152, 69, 18);
		panSuperior.add(button_3);
		button_3.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniNext.png")));
		
		JButton button_4 = new JButton("");
		button_4.setBounds(447, 152, 69, 18);
		panSuperior.add(button_4);
		button_4.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniFoward.png")));
		
		tableProduto = new JTable();
		tableProduto.setBounds(10, 11, 721, 134);
		panSuperior.add(tableProduto);
		
		JPanel panInferior = new JPanel();
		panInferior.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panInferior.setBounds(20, 263, 741, 290);
		panPrincipal.add(panInferior);
		panInferior.setOpaque(false);
		panInferior.setLayout(null);
		
		panLote = new JPanel();
		panLote.setBounds(35, 201, 472, 82);
		panInferior.add(panLote);
		panLote.setBorder(new TitledBorder(null, "Lote", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panLote.setLayout(null);
		panLote.setOpaque(false);
		
		txtIdLote = new JTextField();
		txtIdLote.setBounds(108, 21, 86, 20);
		panLote.add(txtIdLote);
		txtIdLote.setColumns(10);
		
		lblId_1 = new JLabel("Id:");
		lblId_1.setBounds(65, 21, 33, 20);
		panLote.add(lblId_1);
		
		lblDataDeValidade = new JLabel("Data de Validade:");
		lblDataDeValidade.setBounds(10, 52, 101, 20);
		panLote.add(lblDataDeValidade);
		
		txtDataValidadeLote = new JTextField();
		txtDataValidadeLote.setBounds(108, 52, 106, 20);
		panLote.add(txtDataValidadeLote);
		txtDataValidadeLote.setColumns(10);
		
		JPanel panProduto = new JPanel();
		panProduto.setBounds(35, 11, 677, 193);
		panInferior.add(panProduto);
		panProduto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Produto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panProduto.setLayout(null);
		panProduto.setOpaque(false);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(83, 16, 15, 14);
		panProduto.add(lblId);
		
		txtNome = new JTextField();
		txtNome.setBounds(106, 50, 168, 20);
		panProduto.add(txtNome);
		txtNome.setColumns(10);
		
		txtIdProduto = new JTextField();
		txtIdProduto.setBounds(104, 15, 61, 20);
		panProduto.add(txtIdProduto);
		txtIdProduto.setColumns(10);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(62, 46, 36, 20);
		panProduto.add(lblNome);
		
		lblNewLabel_1 = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel_1.setBounds(46, 82, 52, 20);
		panProduto.add(lblNewLabel_1);
		
		JButton btnPesquisaProduto = new JButton("");
		btnPesquisaProduto.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniLupa.png")));
		btnPesquisaProduto.setBounds(189, 5, 30, 25);
		panProduto.add(btnPesquisaProduto);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(106, 85, 168, 20);
		panProduto.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setFont(new Font("Arial", Font.BOLD, 10));
		lblPesquisar.setBounds(177, 24, 61, 25);
		panProduto.add(lblPesquisar);
		
		txtValorVenda = new JTextField();
		txtValorVenda.setColumns(10);
		txtValorVenda.setBounds(104, 113, 61, 20);
		panProduto.add(txtValorVenda);
		
		txtValorCompra = new JTextField();
		txtValorCompra.setColumns(10);
		txtValorCompra.setBounds(106, 154, 61, 20);
		panProduto.add(txtValorCompra);
		
		JLabel lblValorDeVenda = new JLabel("Valor de Venda:");
		lblValorDeVenda.setBounds(14, 118, 84, 20);
		panProduto.add(lblValorDeVenda);
		
		JLabel lblValorDeCompra = new JLabel("Valor de Compra:");
		lblValorDeCompra.setBounds(10, 154, 88, 20);
		panProduto.add(lblValorDeCompra);
		
		JLabel lblFornecedor = new JLabel("Fornecedor:");
		lblFornecedor.setBounds(346, 46, 88, 20);
		panProduto.add(lblFornecedor);
		
		txtIdFornecedor = new JTextField();
		txtIdFornecedor.setColumns(10);
		txtIdFornecedor.setBounds(417, 46, 126, 20);
		panProduto.add(txtIdFornecedor);
		
		JLabel lblBackGround = new JLabel("");
		lblBackGround.setBounds(0, 0, 785, 562);
		panPrincipal.add(lblBackGround);
		lblBackGround.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/BackGround.png")));
		
		janela.setSize(801,624);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CtrlIncluiProduto incluirprod = new CtrlIncluiProduto(txtIdProduto, txtNome, txtDescricao,
				txtValorVenda, txtValorCompra, txtIdFornecedor, txtIdLote, txtDataValidadeLote);
		
		JButton btnPesquisaFornecedor = new JButton("");
		btnPesquisaFornecedor.setBounds(594, 46, 30, 25);
		panProduto.add(btnPesquisaFornecedor);
		
		JLabel label_4 = new JLabel("Pesquisar");
		label_4.setFont(new Font("Arial", Font.BOLD, 10));
		label_4.setBounds(579, 69, 61, 25);
		panProduto.add(label_4);
		
		JPanel panel = new JPanel();
		panel.setBounds(517, 215, 195, 64);
		panInferior.add(panel);
		panel.setLayout(null);
		
		JLabel lblVoltar = new JLabel("Voltar");
		lblVoltar.setBounds(20, 40, 40, 19);
		panel.add(lblVoltar);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.setBounds(10, 11, 49, 25);
		panel.add(btnVoltar);
		btnVoltar.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniBack.png")));
		
		JLabel lblLimpar = new JLabel("Limpar");
		lblLimpar.setBounds(80, 40, 40, 19);
		panel.add(lblLimpar);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.setBounds(70, 11, 49, 25);
		panel.add(btnLimpar);
		btnLimpar.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniClear.png")));
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setBounds(130, 11, 49, 25);
		panel.add(btnSalvar);
		btnSalvar.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniSalvar.png")));
		
		JLabel lblSalvar = new JLabel("Salvar");
		lblSalvar.setBounds(139, 40, 40, 19);
		panel.add(lblSalvar);
		
		btnSalvar.addActionListener(incluirprod);
		
		
		
	}
	
	
	public static void main(String[] args) {
		new FrmProduto();
	}
}
