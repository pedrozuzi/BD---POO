package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import control.ConfigTelas;
import javax.swing.JTextField;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FrmAnimal {
	
	private JFrame janela; 
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
	private JTextField textField;
	private JTable table;
	
	public FrmAnimal() {
		janela = new JFrame("Cliente");
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
		btnGravar.setBounds(407, 501, 96, 31);
		panPrincipal.add(btnGravar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniClear.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(248, 501, 96, 31);
		btnLimpar.setVisible(false);
		panPrincipal.add(btnLimpar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniBack.png")));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(84, 501, 96, 31);
		btnVoltar.setVisible(false);
		panPrincipal.add(btnVoltar);
		
		btnLupaPesquisar = new JButton("");
		btnLupaPesquisar.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniLupa.png")));
		btnLupaPesquisar.setBounds(422, 288, 65, 31);
		btnLupaPesquisar.setVisible(false);
		panPrincipal.add(btnLupaPesquisar);
		
		janela.setSize(627,602);
		janela.setContentPane( panPrincipal );
		
		txtNome = new JTextField();
		txtNome.setBounds(156, 299, 238, 20);
		panPrincipal.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(82, 302, 46, 14);
		panPrincipal.add(lblNome);
		
		txtRga = new JTextField();
		txtRga.setBounds(156, 340, 128, 20);
		panPrincipal.add(txtRga);
		txtRga.setColumns(10);
		
		JLabel lblRga = new JLabel("RGA:");
		lblRga.setBounds(82, 340, 46, 14);
		panPrincipal.add(lblRga);
		
		txtRaca = new JTextField();
		txtRaca.setBounds(156, 378, 138, 20);
		panPrincipal.add(txtRaca);
		txtRaca.setColumns(10);
		
		JLabel lblRaca = new JLabel("Ra\u00E7a:");
		lblRaca.setBounds(82, 381, 46, 14);
		panPrincipal.add(lblRaca);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setBounds(314, 381, 46, 14);
		panPrincipal.add(lblCor);
		
		txtCor = new JTextField();
		txtCor.setBounds(357, 378, 86, 20);
		panPrincipal.add(txtCor);
		txtCor.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(82, 415, 46, 14);
		panPrincipal.add(lblSexo);
		
		textField = new JTextField();
		textField.setBounds(156, 412, 24, 20);
		panPrincipal.add(textField);
		textField.setColumns(10);
		
		JLabel lblEspecie = new JLabel("Esp\u00E9cie:");
		lblEspecie.setBounds(206, 412, 68, 14);
		panPrincipal.add(lblEspecie);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(273, 409, 138, 20);
		panPrincipal.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 138, 601, 124);
		panPrincipal.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		ConfigTelas.centralizarFrame( janela );
	}
	
	public static void main(String[] args) {
		new FrmAnimal();
	}
}
