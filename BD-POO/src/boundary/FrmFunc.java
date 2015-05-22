package boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import control.CtrlFuncionario;
import entity.Funcionario;

import java.awt.Cursor;

import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class FrmFunc implements ActionListener{

	private JFrame janela;
	private JPanel panPrincipal;
	private JTable table;
	private final JTextField txtCodigo = new JTextField();
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtSalario;
	private JLabel lblLogo;
	private JPanel panel;
	private JButton btnIncluir;
	private JLabel lblIncluir;
	private JButton btnAlterar;
	private JLabel lblRemover;
	private JButton btnRemover;
	private JLabel lblPesquisar;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblSalario;
	private JLabel lblCargo;
	private JLabel lblCodigo;
	private JButton btnVoltar;
	private JButton btnLimpar;
	private JButton btnGravar;
	private JButton btnPesquisar;
	private JTextField txtTelefone;
	private JLabel lblTelefone;
	private JScrollPane scrollPane;
	private CtrlFuncionario ctrlFunc;
	private JRadioButton rdbtnBanhistaTosador;
	private JRadioButton rdbtnAtendente;
	private JRadioButton rdbtnAdministrador;
	private ButtonGroup bg;
	private int controle;
	
	public FrmFunc(String nome) {
	
		
		janela = new JFrame();
		janela.setTitle(nome);
		panPrincipal = new JPanel();
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setBackground(SystemColor.text);
		
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setForeground(Color.WHITE);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(64, 11, 426, 79);
		panPrincipal.add(panel);
		
		btnIncluir = new JButton("");
		btnIncluir.setIcon(new ImageIcon(FrmFunc.class.getResource("/img/Insert.png")));
		btnIncluir.setBounds(49, 11, 69, 41);
		panel.add(btnIncluir);
		
		lblIncluir = new JLabel("Incluir");
		lblIncluir.setLabelFor(btnIncluir);
		lblIncluir.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblIncluir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblIncluir.setBounds(59, 54, 59, 19);
		panel.add(lblIncluir);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(FrmFunc.class.getResource("/img/Edit.png")));
		btnAlterar.setBounds(143, 11, 69, 41);
		panel.add(btnAlterar);
		
		JLabel lblAlterar = new JLabel("Alterar");
		lblAlterar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAlterar.setBounds(162, 54, 44, 19);
		panel.add(lblAlterar);
		
		btnRemover = new JButton("");
		btnRemover.setIcon(new ImageIcon(FrmFunc.class.getResource("/img/Delete.png")));
		btnRemover.setBounds(232, 11, 69, 41);
		panel.add(btnRemover);
		
		lblRemover = new JLabel("Excluir");
		lblRemover.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblRemover.setBounds(252, 53, 38, 19);
		panel.add(lblRemover);
		
		lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPesquisar.setBounds(336, 53, 59, 19);
		panel.add(lblPesquisar);
		
		btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(FrmFunc.class.getResource("/img/View.png")));
		btnPesquisar.setBounds(326, 11, 69, 41);
		panel.add(btnPesquisar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 546, 152);
		scrollPane.setVisible(false);
		panPrincipal.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setVisible(false);
		scrollPane.setViewportView(table);
		
		lblNome = new JLabel("Nome : ");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(33, 313, 68, 14);
		lblNome.setVisible(false);
		panPrincipal.add(lblNome);
		
		lblCpf = new JLabel("CPF : ");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(33, 348, 46, 14);
		lblCpf.setVisible(false);
		panPrincipal.add(lblCpf);
		
		lblSalario = new JLabel("Sal\u00E1rio : ");
		lblSalario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalario.setBounds(33, 381, 60, 17);
		lblSalario.setVisible(false);
		panPrincipal.add(lblSalario);
		
		lblCargo = new JLabel("Cargo : ");
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCargo.setBounds(33, 453, 60, 17);
		lblCargo.setVisible(false);
		panPrincipal.add(lblCargo);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigo.setBounds(33, 280, 60, 22);
		lblCodigo.setVisible(false);
		panPrincipal.add(lblCodigo);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(FrmFunc.class.getResource("/img/MiniBack.png")));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(33, 496, 96, 31);
		btnVoltar.setVisible(false);
		panPrincipal.add(btnVoltar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(FrmFunc.class.getResource("/img/MiniClear.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(240, 496, 96, 31);
		btnLimpar.setVisible(false);
		panPrincipal.add(btnLimpar);
		
		btnGravar = new JButton("Gravar");
		btnGravar.setIcon(new ImageIcon(FrmFunc.class.getResource("/img/MiniSalvar.png")));
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravar.setBounds(432, 496, 96, 31);
		btnGravar.setVisible(false);
		panPrincipal.add(btnGravar);
		
		txtCodigo.setBackground(SystemColor.info);
		txtCodigo.setBounds(103, 280, 96, 22);
		txtCodigo.setVisible(false);
		panPrincipal.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBackground(SystemColor.info);
		txtNome.setBounds(103, 313, 182, 22);
		txtNome.setVisible(false);
		panPrincipal.add(txtNome);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBackground(SystemColor.info);
		txtCpf.setBounds(103, 348, 182, 22);
		txtCpf.setVisible(false);
		panPrincipal.add(txtCpf);
		
		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		txtSalario.setBackground(SystemColor.info);
		txtSalario.setBounds(103, 381, 182, 22);
		txtSalario.setVisible(false);
		panPrincipal.add(txtSalario);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(FrmFunc.class.getResource("/img/LogoLudpet.png")));
		lblLogo.setBounds(10, 181, 546, 199);
		panPrincipal.add(lblLogo);
		
		lblTelefone = new JLabel("Telefone :");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefone.setBounds(33, 420, 68, 14);
		lblTelefone.setVisible(false);
		panPrincipal.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBackground(SystemColor.info);
		txtTelefone.setBounds(113, 419, 128, 20);
		txtTelefone.setVisible(false);
		panPrincipal.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		rdbtnAdministrador = new JRadioButton("Administrador");
		rdbtnAdministrador.setVisible(false);
		rdbtnAdministrador.setBorder(new EmptyBorder(0, 0, 0, 0));
		rdbtnAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnAdministrador.setBackground(Color.WHITE);
		rdbtnAdministrador.setBounds(99, 452, 109, 23);
		panPrincipal.add(rdbtnAdministrador);
		
		rdbtnAtendente = new JRadioButton("Atendente");
		rdbtnAtendente.setVisible(false);
		rdbtnAtendente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnAtendente.setBorder(new EmptyBorder(0, 0, 0, 0));
		rdbtnAtendente.setBackground(Color.WHITE);
		rdbtnAtendente.setBounds(227, 452, 109, 23);
		panPrincipal.add(rdbtnAtendente);
		
		rdbtnBanhistaTosador = new JRadioButton("Banhista/Tosador");
		rdbtnBanhistaTosador.setVisible(false);
		rdbtnBanhistaTosador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBanhistaTosador.setBorder(new EmptyBorder(0, 0, 0, 0));
		rdbtnBanhistaTosador.setBackground(Color.WHITE);
		rdbtnBanhistaTosador.setBounds(346, 452, 128, 23);
		panPrincipal.add(rdbtnBanhistaTosador);
		
		bg = new ButtonGroup();
		bg.add(rdbtnBanhistaTosador);
		bg.add(rdbtnAtendente);
		bg.add(rdbtnAdministrador);
		
		janela.setSize(582,600);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		
		ctrlFunc = new CtrlFuncionario();
//		int codigoAtual = ctrlFunc.pegarCodigo();
//		String codAtual = String.valueOf(codigoAtual+1);
//		txtCodigo.setText( codAtual );

//		btnIncluir.addActionListener(e -> {
//			acaoPrincipal(e);
//		});
//		btnAlterar.addActionListener(e -> {
//			acaoPrincipal(e);
//			btnGravar.addActionListener(this);
//		});
//		btnPesquisar.addActionListener(e -> {
//			acaoPrincipal(e);
//			btnGravar.addActionListener(this);
//		});
//		btnRemover.addActionListener(e -> {
//			acaoPrincipal(e);
//			btnGravar.addActionListener(this);
//		});
		
		btnIncluir.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnPesquisar.addActionListener(this);
		btnRemover.addActionListener(this);
		btnLimpar.addActionListener(this);
		btnVoltar.addActionListener(this);
		btnGravar.addActionListener(this);
		
		
	}
	
	private void montarTela(int controle) {
		if(controle == 1){
			lblCodigo.setVisible(true);
			lblNome.setVisible(true);
			lblCargo.setVisible(true);
			lblCpf.setVisible(true);
			lblSalario.setVisible(true);
			lblTelefone.setVisible(true);
			rdbtnAdministrador.setVisible(true);
			rdbtnAdministrador.setEnabled(true);
			rdbtnAtendente.setVisible(true);
			rdbtnAtendente.setEnabled(true);
			rdbtnBanhistaTosador.setVisible(true);
			rdbtnBanhistaTosador.setEnabled(true);
			txtNome.setVisible(true);
			txtCodigo.setVisible(true);
			txtSalario.setVisible(true);
			txtSalario.setEnabled(true);
			txtCpf.setVisible(true);
			txtCpf.setEnabled(true);
			txtTelefone.setVisible(true);
			txtTelefone.setEnabled(true);
			table.setVisible(true);
			scrollPane.setVisible(true);
			btnGravar.setVisible(true);
			btnLimpar.setVisible(true);
			btnVoltar.setVisible(true);
		}else {
			lblCodigo.setVisible(true);
			lblNome.setVisible(true);
			lblCargo.setVisible(true);
			lblCpf.setVisible(true);
			lblSalario.setVisible(true);
			lblTelefone.setVisible(true);
			rdbtnAdministrador.setVisible(true);
			rdbtnAdministrador.setEnabled(false);
			rdbtnAtendente.setVisible(true);
			rdbtnAtendente.setEnabled(false);
			rdbtnBanhistaTosador.setVisible(true);
			rdbtnBanhistaTosador.setEnabled(false);
			txtNome.setVisible(true);
			txtCodigo.setVisible(true);
			txtSalario.setVisible(true);
			txtSalario.setEnabled(false);
			txtCpf.setVisible(true);
			txtCpf.setEnabled(false);
			txtTelefone.setVisible(true);
			txtTelefone.setEnabled(false);
			table.setVisible(true);
			scrollPane.setVisible(true);
			btnGravar.setVisible(true);
			btnLimpar.setVisible(true);
			btnVoltar.setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object acao = e.getSource();
		lblLogo.setVisible(false);
		
		if(btnIncluir.equals(acao)){
			controle = 1;
			montarTela(controle);

		}else if(btnRemover.equals(acao)){
			controle = 2;
			montarTela(controle);
			
		}else if(btnAlterar.equals(acao)){
			controle = 3;
			montarTela(controle);
			
		}else if(btnPesquisar.equals(acao)){
			controle = 4;
			montarTela(controle);
			
		}
		
		if(btnGravar.equals(acao) && controle==1){
			System.out.println("Gravar incluindo");
			Funcionario f = new Funcionario();
			f.setNome( txtNome.getText() );
			f.setCpf( txtCpf.getText() );
			f.setSalario( Double.parseDouble(txtSalario.getText()) );
			if(rdbtnAdministrador.isSelected()){
				f.setCargo("Administrador");
			}else if(rdbtnAtendente.isSelected()){
				f.setCargo("Atendente");
			}else if(rdbtnBanhistaTosador.isSelected()){
				f.setCargo("Banhista/Tosador");
			}
			ctrlFunc.incluir(f);
		}else if(btnGravar.equals(acao) && controle==2){
			System.out.println("Gravar removendo");
		}else if(btnGravar.equals(acao) && controle==3){
			System.out.println("Gravar alterando");
		}else if(btnGravar.equals(acao) && controle==4){
			System.out.println("Gravar pesquisando");
		}

	}
	
	
	private void limpaCampos() {
		bg.clearSelection();
		txtCodigo.setText("");
		txtCpf.setText("");
		txtNome.setText("");
		txtSalario.setText("");
		txtTelefone.setText("");
	}

	public static void main(String[] args) {
		new FrmFunc("Funcionario");
	}
}
