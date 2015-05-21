package boundary;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import entity.Login;
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
	private JLabel labelImagemTxt;
	private JButton btnDeslogar;

	public FrmPrincipal(){
		janela = new JFrame("Menu Principal");
		panPrincipal = new JPanel();
		
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		
		labelImagemTxt = new JLabel("");
		labelImagemTxt.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/textoLudPet.png")));
		labelImagemTxt.setBounds(38, 11, 375, 81);
		panPrincipal.add(labelImagemTxt);
		
		lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/dog.png")));
		lblImagem.setBounds(311, 89, 190, 123);
		panPrincipal.add(lblImagem);
		
		btnRealizarVenda = new JButton("Realizar Venda");
		btnRealizarVenda.setBounds(42, 115, 137, 88);
		panPrincipal.add(btnRealizarVenda);
		
		btnRealizarServico = new JButton("Realizar Serviço");
		btnRealizarServico.setBounds(189, 115, 132, 88);
		panPrincipal.add(btnRealizarServico);
		
		btnRelatorio = new JButton("Relat\u00F3rios");
		btnRelatorio.setBounds(42, 214, 137, 88);
		panPrincipal.add(btnRelatorio);
		
		btnCadastros = new JButton("Cadastros");
		btnCadastros.setBounds(189, 214, 132, 88);
		panPrincipal.add(btnCadastros);
		
		btnAgendarServico = new JButton("Agendar Serviço");
		btnAgendarServico.setBounds(331, 214, 132, 88);
		panPrincipal.add(btnAgendarServico);
		
		btnDeslogar = new JButton("");
		btnDeslogar.setIcon(new ImageIcon(FrmPrincipal.class.getResource
				("/img/icon_login_out.png")));
		btnDeslogar.setBounds(497, 329, 51, 49);
		panPrincipal.add(btnDeslogar);
		
		
		janela.setSize(574,427);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public FrmPrincipal(String a) {
		janela = new JFrame("Menu Principal");
		panPrincipal = new JPanel();
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		
		labelImagemTxt = new JLabel("");
		labelImagemTxt.setIcon(new ImageIcon(FrmPrincipal.class.getResource
				("/img/textoLudPet.png")));
		labelImagemTxt.setBounds(21, 11, 375, 81);
		panPrincipal.add(labelImagemTxt);
		
		lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(FrmPrincipal.class.getResource
				("/img/dog.png")));
		lblImagem.setBounds(175, 88, 190, 123);
		panPrincipal.add(lblImagem);
		
		btnRealizarVenda = new JButton("Realizar Venda");
		btnRealizarVenda.setBounds(38, 116, 137, 88);
		panPrincipal.add(btnRealizarVenda);
		
		btnRealizarServico = new JButton("Realizar Serviço");
		btnRealizarServico.setBounds(185, 214, 137, 88);
		panPrincipal.add(btnRealizarServico);
		
		btnAgendarServico = new JButton("Agendar Serviço");
		btnAgendarServico.setBounds(38, 214, 137, 88);
		panPrincipal.add(btnAgendarServico);
		
		btnDeslogar = new JButton("");
		btnDeslogar.setIcon(new ImageIcon(FrmPrincipal.class.getResource
				("/img/icon_login_out.png")));
		btnDeslogar.setBounds(399, 328, 51, 49);
		panPrincipal.add(btnDeslogar);
		

		
		janela.setSize(476,426);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	
	
	public static void main(String[] args) {
		String s = null;
		new FrmPrincipal(s);
		//new FrmPrincipal();
	}
}
