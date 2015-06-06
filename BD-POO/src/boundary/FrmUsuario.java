package boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.ConfigTelas;
import control.ConfiguracoesTela;
import control.CtrlFuncionario;
import control.CtrlUsuario;
import control.ModeloTabela;
import control.TratamentoTextFields;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import entity.Funcionario;
import entity.Usuario;

public class FrmUsuario implements ActionListener, MouseListener, FocusListener{

	private JFrame janela;
	private JPanel panelPrincipal;
	private JTable table;
	private JTextField txtNome;
	private JTextField txtUsuario;
	private JPasswordField pwdSenha;
	private JPasswordField pwdConfirmarSenha;
	private JPanel panelAcoes;
	private JButton btnPesquisarNome;
	private JLabel lblNome;
	private JPanel panelFuncionario;
	private JButton btnIncluir;
	private JLabel lblIncluir;
	private JButton btnAlterar;
	private JLabel lblAlterar;
	private JButton btnExcluir;
	private JLabel lblExcluir;
	private JScrollPane scrollPane;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JLabel lblConfirmaSenha;
	private JButton btnVerificar;
	private JButton btnVoltar;
	private JButton btnLimpar;
	private JButton btnGravar;
	private JLabel lblDadosObrigatorios;
	private JLabel lblLogoLudPet;
	private CtrlUsuario controlUsuario;
	private ModeloTabela modelo;
	private List<Funcionario> listaF = new ArrayList<Funcionario>();
	private List<Usuario> listaU = new ArrayList<Usuario>();
	private int id;
	private CtrlFuncionario ctrlFunc;
	private JMenuBar menuBarra;
	private JMenu menu;
	private JMenuItem menuPrincipal;
	private JMenuItem logOff;
	private Funcionario f;
	
