package boundary;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import entity.Usuario;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JMenuItem;

import util.ConfiguracoesTela;

public class FrmCadastros {
	
	private JFrame janela;
	private JPanel panPrincipal;
	private JButton btnFornecedor;
	private JButton btnFuncionario;
	private JButton btnProduto;
	private JButton btnUsuario;
	private JButton btnCliente;
	private JButton btnAnimal;
	private JLabel lblLogo;
	private JLabel lblCliente;
	private JLabel lblUsuario;
	private JLabel lblAnimal;
	private JLabel lblProduto;
	private JLabel lblFuncionario;
	private JLabel lblFornecedor;
	private JLabel lblTiraCinza;
	private ConfiguracoesTela configTela;
	private JLabel lblTiraVermelha;
	private JMenuBar mbCadastros;
	private JMenu mnPrincipal;
	private JMenuItem mntmTelaPrincipal;
	private JMenuItem mntmLogOff;
	
	public FrmCadastros(Usuario u) {
		
		janela = new JFrame("Menu Cadastros");
		
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setLayout(null);
		
		lblTiraCinza = new JLabel("");
		lblTiraCinza.setIcon(new ImageIcon(this.getClass().getResource("/img/TiraCinza.png")));
		lblTiraCinza.setBounds(0, 209, 157, 14);
		panPrincipal.add(lblTiraCinza);
		
		lblTiraVermelha = new JLabel("");
		lblTiraVermelha.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/TiraVermelha.png")));
		lblTiraVermelha.setBounds(0, 234, 449, 14);
		panPrincipal.add(lblTiraVermelha);
		
		lblProduto = new JLabel("(F3) Produto");
		lblProduto.setBounds(320, 358, 100, 14);
		panPrincipal.add(lblProduto);
		
		lblFornecedor = new JLabel("(F1) Fornecedor");
		lblFornecedor.setBounds(34, 358, 97, 14);
		panPrincipal.add(lblFornecedor);
		
		lblFuncionario = new JLabel("(F2) Funcion\u00E1rio");
		lblFuncionario.setBounds(172, 358, 97, 14);
		panPrincipal.add(lblFuncionario);
		
		btnFornecedor = new JButton("");
		btnFornecedor.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/fornecedor.png")));
		btnFornecedor.setBounds(24, 271, 97, 89);
		panPrincipal.add(btnFornecedor);
		
		btnFuncionario = new JButton("");
		btnFuncionario.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/funcionario.png")));
		btnFuncionario.setBounds(172, 271, 97, 89);
		panPrincipal.add(btnFuncionario);
		
		btnProduto = new JButton("");
		btnProduto.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/produto.png")));
		btnProduto.setBounds(310, 271, 97, 88);
		panPrincipal.add(btnProduto);
		
		btnUsuario = new JButton("");
		btnUsuario.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/usuario.png")));
		btnUsuario.setBounds(310, 394, 97, 89);
		panPrincipal.add(btnUsuario);
		
		btnCliente = new JButton("");
		btnCliente.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/cliente.png")));
		btnCliente.setBounds(24, 394, 97, 89);
		panPrincipal.add(btnCliente);
		
		btnAnimal = new JButton("");
		btnAnimal.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/pata.png")));
		btnAnimal.setBounds(170, 394, 99, 89);
		panPrincipal.add(btnAnimal);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(this.getClass().getResource("/img/logo.png")));
		lblLogo.setBounds(111, 29, 237, 194);
		panPrincipal.add(lblLogo);
		
		lblAnimal = new JLabel("(F5) Animal");
		lblAnimal.setBounds(183, 483, 97, 14);
		panPrincipal.add(lblAnimal);
		
		lblUsuario = new JLabel("(F6) Usu\u00E1rio");
		lblUsuario.setBounds(323, 483, 97, 14);
		panPrincipal.add(lblUsuario);
		
		lblCliente = new JLabel("(F4) Cliente");
		lblCliente.setBounds(24, 483, 97, 14);
		panPrincipal.add(lblCliente);
		
		janela.setContentPane( panPrincipal );
		
		mbCadastros = new JMenuBar();
		mbCadastros.setBounds(0, 0, 449, 21);
		panPrincipal.add(mbCadastros);
		
		mnPrincipal = new JMenu("Menu");
		mbCadastros.add(mnPrincipal);
		
		mntmTelaPrincipal = new JMenuItem("Menu Principal");
		mntmTelaPrincipal.setIcon(new ImageIcon(FrmCadastros.class.getResource("/img/HomeMenu.png")));
		mnPrincipal.add(mntmTelaPrincipal);
		
		mntmLogOff = new JMenuItem("Log Off");
		mntmLogOff.setIcon(new ImageIcon(FrmCadastros.class.getResource("/img/LogOffMenu.png")));
		mnPrincipal.add(mntmLogOff);
		configTela = new ConfiguracoesTela();
		janela.setSize(457,547);
		configTela.iconeBarra(janela);
		configTela.tamanho(janela);
		
//		ActionMap am = panPrincipal.getActionMap();
//		InputMap im = panPrincipal.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
//		
//		am.put("animal", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new FrmAnimal();
//			}
//		});
//		
//		am.put("fornecedor", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new FrmFornecedor();
//			}
//		});
//		
//		am.put("funcionario", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new FrmFuncionario();
//			}
//		});
//		am.put("produto", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new FrmProduto();
//			}
//		});
//		
//		am.put("cliente", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new FrmCliente();
//			}
//		});
//		
//		am.put("usuario", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new FrmUsuario();
//			}
//		});
//		
//		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "fornecedor");
//		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "funcionario");
//		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), "produto");
//		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0), "cliente");
//		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), "animal");
//		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0), "usuario");
//		
		btnAnimal.addActionListener(e -> {
			fechar();
			new FrmAnimal(u);
		});
		
		btnCliente.addActionListener(e -> {
			fechar();
			new FrmCliente(u);
		});
		btnFornecedor.addActionListener(e -> {
			fechar();
			new FrmFornecedor(u);
		});
		btnFuncionario.addActionListener(e -> {
			fechar();
			new FrmFuncionario(u);
		});
		btnProduto.addActionListener(e -> {
			fechar();
			new FrmProduto(u);
		});
		btnUsuario.addActionListener(e -> {
			fechar();
			new FrmUsuario(u);
		});
		
		mntmTelaPrincipal.addActionListener(e -> {
			fechar();
			new FrmPrincipal(u);
		});
		
		mntmLogOff.addActionListener(e -> {
			fechar();
			new FrmLogin();
		});
		
		
//		janela.setLocationRelativeTo(null);
//		janela.setResizable(false);
//		janela.setVisible(true);
//		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void fechar() {
		janela.dispose();
		janela = null;
	}
}
