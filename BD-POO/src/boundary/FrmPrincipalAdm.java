package boundary;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import entity.Usuario;

import javax.swing.JLabel;

import control.ConfiguracoesTela;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

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
	private JButton btnDeslogar;
	private JLabel lblRelatrios;
	private JLabel lblfRealizarVenda;
	private JLabel lblfCadastros;
	private JLabel lblfRealizarServio;
	private JLabel lblAgendarServio;
	private JLabel label;
	private JLabel lblNewLabel;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;

	public FrmPrincipalAdm(Usuario u){
		System.out.println(u.getNome());
		janela = new JFrame("Menu Principal");
		panPrincipal = new JPanel();
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setBackground(SystemColor.text);
		
		// CONFIGURACOES DE TELA, PODER SER NECESSARIO COMENTAR PARA EDITAR NO WINDONBUILDER
		ConfiguracoesTela configTela = new ConfiguracoesTela(janela);
		configTela.iconeBarra(janela);
		
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		
		btnRealizarVenda = new JButton("");
		btnRealizarVenda.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource
				("/img/venda.png")));
		btnRealizarVenda.setToolTipText("Realizar uma venda");
		btnRealizarVenda.setBounds(85, 249, 137, 88);
		panPrincipal.add(btnRealizarVenda);
		
		btnRealizarServico = new JButton("");
		btnRealizarServico.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource
				("/img/servico.png")));
		btnRealizarServico.setToolTipText("Realizar um Serviço");
		btnRealizarServico.setBounds(232, 249, 132, 88);
		panPrincipal.add(btnRealizarServico);
		
		btnRelatorio = new JButton("");
		btnRelatorio.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource
				("/img/relatorio.png")));
		btnRelatorio.setToolTipText("Abrir Relatórios");
		btnRelatorio.setBounds(85, 362, 137, 88);
		panPrincipal.add(btnRelatorio);
		
		btnCadastros = new JButton("");
		btnCadastros.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource
				("/img/cadastros.png")));
		btnCadastros.setToolTipText("Cadastrar/Consultar/Aterar/Remover");
		btnCadastros.setBounds(232, 362, 132, 88);
		panPrincipal.add(btnCadastros);
		
		btnAgendarServico = new JButton("");
		btnAgendarServico.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource
				("/img/calendar.png")));
		btnAgendarServico.setToolTipText("Agendar um serviço");
		btnAgendarServico.setBounds(374, 362, 132, 88);
		panPrincipal.add(btnAgendarServico);
		
		btnDeslogar = new JButton("");
		btnDeslogar.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource
				("/img/icon_login_out.png")));
		btnDeslogar.setToolTipText("Deslogar");
		btnDeslogar.setBounds(542, 454, 51, 49);
		panPrincipal.add(btnDeslogar);
		
		lblAgendarServio = new JLabel("(F5) Agendar Serviço");
		lblAgendarServio.setBounds(384, 450, 122, 14);
		panPrincipal.add(lblAgendarServio);
		
		lblRelatrios = new JLabel("(F3) Relatórios");
		lblRelatrios.setBounds(108, 450, 98, 14);
		panPrincipal.add(lblRelatrios);
		
		lblfRealizarVenda = new JLabel("(F1) Realizar Venda");
		lblfRealizarVenda.setBounds(95, 337, 110, 14);
		panPrincipal.add(lblfRealizarVenda);
		
		lblfCadastros = new JLabel("(F4) Cadastros");
		lblfCadastros.setBounds(254, 450, 98, 14);
		panPrincipal.add(lblfCadastros);
		
		lblfRealizarServio = new JLabel("(F2) Realizar Serviço");
		lblfRealizarServio.setBounds(242, 337, 122, 14);
		panPrincipal.add(lblfRealizarServio);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource("/img/logo.png")));
		label.setBounds(175, 0, 255, 207);
		panPrincipal.add(label);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource("/img/teste.png")));
		lblNewLabel.setBounds(0, 475, 615, 28);
		panPrincipal.add(lblNewLabel);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource("/img/teste.png")));
		label_1.setBounds(0, 218, 615, 14);
		panPrincipal.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource("/img/teste2.png")));
		label_2.setBounds(0, 193, 183, 14);
		panPrincipal.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(FrmPrincipalAdm.class.getResource("/img/teste2.png")));
		label_3.setBounds(411, 460, 204, 14);
		panPrincipal.add(label_3);
		
		btnDeslogar.addActionListener( e -> deslogar() );
		
		btnCadastros.addActionListener(e -> new FrmCadastros());
		
		btnRelatorio.addActionListener(e -> new FrmRelatorio());
		
		janela.setSize(631,539);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		atalhos();
	}
	
	private void atalhos() {
		ActionMap am = panPrincipal.getActionMap();
		InputMap im = panPrincipal.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "deslogar");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "venda");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "servico");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), "relatorio");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0), "cadastros");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), "agenda");
		
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
				new FrmVenda();
			}
		});
		
		am.put("servico", new AbstractAction() {
			private static final long serialVersionUID = 4184595576327756095L;
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		
		am.put("relatorio", new AbstractAction() {
			private static final long serialVersionUID = 4184595576327756095L;
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrmRelatorio();
			}
		});
		
		am.put("cadastros", new AbstractAction() {
			private static final long serialVersionUID = 4184595576327756095L;
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrmCadastros();
			}
		});
		
		am.put("agenda", new AbstractAction() {
			private static final long serialVersionUID = 4184595576327756095L;
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrmAgenda();
			}
		});
	}

	private void deslogar(){
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
