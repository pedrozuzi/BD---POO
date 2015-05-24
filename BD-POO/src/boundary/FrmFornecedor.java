package boundary;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.ConfigTelas;
import control.CtrlFornecedor;
import control.CtrlTabelaFornecedor;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import persistence.FornecedorDAOImpl;

public class FrmFornecedor implements ConfigTelas {
	
	private JFrame janela; 
	private JPanel panPrincipal;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JLabel lblIncluir;
	private JPanel panel;
	private JLabel lblAlterar;
	private JLabel lblExcluir;
	private JLabel lblPesquisar;
	private JLabel lblTelefone;
	private JLabel lblId;
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
	
	public FrmFornecedor() {
		janela = new JFrame("Fornecedor");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		
		btnLupaPesquisar = new JButton("");
		btnLupaPesquisar.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniLupa.png")));
		btnLupaPesquisar.setBounds(465, 319, 65, 31);
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
		
		txtId = new JTextField();
		txtId.setBounds(137, 319, 109, 20);
		txtId.setVisible(false);
		panPrincipal.add(txtId);
		txtId.setColumns(10);
		
		txtNome = new TratamentoTextFields();
		txtNome.setBounds(137, 360, 296, 20);
		txtNome.setVisible(false);
		panPrincipal.add(txtNome);
		txtNome.setColumns(10);
		
		lblId = new JLabel("C\u00F3digo:");
		lblId.setBounds(62, 322, 65, 14);
		lblId.setVisible(false);
		panPrincipal.add(lblId);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(62, 363, 65, 14);
		lblNome.setVisible(false);
		panPrincipal.add(lblNome);
		
		txtTelefone = new TratamentoTextFields(9);
		txtTelefone.setBounds(137, 406, 109, 20);
		txtTelefone.setVisible(false);
		panPrincipal.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(62, 409, 58, 14);
		lblTelefone.setVisible(false);
		panPrincipal.add(lblTelefone);
		
		btnGravar = new JButton("Gravar");
		btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniSalvar.png")));
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravar.setVisible(false);
		btnGravar.setBounds(434, 460, 96, 31);
		panPrincipal.add(btnGravar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniClear.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(240, 460, 96, 31);
		btnLimpar.setVisible(false);
		panPrincipal.add(btnLimpar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniBack.png")));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(46, 460, 96, 31);
		btnVoltar.setVisible(false);
		panPrincipal.add(btnVoltar);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(FrmFunc.class.getResource
				("/img/LogoLudpet.png")));
		lblLogo.setBounds(10, 181, 546, 199);
		panPrincipal.add(lblLogo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 549, 159);
		scrollPane.setVisible(false);
		panPrincipal.add(scrollPane);
		
		String[] cabecalho = new String[3];
		cabecalho[0] = "Código";
		cabecalho[1] = "Nome";
		cabecalho[2] = "Telefone";
		
		DefaultTableModel modelo = new CtrlTabelaFornecedor(new Object[][]{}, cabecalho);
		
		table = new JTable();
		table.setModel(modelo);
		
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(268);
		table.getColumnModel().getColumn(2).setPreferredWidth(143);
		table.setVisible(false);
		scrollPane.setViewportView(table);
		
		controlTable = new CtrlFornecedor();
		List<Fornecedor> lista = new ArrayList<Fornecedor>();
		
		try {
			lista = controlTable.listaFornecedores();
			for ( Fornecedor f : lista) {
				Object[] linha = new Object[3];
				linha[0] = f.getId();
				linha[1] = f.getNome();
				linha[2] = f.getTelefone();
				modelo.addRow(linha);
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(),
					"ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		janela.setSize(585,553);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		centralizarFrame(janela);
		
		btnLimpar.addActionListener(l -> limpaCampos() );
		
		btnAlterar.addActionListener(e -> {
			btnGravar.setEnabled(true);
			btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
					("/img/MiniSalvar.png")));
			btnGravar.setText("Alterar");
			btnGravar.setActionCommand("Alterar");
			telaAlterarExcluirFornecedor();
			
		});
		
		btnIncluir.addActionListener( e -> {
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
			btnExcluir.setActionCommand("Excluir");
			telaAlterarExcluirFornecedor();
		});
		
		btnPesquisar.addActionListener(e -> {
			btnGravar.setEnabled(false);
		});
		
		btnGravar.addActionListener(e -> {
			String cmd = e.getActionCommand();
			acaoGravar(cmd);
		});
		
	}
	
	private void acaoGravar(String cmd) {
		if("Alterar".equalsIgnoreCase(cmd)){
			System.out.println("Alterando;;;");
		}else if("Incluir".equalsIgnoreCase(cmd)){
			Fornecedor f = new Fornecedor();
			f.setNome(txtNome.getText());
			f.setTelefone(Integer.parseInt(txtTelefone.getText()));
			control = new CtrlFornecedor();
			control.inserir(f);
			limpaCampos();
		}else if("Excluir".equalsIgnoreCase(cmd)){
			
		}
		
	}

	private void telaAlterarExcluirFornecedor() {
		btnLupaPesquisar.setVisible(true);
		txtId.setVisible(true);
		txtId.setEnabled(true);
		txtNome.setVisible(true);
		txtTelefone.setVisible(true);
		lblId.setVisible(true);
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
		txtId.setText("");
		txtTelefone.setText("");
		
	}

	private void telaInserirFornecedor(){
		btnLupaPesquisar.setVisible(false);
		txtId.setVisible(false);
		txtId.setEnabled(false);
		lblId.setVisible(false);
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
	
	public static void main(String[] args) {
		new FrmFornecedor();
	}
}
