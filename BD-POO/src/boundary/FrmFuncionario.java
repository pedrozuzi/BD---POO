package boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import control.CtrlFuncionario;
import entity.Funcionario;
import entity.Usuario;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import util.ConfiguracoesTela;
import util.ModeloTabela;
import util.TratamentoTextFields;

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
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblSalario;
	private JLabel lblCargo;
	private JButton btnVoltar;
	private JButton btnLimpar;
	private JButton btnGravar;
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
	private ModeloTabela modelo;
	private List<Funcionario> lista = new ArrayList<Funcionario>();
	private JPanel panelInformacao;
	private int id;
	private JMenuBar menuBarra;
	private JMenu menu;
	private JMenuItem menuPrincipal;
	private JMenuItem logOff;
	private JLabel lblTiraVermelha2;
	private JLabel lblTiraCinza2;
	private JLabel label;
	private JLabel lblTiraVermelha;
	private JLabel lblTiraCinza3;
	private JLabel lblTiraCinza;
	private ConfiguracoesTela configTela;
	
	public FrmFuncionario(Usuario u) {
	
		janela = new JFrame("Funcionário");
		
		panPrincipal = new JPanel();
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setLayout(null);
		
		menuBarra = new JMenuBar();
		janela.setJMenuBar(menuBarra);
		
		menu = new JMenu("Menu");
		menuBarra.add(menu);
		
		menuPrincipal = new JMenuItem("Menu Principal");
		menuPrincipal.setIcon(new ImageIcon(getClass()
				.getResource("/img/HomeMenu.png")));
		menu.add(menuPrincipal);
		
		menuPrincipal.addActionListener(e -> {
			janela.dispose();
			new FrmPrincipal(u);
		}); 
		
		logOff = new JMenuItem("Log Off");
		logOff.setIcon(new ImageIcon(getClass()
				.getResource("/img/LogOffMenu.png")));
		menu.add(logOff);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setForeground(Color.WHITE);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(123, 28, 328, 79);
		panPrincipal.add(panel);
		
		btnIncluir = new JButton("");
		btnIncluir.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/Insert.png")));
		btnIncluir.setBounds(49, 11, 69, 41);
		panel.add(btnIncluir);
		
		lblIncluir = new JLabel("Incluir");
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
		
		lblTiraVermelha2 = new JLabel("");
		lblTiraVermelha2.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/TiraVermelha.png")));
		lblTiraVermelha2.setBounds(-11, 380, 599, 14);
		panPrincipal.add(lblTiraVermelha2);
		
		lblTiraCinza3 = new JLabel("");
		lblTiraCinza3.setBounds(0, 17, 119, 14);
		lblTiraCinza3.setIcon(new ImageIcon(this.getClass().getResource("/img/TiraCinza.png")));
		panPrincipal.add(lblTiraCinza3);
		
		lblTiraVermelha = new JLabel("");
		lblTiraVermelha.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/TiraVermelha.png")));
		lblTiraVermelha.setBounds(0, 0, 576, 14);
		panPrincipal.add(lblTiraVermelha);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(this.getClass().getResource("/img/TiraCinza.png")));
		label.setBounds(354, 365, 234, 14);
		panPrincipal.add(label);
		
		lblTiraCinza2 = new JLabel("");
		lblTiraCinza2.setIcon(new ImageIcon(this.getClass().getResource("/img/TiraCinza.png")));
		lblTiraCinza2.setBounds(0, 365, 209, 14);
		panPrincipal.add(lblTiraCinza2);
		
		lblTiraCinza = new JLabel("");
		lblTiraCinza.setBounds(450, 17, 128, 14);
		panPrincipal.add(lblTiraCinza);
		lblTiraCinza.setIcon(new ImageIcon(this.getClass().getResource("/img/TiraCinza.png")));
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(this.getClass().getResource("/img/logo.png")));
		lblLogo.setBounds(155, 155, 269, 255);
		panPrincipal.add(lblLogo);
		
		ctrlFunc = new CtrlFuncionario();
		
		table = new JTable();
		table.addMouseListener(this);
		table.setBorder(new LineBorder(Color.BLACK));
		table.setGridColor(Color.BLACK);
		table.setShowGrid(true);
		
		scrollPane = new JScrollPane();
		scrollPane.getViewport().setBorder(null);
		scrollPane.setViewportView(table);
		scrollPane.setBounds(10, 118, 556, 153);
		scrollPane.setVisible(false);
		panPrincipal.add(scrollPane);
		
		lblNome = new JLabel("Nome : *");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(33, 300, 68, 14);
		lblNome.setVisible(false);
		panPrincipal.add(lblNome);
		
		lblCpf = new JLabel("CPF : *");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(33, 340, 60, 14);
		lblCpf.setVisible(false);
		panPrincipal.add(lblCpf);
		
		lblSalario = new JLabel("Sal\u00E1rio : *");
		lblSalario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalario.setBounds(33, 380, 68, 17);
		lblSalario.setVisible(false);
		panPrincipal.add(lblSalario);
		
		lblCargo = new JLabel("Cargo : *");
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCargo.setBounds(33, 466, 68, 17);
		lblCargo.setVisible(false);
		panPrincipal.add(lblCargo);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/MiniBack.png")));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(33, 523, 96, 31);
		btnVoltar.setVisible(false);
		panPrincipal.add(btnVoltar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/MiniClear.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(243, 523, 96, 31);
		btnLimpar.setVisible(false);
		panPrincipal.add(btnLimpar);
		
		btnGravar = new JButton("Gravar");
		btnGravar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/MiniSalvar.png")));
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravar.setBounds(429, 523, 103, 31);
		btnGravar.setVisible(false);
		panPrincipal.add(btnGravar);
			
		txtNome = new TratamentoTextFields();
		txtNome.setColumns(10);
		txtNome.setBackground(SystemColor.info);
		txtNome.setBounds(123, 298, 182, 22);
		txtNome.setVisible(false);
		panPrincipal.add(txtNome);
		
		txtCpf = new JTextField();
		txtCpf = TratamentoTextFields.mascara(txtCpf, "cpf");
		txtCpf.setColumns(10);
		txtCpf.setBackground(SystemColor.info);
		txtCpf.setBounds(123, 338, 182, 22);
		txtCpf.setVisible(false);
		panPrincipal.add(txtCpf);
		
		txtSalario = new TratamentoTextFields(txtSalario, 8);
		txtSalario.setColumns(10);
		txtSalario.setBackground(SystemColor.info);
		txtSalario.setBounds(123, 379, 182, 22);
		txtSalario.setVisible(false);
		panPrincipal.add(txtSalario);
		
		lblTelefone = new JLabel("Telefone : *\r\n");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefone.setBounds(33, 422, 89, 14);
		lblTelefone.setVisible(false);
		panPrincipal.add(lblTelefone);
		
		txtTelefone = new TratamentoTextFields(9);
		txtTelefone.setBackground(SystemColor.info);
		txtTelefone.setBounds(123, 421, 128, 20);
		txtTelefone.setVisible(false);
		panPrincipal.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		rdbtnAdministrador = new JRadioButton("Administrador");
		rdbtnAdministrador.setVisible(false);
		rdbtnAdministrador.setBorder(new EmptyBorder(0, 0, 0, 0));
		rdbtnAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnAdministrador.setBackground(Color.WHITE);
		rdbtnAdministrador.setBounds(124, 464, 109, 23);
		panPrincipal.add(rdbtnAdministrador);
		
		rdbtnAtendente = new JRadioButton("Atendente");
		rdbtnAtendente.setVisible(false);
		rdbtnAtendente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnAtendente.setBorder(new EmptyBorder(0, 0, 0, 0));
		rdbtnAtendente.setBackground(Color.WHITE);
		rdbtnAtendente.setBounds(242, 464, 109, 23);
		panPrincipal.add(rdbtnAtendente);
		
		rdbtnBanhistaTosador = new JRadioButton("Banhista/Tosador");
		rdbtnBanhistaTosador.setVisible(false);
		rdbtnBanhistaTosador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBanhistaTosador.setBorder(new EmptyBorder(0, 0, 0, 0));
		rdbtnBanhistaTosador.setBackground(Color.WHITE);
		rdbtnBanhistaTosador.setBounds(354, 464, 128, 23);
		panPrincipal.add(rdbtnBanhistaTosador);
		
		bg = new ButtonGroup();
		bg.add(rdbtnBanhistaTosador);
		bg.add(rdbtnAtendente);
		bg.add(rdbtnAdministrador);
		
		btnPesquisarNome = new JButton("");
		btnPesquisarNome.setVisible(false);
		btnPesquisarNome.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/MiniLupa.png")));
		btnPesquisarNome.setBounds(312, 297, 40, 23);
		panPrincipal.add(btnPesquisarNome);
		
		lblDadoObrigatorio = new JLabel("* Dados obrigat\u00F3rios");
		lblDadoObrigatorio.setVisible(false);
		lblDadoObrigatorio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDadoObrigatorio.setBounds(404, 498, 128, 14);
		panPrincipal.add(lblDadoObrigatorio);
		
		panelInformacao = new JPanel();
		panelInformacao.setBounds(0, 565, 576, 21);
		panPrincipal.add(panelInformacao);
		
		janela.setContentPane( panPrincipal);
		
		configTela = new ConfiguracoesTela();
		janela.setSize(582,625);
		configTela.iconeBarra(janela);
		configTela.tamanho(janela);

		btnLimpar.addActionListener(this);
		btnVoltar.addActionListener( e -> {
			janela.dispose();
			janela = null;
			new FrmCadastros(u);
		});
		btnGravar.addActionListener(this);
		btnIncluir.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnRemover.addActionListener(this);
		
		btnPesquisarNome.addActionListener(e -> {
			pesquisar();
		});
		
		logOff.addActionListener(e -> {
			janela.dispose();
			new FrmLogin();
		});
			
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
			table.setVisible(false);
			scrollPane.setVisible(false);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object acao = e.getSource();
		String cmd = e.getActionCommand();
		lblLogo.setVisible(false);
		lblTiraCinza2.setVisible(false);
		label.setVisible(false);
		lblTiraVermelha2.setVisible(false);
		Funcionario f = new Funcionario();
			
		if(btnIncluir.equals(acao)){
			limpaCampos();
			montarTela(1);
			btnGravar.setText("Gravar");
			btnGravar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/MiniSalvar.png")));
			btnGravar.setEnabled(true);
			btnGravar.setActionCommand("Incluir");
		}else if(btnRemover.equals(acao)){
			limpaCampos();
			montarTela(2);
			btnGravar.setActionCommand("Remover");
			btnGravar.setText("Excluir");
			btnGravar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/trash.png")));
			btnGravar.setEnabled(true);
		}else if(btnAlterar.equals(acao)){
			limpaCampos();
			montarTela(2);
			btnGravar.setText("Salvar");
			btnGravar.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/img/MiniSalvar.png")));
			btnGravar.setEnabled(true);
			btnGravar.setActionCommand("Alterar");
			habilitarCampos();
		}
		
		if("Incluir".equalsIgnoreCase(cmd)){
			if( !validaCampos() ){
				f.setNome( txtNome.getText() );
				f.setCpf( txtCpf.getText().replace("-", "").replace(".", ""));
				f.setSalario( Double.parseDouble(txtSalario.getText().replace(",", ".")) );
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
			}else{
				JOptionPane.showMessageDialog(null, "Sem dados para processar",
						"Erro", JOptionPane.QUESTION_MESSAGE);
			}
		}else if("Remover".equalsIgnoreCase(cmd)){
			if(txtNome.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Sem dados para processar",
						"Erro", JOptionPane.QUESTION_MESSAGE);
			}else{
				f.setId( id );
				ctrlFunc.remover(f);
				limpaCampos();
			}
		}else if("Alterar".equalsIgnoreCase(cmd)){
			if(validaCampos()){
				JOptionPane.showMessageDialog(null, "Sem dados para processar",
						"Erro", JOptionPane.QUESTION_MESSAGE);
			}else{
				f.setId(id);
				f.setNome( txtNome.getText() );
				f.setCpf( txtCpf.getText().replace("-", "").replace(".", "") );
				f.setSalario( Double.parseDouble(txtSalario.getText()) );
				f.setTelefone( Integer.parseInt(txtTelefone.getText()) );
				if(rdbtnAdministrador.isSelected()){
					f.setIdTipo(1);
					ctrlFunc.alterar(f);
				}else if(rdbtnAtendente.isSelected()){
					f.setIdTipo(2);
					ctrlFunc.alterar(f);
				}else if(rdbtnBanhistaTosador.isSelected()){
					f.setIdTipo(3);
					ctrlFunc.alterar(f);
				}
				limpaCampos();
			}
		}
		
		if(btnLimpar.equals(acao)){
			limpaCampos();
		}

	}
	
	private void pesquisar() {
		try{
			lista = ctrlFunc.pesquisarFuncionario(txtNome.getText());
			if (!lista.isEmpty()) {
				modelo = new ModeloTabela(lista);
				table.getTableHeader().setReorderingAllowed(false);
				table.setModel(modelo);
			}else{
				JOptionPane.showMessageDialog(null, "Nenhum registro encontrado",
						"Aviso", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (NullPointerException e1) {
			System.out.println("NullPointer");
		}
		
	}

	private boolean validaCampos() {
		return txtNome.getText().isEmpty() || txtCpf.getText().isEmpty() || 
				txtSalario.getText().isEmpty() || txtTelefone.getText().isEmpty();
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
		Object[] valores = new Object[2];
		int linha = table.getSelectedRow();
		int coluna = table.getSelectedColumn();
		
		for (coluna = 0; coluna < table.getColumnCount(); coluna++) {
			valores[coluna] = table.getValueAt(linha, coluna);
		}
//		valores[coluna] = table.getValueAt(linha, coluna); NAO FUNCIONA SOMENTE COM ESTA LINHA POIS NAO PEGARA O 
//															VALOR DAS DUAS COLUNAS.
		
		id = lista.get(linha).getId();
		for (Funcionario f : lista) {
			if(valores[0].equals(f.getNome())){
//				txtNome.setText(String.valueOf(valores[0]));
//				txtCpf.setText(String.valueOf(valores[1]));
				txtNome.setText(f.getNome());
				txtCpf.setText(f.getCpf());
				txtTelefone.setText( Integer.toString(f.getTelefone()) );
				txtSalario.setText( Double.toString(f.getSalario()) );
				if( f.getIdTipo() == 1 ){
					rdbtnAdministrador.setSelected(true);
					rdbtnBanhistaTosador.setSelected(false);
					rdbtnAtendente.setSelected(false);
				}else if( f.getIdTipo() == 2 ){
					rdbtnAdministrador.setSelected(false);
					rdbtnBanhistaTosador.setSelected(false);
					rdbtnAtendente.setSelected(true);
				}else{
					rdbtnAdministrador.setSelected(false);
					rdbtnBanhistaTosador.setSelected(true);
					rdbtnAtendente.setSelected(false);
				}
			}
			
		}
	}

	private void habilitarCampos() {
		txtCpf.setEnabled(true);
		txtSalario.setEnabled(true);
		txtTelefone.setEnabled(true);
		rdbtnBanhistaTosador.setEnabled(true);
		rdbtnAtendente.setEnabled(true);
		rdbtnAdministrador.setEnabled(true);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
//	public static void main(String[] args) {
//		new FrmFuncionario();
//	}
}
