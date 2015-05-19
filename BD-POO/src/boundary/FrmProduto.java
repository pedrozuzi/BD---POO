package boundary;





import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class FrmProduto {

	private JFrame janela = new JFrame("Produto");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPanel panel_1;
	private JLabel lblNome;

	public FrmProduto(){
		
		JPanel panPrincipal = new JPanel();
		JPanel panForm = new JPanel();
		
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(344, 292, 106, 25);
		panPrincipal.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/BackGround.png")));
		lblNewLabel.setBounds(0, 292, 112, 31);
		panPrincipal.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Produto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(38, 25, 529, 136);
		panPrincipal.add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(49, 24, 15, 14);
		panel.add(lblId);
		
		textField_3 = new JTextField();
		textField_3.setBounds(96, 53, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(96, 21, 96, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(34, 53, 55, 20);
		panel.add(lblNome);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Lote", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(38, 181, 251, 100);
		panPrincipal.add(panel_1);
		panel_1.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(82, 21, 86, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		janela.setSize(626,489);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {

		new FrmProduto();
	}
}
