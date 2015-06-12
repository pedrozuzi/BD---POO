package boundary;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import util.ConfiguracoesTela;
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
	private JLabel lblLogoLudPet;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JButton btnRelatorio;
	private JLabel lblRelatrios;
	private JLabel lblfCadastros;
	private JLabel lblNewLabel;
	private Usuario usuario;

	public FrmPrincipal(Usuario u) {
		if (u.getF().getIdTipo() != 1) {
			principal(u);
		} else {
			principalAdm(u);
		}
		
		usuario = u;
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	private void principalAdm(Usuario u) {
		
		janela = new JFrame("Menu Principal");
				
		panPrincipal = new JPanel();
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setBackground(SystemColor.text);
		
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		
		btnRealizarVenda = new JButton("");
		btnRealizarVenda.setIcon(new ImageIcon(this.getClass().getResource
				("/img/venda.png")));
		btnRealizarVenda.setToolTipText("Realizar uma venda");
		btnRealizarVenda.setBounds(152, 267, 137, 88);
		panPrincipal.add(btnRealizarVenda);
		
		btnRealizarServico = new JButton("");
		btnRealizarServico.setIcon(new ImageIcon(this.getClass().getResource
				("/img/servico.png")));
		btnRealizarServico.setToolTipText("Realizar um Serviço");
		btnRealizarServico.setBounds(299, 267, 132, 88);
		panPrincipal.add(btnRealizarServico);
		
		btnRelatorio = new JButton("");
		btnRelatorio.setIcon(new ImageIcon(this.getClass().getResource
				("/img/relatorio.png")));
		btnRelatorio.setToolTipText("Abrir Relatórios");
		btnRelatorio.setBounds(86, 380, 137, 88);
		btnRelatorio.setEnabled(false);
		panPrincipal.add(btnRelatorio);
		
		btnCadastros = new JButton("");
		btnCadastros.setIcon(new ImageIcon(this.getClass().getResource
				("/img/cadastros.png")));
		btnCadastros.setToolTipText("Cadastrar/Consultar/Aterar/Remover");
		btnCadastros.setBounds(233, 380, 132, 88);
		panPrincipal.add(btnCadastros);
		
		btnAgendarServico = new JButton("");
		btnAgendarServico.setIcon(new ImageIcon(this.getClass().getResource
				("/img/calendar.png")));
		btnAgendarServico.setToolTipText("Agendar um serviço");
		btnAgendarServico.setBounds(375, 380, 132, 88);
		panPrincipal.add(btnAgendarServico);
		
		lblAgendarServio = new JLabel("Agendar Servi\u00E7o");
		lblAgendarServio.setBounds(411, 468, 122, 14);
		panPrincipal.add(lblAgendarServio);
		
		lblRelatrios = new JLabel("Relat\u00F3rios");
		lblRelatrios.setBounds(119, 468, 98, 14);
		lblRelatrios.setEnabled(false);
		panPrincipal.add(lblRelatrios);
		
		lblfRealizarVenda = new JLabel("Realizar Venda");
		lblfRealizarVenda.setBounds(179, 355, 110, 14);
		panPrincipal.add(lblfRealizarVenda);
		
		lblfCadastros = new JLabel("Cadastros");
		lblfCadastros.setBounds(277, 468, 98, 14);
		panPrincipal.add(lblfCadastros);
		
		lblfRealizarServio = new JLabel("Realizar Servi\u00E7o");
		lblfRealizarServio.setBounds(331, 355, 122, 14);
		panPrincipal.add(lblfRealizarServio);
		
		lblLogoLudPet = new JLabel("");
		lblLogoLudPet.setIcon(new ImageIcon(this.getClass().getResource("/img/logo.png")));
		lblLogoLudPet.setBounds(175, 25, 255, 207);
		panPrincipal.add(lblLogoLudPet);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/img/teste.png")));
		lblNewLabel.setBounds(0, 507, 615, 28);
		panPrincipal.add(lblNewLabel);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(this.getClass().getResource("/img/teste.png")));
		label_1.setBounds(0, 242, 615, 14);
		panPrincipal.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(this.getClass().getResource("/img/teste2.png")));
		label_2.setBounds(0, 217, 183, 14);
		panPrincipal.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(this.getClass().getResource("/img/teste2.png")));
		label_3.setBounds(411, 492, 204, 14);
		panPrincipal.add(label_3);
		
		btnCadastros.addActionListener(e -> {
			sair();
			new FrmCadastros(u);
		});
		
		btnRelatorio.addActionListener(e -> {
			sair();
			new FrmRelatorio(u);
		});
		
		btnAgendarServico.addActionListener( e -> {
			sair();
			new FrmAgenda();
		});
		
		btnRealizarVenda.addActionListener(e -> {
			sair();
			new FrmVenda(u);
		});
		
		btnRealizarServico.addActionListener( e -> {
			sair();
			new FrmServico(u);
		});
		
		janela.setSize(631,573);		
		ConfiguracoesTela configTela = new ConfiguracoesTela();
		configTela.iconeBarra(janela);
		configTela.tamanho(janela);
		
	}

	private void sair() {
		janela.dispose();
		janela = null;		
	}
	
	private void principal(Usuario u) {
		
		janela = new JFrame("Menu Principal");
		
		panPrincipal = new JPanel();
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setBackground(SystemColor.text);
		
		btnCadastros = new JButton();
		
		btnRealizarVenda = new JButton("");
		btnRealizarVenda.setIcon(new ImageIcon(this.getClass().getResource
				("/img/venda.png")));
		btnRealizarVenda.setToolTipText("Realizar uma venda");
		btnRealizarVenda.setBounds(80, 285, 137, 88);
		panPrincipal.add(btnRealizarVenda);
		
		btnRealizarServico = new JButton("");
		btnRealizarServico.setIcon(new ImageIcon(this.getClass().getResource
				("/img/servico.png")));
		btnRealizarServico.setToolTipText("Realizar um Serviço");
		btnRealizarServico.setBounds(399, 286, 137, 88);
		panPrincipal.add(btnRealizarServico);
		
		btnAgendarServico = new JButton("");
		btnAgendarServico.setIcon(new ImageIcon(this.getClass().getResource
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
		
		lblLogoLudPet = new JLabel("");
		lblLogoLudPet.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/logo.png")));
		lblLogoLudPet.setBounds(180, 11, 228, 223);
		panPrincipal.add(lblLogoLudPet);
		
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
		
		btnRealizarServico.addActionListener( e -> {
			sair();
			new FrmServico(u);
		});
		
		btnRealizarVenda.addActionListener( e -> {
			sair();
			new FrmVenda(u);
		});
		
		btnAgendarServico.addActionListener( e -> {
			sair();
			new FrmAgenda();
		});
		
		janela.setSize(623,529);		
		ConfiguracoesTela configTela = new ConfiguracoesTela();
		configTela.iconeBarra(janela);
		configTela.tamanho(janela);
		
				
	}

	public void deslogar(){
		Object[] opcoes = {"Sim", "Não"};
		int escolha = JOptionPane.showOptionDialog(null, "Deseja Deslogar ?", 
				"Aviso", JOptionPane.DEFAULT_OPTION, 
				JOptionPane.WARNING_MESSAGE, 
				null, opcoes, opcoes[1]);
			
		if (escolha == JOptionPane.YES_OPTION) {
			sair();
			new FrmLogin();
		}
	}
}
