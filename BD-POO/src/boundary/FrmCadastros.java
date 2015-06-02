package boundary;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.ConfigTelas;
import javax.swing.JButton;
import javax.swing.JLabel;

public class FrmCadastros {
	
	private JFrame janela;
	private JPanel panPrincipal;
	
	public FrmCadastros() {
		janela = new JFrame();
		janela.setTitle("Menu Cadastros");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setLayout(null);
		
		
		janela.setSize(623,323);
		janela.setContentPane( panPrincipal );
		
		JButton btnFornecedor = new JButton("Fornecedor");
		btnFornecedor.setBounds(46, 86, 89, 77);
		panPrincipal.add(btnFornecedor);
		
		JButton btnFuncionario = new JButton("Funcionario");
		btnFuncionario.setBounds(170, 86, 87, 77);
		panPrincipal.add(btnFuncionario);
		
		JButton btnProduto = new JButton("Produto");
		btnProduto.setBounds(292, 86, 87, 76);
		panPrincipal.add(btnProduto);
		
		JButton btnUsuario = new JButton("Usuario");
		btnUsuario.setBounds(411, 86, 89, 77);
		panPrincipal.add(btnUsuario);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setBounds(46, 174, 89, 77);
		panPrincipal.add(btnCliente);
		
		JButton btnAnimal = new JButton("Animal");
		btnAnimal.setBounds(168, 174, 89, 77);
		panPrincipal.add(btnAnimal);
		
		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setBounds(244, 29, 46, 14);
		panPrincipal.add(lblLogo);
		
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new FrmCadastros();
	}
}
