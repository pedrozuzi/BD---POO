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
	private JPanel panLote;
	private JPanel panProduto;
	private JLabel lblNome;
	private JLabel lblNewLabel_1;
	private JLabel lblId_1;
	private JLabel lblDataDeValidade;

	public FrmProduto(){
		
		JPanel panPrincipal = new JPanel();
		JPanel panForm = new JPanel();
		
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		
		JPanel panProduto = new JPanel();
		panProduto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Produto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panProduto.setBounds(38, 25, 529, 136);
		panPrincipal.add(panProduto);
		panProduto.setLayout(null);
		panProduto.setOpaque(false);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(49, 24, 15, 14);
		panProduto.add(lblId);
		
		textField_3 = new JTextField();
		textField_3.setBounds(96, 53, 86, 20);
		panProduto.add(textField_3);
		textField_3.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(96, 21, 96, 20);
		panProduto.add(textField);
		textField.setColumns(10);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(34, 53, 55, 20);
		panProduto.add(lblNome);
		
		lblNewLabel_1 = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel_1.setBounds(34, 84, 55, 20);
		panProduto.add(lblNewLabel_1);
		
		panLote = new JPanel();
		panLote.setBorder(new TitledBorder(null, "Lote", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panLote.setBounds(38, 181, 529, 100);
		panPrincipal.add(panLote);
		panLote.setLayout(null);
		panLote.setOpaque(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(108, 21, 86, 20);
		panLote.add(textField_1);
		textField_1.setColumns(10);
		
		lblId_1 = new JLabel("Id:");
		lblId_1.setBounds(65, 21, 33, 20);
		panLote.add(lblId_1);
		
		lblDataDeValidade = new JLabel("Data de Validade:");
		lblDataDeValidade.setBounds(10, 52, 101, 20);
		panLote.add(lblDataDeValidade);
		
		textField_2 = new JTextField();
		textField_2.setBounds(104, 50, 106, 25);
		panLote.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/BackGround.png")));
		lblNewLabel.setBounds(0, 0, 610, 450);
		panPrincipal.add(lblNewLabel);
		janela.setSize(626,489);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {

		new FrmProduto();
	}
}
