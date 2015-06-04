package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class FrmAgenda extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAgenda frame = new FrmAgenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmAgenda() {
		setTitle("Agenda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setSelected(true);
		radioButton_1.setBounds(139, 33, 39, 21);
		contentPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("");
		radioButton_2.setBounds(139, 55, 39, 21);
		contentPane.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("");
		radioButton_3.setBounds(139, 74, 39, 21);
		contentPane.add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("");
		radioButton_4.setBounds(139, 93, 39, 21);
		contentPane.add(radioButton_4);
		
		JRadioButton radioButton_5 = new JRadioButton("");
		radioButton_5.setBounds(139, 113, 39, 21);
		contentPane.add(radioButton_5);
		
		JRadioButton radioButton_6 = new JRadioButton("");
		radioButton_6.setBounds(139, 132, 39, 21);
		contentPane.add(radioButton_6);
		
		JRadioButton radioButton_7 = new JRadioButton("");
		radioButton_7.setBounds(139, 155, 39, 21);
		contentPane.add(radioButton_7);
		
		JRadioButton radioButton_8 = new JRadioButton("");
		radioButton_8.setBounds(139, 172, 39, 21);
		contentPane.add(radioButton_8);
		
		JRadioButton radioButton_9 = new JRadioButton("");
		radioButton_9.setBounds(139, 198, 39, 21);
		contentPane.add(radioButton_9);
		
		JRadioButton radioButton_10 = new JRadioButton("");
		radioButton_10.setBounds(139, 215, 39, 21);
		contentPane.add(radioButton_10);
		
		JRadioButton radioButton_11 = new JRadioButton("");
		radioButton_11.setBounds(139, 232, 39, 21);
		contentPane.add(radioButton_11);
		
		JRadioButton radioButton_12 = new JRadioButton("");
		radioButton_12.setBounds(139, 255, 39, 21);
		contentPane.add(radioButton_12);
		
		JRadioButton radioButton_13 = new JRadioButton("");
		radioButton_13.setBounds(139, 272, 39, 21);
		contentPane.add(radioButton_13);
		
		JRadioButton radioButton_14 = new JRadioButton("");
		radioButton_14.setBounds(139, 293, 39, 21);
		contentPane.add(radioButton_14);
		
		JRadioButton radioButton_15 = new JRadioButton("");
		radioButton_15.setBounds(139, 312, 39, 21);
		contentPane.add(radioButton_15);
		
		JRadioButton radioButton_16 = new JRadioButton("");
		radioButton_16.setBounds(139, 334, 39, 21);
		contentPane.add(radioButton_16);
		
		JRadioButton radioButton_17 = new JRadioButton("");
		radioButton_17.setBounds(139, 355, 39, 21);
		contentPane.add(radioButton_17);
		
		JRadioButton radioButton_18 = new JRadioButton("");
		radioButton_18.setBounds(139, 379, 39, 21);
		contentPane.add(radioButton_18);
		
		JRadioButton radioButton_19 = new JRadioButton("");
		radioButton_19.setBounds(139, 379, 39, 21);
		contentPane.add(radioButton_19);
		
		JRadioButton radioButton_20 = new JRadioButton("");
		radioButton_20.setBounds(212, 33, 39, 21);
		contentPane.add(radioButton_20);
		
		JRadioButton radioButton_21 = new JRadioButton("");
		radioButton_21.setBounds(212, 55, 39, 21);
		contentPane.add(radioButton_21);
		
		JRadioButton radioButton_22 = new JRadioButton("");
		radioButton_22.setBounds(212, 74, 39, 21);
		contentPane.add(radioButton_22);
		
		JRadioButton radioButton_23 = new JRadioButton("");
		radioButton_23.setBounds(212, 93, 39, 21);
		contentPane.add(radioButton_23);
		
		JRadioButton radioButton_24 = new JRadioButton("");
		radioButton_24.setBounds(212, 113, 39, 21);
		contentPane.add(radioButton_24);
		
		JRadioButton radioButton_25 = new JRadioButton("");
		radioButton_25.setBounds(212, 132, 39, 21);
		contentPane.add(radioButton_25);
		
		JRadioButton radioButton_26 = new JRadioButton("");
		radioButton_26.setBounds(212, 155, 39, 21);
		contentPane.add(radioButton_26);
		
		JRadioButton radioButton_27 = new JRadioButton("");
		radioButton_27.setBounds(212, 172, 39, 21);
		contentPane.add(radioButton_27);
		
		JRadioButton radioButton_28 = new JRadioButton("");
		radioButton_28.setBounds(212, 187, 39, 21);
		contentPane.add(radioButton_28);
		
		JRadioButton radioButton_29 = new JRadioButton("");
		radioButton_29.setBounds(212, 215, 39, 21);
		contentPane.add(radioButton_29);
		
		JRadioButton radioButton_30 = new JRadioButton("");
		radioButton_30.setBounds(212, 232, 39, 21);
		contentPane.add(radioButton_30);
		
		JRadioButton radioButton_31 = new JRadioButton("");
		radioButton_31.setBounds(212, 255, 39, 21);
		contentPane.add(radioButton_31);
		
		JRadioButton radioButton_32 = new JRadioButton("");
		radioButton_32.setBounds(212, 272, 39, 21);
		contentPane.add(radioButton_32);
		
		JRadioButton radioButton_33 = new JRadioButton("");
		radioButton_33.setBounds(212, 293, 39, 21);
		contentPane.add(radioButton_33);
		
		JRadioButton radioButton_34 = new JRadioButton("");
		radioButton_34.setBounds(212, 312, 39, 21);
		contentPane.add(radioButton_34);
		
		JRadioButton radioButton_35 = new JRadioButton("");
		radioButton_35.setBounds(212, 334, 39, 21);
		contentPane.add(radioButton_35);
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBounds(212, 355, 39, 21);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_36 = new JRadioButton("");
		radioButton_36.setBounds(212, 379, 39, 21);
		contentPane.add(radioButton_36);
		
		JRadioButton radioButton_37 = new JRadioButton("");
		radioButton_37.setBounds(212, 415, 39, 21);
		contentPane.add(radioButton_37);
		
		JRadioButton radioButton_38 = new JRadioButton("");
		radioButton_38.setBounds(139, 415, 39, 21);
		contentPane.add(radioButton_38);
		
		JRadioButton radioButton_39 = new JRadioButton("");
		radioButton_39.setBounds(139, 391, 39, 21);
		contentPane.add(radioButton_39);
		
		JRadioButton radioButton_40 = new JRadioButton("");
		radioButton_40.setBounds(212, 391, 39, 21);
		contentPane.add(radioButton_40);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FrmAgenda.class.getResource("/img/hrs.png")));
		label.setBounds(45, 11, 220, 425);
		contentPane.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Banho", "Tosa"}));
		comboBox.setBounds(348, 335, 91, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Hury", "Pedro"}));
		comboBox_1.setBounds(460, 334, 84, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblServio = new JLabel("Servi\u00E7o");
		lblServio.setBounds(348, 312, 46, 14);
		contentPane.add(lblServio);
		
		JLabel lblFuncionario = new JLabel("Funcionario");
		lblFuncionario.setBounds(460, 312, 84, 14);
		contentPane.add(lblFuncionario);
		
		textField = new JTextField();
		textField.setText("04/06/2015");
		textField.setBounds(301, 34, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(301, 11, 46, 14);
		contentPane.add(lblData);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(FrmAgenda.class.getResource("/img/MiniLupa.png")));
		button.setBounds(397, 33, 33, 23);
		contentPane.add(button);
		
		JTextArea txtrClienteNomeAnimal = new JTextArea();
		txtrClienteNomeAnimal.setText("CLIENTE\r\nNOME                     ANIMAL             HRS\r\nJo\u00E3o                     Rex - Cachorro      8:30");
		txtrClienteNomeAnimal.setBounds(301, 92, 403, 144);
		contentPane.add(txtrClienteNomeAnimal);
		
		textField_1 = new JTextField();
		textField_1.setBounds(344, 256, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(288, 262, 46, 14);
		contentPane.add(lblNome);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(FrmAgenda.class.getResource("/img/MiniLupa.png")));
		button_1.setBounds(440, 255, 33, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(FrmAgenda.class.getResource("/img/MiniSalvar.png")));
		button_2.setBounds(569, 334, 89, 23);
		contentPane.add(button_2);
	}
}
