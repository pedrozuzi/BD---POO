package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import control.ConfigTelas;
import control.CtrlCliente;
import control.ModeloTabela;
import control.TratamentoTextFields;
import entity.Cliente;

public class FrmCliente extends MouseAdapter {
	
	private JFrame janela; 
	private JPanel panPrincipal;
	private JPanel panel;
	private JButton btnIncluir;
	private JLabel lblIncluir;
	private JButton btnAlterar;
	private JLabel lblAlterar;
	private JLabel lblExcluir;
	private JButton btnExcluir;
	private JLabel lblLogo;
	private JTextField txtNome;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtTelefone;
	private JLabel lblTelefone;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnLupaPesquisar;
	private JButton btnGravar;
	private JButton btnLimpar;
	private JButton btnVoltar;
	private CtrlCliente control;
	private int id;
	private JLabel lblNome;
	private JLabel lblLogradouro;
	private JLabel lblNumero;
	private JLabel lblBairro;
	private List<Cliente> lista;
	private JTextField txtCpf;
	private JLabel lblCpf;
	private ModeloTabela modelo;
	
	public FrmCliente() {
		janela = new JFrame("Cliente");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setLayout(null);
		
		lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setFont(new Font("Arial", Font.BOLD, 14));
		lblLogradouro.setVisible(false);
		lblLogradouro.setBounds(90, 398, 96, 14);
		panPrincipal.add(lblLogradouro);
		
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.BOLD, 14));
		lblNome.setVisible(false);
		lblNome.setBounds(90, 325, 62, 14);
		panPrincipal.add(lblNome);
		
		txtLogradouro = new TratamentoTextFields();
		txtLogradouro.setFont(new Font("Arial", Font.PLAIN, 14));
		txtLogradouro.setVisible(false);
		txtLogradouro.setBounds(205, 396, 318, 20);
		panPrincipal.add(txtLogradouro);
		txtLogradouro.setColumns(10);
		
		txtNome = new TratamentoTextFields();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNome.setVisible(false);
		txtNome.setBounds(205, 323, 318, 20);
		panPrincipal.add(txtNome);
		txtNome.setColumns(10);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
				"A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(186, 11, 343, 79);
		panPrincipal.add(panel);
		
		btnIncluir = new JButton("");
		btnIncluir.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/Insert.png")));
		btnIncluir.setBounds(49, 11, 69, 41);
		btnIncluir.setVisible(true);
		panel.add(btnIncluir);
		
		lblIncluir = new JLabel("(F2) Incluir");
		lblIncluir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblIncluir.setVisible(true);
		lblIncluir.setBounds(54, 54, 69, 19);
		panel.add(lblIncluir);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/Edit.png")));
		btnAlterar.setBounds(143, 11, 69, 41);
		btnAlterar.setVisible(true);
		panel.add(btnAlterar);
		
		lblAlterar = new JLabel("Alterar");
		lblAlterar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAlterar.setVisible(true);
		lblAlterar.setBounds(162, 54, 44, 19);
		panel.add(lblAlterar);
		
		btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/Delete.png")));
		btnExcluir.setBounds(232, 11, 69, 41);
		btnExcluir.setVisible(true);
		panel.add(btnExcluir);
		
		lblExcluir = new JLabel("Excluir");
		lblExcluir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblExcluir.setVisible(true);
		lblExcluir.setBounds(252, 53, 38, 19);
		panel.add(lblExcluir);
		
		btnGravar = new JButton("Gravar");
		btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniSalvar.png")));
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravar.setVisible(false);
		btnGravar.setBounds(518, 539, 96, 31);
		panPrincipal.add(btnGravar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniClear.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(308, 539, 96, 31);
		btnLimpar.setVisible(false);
		panPrincipal.add(btnLimpar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniBack.png")));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(106, 539, 96, 31);
		btnVoltar.setVisible(false);
		panPrincipal.add(btnVoltar);
		
		btnLupaPesquisar = new JButton("");
		btnLupaPesquisar.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniLupa.png")));
		btnLupaPesquisar.setBounds(555, 309, 65, 31);
		btnLupaPesquisar.setVisible(false);
		panPrincipal.add(btnLupaPesquisar);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(FrmFuncionario.class.getResource
				("/img/LogoLudpet.png")));
		lblLogo.setBounds(106, 154, 546, 199);
		panPrincipal.add(lblLogo);
		
		txtNumero = new TratamentoTextFields(8);
		txtNumero.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNumero.setVisible(false);
		txtNumero.setBounds(157, 439, 86, 20);
		panPrincipal.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtBairro = new TratamentoTextFields();
		txtBairro.setFont(new Font("Arial", Font.PLAIN, 14));
		txtBairro.setVisible(false);
		txtBairro.setBounds(330, 439, 269, 20);
		panPrincipal.add(txtBairro);
		txtBairro.setColumns(10);
		
		txtTelefone = new TratamentoTextFields(9);
		txtTelefone.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTelefone.setVisible(false);
		txtTelefone.setBounds(169, 485, 133, 20);
		panPrincipal.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setFont(new Font("Arial", Font.BOLD, 14));
		lblNumero.setVisible(false);
		lblNumero.setBounds(90, 444, 62, 14);
		panPrincipal.add(lblNumero);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Arial", Font.BOLD, 14));
		lblBairro.setVisible(false);
		lblBairro.setBounds(266, 441, 72, 14);
		panPrincipal.add(lblBairro);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 14));
		lblTelefone.setVisible(false);
		lblTelefone.setBounds(90, 487, 69, 14);
		panPrincipal.add(lblTelefone);
		
		lblCpf = new JLabel("CPF: ");
		lblCpf.setVisible(false);
		lblCpf.setFont(new Font("Arial", Font.BOLD, 14));
		lblCpf.setBounds(90, 360, 46, 14);
		panPrincipal.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf = TratamentoTextFields.mascaraCpf(txtCpf);
		txtCpf.setBounds(205, 360, 121, 20);
		txtCpf.setVisible(false);
		panPrincipal.add(txtCpf);
		txtCpf.setColumns(10);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setBorder(new LineBorder(Color.BLACK));
		table.setGridColor(Color.BLACK);
		table.setShowGrid(true);
		
		scrollPane = new JScrollPane();
		scrollPane.getViewport().setBorder(null);
		scrollPane.getViewport().add(table);
		scrollPane.setBounds(10, 112, 717, 167);
		scrollPane.setVisible(false);
		panPrincipal.add(scrollPane);
		
		janela.setSize(749,677);
		janela.setContentPane( panPrincipal);
		ConfigTelas.centralizarFrame(janela);
		
		//modelo = montarTabela();
		
		btnLimpar.addActionListener(l -> limpaCampos() );
		
		btnIncluir.addActionListener(l -> {
			btnGravar.setEnabled(true);
			btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
					("/img/MiniSalvar.png")));
			btnGravar.setText("Gravar");
			btnGravar.setActionCommand("Incluir");
			telaInserirFornecedor();
		});
		
		btnAlterar.addActionListener(l -> {
			btnGravar.setEnabled(true);
			btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
					("/img/MiniSalvar.png")));
			btnGravar.setText("Alterar");
			btnGravar.setActionCommand("Alterar");
			telaAlterarExcluirFornecedor();
		});
		
		btnExcluir.addActionListener(l -> {
			btnGravar.setEnabled(true);
			btnGravar.setText("Excluir");
			btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
					("/img/trash.png")));
			btnGravar.setActionCommand("Excluir");
			telaAlterarExcluirFornecedor();
		});
		
		btnGravar.addActionListener(e -> {
			String cmd = e.getActionCommand();
			acaoGravar(cmd);
		});
		
		btnLupaPesquisar.addActionListener(l -> {
			control = new CtrlCliente();
			lista = new ArrayList<Cliente>();
			
			try {
				lista = control.buscaClientePorNome(txtNome.getText());
				if (!lista.isEmpty()) {
					modelo = new ModeloTabela(lista);
					table.getTableHeader().setReorderingAllowed(false);
					table.setModel(modelo);
				}
			} catch (Exception e1) {
			}
			
			//modelo.setNumRows(0); //apagar Jtable para uma nova consulta
			//buscarDadosTabelaPorNome(modelo);
			limpaCampos();
		});
		
		
	}
	
	private void acaoGravar(String cmd) {
		Cliente c = new Cliente();
		control = new CtrlCliente();
		
		 if("Incluir".equalsIgnoreCase(cmd)){
				c.setIdTipo(5);
				c.setNome(txtNome.getText());
				c.setCpf(txtCpf.getText().replace("-", "").replace(".", ""));
				c.setLogradouro(txtLogradouro.getText());
				c.setNumero(Integer.parseInt(txtNumero.getText()));
				c.setBairro(txtBairro.getText());
				c.setTelefone(Integer.parseInt(txtTelefone.getText()));
				control.inserir(c);
		 }else if("Alterar".equalsIgnoreCase(cmd)){
				c.setId(id);
				c.setNome(txtNome.getText());
				c.setCpf(txtCpf.getText().replace("-", "").replace(".", ""));
				c.setLogradouro(txtLogradouro.getText());
				c.setNumero(Integer.parseInt(txtNumero.getText()));
				c.setBairro(txtBairro.getText());
				c.setTelefone(Integer.parseInt(txtTelefone.getText()));
				control.atualiza(c);
				//modelo.setNumRows(0); //apagar Jtable para uma nova consulta
		 }else if("Excluir".equalsIgnoreCase(cmd)){
				c.setId(id);
				c.setNome(txtNome.getText());
				c.setCpf(txtCpf.getText().replace("-", "").replace(".", ""));
				c.setLogradouro(txtLogradouro.getText());
				c.setNumero(Integer.parseInt(txtNumero.getText()));
				c.setBairro(txtBairro.getText());
				c.setTelefone(Integer.parseInt(txtTelefone.getText()));
				control.excluir(c);
				//modelo.setNumRows(0); //apagar Jtable para uma nova consulta
		 }
		 limpaCampos();
	}

	private void telaInserirFornecedor() {
		btnLupaPesquisar.setVisible(false);
		txtCpf.setVisible(true);
		lblCpf.setVisible(true);
		txtNome.setVisible(true);
		txtLogradouro.setVisible(true);
		txtNumero.setVisible(true);
		txtBairro.setVisible(true);
		txtTelefone.setVisible(true);
		lblNome.setVisible(true);
		lblLogradouro.setVisible(true);
		lblNumero.setVisible(true);
		lblBairro.setVisible(true);
		lblTelefone.setVisible(true);
		btnGravar.setVisible(true);
		btnLimpar.setVisible(true);
		btnVoltar.setVisible(true);
		lblLogo.setVisible(false);
		scrollPane.setVisible(false);
		table.setVisible(false);
	}
	
	private void telaAlterarExcluirFornecedor() {
		lblLogo.setVisible(false);
		btnLupaPesquisar.setVisible(true);
		txtNome.setVisible(true);
		txtCpf.setVisible(true);
		lblCpf.setVisible(true);
		txtLogradouro.setVisible(true);
		txtNumero.setVisible(true);
		txtBairro.setVisible(true);
		txtTelefone.setVisible(true);
		lblNome.setVisible(true);
		lblLogradouro.setVisible(true);
		lblNumero.setVisible(true);
		lblBairro.setVisible(true);
		lblTelefone.setVisible(true);
		btnGravar.setVisible(true);
		btnLimpar.setVisible(true);
		btnVoltar.setVisible(true);
		scrollPane.setVisible(true);
		table.setVisible(true);
	}

	private void limpaCampos() {
		txtNome.setText("");
		txtCpf.setText("");
		txtLogradouro.setText("");
		txtNumero.setText("");
		txtBairro.setText("");
		txtTelefone.setText("");
	}
	
