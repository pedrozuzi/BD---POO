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
	private JButton btnDeslogar;
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

	/**
	 * @wbp.parser.entryPoint
	 */
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
		btnRealizarVenda.setBounds(151, 249, 137, 88);
		panPrincipal.add(btnRealizarVenda);
		
		btnRealizarServico = new JButton("");
		btnRealizarServico.setIcon(new ImageIcon(this.getClass().getResource
				("/img/servico.png")));
		btnRealizarServico.setToolTipText("Realizar um Serviço");
		btnRealizarServico.setBounds(298, 249, 132, 88);
		panPrincipal.add(btnRealizarServico);
		
		btnRelatorio = new JButton("");
		btnRelatorio.setIcon(new ImageIcon(this.getClass().getResource
				("/img/relatorio.png")));
		btnRelatorio.setToolTipText("Abrir Relatórios");
		btnRelatorio.setBounds(85, 362, 137, 88);
		btnRelatorio.setEnabled(false);
		panPrincipal.add(btnRelatorio);
		
		btnCadastros = new JButton("");
		btnCadastros.setIcon(new ImageIcon(this.getClass().getResource
				("/img/cadastros.png")));
		btnCadastros.setToolTipText("Cadastrar/Consultar/Aterar/Remover");
		btnCadastros.setBounds(232, 362, 132, 88);
		panPrincipal.add(btnCadastros);
		
		btnAgendarServico = new JButton("");
		btnAgendarServico.setIcon(new ImageIcon(this.getClass().getResource
				("/img/calendar.png")));
		btnAgendarServico.setToolTipText("Agendar um serviço");
		btnAgendarServico.setBounds(374, 362, 132, 88);
		panPrincipal.add(btnAgendarServico);
		
		btnDeslogar = new JButton("");
		btnDeslogar.setIcon(new ImageIcon(this.getClass().getResource
				("/img/icon_login_out.png")));
		btnDeslogar.setToolTipText("Deslogar");
		btnDeslogar.setBounds(542, 454, 51, 49);
		panPrincipal.add(btnDeslogar);
		
		lblAgendarServio = new JLabel("(F5) Agendar Serviço");
		lblAgendarServio.setBounds(384, 450, 122, 14);
		panPrincipal.add(lblAgendarServio);
		
		lblRelatrios = new JLabel("(F3) Relatórios");
		lblRelatrios.setBounds(108, 450, 98, 14);
		lblRelatrios.setEnabled(false);
		panPrincipal.add(lblRelatrios);
		
		lblfRealizarVenda = new JLabel("(F1) Realizar Venda");
		lblfRealizarVenda.setBounds(161, 337, 110, 14);
		panPrincipal.add(lblfRealizarVenda);
		
		lblfCadastros = new JLabel("(F4) Cadastros");
		lblfCadastros.setBounds(254, 450, 98, 14);
		panPrincipal.add(lblfCadastros);
		
		lblfRealizarServio = new JLabel("(F2) Realizar Serviço");
		lblfRealizarServio.setBounds(308, 337, 122, 14);
		panPrincipal.add(lblfRealizarServio);
		
		lblLogoLudPet = new JLabel("");
		lblLogoLudPet.setIcon(new ImageIcon(this.getClass().getResource("/img/logo.png")));
		lblLogoLudPet.setBounds(175, 0, 255, 207);
		panPrincipal.add(lblLogoLudPet);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/img/teste.png")));
		lblNewLabel.setBounds(0, 475, 615, 28);
		panPrincipal.add(lblNewLabel);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(this.getClass().getResource("/img/teste.png")));
		label_1.setBounds(0, 218, 615, 14);
		panPrincipal.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(this.getClass().getResource("/img/teste2.png")));
		label_2.setBounds(0, 193, 183, 14);
		panPrincipal.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(this.getClass().getResource("/img/teste2.png")));
		label_3.setBounds(411, 460, 204, 14);
		panPrincipal.add(label_3);
		
		btnDeslogar.addActionListener( e -> {
			deslogar();
		});
		
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
		
		atalhos();
		atalhosAdm();
		
		janela.setSize(631,539);		
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
		
		btnDeslogar = new JButton("");
		btnDeslogar.setIcon(new ImageIcon(this.getClass().getResource
				("/img/icon_login_out.png")));
		btnDeslogar.setToolTipText("Deslogar-se");
		btnDeslogar.setBounds(545, 442, 51, 49);
		panPrincipal.add(btnDeslogar);
		
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
		
		btnDeslogar.addActionListener( e -> deslogar() );
		
		btnAgendarServico.addActionListener( e -> {
			sair();
			new FrmAgenda();
		});
		
		janela.setSize(623,529);		
		ConfiguracoesTela configTela = new ConfiguracoesTela();
		configTela.iconeBarra(janela);
		configTela.tamanho(janela);
		
		atalhos(); //REFAZER
				
	}

	private void atalhosAdm() {
		
		ActionMap am = panPrincipal.getActionMap();
		InputMap im = panPrincipal.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), "relatorio");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0), "cadastros");
		
		am.put("relatorio", new AbstractAction() {
			private static final long serialVersionUID = 4184595576327756095L;
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrmRelatorio(usuario);
			}
		});
		
		am.put("cadastros", new AbstractAction() {
			private static final long serialVersionUID = 4184595576327756095L;
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrmCadastros(usuario);
			}
		});
	}

	private void atalhos() {
		ActionMap am = panPrincipal.getActionMap();
		InputMap im = panPrincipal.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "deslogar");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "venda");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "agenda");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), "servico");
		
		am.put("deslogar", new AbstractAction() {
			private static final long serialVersionUID = 4184595576327756095L;
			@Override
			public void actionPerformed(ActionEvent e) {
				deslogar();
			}
		});
		
		am.put("venda", new AbstractAction() {
			private static final long serialVersionUID = 4184595576327756095L;
			@Override
			public void actionPerformed(ActionEvent e) {
				sair();
				new FrmVenda(usuario);
			}
		});
		
		am.put("servico", new AbstractAction() {
			private static final long serialVersionUID = 4184595576327756095L;
			@Override
			public void actionPerformed(ActionEvent e) {
				sair();
				new FrmServico(usuario);
			}
		});
		
		am.put("agenda", new AbstractAction() {
			private static final long serialVersionUID = 4184595576327756095L;
			@Override
			public void actionPerformed(ActionEvent e) {
				sair();
				new FrmAgenda();
			}
		});
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
