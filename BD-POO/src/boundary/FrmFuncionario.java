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
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import control.CtrlFuncionario;
import entity.Funcionario;

import java.awt.Cursor;

import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class FrmFuncionario implements ActionListener{

	private JFrame janela;
	private JPanel panPrincipal;
	private JTable table;
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
	private JButton btnPesquisarNome;
	
	public FrmFuncionario(String nome) {
	
		janela = new JFrame("Fornecedor");
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
		btnIncluir.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/Insert.png")));
		btnIncluir.setBounds(49, 11, 69, 41);
		panel.add(btnIncluir);
		
		lblIncluir = new JLabel("Incluir");
		lblIncluir.setVerticalTextPosition(SwingConstants.TOP);
		lblIncluir.setLabelFor(panel);
		lblIncluir.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblIncluir.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIncluir.setBounds(59, 54, 39, 19);
		panel.add(lblIncluir);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/Edit.png")));
		btnAlterar.setBounds(143, 11, 69, 41);
		panel.add(btnAlterar);
		
		JLabel lblAlterar = new JLabel("Alterar");
		lblAlterar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAlterar.setBounds(153, 54, 44, 19);
		panel.add(lblAlterar);
		
		btnRemover = new JButton("");
		btnRemover.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/Delete.png")));
		btnRemover.setBounds(232, 11, 69, 41);
		panel.add(btnRemover);
		
		lblRemover = new JLabel("Excluir");
		lblRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRemover.setBounds(242, 54, 39, 19);
		panel.add(lblRemover);
		
		lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPesquisar.setBounds(336, 54, 59, 19);
		panel.add(lblPesquisar);
		
		btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/View.png")));
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
		lblNome.setBounds(33, 290, 68, 14);
		lblNome.setVisible(false);
		panPrincipal.add(lblNome);
		
		lblCpf = new JLabel("CPF : ");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(33, 322, 46, 14);
		lblCpf.setVisible(false);
		panPrincipal.add(lblCpf);
		
		lblSalario = new JLabel("Sal\u00E1rio : ");
		lblSalario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalario.setBounds(33, 360, 60, 17);
		lblSalario.setVisible(false);
		panPrincipal.add(lblSalario);
		
		lblCargo = new JLabel("Cargo : ");
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCargo.setBounds(33, 438, 60, 17);
		lblCargo.setVisible(false);
		panPrincipal.add(lblCargo);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/MiniBack.png")));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(33, 496, 96, 31);
		btnVoltar.setVisible(false);
		panPrincipal.add(btnVoltar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/MiniClear.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(240, 496, 96, 31);
		btnLimpar.setVisible(false);
		panPrincipal.add(btnLimpar);
		
		btnGravar = new JButton("Gravar");
		btnGravar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/MiniSalvar.png")));
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravar.setBounds(425, 496, 103, 31);
		btnGravar.setVisible(false);
		panPrincipal.add(btnGravar);
			
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBackground(SystemColor.info);
		txtNome.setBounds(103, 288, 182, 22);
		txtNome.setVisible(false);
		panPrincipal.add(txtNome);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBackground(SystemColor.info);
		txtCpf.setBounds(103, 320, 182, 22);
		txtCpf.setVisible(false);
		panPrincipal.add(txtCpf);
		
		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		txtSalario.setBackground(SystemColor.info);
		txtSalario.setBounds(103, 359, 182, 22);
		txtSalario.setVisible(false);
		panPrincipal.add(txtSalario);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/LogoLudpet.png")));
		lblLogo.setBounds(10, 181, 546, 199);
		panPrincipal.add(lblLogo);
		
		lblTelefone = new JLabel("Telefone :");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefone.setBounds(33, 402, 68, 14);
		lblTelefone.setVisible(false);
		panPrincipal.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBackground(SystemColor.info);
		txtTelefone.setBounds(103, 401, 128, 20);
		txtTelefone.setVisible(false);
		panPrincipal.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		rdbtnAdministrador = new JRadioButton("Administrador");
		rdbtnAdministrador.setVisible(false);
		rdbtnAdministrador.setBorder(new EmptyBorder(0, 0, 0, 0));
		rdbtnAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnAdministrador.setBackground(Color.WHITE);
		rdbtnAdministrador.setBounds(103, 436, 109, 23);
		panPrincipal.add(rdbtnAdministrador);
		
		rdbtnAtendente = new JRadioButton("Atendente");
		rdbtnAtendente.setVisible(false);
		rdbtnAtendente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnAtendente.setBorder(new EmptyBorder(0, 0, 0, 0));
		rdbtnAtendente.setBackground(Color.WHITE);
		rdbtnAtendente.setBounds(227, 436, 109, 23);
		panPrincipal.add(rdbtnAtendente);
		
		rdbtnBanhistaTosador = new JRadioButton("Banhista/Tosador");
		rdbtnBanhistaTosador.setVisible(false);
		rdbtnBanhistaTosador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBanhistaTosador.setBorder(new EmptyBorder(0, 0, 0, 0));
		rdbtnBanhistaTosador.setBackground(Color.WHITE);
		rdbtnBanhistaTosador.setBounds(346, 436, 128, 23);
		panPrincipal.add(rdbtnBanhistaTosador);
		
		bg = new ButtonGroup();
		bg.add(rdbtnBanhistaTosador);
		bg.add(rdbtnAtendente);
		bg.add(rdbtnAdministrador);
		
		btnPesquisarNome = new JButton("");
		btnPesquisarNome.setVisible(false);
		btnPesquisarNome.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/MiniLupa.png")));
		btnPesquisarNome.setBounds(295, 287, 40, 23);
		panPrincipal.add(btnPesquisarNome);
		
		janela.setSize(582,600);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		
		btnIncluir.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnPesquisar.addActionListener(this);
		btnRemover.addActionListener(this);
		btnLimpar.addActionListener(this);
		btnVoltar.addActionListener(this);
		btnGravar.addActionListener(this);
		btnPesquisarNome.addActionListener(this);
				
	}
	
	private void montarTela(int controle) {
		if(controle == 1){
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
			btnPesquisarNome.setVisible(false);
		}else {
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
			btnPesquisarNome.setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object acao = e.getSource();
		String cmd = e.getActionCommand();
		lblLogo.setVisible(false);
		
		if(btnIncluir.equals(acao)){
			montarTela(1);
			btnGravar.setText("Gravar");
			btnGravar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/MiniSalvar.png")));
			btnGravar.setEnabled(true);
			btnGravar.setActionCommand("Incluir");
		}else if(btnRemover.equals(acao)){
			montarTela(2);
			btnGravar.setActionCommand("Remover");
			btnGravar.setText("Excluir");
			btnGravar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/MiniX.png")));
			btnGravar.setEnabled(true);			
		}else if(btnAlterar.equals(acao)){
			montarTela(2);
			btnGravar.setText("Salvar");
			btnGravar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/MiniEditar.png")));
			btnGravar.setEnabled(true);
			btnGravar.setActionCommand("Alterar");
		}else if(btnPesquisar.equals(acao)){
			montarTela(2);
			btnGravar.setText("Gravar");
			btnGravar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/MiniSalvar.png")));
			btnGravar.setEnabled(false);
			btnGravar.setActionCommand("Pesquisar");
		}
		
		if("Incluir".equalsIgnoreCase(cmd)){

			ctrlFunc = new CtrlFuncionario();
			Funcionario f = new Funcionario();
			f.setNome( txtNome.getText() );
			f.setCpf( txtCpf.getText() );
			f.setSalario( Double.parseDouble(txtSalario.getText()) );
			f.setTelefone( Integer.parseInt(txtTelefone.getText()) );
			if(rdbtnAdministrador.isSelected()){
				f.setIdTipo(1);
				ctrlFunc.incluir(f);
			}else if(rdbtnAtendente.isSelected()){
				f.setIdTipo(2);
				ctrlFunc.incluir(f);
			}else if(rdbtnBanhistaTosador.isSelected()){
				f.setIdTipo(3);
				ctrlFunc.incluir(f);
			}
			limpaCampos();
		}else if("Remover".equalsIgnoreCase(cmd)){
			if(txtNome.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Sem dados para processar",
						"Erro", JOptionPane.QUESTION_MESSAGE);
			}else{
				System.out.println("Remover Funcionario");
			}
		}else if("Alterar".equalsIgnoreCase(cmd)){
			if(txtNome.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Sem dados para processar",
						"Erro", JOptionPane.QUESTION_MESSAGE);
			}else{
				System.out.println("Remover Funcionario");
			}
		}else if("Pesquisar".equalsIgnoreCase(cmd)){
			System.out.println("Gravar pesquisando");
		}
		
		if(btnVoltar.equals(acao)){
			System.out.println("Voltando...");
		}
		if(btnLimpar.equals(acao)){
			limpaCampos();
		}
		if(btnPesquisarNome.equals(acao)){
			System.out.println("Procurar por aquele nome...");
		}

	}
	
	
	private void limpaCampos() {
		bg.clearSelection();
		txtCpf.setText("");
		txtNome.setText("");
		txtSalario.setText("");
		txtTelefone.setText("");
	}

	public static void main(String[] args) {
		new FrmFuncionario("Funcionario");
	}
}
