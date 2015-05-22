package boundary;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import entity.Login;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;

public class FrmPrincipal {

	private JFrame janela;
	private JButton btnRealizarVenda;
	private JPanel panPrincipal;
	private JPanel panel;
	private Login login;
	private JButton btnRealizarServico;
	private JButton btnRelatorio;
	private JButton btnCadastros;
	private JButton btnAgendarServico;
	private JLabel lblImagem;
	private JLabel labelImagemTxt;
	private JButton btnDeslogar;
	private JLabel lblRelatrios;
	private JLabel lblfRealizarVenda;
	private JLabel lblfCadastros;
	private JLabel lblfRealizarServio;
	private JLabel lblAgendarServio;

	public FrmPrincipal(){
		janela = new JFrame("Menu Principal");
		panPrincipal = new JPanel();
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setBackground(SystemColor.text);
		
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		
		labelImagemTxt = new JLabel("");
		labelImagemTxt.setIcon(new ImageIcon(FrmPrincipal.class.getResource
				("/img/textoLudPet.png")));
		labelImagemTxt.setBounds(38, 11, 375, 81);
		panPrincipal.add(labelImagemTxt);
		
		lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(FrmPrincipal.class.getResource
				("/img/dog.png")));
		lblImagem.setBounds(311, 89, 190, 123);
		panPrincipal.add(lblImagem);
		
		btnRealizarVenda = new JButton("");
		btnRealizarVenda.setIcon(new ImageIcon(FrmPrincipal.class.getResource
				("/img/venda.png")));
		btnRealizarVenda.setToolTipText("Realizar uma venda");
		btnRealizarVenda.setBounds(42, 115, 137, 88);
		panPrincipal.add(btnRealizarVenda);
		
		btnRealizarServico = new JButton("");
		btnRealizarServico.setIcon(new ImageIcon(FrmPrincipal.class.getResource
				("/img/servico.png")));
		btnRealizarServico.setToolTipText("Realizar um Serviço");
		btnRealizarServico.setBounds(189, 115, 132, 88);
		panPrincipal.add(btnRealizarServico);
		
		btnRelatorio = new JButton("");
		btnRelatorio.setIcon(new ImageIcon(FrmPrincipal.class.getResource
				("/img/relatorio.png")));
		btnRelatorio.setToolTipText("Abrir Relatórios");
		btnRelatorio.setBounds(41, 248, 137, 88);
		panPrincipal.add(btnRelatorio);
		
		btnCadastros = new JButton("");
		btnCadastros.setIcon(new ImageIcon(FrmPrincipal.class.getResource
				("/img/cadastros.png")));
		btnCadastros.setToolTipText("Cadastrar/Consultar/Aterar/Remover");
		btnCadastros.setBounds(188, 248, 132, 88);
		panPrincipal.add(btnCadastros);
		
		btnAgendarServico = new JButton("");
		btnAgendarServico.setIcon(new ImageIcon(FrmPrincipal.class.getResource
				("/img/calendar.png")));
		btnAgendarServico.setToolTipText("Agendar um serviço");
		btnAgendarServico.setBounds(330, 248, 132, 88);
		panPrincipal.add(btnAgendarServico);
		
		btnDeslogar = new JButton("");
		btnDeslogar.setIcon(new ImageIcon(FrmPrincipal.class.getResource
				("/img/icon_login_out.png")));
		btnDeslogar.setToolTipText("Deslogar-se");
		btnDeslogar.setBounds(499, 367, 51, 49);
		panPrincipal.add(btnDeslogar);
		
		lblAgendarServio = new JLabel("(F5) Agendar Serviço");
		lblAgendarServio.setBounds(340, 336, 122, 14);
		panPrincipal.add(lblAgendarServio);
		
		lblRelatrios = new JLabel("(F3) Relatórios");
		lblRelatrios.setBounds(64, 336, 98, 14);
		panPrincipal.add(lblRelatrios);
		
		lblfRealizarVenda = new JLabel("(F1) Realizar Venda");
		lblfRealizarVenda.setBounds(52, 203, 110, 14);
		panPrincipal.add(lblfRealizarVenda);
		
