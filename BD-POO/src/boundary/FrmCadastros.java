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
	
	public FrmCadastros() {
		janela = new JFrame();
		janela.setTitle("Menu Cadastros");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setLayout(null);
		
		// CONFIGURACOES DE TELA, PODER SER NECESSARIO COMENTAR PARA EDITAR NO WINDONBUILDER
		ConfiguracoesTela configTela = new ConfiguracoesTela(janela);
		configTela.iconeBarra(janela);
		
		janela.setSize(453,389);
		janela.setContentPane( panPrincipal );
		
		btnFornecedor = new JButton("");
		btnFornecedor.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/fornecedor.png")));
		btnFornecedor.setBounds(45, 119, 97, 89);
		panPrincipal.add(btnFornecedor);
		
		btnFuncionario = new JButton("");
		btnFuncionario.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/funcionario.png")));
		btnFuncionario.setBounds(169, 119, 97, 89);
		panPrincipal.add(btnFuncionario);
		
		btnProduto = new JButton("");
		btnProduto.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/produto.png")));
		btnProduto.setBounds(291, 119, 97, 88);
		panPrincipal.add(btnProduto);
		
		btnUsuario = new JButton("");
		btnUsuario.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/usuario.png")));
		btnUsuario.setBounds(291, 235, 97, 89);
		panPrincipal.add(btnUsuario);
		
		btnCliente = new JButton("");
		btnCliente.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/cliente.png")));
		btnCliente.setBounds(45, 236, 97, 89);
		panPrincipal.add(btnCliente);
		
		btnAnimal = new JButton("");
		btnAnimal.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/pata.png")));
		btnAnimal.setBounds(167, 236, 99, 89);
		panPrincipal.add(btnAnimal);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/LogoPetShop100.png")));
		lblLogo.setBounds(-11, 11, 433, 112);
		panPrincipal.add(lblLogo);
		
		lblFornecedor = new JLabel("(F1) Fornecedor");
		lblFornecedor.setBounds(55, 206, 97, 14);
		panPrincipal.add(lblFornecedor);
		
		lblFuncionario = new JLabel("(F2) Funcion\u00E1rio");
		lblFuncionario.setBounds(169, 206, 97, 14);
		panPrincipal.add(lblFuncionario);
		
		lblProduto = new JLabel("(F3) Produto");
		lblProduto.setBounds(288, 206, 100, 14);
		panPrincipal.add(lblProduto);
		
		lblAnimal = new JLabel("(F5) Animal");
		lblAnimal.setBounds(169, 325, 97, 14);
		panPrincipal.add(lblAnimal);
		
		lblUsuario = new JLabel("(F6) Usu\u00E1rio");
		lblUsuario.setBounds(291, 325, 97, 14);
		panPrincipal.add(lblUsuario);
		
		lblCliente = new JLabel("(F4) Cliente");
		lblCliente.setBounds(45, 325, 97, 14);
		panPrincipal.add(lblCliente);
		
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
			new FrmAnimal();
			fechar();
		});
		
		btnCliente.addActionListener(e -> {
			new FrmCliente();
			fechar();
		});
		btnFornecedor.addActionListener(e -> {
			new FrmFornecedor();
			fechar();
		});
		btnFuncionario.addActionListener(e -> {
			new FrmFuncionario();
			fechar();
		});
		btnProduto.addActionListener(e -> {
			new FrmProduto();
			fechar();
		});
		btnUsuario.addActionListener(e -> {
			new FrmUsuario();
			fechar();
		});
		
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void fechar() {
		janela.dispose();
	}

	public static void main(String[] args) {
		new FrmCadastros();
	}
}
