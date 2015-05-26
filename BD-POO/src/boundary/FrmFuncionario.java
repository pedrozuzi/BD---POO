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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import control.CtrlFornecedor;
import control.CtrlFuncionario;
import control.CtrlTabela;
import control.TratamentoTextFields;
import entity.Fornecedor;
import entity.Funcionario;

import java.awt.Cursor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class FrmFuncionario implements ActionListener, MouseListener{

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
	private JLabel lblDadoObrigatorio;
	private JLabel lblAlterar;
	private DefaultTableModel modelo;
	private List<Funcionario> lista;
	
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
		
		lblAlterar = new JLabel("Alterar");
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
		
		table = new JTable();
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 546, 152);
		scrollPane.setVisible(false);
		panPrincipal.add(scrollPane);
		
		lblNome = new JLabel("Nome : *");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(33, 290, 68, 14);
		lblNome.setVisible(false);
		panPrincipal.add(lblNome);
		
		lblCpf = new JLabel("CPF : *");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(33, 322, 60, 14);
		lblCpf.setVisible(false);
		panPrincipal.add(lblCpf);
		
		lblSalario = new JLabel("Sal\u00E1rio : *");
		lblSalario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalario.setBounds(33, 360, 68, 17);
		lblSalario.setVisible(false);
		panPrincipal.add(lblSalario);
		
		lblCargo = new JLabel("Cargo : *");
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCargo.setBounds(33, 438, 68, 17);
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
			
		txtNome = new TratamentoTextFields();
		txtNome.setColumns(10);
		txtNome.setBackground(SystemColor.info);
		txtNome.setBounds(123, 288, 182, 22);
		txtNome.setVisible(false);
		panPrincipal.add(txtNome);
		
		txtCpf = new TratamentoTextFields(11);
		txtCpf.setColumns(10);
		txtCpf.setBackground(SystemColor.info);
		txtCpf.setBounds(123, 320, 182, 22);
		txtCpf.setVisible(false);
		panPrincipal.add(txtCpf);
		
		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		txtSalario.setBackground(SystemColor.info);
		txtSalario.setBounds(123, 359, 182, 22);
		txtSalario.setVisible(false);
		panPrincipal.add(txtSalario);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/LogoLudpet.png")));
		lblLogo.setBounds(10, 181, 546, 199);
		panPrincipal.add(lblLogo);
		
		lblTelefone = new JLabel("Telefone : *\r\n");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefone.setBounds(33, 402, 89, 14);
		lblTelefone.setVisible(false);
		panPrincipal.add(lblTelefone);
		
		txtTelefone = new TratamentoTextFields(9);
		txtTelefone.setBackground(SystemColor.info);
		txtTelefone.setBounds(123, 401, 128, 20);
		txtTelefone.setVisible(false);
		panPrincipal.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		rdbtnAdministrador = new JRadioButton("Administrador");
		rdbtnAdministrador.setVisible(false);
		rdbtnAdministrador.setBorder(new EmptyBorder(0, 0, 0, 0));
		rdbtnAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnAdministrador.setBackground(Color.WHITE);
		rdbtnAdministrador.setBounds(124, 436, 109, 23);
		panPrincipal.add(rdbtnAdministrador);
		
		rdbtnAtendente = new JRadioButton("Atendente");
		rdbtnAtendente.setVisible(false);
		rdbtnAtendente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnAtendente.setBorder(new EmptyBorder(0, 0, 0, 0));
		rdbtnAtendente.setBackground(Color.WHITE);
		rdbtnAtendente.setBounds(243, 436, 109, 23);
		panPrincipal.add(rdbtnAtendente);
		
		rdbtnBanhistaTosador = new JRadioButton("Banhista/Tosador");
		rdbtnBanhistaTosador.setVisible(false);
		rdbtnBanhistaTosador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBanhistaTosador.setBorder(new EmptyBorder(0, 0, 0, 0));
		rdbtnBanhistaTosador.setBackground(Color.WHITE);
		rdbtnBanhistaTosador.setBounds(362, 436, 128, 23);
		panPrincipal.add(rdbtnBanhistaTosador);
		
		bg = new ButtonGroup();
		bg.add(rdbtnBanhistaTosador);
		bg.add(rdbtnAtendente);
		bg.add(rdbtnAdministrador);
		
		btnPesquisarNome = new JButton("");
		btnPesquisarNome.setVisible(false);
		btnPesquisarNome.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/MiniLupa.png")));
		btnPesquisarNome.setBounds(315, 287, 40, 23);
		panPrincipal.add(btnPesquisarNome);
		
		lblDadoObrigatorio = new JLabel("* Dados obrigat\u00F3rios");
		lblDadoObrigatorio.setVisible(false);
		lblDadoObrigatorio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDadoObrigatorio.setBounds(410, 470, 128, 14);
		panPrincipal.add(lblDadoObrigatorio);
		
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
			
		modelo = montarTabela();
	}
	
	private void montarTela(int controle) {
		if(controle == 1){
			lblNome.setVisible(true);
			lblCargo.setVisible(true);
			lblCpf.setVisible(true);
			lblSalario.setVisible(true);
			lblTelefone.setVisible(true);
			lblDadoObrigatorio.setVisible(true);
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
			lblDadoObrigatorio.setVisible(true);
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
	
	private DefaultTableModel montarTabela() {
		String[] coluna = new String[3];
		coluna[0] = "Nome";
		coluna[1] = "CPF";
		coluna[2] = "Cargo";
		
		modelo = new CtrlTabela(new Object[][] {}, coluna);
		
		table.setModel(modelo);
		table.addMouseListener(this);
		table.getTableHeader().setReorderingAllowed(false); //deixar as colunas para nao serem movidas de seu lugar original
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.setVisible(false);
		scrollPane.setViewportView(table);
		return modelo;
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
			btnGravar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/trash.png")));
			btnGravar.setEnabled(true);			
		}else if(btnAlterar.equals(acao)){
			montarTela(2);
			btnGravar.setText("Salvar");
			btnGravar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/MiniSalvar.png")));
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
			modelo.setNumRows(0);
			buscarDadosDaTabela();
			limpaCampos();
		}

	}
	
	
	private void buscarDadosDaTabela() {
		ctrlFunc = new CtrlFuncionario();
		lista = new ArrayList<Funcionario>();	
		
		lista = ctrlFunc.pesquisarFuncionario( txtNome.getText() );
		if(lista.isEmpty()){
			JOptionPane.showMessageDialog(null, "Nenhum registro encontrado",
					"Aviso", JOptionPane.INFORMATION_MESSAGE);
		}else{
			for (Funcionario f : lista) {
				Object[] linha = new Object[3];
				linha[0] = f.getNome();
				linha[1] = f.getCpf();
				if( f.getIdTipo() == 1 ){
					linha[2] = "Administrador";
				}else if( f.getIdTipo() == 2 ){
					linha[2] = "Atendente";
				}else{
					linha[2] = "Tosador/Banhista";
				}
				
				modelo.addRow(linha);
			} 
		}
	}

	private void limpaCampos() {
		bg.clearSelection();
		txtCpf.setText("");
		txtNome.setText("");
		txtSalario.setText("");
		txtTelefone.setText("");
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object[] valores = new Object[3];
		int linha = table.getSelectedRow();
		int coluna = table.getSelectedColumn();
		valores[0] = table.getValueAt(linha, coluna);

		for (Funcionario f : lista) {
			if(((String) valores[0]).equals(f.getNome())){
				txtNome.setText( f.getNome() );
				txtCpf.setText( f.getCpf() ); 
				txtTelefone.setText( Integer.toString(f.getTelefone()) );
				txtSalario.setText( Double.toString(f.getSalario()) );
				if( f.getIdTipo() == 1 ){
					rdbtnAdministrador.setSelected(true);
				}else if( f.getIdTipo() == 2 ){
					rdbtnAtendente.setSelected(true);
				}else{
					rdbtnBanhistaTosador.setSelected(true);
				}

			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	
	public static void main(String[] args) {
		new FrmFuncionario("Funcionario");
	}
}