	public FrmUsuario() {

		janela = new JFrame("Usuario");
		janela.setTitle("Usu\u00E1rio");
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(SystemColor.window);
		janela.setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		// CONFIGURACOES DE TELA, PODER SER NECESSARIO COMENTAR PARA EDITAR NO WINDONBUILDER
		ConfiguracoesTela configTela = new ConfiguracoesTela(janela);
		configTela.iconeBarra(janela);
		
		menuBarra = new JMenuBar();
		janela.setJMenuBar(menuBarra);
		
		menu = new JMenu("Menu");
		menuBarra.add(menu);
		
		menuPrincipal = new JMenuItem("Menu Principal");
		menuPrincipal.setIcon(new ImageIcon(getClass()
				.getResource("/img/HomeMenu.png")));
		menu.add(menuPrincipal);
		
		//MANDAR O USUARIO LOGADO NO SISTEMA NO LUGAR DE (null)
		menuPrincipal.addActionListener(e -> {
			janela.dispose();
			new FrmPrincipal(null);
		}); 
		
		logOff = new JMenuItem("Log Off");
		logOff.setIcon(new ImageIcon(getClass()
				.getResource("/img/LogOffMenu.png")));
		menu.add(logOff);
		
		
		logOff.addActionListener(e -> {
			janela.dispose();
			new FrmLogin();
		});
		
		panelAcoes = new JPanel();
		panelAcoes.setLayout(null);
		panelAcoes.setForeground(Color.WHITE);
		panelAcoes.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelAcoes.setBackground(SystemColor.window);
		panelAcoes.setBounds(139, 27, 338, 79);
		panelPrincipal.add(panelAcoes);
		
		btnIncluir = new JButton("");
		btnIncluir.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/Insert.png")));
		btnIncluir.setBounds(49, 11, 69, 41);
		panelAcoes.add(btnIncluir);
		
		lblIncluir = new JLabel("Incluir");
		lblIncluir.setVerticalTextPosition(SwingConstants.TOP);
		lblIncluir.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIncluir.setBounds(59, 54, 39, 19);
		panelAcoes.add(lblIncluir);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/Edit.png")));
		btnAlterar.setBounds(143, 11, 69, 41);
		panelAcoes.add(btnAlterar);
		
		lblAlterar = new JLabel("Alterar");
		lblAlterar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAlterar.setBounds(153, 54, 44, 19);
		panelAcoes.add(lblAlterar);
		
		btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/Delete.png")));
		btnExcluir.setBounds(232, 11, 69, 41);
		panelAcoes.add(btnExcluir);
		
		lblExcluir = new JLabel("Excluir");
		lblExcluir.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblExcluir.setBounds(242, 54, 39, 19);
		panelAcoes.add(lblExcluir);
		
		table = new JTable();
		table.setBorder(new LineBorder(Color.black));
		table.setGridColor(Color.black);
		table.setShowGrid(true);
		table.addMouseListener(this);
		
		scrollPane = new JScrollPane();
		scrollPane.setVisible(false);
		scrollPane.getViewport().setBorder(null);
		scrollPane.getViewport().add(table);
		scrollPane.setBounds(9, 117, 608, 163);
		panelPrincipal.add(scrollPane);

		panelFuncionario = new JPanel();
		panelFuncionario.setVisible(false);
		panelFuncionario.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Funcionario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFuncionario.setForeground(Color.WHITE);
		panelFuncionario.setBackground(Color.WHITE);
		panelFuncionario.setBounds(29, 302, 438, 84);
		panelPrincipal.add(panelFuncionario);
		panelFuncionario.setLayout(null);
		
		lblNome = new JLabel("Nome :");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(10, 31, 58, 14);
		panelFuncionario.add(lblNome);
		
		txtNome = new TratamentoTextFields();
		txtNome.setBackground(SystemColor.info);
		txtNome.setBounds(78, 30, 261, 23);
		txtNome.setColumns(10);
		panelFuncionario.add(txtNome);
		
		btnPesquisarNome = new JButton("");
		btnPesquisarNome.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/MiniLupa.png")));
		btnPesquisarNome.setBounds(349, 27, 40, 23);
		panelFuncionario.add(btnPesquisarNome);
		
		lblUsuario = new JLabel("Usu\u00E1rio : *");
		lblUsuario.setVisible(false);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(38, 408, 80, 14);
		panelPrincipal.add(lblUsuario);
		
		lblSenha = new JLabel("Senha : *");
		lblSenha.setVisible(false);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(38, 443, 80, 14);
		panelPrincipal.add(lblSenha);
		
		txtUsuario = new TratamentoTextFields();
		txtUsuario.setVisible(false);
		txtUsuario.setBackground(SystemColor.info);
		txtUsuario.setBounds(128, 406, 141, 23);
		txtUsuario.setEditable(false);
		panelPrincipal.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setVisible(false);
		pwdSenha.setBackground(SystemColor.info);
		pwdSenha.setBounds(128, 441, 141, 23);
		pwdSenha.setEditable(false);
		panelPrincipal.add(pwdSenha);
		
		lblConfirmaSenha = new JLabel("Confirmar senha : *");
		lblConfirmaSenha.setVisible(false);
		lblConfirmaSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConfirmaSenha.setBounds(38, 480, 141, 14);
		panelPrincipal.add(lblConfirmaSenha);
		
		pwdConfirmarSenha = new JPasswordField();
		pwdConfirmarSenha.setVisible(false);
		pwdConfirmarSenha.setBackground(SystemColor.info);
		pwdConfirmarSenha.setBounds(189, 478, 141, 23);
		pwdConfirmarSenha.setEditable(false);
		panelPrincipal.add(pwdConfirmarSenha);
		
		btnVerificar = new JButton("Verificar");
		btnVerificar.setVisible(false);
		btnVerificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVerificar.setBounds(279, 406, 90, 23);
		panelPrincipal.add(btnVerificar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setVisible(false);
		btnVoltar.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/MiniBack.png")));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(29, 562, 98, 31);
		panelPrincipal.add(btnVoltar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setVisible(false);
		btnLimpar.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/MiniClear.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(261, 562, 98, 31);
		panelPrincipal.add(btnLimpar);
		
		btnGravar = new JButton("Gravar\r\n");
		btnGravar.setVisible(false);
		btnGravar.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/MiniSalvar.png")));
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravar.setBounds(483, 562, 98, 31);
		panelPrincipal.add(btnGravar);
		
		lblDadosObrigatorios = new JLabel("* Dados obrigat\u00F3rios");
		lblDadosObrigatorios.setVisible(false);
		lblDadosObrigatorios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDadosObrigatorios.setBounds(464, 537, 117, 14);
		panelPrincipal.add(lblDadosObrigatorios);
		
		lblLogoLudPet = new JLabel("");
		lblLogoLudPet.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/LogoLudpet.png")));
		lblLogoLudPet.setBounds(20, 174, 587, 286);
		panelPrincipal.add(lblLogoLudPet);
		
		janela.setSize(633, 671);		
		ConfigTelas.centralizarFrame(janela);
		
		f = new Funcionario();
		ctrlFunc = new CtrlFuncionario();
		controlUsuario = new CtrlUsuario();
		
		btnIncluir.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnExcluir.addActionListener(this);
		btnGravar.addActionListener(this);
		btnVoltar.addActionListener(this);
		btnLimpar.addActionListener(this);
		btnPesquisarNome.addActionListener(this);	
		
		txtUsuario.addFocusListener(this);
		pwdSenha.addFocusListener(this);
		pwdConfirmarSenha.addFocusListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();
		Object obj = e.getSource();
		lblLogoLudPet.setVisible(false);
		montarTela();
		
		if(btnIncluir.equals(obj)){
			btnGravar.setActionCommand("Incluir");
			btnGravar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/MiniSalvar.png")));
			btnGravar.setText("Gravar");
			btnPesquisarNome.setActionCommand("PesquisarNomeIncluir");
		} else if(btnAlterar.equals(obj)){
			btnGravar.setActionCommand("Alterar");
			btnGravar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/MiniSalvar.png")));
			btnGravar.setText("Salvar");
			btnPesquisarNome.setActionCommand("PesquisarNomeAlterar");
		}else if(btnExcluir.equals(obj)){
			btnGravar.setActionCommand("Excluir");
			btnGravar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/trash.png")));
			btnGravar.setText("Excluir");
			btnPesquisarNome.setActionCommand("PesquisarNomeExcluir");
		}
		
		if(acao.equalsIgnoreCase("Incluir")){
			if(new String(pwdSenha.getPassword()).equals(new String(pwdConfirmarSenha.getPassword()))){
				Usuario u = new Usuario();
				u.setNome( txtUsuario.getText() );
				u.setSenha(new String ( pwdSenha.getPassword() ));
				u.setF(f);
				controlUsuario.adicionarUsuario(u);
				limpaCampos();
			} else {
				JOptionPane.showMessageDialog(null, "Senhas não coincidem", 
						"Aviso", JOptionPane.INFORMATION_MESSAGE);
				limpaCampos();
				pwdSenha.grabFocus();
			}
		}else if(acao.equalsIgnoreCase("Alterar")){
			
		}else if(acao.equalsIgnoreCase("Excluir")){
			
		}else if(acao.equalsIgnoreCase("Voltar")){
			
		}else if(acao.equalsIgnoreCase("Limpar")){
			limpaCampos();
		}
	
		if(acao.equalsIgnoreCase("PesquisarNomeIncluir") ){
			pesquisarFuncionario();
		} else if(acao.equalsIgnoreCase("PesquisarNomeAlterar")){
			pesquisarUsuario();
		} else if(acao.equalsIgnoreCase("PesquisarNomeExcluir")){
			pesquisarFuncionario();
		}
		
		
	}
	
	private void pesquisarUsuario(){
		
		try{
			
			listaU = controlUsuario.pesquisarUsuario( txtNome.getText() );
			if (!listaU.isEmpty()) {
				modelo = new ModeloTabela(listaU);
				table.getTableHeader().setReorderingAllowed(false);
				table.setModel(modelo);
				
			} else {
				JOptionPane.showMessageDialog(null,
						"Nenhum registro encontrado", "Aviso",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (NullPointerException e1) {
			System.out.println("NullPointer");
		}
		
	}
	
	private void pesquisarFuncionario() {
			
		try {
			System.out.println("TESTE.. "+ txtNome.getText());
			listaF = ctrlFunc.pesquisarFuncionario(txtNome.getText());
			if (!listaF.isEmpty()) {
				modelo = new ModeloTabela(listaF);
				table.getTableHeader().setReorderingAllowed(false);
				table.setModel(modelo);
				
			} else {
				JOptionPane.showMessageDialog(null,
						"Nenhum registro encontrado", "Aviso",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (NullPointerException e1) {
			System.out.println("NullPointer");
		}

	}

	private void montarTela() {
		panelFuncionario.setVisible(true);
		scrollPane.setVisible(true);
		lblNome.setVisible(true);
		lblUsuario.setVisible(true);
		lblConfirmaSenha.setVisible(true);
		lblDadosObrigatorios.setVisible(true);
		lblSenha.setVisible(true);
		lblConfirmaSenha.setVisible(true);
		txtUsuario.setVisible(true);
		txtUsuario.setEditable(false);
		pwdConfirmarSenha.setVisible(true);
		pwdConfirmarSenha.setEditable(false);
		pwdSenha.setVisible(true);
		pwdSenha.setEditable(false);
		btnPesquisarNome.setVisible(true);
		btnGravar.setVisible(true);
		btnVoltar.setVisible(true);
		btnVerificar.setVisible(true);
		btnLimpar.setVisible(true);
		//limpaCampos(); <---- ESTA LIMPANDO O CAMPO ANTES DE PESQUISAR
	}

	private void limpaCampos() {
		txtNome.setText("");
		pwdSenha.setText("");
		pwdConfirmarSenha.setText("");
		txtUsuario.setText("");
	}

	public static void main(String[] args) {
		new FrmUsuario();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object[] valores = new Object[2];
		int linha = table.getSelectedRow();
		int coluna = table.getSelectedColumn();
		
		for (coluna = 0; coluna < table.getColumnCount(); coluna++) {
			valores[coluna] = table.getValueAt(linha, coluna);
		}
		
		id = listaF.get(linha).getId();
		f = listaF.get(linha);
		for (Funcionario f : listaF) {
			if(valores[0].equals(f.getNome())){
				txtNome.setText(String.valueOf(valores[0]));
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		Object obj = e.getSource();
		
		if(txtUsuario.equals(obj)){
			if(controlUsuario.verificarNomeUsuario( txtUsuario.getText() )){
				JOptionPane.showMessageDialog(null,"Usuário já existente", 
						"Aviso", JOptionPane.INFORMATION_MESSAGE);
				txtNome.grabFocus();
				limpaCampos();
			} else {
				System.out.println("ENTROU");
				pwdSenha.setEditable(true);
				pwdConfirmarSenha.setEditable(true);
				pwdSenha.grabFocus();
			}
		} 
	}
}
