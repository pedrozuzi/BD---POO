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
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class FrmFunc {

	JFrame janela;
	JPanel panPrincipal;
	private JTable table;
	private final JTextField textField = new JTextField();
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public FrmFunc() {
	
		janela = new JFrame();
		panPrincipal = new JPanel();
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setBackground(SystemColor.text);
		
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setForeground(Color.WHITE);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(64, 11, 426, 79);
		panPrincipal.add(panel);
		
		JButton btnIncluir = new JButton("");
		btnIncluir.setIcon(new ImageIcon(FrmFunc.class.getResource("/img/Insert.png")));
		btnIncluir.setBounds(49, 11, 69, 41);
		panel.add(btnIncluir);
		
		JLabel lblfincluir = new JLabel("(F2)Incluir");
		lblfincluir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblfincluir.setBounds(59, 54, 59, 19);
		panel.add(lblfincluir);
		
		JButton btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(FrmFunc.class.getResource("/img/Edit.png")));
		btnAlterar.setBounds(143, 11, 69, 41);
		panel.add(btnAlterar);
		
		JLabel label_1 = new JLabel("Alterar");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label_1.setBounds(162, 54, 44, 19);
		panel.add(label_1);
		
		JButton btnRemover = new JButton("");
		btnRemover.setIcon(new ImageIcon(FrmFunc.class.getResource("/img/Delete.png")));
		btnRemover.setBounds(232, 11, 69, 41);
		panel.add(btnRemover);
		
		JLabel label_2 = new JLabel("Excluir");
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label_2.setBounds(252, 53, 38, 19);
		panel.add(label_2);
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setIcon(new ImageIcon(FrmFunc.class.getResource("/img/View.png")));
		btnPesquisar.setBounds(326, 11, 69, 41);
		panel.add(btnPesquisar);
		
		JLabel label_3 = new JLabel("Pesquisar");
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label_3.setBounds(336, 53, 59, 19);
		panel.add(label_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 546, 152);
		panPrincipal.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JLabel lblNome = new JLabel("Nome : ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(33, 313, 68, 14);
		panPrincipal.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF : ");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(33, 348, 46, 14);
		panPrincipal.add(lblCpf);
		
		JLabel lblSalario = new JLabel("Salario : ");
		lblSalario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalario.setBounds(33, 381, 60, 17);
		panPrincipal.add(lblSalario);
		
		JLabel lblCargo = new JLabel("Cargo : ");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargo.setBounds(33, 421, 60, 17);
		panPrincipal.add(lblCargo);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigo.setBounds(33, 280, 60, 22);
		panPrincipal.add(lblCodigo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(FrmFunc.class.getResource("/img/MiniBack.png")));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(33, 496, 96, 31);
		panPrincipal.add(btnVoltar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(FrmFunc.class.getResource("/img/MiniClear.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(240, 496, 96, 31);
		panPrincipal.add(btnLimpar);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.setIcon(new ImageIcon(FrmFunc.class.getResource("/img/MiniSalvar.png")));
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravar.setBounds(432, 496, 96, 31);
		panPrincipal.add(btnGravar);
		textField.setBackground(SystemColor.info);
		textField.setBounds(103, 280, 96, 22);
		panPrincipal.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.info);
		textField_1.setBounds(103, 313, 182, 22);
		panPrincipal.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.info);
		textField_2.setBounds(103, 348, 182, 22);
		panPrincipal.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBackground(SystemColor.info);
		textField_3.setBounds(103, 381, 182, 22);
		panPrincipal.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBackground(SystemColor.info);
		textField_4.setBounds(103, 416, 182, 22);
		panPrincipal.add(textField_4);
		
		JLabel lblLogoLudPet = new JLabel("");
		lblLogoLudPet.setIcon(new ImageIcon(FrmFunc.class.getResource("/img/LogoLudpet.png")));
		lblLogoLudPet.setBounds(10, 181, 546, 199);
		panPrincipal.add(lblLogoLudPet);
		janela.setSize(582,600);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	public static void main(String[] args) {
		new FrmFunc();
	}
}
