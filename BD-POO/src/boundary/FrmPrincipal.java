package boundary;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import util.ConfiguracoesTela;
import entity.Usuario;

/**
 * Classe que representa o Menu Principal do sistema
 * @author Pedro Zuzi
 *
 */
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
	private JLabel lblTiraVermelhaBaixo;
	private JLabel lblTiraVermelha;
	private JLabel lblTiraCinza;
	private JLabel lblTiraCinzaBaixo;
	private JButton btnRelatorio;
	private JLabel lblRelatrios;
	private JLabel lblfCadastros;
	private JLabel lblNewLabel;
	private JMenu mnMenu;
	private JMenuItem mntmLogOff;
	private JMenuBar mbPrincipal;

	/**
	 * Contrutor, recebe o usuário logado no sistema
	 * @param u
	 */
	public FrmPrincipal(Usuario u) {
		if (u.getF().getIdTipo() != 1) {
			principal(u);
		} else {
			principalAdm(u);
		}
		
	}
	
	/**
	 * Método que constrói a tela principal do administrador do sistema
	 * @param u recebe o usuário logado
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
		
		lblTiraVermelhaBaixo = new JLabel("");
		lblTiraVermelhaBaixo.setIcon(new ImageIcon(this.getClass().getResource("/img/teste.png")));
		lblTiraVermelhaBaixo.setBounds(0, 242, 615, 14);
		panPrincipal.add(lblTiraVermelhaBaixo);
		
		lblTiraVermelha = new JLabel("");
		lblTiraVermelha.setIcon(new ImageIcon(this.getClass().getResource("/img/teste2.png")));
		lblTiraVermelha.setBounds(0, 217, 183, 14);
		panPrincipal.add(lblTiraVermelha);
		
		lblTiraCinza = new JLabel("");
		lblTiraCinza.setIcon(new ImageIcon(this.getClass().getResource("/img/teste2.png")));
		lblTiraCinza.setBounds(411, 492, 204, 14);
		panPrincipal.add(lblTiraCinza);
		
		mbPrincipal = new JMenuBar();
		mbPrincipal.setBounds(0, 0, 621, 21);
		panPrincipal.add(mbPrincipal);
		
		mnMenu = new JMenu("Menu");
		mbPrincipal.add(mnMenu);
		
		mntmLogOff = new JMenuItem("Log Off");
		mntmLogOff.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/LogOffMenu.png")));
		mnMenu.add(mntmLogOff);
		
		mntmLogOff.addActionListener(e -> {
			sair();
			new FrmLogin();
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
			new FrmAgenda(u);
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

	/**
	 * Método invocado para fechar a tela
	 */
	private void sair() {
		janela.dispose();
		janela = null;		
	}
	
	/**
	 * Método que constrói a tela principal do sistema
	 * @param u recebe o usuário logado
	 */
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
		btnRealizarVenda.setBounds(80, 313, 137, 88);
		panPrincipal.add(btnRealizarVenda);
		
		btnRealizarServico = new JButton("");
		btnRealizarServico.setIcon(new ImageIcon(this.getClass().getResource
				("/img/servico.png")));
		btnRealizarServico.setToolTipText("Realizar um Serviço");
		btnRealizarServico.setBounds(399, 314, 137, 88);
		panPrincipal.add(btnRealizarServico);
		
		btnAgendarServico = new JButton("");
		btnAgendarServico.setIcon(new ImageIcon(this.getClass().getResource
				("/img/calendar.png")));
		btnAgendarServico.setToolTipText("Agendar um serviço");
		btnAgendarServico.setBounds(241, 313, 137, 88);
		panPrincipal.add(btnAgendarServico);
		
		lblAgendarServio = new JLabel("Agendar Servi\u00E7o");
		lblAgendarServio.setBounds(267, 401, 122, 14);
		panPrincipal.add(lblAgendarServio);
		
		lblfRealizarVenda = new JLabel("Realizar Venda");
		lblfRealizarVenda.setBounds(107, 401, 110, 14);
		panPrincipal.add(lblfRealizarVenda);
		
		lblfRealizarServio = new JLabel("Realizar Servi\u00E7o");
		lblfRealizarServio.setBounds(425, 401, 122, 14);
		panPrincipal.add(lblfRealizarServio);
		
		lblLogoLudPet = new JLabel("");
		lblLogoLudPet.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/logo.png")));
		lblLogoLudPet.setBounds(180, 39, 228, 223);
		panPrincipal.add(lblLogoLudPet);
		
		lblTiraVermelhaBaixo = new JLabel("");
		lblTiraVermelhaBaixo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/teste.png")));
		lblTiraVermelhaBaixo.setBounds(0, 460, 606, 31);
		panPrincipal.add(lblTiraVermelhaBaixo);
		
		lblTiraVermelha = new JLabel("");
		lblTiraVermelha.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/teste.png")));
		lblTiraVermelha.setBounds(0, 263, 606, 14);
		panPrincipal.add(lblTiraVermelha);
		
		lblTiraCinza = new JLabel("");
		lblTiraCinza.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/teste2.png")));
		lblTiraCinza.setBounds(0, 238, 204, 14);
		panPrincipal.add(lblTiraCinza);
		
		lblTiraCinzaBaixo = new JLabel("");
		lblTiraCinzaBaixo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/teste2.png")));
		lblTiraCinzaBaixo.setBounds(399, 435, 204, 14);
		panPrincipal.add(lblTiraCinzaBaixo);
		
		mbPrincipal = new JMenuBar();
		mbPrincipal.setBounds(0, 0, 621, 21);
		panPrincipal.add(mbPrincipal);
		
		mnMenu = new JMenu("Menu");
		mbPrincipal.add(mnMenu);
		
		mntmLogOff = new JMenuItem("Log Off");
		mntmLogOff.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/LogOffMenu.png")));
		mnMenu.add(mntmLogOff);
		
		mntmLogOff.addActionListener(e -> {
			sair();
			new FrmLogin();
		});
		
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
			new FrmAgenda(u);
		});
		
		janela.setSize(623,529);		
		ConfiguracoesTela configTela = new ConfiguracoesTela();
		configTela.iconeBarra(janela);
		configTela.tamanho(janela);
		
				
	}

	/**
	 * Método para deslogar
	 */
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
