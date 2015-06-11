package boundary;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

import control.ConfiguracoesTela;
import entity.Usuario;

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
	
	public FrmCadastros(Usuario u) {
		
		janela = new JFrame("Menu Cadastros");
		
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setLayout(null);
		
		lblTiraCinza = new JLabel("");
		lblTiraCinza.setIcon(new ImageIcon(this.getClass().getResource("/img/TiraCinza.png")));
		lblTiraCinza.setBounds(0, 176, 157, 14);
		panPrincipal.add(lblTiraCinza);
		
		lblTiraVermelha = new JLabel("");
		lblTiraVermelha.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/TiraVermelha.png")));
		lblTiraVermelha.setBounds(0, 201, 449, 14);
		panPrincipal.add(lblTiraVermelha);
		
		lblProduto = new JLabel("(F3) Produto");
		lblProduto.setBounds(320, 326, 100, 14);
		panPrincipal.add(lblProduto);
		
		lblFornecedor = new JLabel("(F1) Fornecedor");
		lblFornecedor.setBounds(35, 326, 97, 14);
		panPrincipal.add(lblFornecedor);
		
		lblFuncionario = new JLabel("(F2) Funcion\u00E1rio");
		lblFuncionario.setBounds(170, 326, 97, 14);
		panPrincipal.add(lblFuncionario);
		
		btnFornecedor = new JButton("");
		btnFornecedor.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/fornecedor.png")));
		btnFornecedor.setBounds(25, 239, 97, 89);
		panPrincipal.add(btnFornecedor);
		
		btnFuncionario = new JButton("");
		btnFuncionario.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/funcionario.png")));
		btnFuncionario.setBounds(170, 239, 97, 89);
		panPrincipal.add(btnFuncionario);
		
		btnProduto = new JButton("");
		btnProduto.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/produto.png")));
		btnProduto.setBounds(310, 239, 97, 88);
		panPrincipal.add(btnProduto);
		
		btnUsuario = new JButton("");
		btnUsuario.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/usuario.png")));
		btnUsuario.setBounds(310, 369, 97, 89);
		panPrincipal.add(btnUsuario);
		
		btnCliente = new JButton("");
		btnCliente.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/cliente.png")));
		btnCliente.setBounds(25, 369, 97, 89);
		panPrincipal.add(btnCliente);
		
		btnAnimal = new JButton("");
		btnAnimal.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/pata.png")));
		btnAnimal.setBounds(170, 369, 99, 89);
		panPrincipal.add(btnAnimal);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(this.getClass().getResource("/img/logo.png")));
		lblLogo.setBounds(99, -8, 243, 219);
		panPrincipal.add(lblLogo);
		
		lblAnimal = new JLabel("(F5) Animal");
		lblAnimal.setBounds(183, 458, 97, 14);
		panPrincipal.add(lblAnimal);
		
		lblUsuario = new JLabel("(F6) Usu\u00E1rio");
		lblUsuario.setBounds(323, 458, 97, 14);
		panPrincipal.add(lblUsuario);
		
		lblCliente = new JLabel("(F4) Cliente");
		lblCliente.setBounds(25, 458, 97, 14);
		panPrincipal.add(lblCliente);
		
		janela.setContentPane( panPrincipal );
		configTela = new ConfiguracoesTela();
		janela.setSize(455,512);
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
		
//		janela.setLocationRelativeTo(null);
//		janela.setResizable(false);
//		janela.setVisible(true);
//		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void fechar() {
		janela.dispose();
		janela = null;
	}

//	public static void main(String[] args) {
//		new FrmCadastros();
//	}
}