		lblfCadastros = new JLabel("(F4) Cadastros");
		lblfCadastros.setBounds(210, 336, 98, 14);
		panPrincipal.add(lblfCadastros);
		
		lblfRealizarServio = new JLabel("(F2) Realizar Serviço");
		lblfRealizarServio.setBounds(199, 203, 122, 14);
		panPrincipal.add(lblfRealizarServio);
		
		btnDeslogar.addActionListener( e -> deslogar() );
		
		
		janela.setSize(576,465);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public FrmPrincipal(String a) {
		janela = new JFrame("Menu Principal");
		panPrincipal = new JPanel();
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setBackground(SystemColor.text);
		
		labelImagemTxt = new JLabel("");
		labelImagemTxt.setIcon(new ImageIcon(FrmPrincipal.class.getResource
				("/img/textoLudPet.png")));
		labelImagemTxt.setBounds(21, 11, 375, 81);
		panPrincipal.add(labelImagemTxt);
		
		lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(FrmPrincipal.class.getResource
				("/img/dog.png")));
		lblImagem.setBounds(172, 103, 190, 123);
		panPrincipal.add(lblImagem);
		
		btnRealizarVenda = new JButton("");
		btnRealizarVenda.setIcon(new ImageIcon(FrmPrincipal.class.getResource
				("/img/venda.png")));
		btnRealizarVenda.setToolTipText("Realizar uma venda");
		btnRealizarVenda.setBounds(38, 116, 137, 88);
		panPrincipal.add(btnRealizarVenda);
		
		btnRealizarServico = new JButton("");
		btnRealizarServico.setIcon(new ImageIcon(FrmPrincipal.class.getResource
				("/img/servico.png")));
		btnRealizarServico.setToolTipText("Realizar um Serviço");
		btnRealizarServico.setBounds(196, 231, 137, 88);
		panPrincipal.add(btnRealizarServico);
		
		btnAgendarServico = new JButton("");
		btnAgendarServico.setIcon(new ImageIcon(FrmPrincipal.class.getResource
				("/img/calendar.png")));
		btnAgendarServico.setToolTipText("Agendar um serviço");
		btnAgendarServico.setBounds(38, 230, 137, 88);
		panPrincipal.add(btnAgendarServico);
		
		lblAgendarServio = new JLabel("(F2) Agendar Servi\u00E7o");
		lblAgendarServio.setBounds(48, 318, 122, 14);
		panPrincipal.add(lblAgendarServio);
		
		lblfRealizarVenda = new JLabel("(F1) Realizar Venda");
		lblfRealizarVenda.setBounds(52, 203, 110, 14);
		panPrincipal.add(lblfRealizarVenda);
		
		lblfRealizarServio = new JLabel("(F3) Realizar Servi\u00E7o");
		lblfRealizarServio.setBounds(206, 318, 122, 14);
		panPrincipal.add(lblfRealizarServio);
		
		btnDeslogar = new JButton("");
		btnDeslogar.setIcon(new ImageIcon(FrmPrincipal.class.getResource
				("/img/icon_login_out.png")));
		btnDeslogar.setToolTipText("Deslogar-se");
		btnDeslogar.setBounds(399, 328, 51, 49);
		panPrincipal.add(btnDeslogar);
		
		
		janela.setSize(476,426);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		btnDeslogar.addActionListener( e -> deslogar() );
		
	}
	
	public void deslogar(){
		Object[] opcoes = {"Sim", "Não"};
		int escolha = JOptionPane.showOptionDialog(null, "Deseja Deslogar-se ?", 
				"Aviso", JOptionPane.DEFAULT_OPTION, 
				JOptionPane.WARNING_MESSAGE, 
				null, opcoes, opcoes[1]);
			
		if (escolha == JOptionPane.YES_OPTION) {
			janela.dispose();
			new FrmLogin();
		}
	}
	
	
	public static void main(String[] args) {
		String s = null;
		new FrmPrincipal(s);
		new FrmPrincipal();
	}
}
