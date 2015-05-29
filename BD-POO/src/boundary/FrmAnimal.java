package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import control.ConfigTelas;
import control.CtrlTabela;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FrmAnimal extends MouseAdapter {
	
	private JFrame janelaAnimal;
	private JPanel panPrincipal;
	private JPanel panel;
	private JButton btnIncluir;
	private JLabel lblIncluir;
	private JButton btnAlterar;
	private JLabel lblAlterar;
	private JButton btnExcluir;
	private JLabel lblExcluir;
	private JButton btnGravar;
	private JButton btnLimpar;
	private JButton btnVoltar;
	private JButton btnLupaPesquisar;
	private JTextField txtNome;
	private JTextField txtRga;
	private JTextField txtRaca;
	private JTextField txtCor;
	private JTable table;
	private JLabel lblCliente;
	private JTextField textField_1;
	private JLabel lblEspecie;
	private JComboBox<String> comboBoxEspecie;
	private JScrollPane scrollPane;
	private JLabel lblRaca;
	private JLabel lblCor;
	private JLabel lblSexo;
	private JLabel lblRga;
	private JComboBox<String> comboBoxSexo;
	private DefaultTableModel modelo;
	
	public FrmAnimal(int idAnimal) {
		janelaAnimal = new JFrame();
		janelaAnimal.setTitle("Cliente");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
				"A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(112, 11, 343, 79);
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
		btnGravar.setBounds(406, 543, 96, 31);
		panPrincipal.add(btnGravar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniClear.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(247, 543, 96, 31);
		btnLimpar.setVisible(false);
		panPrincipal.add(btnLimpar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniBack.png")));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(83, 543, 96, 31);
		btnVoltar.setVisible(false);
		panPrincipal.add(btnVoltar);
		
		btnLupaPesquisar = new JButton("");
		btnLupaPesquisar.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniLupa.png")));
		btnLupaPesquisar.setBounds(422, 288, 65, 31);
		panPrincipal.add(btnLupaPesquisar);
		
		txtNome = new JTextField();
		txtNome.setBounds(155, 341, 238, 20);
		panPrincipal.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(81, 344, 46, 14);
		panPrincipal.add(lblNome);
		
		txtRga = new JTextField();
		txtRga.setBounds(155, 382, 128, 20);
		panPrincipal.add(txtRga);
		txtRga.setColumns(10);
		
		lblRga = new JLabel("RGA:");
		lblRga.setBounds(81, 382, 46, 14);
		panPrincipal.add(lblRga);
		
		txtRaca = new JTextField();
		txtRaca.setBounds(155, 420, 138, 20);
		panPrincipal.add(txtRaca);
		txtRaca.setColumns(10);
		
		lblRaca = new JLabel("Ra\u00E7a:");
		lblRaca.setBounds(81, 423, 46, 14);
		panPrincipal.add(lblRaca);
		
		lblCor = new JLabel("Cor:");
		lblCor.setBounds(313, 423, 46, 14);
		panPrincipal.add(lblCor);
		
		txtCor = new JTextField();
		txtCor.setBounds(356, 420, 86, 20);
		panPrincipal.add(txtCor);
		txtCor.setColumns(10);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(81, 457, 46, 14);
		panPrincipal.add(lblSexo);
		
		lblEspecie = new JLabel("Esp\u00E9cie:");
		lblEspecie.setBounds(205, 454, 68, 14);
		panPrincipal.add(lblEspecie);
		
		comboBoxEspecie = new JComboBox<String>();
		comboBoxEspecie.setBounds(272, 451, 138, 20);
		comboBoxEspecie.addItem(Especie.CACHORRO.getESPECIE());
		comboBoxEspecie.addItem(Especie.GATO.getESPECIE());	
		panPrincipal.add(comboBoxEspecie);
			
		comboBoxSexo = new JComboBox<String>();
		comboBoxSexo.setBounds(127, 454, 38, 20);
		comboBoxSexo.addItem(SexoAnimal.MACHO.getSEXO());
		comboBoxSexo.addItem(SexoAnimal.FEMEA.getSEXO());
		panPrincipal.add(comboBoxSexo);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 138, 601, 124);
		panPrincipal.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblCliente = new JLabel("Cliente: ");
		lblCliente.setBounds(83, 299, 52, 20);
		panPrincipal.add(lblCliente);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(155, 299, 238, 20);
		panPrincipal.add(textField_1);
		textField_1.setColumns(10);
		
		janelaAnimal.setSize(627,656);
		janelaAnimal.setContentPane( panPrincipal );
		ConfigTelas.centralizarFrame( janelaAnimal );
		
		modelo = montarTabela();
		
		btnLupaPesquisar.addActionListener(l -> {
			new FrmAnimal(new JDialog(janelaAnimal, true));
		});
	}
	
	public FrmAnimal(JDialog jd) {
		
		jd.setSize(500,500);
		jd.setLocationRelativeTo(null);
		jd.setVisible(true);
		
		
	
	}
	
	public DefaultTableModel montarTabela () {
		String[] colunas = new String[4];
		colunas[0] = "Nome";
		colunas[1] = "Raça";
		colunas[2] = "Sexo";
		colunas[3] = "Espécie";
		
		modelo = new CtrlTabela(new Object[][] {}, colunas);

		table.setModel(modelo);
		table.addMouseListener(this);
		table.getTableHeader().setReorderingAllowed(false); //deixar as colunas para nao serem movidas de seu lugar original
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		return modelo;
}

	public static void main(String[] args) {
		int idAnimal = 0;
		new FrmAnimal(idAnimal);
	}
}
