package boundary;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.CtrlLogin;
import entity.Login;

import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class FrmPrincipal {

	
	private JFrame janela;
	private JButton btnRealizarVenda;
	private JPanel panPrincipal;
	private Login login;
	private JButton btnRealizarServico;
	private JButton btnRelatorio;
	private JButton btnCadastros;
	private JButton btnAgendarServico;
	private JLabel lblImagem;

	public FrmPrincipal(){
		janela = new JFrame("Menu Principal");
		panPrincipal = new JPanel();
		
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/textoLudPet.png")));
		label.setBounds(38, 11, 375, 81);
		panPrincipal.add(label);
		
		lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/dog.png")));
		lblImagem.setBounds(311, 89, 190, 123);
		panPrincipal.add(lblImagem);
		
		btnRealizarVenda = new JButton("Realizar Venda");
		btnRealizarVenda.setBounds(42, 115, 137, 88);
		panPrincipal.add(btnRealizarVenda);
		
		btnRealizarServico = new JButton("Realizar Servi\u00E7o");
		btnRealizarServico.setBounds(189, 115, 132, 88);
		panPrincipal.add(btnRealizarServico);
		
		btnRelatorio = new JButton("Relat\u00F3rios");
		btnRelatorio.setBounds(42, 214, 137, 88);
		panPrincipal.add(btnRelatorio);
		
		btnCadastros = new JButton("Cadastros");
		btnCadastros.setBounds(189, 214, 132, 88);
		panPrincipal.add(btnCadastros);
		
		btnAgendarServico = new JButton("Agendar Servi\u00E7o");
		btnAgendarServico.setBounds(331, 214, 132, 88);
		panPrincipal.add(btnAgendarServico);
		
		
		janela.setSize(561,367);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public FrmPrincipal(String a) {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public static void main(String[] args) {

		new FrmPrincipal();
	}
}
