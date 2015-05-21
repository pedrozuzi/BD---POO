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

/**
 * 
 * @author Hury
 *
 */

public class FrmProduto {

	private JFrame janela = new JFrame("Produto");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPanel panLote;
	private JPanel panProduto;
	private JLabel lblNome;
	private JLabel lblNewLabel_1;
	private JLabel lblId_1;
	private JLabel lblDataDeValidade;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
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
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/Insert.png")));
		button.setBounds(49, 11, 69, 41);
		panAcoes.add(button);
		
		JLabel label = new JLabel("Incluir");
		label.setBounds(59, 58, 40, 19);
		panAcoes.add(label);
		
		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/Edit.png")));
		button_5.setBounds(143, 11, 69, 41);
		panAcoes.add(button_5);
		
		JLabel label_1 = new JLabel("Alterar");
		label_1.setBounds(163, 58, 40, 19);
		panAcoes.add(label_1);
		
		JButton button_6 = new JButton("");
		button_6.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/Delete.png")));
		button_6.setBounds(232, 11, 69, 41);
		panAcoes.add(button_6);
		
		JLabel label_2 = new JLabel("Excluir");
		label_2.setBounds(242, 58, 40, 19);
		panAcoes.add(label_2);
		
		JButton button_8 = new JButton("");
		button_8.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/View.png")));
		button_8.setBounds(326, 11, 69, 41);
		panAcoes.add(button_8);
		
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
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(640, 234, 49, 25);
		panInferior.add(btnNewButton_1);
		btnNewButton_1.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniSalvar.png")));
		
		JLabel lblSalvar = new JLabel("Salvar");
		lblSalvar.setBounds(649, 263, 40, 19);
		panInferior.add(lblSalvar);
		
		panLote = new JPanel();
		panLote.setBounds(35, 201, 500, 82);
		panInferior.add(panLote);
		panLote.setBorder(new TitledBorder(null, "Lote", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panLote.setLayout(null);
		panLote.setOpaque(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(108, 21, 86, 20);
		panLote.add(textField_1);
		textField_1.setColumns(10);
		
		lblId_1 = new JLabel("Id:");
		lblId_1.setBounds(65, 21, 33, 20);
		panLote.add(lblId_1);
		
		lblDataDeValidade = new JLabel("Data de Validade:");
		lblDataDeValidade.setBounds(10, 52, 101, 20);
		panLote.add(lblDataDeValidade);
		
		textField_2 = new JTextField();
		textField_2.setBounds(108, 52, 106, 20);
		panLote.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panProduto_1 = new JPanel();
		panProduto_1.setBounds(35, 11, 677, 193);
		panInferior.add(panProduto_1);
		panProduto_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Produto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panProduto_1.setLayout(null);
		panProduto_1.setOpaque(false);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(83, 16, 15, 14);
		panProduto_1.add(lblId);
		
		textField_3 = new JTextField();
		textField_3.setBounds(106, 50, 168, 20);
		panProduto_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(104, 15, 61, 20);
		panProduto_1.add(textField);
		textField.setColumns(10);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(62, 46, 36, 20);
		panProduto_1.add(lblNome);
		
		lblNewLabel_1 = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel_1.setBounds(46, 82, 52, 20);
		panProduto_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniLupa.png")));
		btnNewButton.setBounds(403, 24, 30, 25);
		panProduto_1.add(btnNewButton);
		
		textField_4 = new JTextField();
		textField_4.setBounds(106, 85, 168, 20);
		panProduto_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setFont(new Font("Arial", Font.BOLD, 8));
		lblPesquisar.setBounds(399, 48, 44, 14);
		panProduto_1.add(lblPesquisar);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(104, 113, 61, 20);
		panProduto_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(106, 154, 61, 20);
		panProduto_1.add(textField_6);
		
		JLabel lblValorDeVenda = new JLabel("Valor de Venda:");
		lblValorDeVenda.setBounds(14, 118, 84, 20);
		panProduto_1.add(lblValorDeVenda);
		
		JLabel lblValorDeCompra = new JLabel("Valor de Compra:");
		lblValorDeCompra.setBounds(10, 154, 88, 20);
		panProduto_1.add(lblValorDeCompra);
		
		JLabel lblFornecedor = new JLabel("Fornecedor:");
		lblFornecedor.setBounds(284, 154, 88, 20);
		panProduto_1.add(lblFornecedor);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(380, 154, 61, 20);
		panProduto_1.add(textField_7);
		
		JButton button_7 = new JButton("");
		button_7.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniClear.png")));
		button_7.setBounds(569, 234, 49, 25);
		panInferior.add(button_7);
		
		JLabel lblLimpar = new JLabel("Limpar");
		lblLimpar.setBounds(579, 263, 40, 19);
		panInferior.add(lblLimpar);
		
		JLabel lblBackGround = new JLabel("");
		lblBackGround.setBounds(0, 0, 785, 562);
		panPrincipal.add(lblBackGround);
		lblBackGround.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/BackGround.png")));
		janela.setSize(801,624);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {

		new FrmProduto();
	}
}
