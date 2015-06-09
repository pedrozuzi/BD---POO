package boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.ConfiguracoesTela;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

public class FrmServico {

	
	private JFrame janela;
	private JPanel panel;
	private ConfiguracoesTela configTela;
	private JTextField txtCodigoServico;
	private JTextField txtNomeCliente;
	private JTextField txtValor;
	private JTextField txtRaca;
	private JLabel lblCodigoServico;
	private JMenuBar menuBar;
	private JMenu mnPrincipal;
	private JMenuItem mntmMenuPrincipal;
	private JMenuItem mntmLogOff;
	private JButton btnPesquisarCodigo;
	private JPanel panelClienteAnimal;
	private JLabel lblCdigoCliente;
	private JButton btnPesquisarCliente;
	private JLabel lblAnimal;
	private JLabel lblRaca;
	private JPanel panelServico;
	private JRadioButton rdbtnBanho;
	private JRadioButton rdbtnTosa;
	private JRadioButton rdbtnBanhoTosa;
	private JLabel lblValor;
	private JButton btnFinalizar;
	private JButton btnCancelar;
	private JButton btnLimpar;

	public FrmServico() {
		
		janela = new JFrame("Servico");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		configTela = new ConfiguracoesTela( janela );
		
		janela.setVisible(true);
		janela.setSize(500, 500);
		janela.setContentPane(panel);
		panel.setLayout(null);
		
		lblCodigoServico = new JLabel("C\u00F3digo Servico : ");
		lblCodigoServico.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCodigoServico.setBounds(23, 57, 111, 14);
		panel.add(lblCodigoServico);
		
		txtCodigoServico = new JTextField();
		txtCodigoServico.setBackground(SystemColor.info);
		txtCodigoServico.setBounds(131, 55, 63, 20);
		txtCodigoServico.setColumns(10);
		panel.add(txtCodigoServico);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 484, 21);
		panel.add(menuBar);
		
		mnPrincipal = new JMenu("Menu");
		menuBar.add(mnPrincipal);
		
		mntmMenuPrincipal = new JMenuItem("Menu Principal");
		mntmMenuPrincipal.setIcon(new ImageIcon(FrmServico.class.getResource("/img/HomeMenu.png")));
		mnPrincipal.add(mntmMenuPrincipal);
		
		mntmLogOff = new JMenuItem("Log Off");
		mntmLogOff.setIcon(new ImageIcon(FrmServico.class.getResource("/img/LogOffMenu.png")));
		mnPrincipal.add(mntmLogOff);
		
		btnPesquisarCodigo = new JButton("");
		btnPesquisarCodigo.setIcon(new ImageIcon(FrmServico.class.getResource("/img/MiniLupa.png")));
		btnPesquisarCodigo.setBounds(204, 52, 43, 23);
		panel.add(btnPesquisarCodigo);
		
		panelClienteAnimal = new JPanel();
		panelClienteAnimal.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cliente/Animal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelClienteAnimal.setBackground(Color.WHITE);
		panelClienteAnimal.setBounds(10, 97, 447, 106);
		panel.add(panelClienteAnimal);
		panelClienteAnimal.setLayout(null);
		
		lblCdigoCliente = new JLabel("Nome Cliente : ");
		lblCdigoCliente.setBounds(20, 24, 111, 14);
		panelClienteAnimal.add(lblCdigoCliente);
		lblCdigoCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(116, 22, 191, 20);
		panelClienteAnimal.add(txtNomeCliente);
		txtNomeCliente.setBackground(SystemColor.info);
		txtNomeCliente.setColumns(10);
		
		btnPesquisarCliente = new JButton("");
		btnPesquisarCliente.setBounds(317, 19, 43, 23);
		panelClienteAnimal.add(btnPesquisarCliente);
		btnPesquisarCliente.setIcon(new ImageIcon(FrmServico.class.getResource("/img/MiniLupa.png")));
		
		lblAnimal = new JLabel("Animal : ");
		lblAnimal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAnimal.setBounds(20, 59, 68, 14);
		panelClienteAnimal.add(lblAnimal);
		
		JComboBox cbAnimal = new JComboBox();
		cbAnimal.setMaximumRowCount(10);
		cbAnimal.setBounds(116, 57, 111, 20);
		panelClienteAnimal.add(cbAnimal);
		
		lblRaca = new JLabel("Ra\u00E7a : ");
		lblRaca.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRaca.setBounds(237, 60, 46, 14);
		panelClienteAnimal.add(lblRaca);
		
		txtRaca = new JTextField();
		txtRaca.setBackground(SystemColor.info);
		txtRaca.setBounds(293, 57, 86, 20);
		panelClienteAnimal.add(txtRaca);
		txtRaca.setColumns(10);
		
		panelServico = new JPanel();
		panelServico.setBorder(new TitledBorder(null, "Servi\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelServico.setBackground(Color.WHITE);
		panelServico.setBounds(10, 218, 447, 63);
		panel.add(panelServico);
		panelServico.setLayout(null);
		
		rdbtnBanho = new JRadioButton("Banho");
		rdbtnBanho.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnBanho.setBackground(Color.WHITE);
		rdbtnBanho.setBounds(18, 21, 109, 23);
		panelServico.add(rdbtnBanho);
		
		rdbtnTosa = new JRadioButton("Tosa");
		rdbtnTosa.setBackground(Color.WHITE);
		rdbtnTosa.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnTosa.setBounds(129, 21, 109, 23);
		panelServico.add(rdbtnTosa);
		
		rdbtnBanhoTosa = new JRadioButton("Banho/Tosa");
		rdbtnBanhoTosa.setBackground(Color.WHITE);
		rdbtnBanhoTosa.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnBanhoTosa.setBounds(240, 21, 109, 23);
		panelServico.add(rdbtnBanhoTosa);
		
		lblValor = new JLabel("Valor : ");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblValor.setBounds(23, 305, 56, 14);
		panel.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBackground(SystemColor.info);
		txtValor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtValor.setBounds(92, 303, 86, 20);
		panel.add(txtValor);
		txtValor.setColumns(10);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFinalizar.setBounds(356, 407, 101, 31);
		panel.add(btnFinalizar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(FrmServico.class.getResource("/img/MiniX.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(23, 407, 111, 31);
		panel.add(btnCancelar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(FrmServico.class.getResource("/img/MiniClear.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(190, 407, 111, 31);
		panel.add(btnLimpar);
	
	}
	
	public static void main(String[] args) {
		new FrmServico();
	}
}
