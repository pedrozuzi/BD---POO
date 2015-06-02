package boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.ConfigTelas;
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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import sun.font.StrikeCache;
import entity.Funcionario;

public class FrmUsuario implements ActionListener, MouseListener, KeyListener, FocusListener{

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
	private List<Funcionario> lista = new ArrayList<Funcionario>();
	private int id;
	private CtrlFuncionario ctrlFunc;
	
	public FrmUsuario() {

		janela = new JFrame("Usuario");
		janela.setTitle("Usu\u00E1rio");
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(SystemColor.window);
		janela.setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
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
		btnIncluir.setActionCommand("Incluir");
		panelAcoes.add(btnIncluir);
		
		lblIncluir = new JLabel("Incluir");
		lblIncluir.setVerticalTextPosition(SwingConstants.TOP);
		lblIncluir.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIncluir.setBounds(59, 54, 39, 19);
		panelAcoes.add(lblIncluir);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/Edit.png")));
		btnAlterar.setBounds(143, 11, 69, 41);
		btnAlterar.setActionCommand("Alterar");
		panelAcoes.add(btnAlterar);
		
		lblAlterar = new JLabel("Alterar");
		lblAlterar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAlterar.setBounds(153, 54, 44, 19);
		panelAcoes.add(lblAlterar);
		
		btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/Delete.png")));
		btnExcluir.setBounds(232, 11, 69, 41);
		btnExcluir.setActionCommand("Excluir");
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
		scrollPane.setViewportView(table);
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
		
		txtNome = new JTextField();
		txtNome.setBackground(SystemColor.info);
		txtNome.setBounds(78, 30, 261, 23);
		panelFuncionario.add(txtNome);
		txtNome.setColumns(10);
		
		btnPesquisarNome = new JButton("");
		btnPesquisarNome.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/MiniLupa.png")));
		btnPesquisarNome.setBounds(349, 27, 40, 23);
		btnPesquisarNome.setActionCommand("PesquisarNome");
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
		lblLogoLudPet.setVisible(false);
		montarTela();
		
		if(acao.equalsIgnoreCase("Incluir")){
			btnGravar.setActionCommand("Gravar");
			btnGravar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/MiniSalvar.png")));
			btnGravar.setText("Gravar");
		} else if(acao.equalsIgnoreCase("Alterar")){
			btnGravar.setActionCommand("Mudar");
			btnGravar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/MiniSalvar.png")));
			btnGravar.setText("Salvar");
		}else if(acao.equalsIgnoreCase("Excluir")){
			btnGravar.setActionCommand("Deletar");
			btnGravar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/trash.png")));
			btnGravar.setText("Excluir");
		}
		
		if(acao.equalsIgnoreCase("PesquisarNome")){
			pesquisar();
		}
		
		if(acao.equalsIgnoreCase("Gravar")){
			if(new String(pwdSenha.getPassword()).equals(new String(pwdConfirmarSenha.getPassword()))){
				System.out.println("Incluir usuario");
			} else {
				JOptionPane.showMessageDialog(null, "Senhas não coincidem", 
						"Aviso", JOptionPane.INFORMATION_MESSAGE);
				pwdSenha.setText("");
				pwdConfirmarSenha.setText("");
				pwdSenha.grabFocus();
			}
		}else if(acao.equalsIgnoreCase("Mudar")){
			
		}else if(acao.equalsIgnoreCase("Deletar")){
			
		}else if(acao.equalsIgnoreCase("Voltar")){
			
		}else if(acao.equalsIgnoreCase("Limpar")){
			limpaCampos();
		}
		
		
	}
	
	private void pesquisar() {

		try {
			lista = ctrlFunc.pesquisarFuncionario(txtNome.getText());
			if (!lista.isEmpty()) {
				modelo = new ModeloTabela(lista);
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
		pwdConfirmarSenha.setVisible(true);
		pwdSenha.setVisible(true);
		btnPesquisarNome.setVisible(true);
		btnGravar.setVisible(true);
		btnVoltar.setVisible(true);
		btnVerificar.setVisible(true);
		btnLimpar.setVisible(true);
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
		
		id = lista.get(linha).getId();
		for (Funcionario f : lista) {
			if(valores[0].equals(f.getNome())){
				txtNome.setText(String.valueOf(valores[0]));
			}
		}
		
		txtUsuario.setEditable(true);
		txtUsuario.grabFocus();
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
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
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
