package boundary;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import control.ConfigTelas;
import control.CtrlFornecedor;
import control.CtrlTabela;
import control.CtrlTableFornecedor;
import control.TratamentoTextFields;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import entity.Fornecedor;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class FrmFornecedor extends MouseAdapter implements ConfigTelas{
	
	private JFrame janela; 
	private JPanel panPrincipal;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JLabel lblIncluir;
	private JPanel panel;
	private JLabel lblAlterar;
	private JLabel lblExcluir;
	private JLabel lblPesquisar;
	private JLabel lblTelefone;
	private JLabel lblNome;
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnPesquisar;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnGravar;
	private JButton btnLimpar;
	private JButton btnVoltar;
	private JLabel lblLogo;
	private CtrlFornecedor control;
	private CtrlTableFornecedor controlTable;
	private JButton btnLupaPesquisar;
	private DefaultTableModel modelo;
	private int id;
	private List<Fornecedor> lista;
	
	public FrmFornecedor() {
		janela = new JFrame("Fornecedor");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setLayout(null);
		
		btnLupaPesquisar = new JButton("");
		btnLupaPesquisar.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniLupa.png")));
		btnLupaPesquisar.setBounds(447, 291, 65, 31);
		btnLupaPesquisar.setVisible(false);
		panPrincipal.add(btnLupaPesquisar);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
				"A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(62, 11, 426, 79);
		panPrincipal.add(panel);
		
		btnIncluir = new JButton("");
		btnIncluir.setBounds(49, 11, 69, 41);
		btnIncluir.setVisible(true);
		panel.add(btnIncluir);
		
		lblIncluir = new JLabel("(F2) Incluir");
		btnIncluir.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/Insert.png")));
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
		
		lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPesquisar.setVisible(true);
		lblPesquisar.setBounds(336, 53, 59, 19);
		panel.add(lblPesquisar);
		
		btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/View.png")));
		btnPesquisar.setVisible(true);
		btnPesquisar.setBounds(326, 11, 69, 41);
		panel.add(btnPesquisar);
		
		txtNome = new TratamentoTextFields();
		txtNome.setBounds(126, 302, 296, 20);
		txtNome.setVisible(false);
		panPrincipal.add(txtNome);
		txtNome.setColumns(10);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(51, 305, 65, 14);
		lblNome.setVisible(false);
		panPrincipal.add(lblNome);
		
		txtTelefone = new TratamentoTextFields(9);
		txtTelefone.setBounds(126, 348, 109, 20);
		txtTelefone.setVisible(false);
		panPrincipal.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(51, 351, 58, 14);
		lblTelefone.setVisible(false);
		panPrincipal.add(lblTelefone);
		
		btnGravar = new JButton("Gravar");
		btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniSalvar.png")));
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravar.setVisible(false);
		btnGravar.setBounds(434, 416, 96, 31);
		panPrincipal.add(btnGravar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniClear.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(240, 416, 96, 31);
		btnLimpar.setVisible(false);
		panPrincipal.add(btnLimpar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniBack.png")));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(46, 416, 96, 31);
		btnVoltar.setVisible(false);
		panPrincipal.add(btnVoltar);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(FrmFuncionario.class.getResource
				("/img/LogoLudpet.png")));
		lblLogo.setBounds(13, 135, 546, 199);
		panPrincipal.add(lblLogo);
		
		table = new JTable();
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 549, 159);
		scrollPane.setVisible(false);
		panPrincipal.add(scrollPane);
		
		modelo = montarTabela();
		
		janela.setSize(581,511);
		janela.setContentPane( panPrincipal);
		ConfigTelas.centralizarFrame(janela);
		
		btnLupaPesquisar.addActionListener(e -> {
			modelo.setNumRows(0); //apagar Jtable para uma nova consulta
			buscarDadosTabelaPorNome(modelo);
			limpaCampos();
		});
		
		btnLimpar.addActionListener(l -> limpaCampos() );
		
		btnAlterar.addActionListener(e -> {
			btnGravar.setEnabled(true);
			btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
					("/img/MiniSalvar.png")));
			btnGravar.setText("Alterar");
			btnGravar.setActionCommand("Alterar");
			telaAlterarExcluirPesquisarFornecedor();
			
		});
		
		btnIncluir.addActionListener( e -> {
			modelo.setNumRows(0); //apagar Jtable para uma nova consulta
			btnGravar.setEnabled(true);
			btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
					("/img/MiniSalvar.png")));
			btnGravar.setText("Gravar");
			btnGravar.setActionCommand("Incluir");
			telaInserirFornecedor();
		});
		
		btnExcluir.addActionListener(e -> {
			btnGravar.setEnabled(true);
			btnGravar.setText("Excluir");
			btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
					("/img/trash.png")));
			btnGravar.setActionCommand("Excluir");
			telaAlterarExcluirPesquisarFornecedor();
		});
		
		btnPesquisar.addActionListener(e -> {
			btnLupaPesquisar.setVisible(true);
			btnGravar.setEnabled(false);
			telaAlterarExcluirPesquisarFornecedor();
		});
		
		btnGravar.addActionListener(e -> {
			if (!validaCampos()) {
				String cmd = e.getActionCommand();
				acaoGravar(cmd);
			}else{
				JOptionPane.showMessageDialog(null, "Digite nome e telefone para gravar",
						"Aviso", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
	}
	
	private boolean validaCampos() {
		return txtNome.getText().isEmpty() || txtTelefone.getText().isEmpty();
	}
	
	private void acaoGravar(String cmd) {
		Fornecedor f = new Fornecedor();
		control = new CtrlFornecedor();
		if("Alterar".equalsIgnoreCase(cmd)){
			f.setId(id);
			f.setNome(txtNome.getText());
			f.setTelefone(Integer.parseInt(txtTelefone.getText()));
			control.atualiza(f);
			modelo.setNumRows(0); //apagar Jtable para uma nova consulta
			//buscarDadosTabelaPorNome(modelo);
		}else if("Incluir".equalsIgnoreCase(cmd)){
			f.setIdTipo(4);
			f.setNome(txtNome.getText());
			f.setTelefone(Integer.parseInt(txtTelefone.getText()));
			control.inserir(f);
		}else if("Excluir".equalsIgnoreCase(cmd)){
			f.setId(id);
			f.setNome(txtNome.getText());
			f.setTelefone(Integer.parseInt(txtTelefone.getText()));
			control.excluir(f);
			modelo.setNumRows(0); //apagar Jtable para uma nova consulta
			//buscarDadosTabelaPorNome(modelo);
		}
		limpaCampos();
	}

	private void telaAlterarExcluirPesquisarFornecedor() {
		btnLupaPesquisar.setVisible(true);
		txtNome.setVisible(true);
		txtTelefone.setVisible(true);
		lblNome.setVisible(true);
		lblTelefone.setVisible(true);
		btnGravar.setVisible(true);
		btnLimpar.setVisible(true);
		btnVoltar.setVisible(true);
		lblLogo.setVisible(false);
		scrollPane.setVisible(true);
		table.setVisible(true);
		
	}

	private void limpaCampos() {
		txtNome.setText("");
		txtTelefone.setText("");
	}

	private void telaInserirFornecedor(){
		btnLupaPesquisar.setVisible(false);
		txtNome.setVisible(true);
		txtTelefone.setVisible(true);
		lblNome.setVisible(true);
		lblTelefone.setVisible(true);
		btnGravar.setVisible(true);
		btnLimpar.setVisible(true);
		btnVoltar.setVisible(true);
		lblLogo.setVisible(false);
		scrollPane.setVisible(true);
		table.setVisible(true);
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
			txtNome.setText( String.valueOf(valores[0]));
			txtTelefone.setText(String.valueOf(valores[1])); 

	}
	
	public static void main(String[] args) {
		new FrmFornecedor();
	}
	
	public DefaultTableModel montarTabela () {
			String[] colunas = new String[2];
			colunas[0] = "Nome";
			colunas[1] = "Telefone";

			modelo = new CtrlTabela(new Object[][] {}, colunas);

			table.setModel(modelo);
			table.addMouseListener(this);
			table.getTableHeader().setReorderingAllowed(false); //deixar as colunas para nao serem movidas de seu lugar original
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(0).setPreferredWidth(250);
			table.getColumnModel().getColumn(1).setPreferredWidth(60);
			table.setVisible(false);
			scrollPane.setViewportView(table);
			return modelo;
	}
	
	public void buscarDadosTabelaPorNome(DefaultTableModel modelo) {
		controlTable = new CtrlFornecedor(); //instanciado comoa tribulto
		lista = new ArrayList<Fornecedor>();
		
			if (!txtNome.getText().equals("")) {
				try {
					lista = controlTable.buscaFornecedorPorNome(txtNome.getText());
					if (!lista.isEmpty()) {
						for (Fornecedor f : lista) {
							Object[] linha = new Object[2];
							linha[0] = f.getNome();
							linha[1] = f.getTelefone();
							modelo.addRow(linha);
						} 
					}else{
						JOptionPane.showMessageDialog(null, "Nenhum registro encontrado",
								"Aviso", JOptionPane.INFORMATION_MESSAGE);
					}
					
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}else{
				JOptionPane.showMessageDialog(null, "Digite um nome para pesquisar",
						"Aviso", JOptionPane.INFORMATION_MESSAGE);
			}
		}
}
