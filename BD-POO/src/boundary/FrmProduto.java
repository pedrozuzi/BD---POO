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
		
		JPanel panProduto = new JPanel();
		panProduto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Produto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panProduto.setBounds(38, 54, 529, 136);
		panPrincipal.add(panProduto);
		panProduto.setLayout(null);
		panProduto.setOpaque(false);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(74, 24, 15, 14);
		panProduto.add(lblId);
		
		textField_3 = new JTextField();
		textField_3.setBounds(106, 52, 168, 20);
		panProduto.add(textField_3);
		textField_3.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(106, 21, 61, 20);
		panProduto.add(textField);
		textField.setColumns(10);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(58, 52, 44, 20);
		panProduto.add(lblNome);
		
		lblNewLabel_1 = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel_1.setBounds(37, 83, 61, 20);
		panProduto.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniLupa.png")));
		btnNewButton.setBounds(197, 11, 30, 25);
		panProduto.add(btnNewButton);
		
		textField_4 = new JTextField();
		textField_4.setBounds(106, 84, 168, 41);
		panProduto.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setFont(new Font("Arial", Font.BOLD, 8));
		lblPesquisar.setBounds(193, 35, 44, 14);
		panProduto.add(lblPesquisar);
		
		panLote = new JPanel();
		panLote.setBorder(new TitledBorder(null, "Lote", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panLote.setBounds(38, 201, 529, 100);
		panPrincipal.add(panLote);
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
		textField_2.setBounds(104, 50, 106, 25);
		panLote.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniSalvar.png")));
		btnNewButton_1.setBounds(487, 326, 69, 23);
		panPrincipal.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniX.png")));
		btnNewButton_2.setBounds(383, 326, 69, 23);
		panPrincipal.add(btnNewButton_2);
		
		JLabel lblAdicionar = new JLabel("Adicionar");
		lblAdicionar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdicionar.setBounds(497, 350, 69, 23);
		panPrincipal.add(lblAdicionar);
		
		JLabel lblLimparCampos = new JLabel("Limpar Campos");
		lblLimparCampos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLimparCampos.setBounds(372, 350, 103, 23);
		panPrincipal.add(lblLimparCampos);
		
		JLabel lblBackGround = new JLabel("New label");
		lblBackGround.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/BackGround.png")));
		lblBackGround.setBounds(0, 0, 606, 429);
		panPrincipal.add(lblBackGround);
		janela.setSize(622,489);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {

		new FrmProduto();
	}
}
