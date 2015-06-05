package boundary;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entity.Usuario;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.SystemColor;

public class FrmPrincipalAdm {

	private JFrame janela;
	private JButton btnRealizarVenda;
	private JPanel panPrincipal;
	private JPanel panel;
	private Usuario usuario;
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

	public FrmPrincipalAdm(Usuario u){
		System.out.println(u.getNome());
		janela = new JFrame("Menu Principal");
		panPrincipal = new JPanel();
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setBackground(SystemColor.text);
		
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		
		lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource
				("/img/dog.png")));
		lblImagem.setBounds(312, 108, 190, 123);
		panPrincipal.add(lblImagem);
		
		labelImagemTxt = new JLabel("");
		labelImagemTxt.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource
				("/img/LogoPetShop100.png")));
		labelImagemTxt.setBounds(42, 11, 439, 107);
		panPrincipal.add(labelImagemTxt);
		
		btnRealizarVenda = new JButton("");
		btnRealizarVenda.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource
				("/img/venda.png")));
		btnRealizarVenda.setToolTipText("Realizar uma venda");
		btnRealizarVenda.setBounds(43, 134, 137, 88);
		panPrincipal.add(btnRealizarVenda);
		
		btnRealizarServico = new JButton("");
		btnRealizarServico.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource
				("/img/servico.png")));
		btnRealizarServico.setToolTipText("Realizar um Serviço");
		btnRealizarServico.setBounds(190, 134, 132, 88);
		panPrincipal.add(btnRealizarServico);
		
		btnRelatorio = new JButton("");
		btnRelatorio.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource
				("/img/relatorio.png")));
		btnRelatorio.setToolTipText("Abrir Relatórios");
		btnRelatorio.setBounds(42, 267, 137, 88);
		panPrincipal.add(btnRelatorio);
		
		btnCadastros = new JButton("");
		btnCadastros.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource
				("/img/cadastros.png")));
		btnCadastros.setToolTipText("Cadastrar/Consultar/Aterar/Remover");
		btnCadastros.setBounds(189, 267, 132, 88);
		panPrincipal.add(btnCadastros);
		
		btnAgendarServico = new JButton("");
		btnAgendarServico.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource
				("/img/calendar.png")));
		btnAgendarServico.setToolTipText("Agendar um serviço");
		btnAgendarServico.setBounds(331, 267, 132, 88);
		panPrincipal.add(btnAgendarServico);
		
		btnDeslogar = new JButton("");
		btnDeslogar.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource
				("/img/icon_login_out.png")));
		btnDeslogar.setToolTipText("Deslogar");
		btnDeslogar.setBounds(499, 367, 51, 49);
		panPrincipal.add(btnDeslogar);
		
		lblAgendarServio = new JLabel("(F5) Agendar Serviço");
		lblAgendarServio.setBounds(341, 355, 122, 14);
		panPrincipal.add(lblAgendarServio);
		
		lblRelatrios = new JLabel("(F3) Relatórios");
		lblRelatrios.setBounds(65, 355, 98, 14);
		panPrincipal.add(lblRelatrios);
		
		lblfRealizarVenda = new JLabel("(F1) Realizar Venda");
		lblfRealizarVenda.setBounds(53, 222, 110, 14);
		panPrincipal.add(lblfRealizarVenda);
		
		lblfCadastros = new JLabel("(F4) Cadastros");
		lblfCadastros.setBounds(211, 355, 98, 14);
		panPrincipal.add(lblfCadastros);
		
		lblfRealizarServio = new JLabel("(F2) Realizar Serviço");
		lblfRealizarServio.setBounds(200, 222, 122, 14);
		panPrincipal.add(lblfRealizarServio);
		
		btnDeslogar.addActionListener( e -> deslogar() );
		
		btnCadastros.addActionListener(e -> new FrmCadastros());
		
		
		janela.setSize(576,465);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void deslogar(){
		Object[] opcoes = {"Sim", "Não"};
		int escolha = JOptionPane.showOptionDialog(null, "Deseja Deslogar ?", 
				"Aviso", JOptionPane.DEFAULT_OPTION, 
				JOptionPane.WARNING_MESSAGE, 
				null, opcoes, opcoes[1]);
			
		if (escolha == JOptionPane.YES_OPTION) {
			janela.dispose();
			new FrmLogin();
		}
	}
	
	
	public static void main(String[] args) {
		new FrmPrincipalAdm(new Usuario());
	}
}
