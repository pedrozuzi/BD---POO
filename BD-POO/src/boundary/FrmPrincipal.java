package boundary;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.ConfiguracoesTela;
import entity.Usuario;

public class FrmPrincipal {
	
	private JFrame janela;
	private JPanel panPrincipal;
	private JButton btnCadastros;
	private JButton btnRealizarVenda;
	private JButton btnRealizarServico;
	private JButton btnAgendarServico;
	private JLabel lblAgendarServio;
	private JLabel lblfRealizarVenda;
	private JLabel lblfRealizarServio;
	private JButton btnDeslogar;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;

	public FrmPrincipal(Usuario u) {
		System.out.println(u.getNome());
		janela = new JFrame("Menu Principal");
		panPrincipal = new JPanel();
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setBackground(SystemColor.text);
		
		// CONFIGURACOES DE TELA, PODER SER NECESSARIO COMENTAR PARA EDITAR NO WINDONBUILDER
		ConfiguracoesTela configTela = new ConfiguracoesTela(janela);
		configTela.iconeBarra(janela);
		
		btnCadastros = new JButton();
		
		btnRealizarVenda = new JButton("");
		btnRealizarVenda.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource
				("/img/venda.png")));
		btnRealizarVenda.setToolTipText("Realizar uma venda");
		btnRealizarVenda.setBounds(80, 285, 137, 88);
		panPrincipal.add(btnRealizarVenda);
		
		btnRealizarServico = new JButton("");
		btnRealizarServico.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource
				("/img/servico.png")));
		btnRealizarServico.setToolTipText("Realizar um Serviço");
		btnRealizarServico.setBounds(399, 286, 137, 88);
		panPrincipal.add(btnRealizarServico);
		
		btnAgendarServico = new JButton("");
		btnAgendarServico.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource
				("/img/calendar.png")));
		btnAgendarServico.setToolTipText("Agendar um serviço");
		btnAgendarServico.setBounds(241, 285, 137, 88);
		panPrincipal.add(btnAgendarServico);
		
		lblAgendarServio = new JLabel("(F2) Agendar Servi\u00E7o");
		lblAgendarServio.setBounds(251, 373, 122, 14);
		panPrincipal.add(lblAgendarServio);
		
		lblfRealizarVenda = new JLabel("(F1) Realizar Venda");
		lblfRealizarVenda.setBounds(94, 372, 110, 14);
		panPrincipal.add(lblfRealizarVenda);
		
		lblfRealizarServio = new JLabel("(F3) Realizar Servi\u00E7o");
		lblfRealizarServio.setBounds(409, 373, 122, 14);
		panPrincipal.add(lblfRealizarServio);
		
		btnDeslogar = new JButton("");
		btnDeslogar.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource
				("/img/icon_login_out.png")));
		btnDeslogar.setToolTipText("Deslogar-se");
		btnDeslogar.setBounds(545, 442, 51, 49);
		panPrincipal.add(btnDeslogar);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/logo.png")));
		label.setBounds(180, 11, 228, 223);
		panPrincipal.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/teste.png")));
		label_1.setBounds(0, 460, 606, 31);
		panPrincipal.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/teste.png")));
		label_2.setBounds(0, 235, 606, 14);
		panPrincipal.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/teste2.png")));
		label_3.setBounds(0, 210, 204, 14);
		panPrincipal.add(label_3);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/teste2.png")));
		label_4.setBounds(399, 435, 204, 14);
		panPrincipal.add(label_4);
		
		
		janela.setSize(623,529);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		btnDeslogar.addActionListener( e -> deslogar() );
		
		btnCadastros.addActionListener(e -> new FrmCadastros());
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
		new FrmPrincipal(new Usuario());
	}

}