//	public DefaultTableModel montarTabela () {
//		String[] colunas = new String[5];
//		colunas[0] = "Nome";
//		colunas[1] = "Logradouro";
//		colunas[2] = "Número";
//		colunas[3] = "Bairro";
//		colunas[4] = "Telefone";
//
//		modelo = new CtrlTabela(new Object[][] {}, colunas);
//
//		table.setModel(modelo);
//		table.addMouseListener(this);
//		table.getTableHeader().setReorderingAllowed(false); //deixar as colunas para nao serem movidas de seu lugar original
//		table.getColumnModel().getColumn(0).setPreferredWidth(200);
//		table.getColumnModel().getColumn(1).setPreferredWidth(150);
//		table.getColumnModel().getColumn(2).setPreferredWidth(30);
//		table.getColumnModel().getColumn(3).setPreferredWidth(150);
//		table.getColumnModel().getColumn(4).setPreferredWidth(40);
//		table.setVisible(false);
//		scrollPane.setViewportView(table);
//		return modelo;
//}
//
//public void buscarDadosTabelaPorNome(DefaultTableModel modelo) {
//	controlTable = new CtrlCliente(); //instanciado comoa tribulto
//	lista = new ArrayList<Cliente>();
//	
//		if (!txtNome.getText().equals("")) {
//			try {
//				lista = controlTable.buscaClientePorNome(txtNome.getText());
//				if (!lista.isEmpty()) {
//					for (Cliente c : lista) {
//						Object[] linha = new Object[5];
//						linha[0] = c.getNome();
//						linha[1] = c.getLogradouro();
//						linha[2] = c.getNumero();
//						linha[3] = c.getBairro();
//						linha[4] = c.getTelefone();
//						modelo.addRow(linha);
//					} 
//				}else{
//					JOptionPane.showMessageDialog(null, "Nenhum registro encontrado",
//							"Aviso", JOptionPane.INFORMATION_MESSAGE);
//				}
//				
//			}catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}else{
//			JOptionPane.showMessageDialog(null, "Digite um nome para pesquisar",
//					"Aviso", JOptionPane.INFORMATION_MESSAGE);
//		}
//	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object[] valores = new Object[6];
		int linha = table.getSelectedRow();
		int coluna = table.getSelectedColumn();
		
		for (coluna = 0; coluna < table.getColumnCount(); coluna++) {
			valores[coluna] = table.getValueAt(linha, coluna);
		}
		
		id = lista.get(linha).getId();
		txtNome.setText( String.valueOf(valores[0]));
		System.out.println(valores[1]);
		txtCpf.setText(String.valueOf(valores[1]));
		txtLogradouro.setText(String.valueOf(valores[2])); 
		txtNumero.setText(String.valueOf(valores[3]));
		txtBairro.setText(String.valueOf(valores[4]));
		txtTelefone.setText(String.valueOf(valores[5]));
		
	}

	public static void main(String[] args) {
		new FrmCliente();
	}
}
