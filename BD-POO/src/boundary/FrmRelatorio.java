package boundary;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.ConfigTelas;
import control.ConfiguracoesTela;

import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class FrmRelatorio {
	
	private JFrame janela; 
	private JPanel panPrincipal;
	private JComboBox<String> comboBox;
	private JLabel lblGerarRelatrio;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	
	public FrmRelatorio() {
		janela = new JFrame("Relatório");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setLayout(null);
		
		// CONFIGURACOES DE TELA, PODER SER NECESSARIO COMENTAR PARA EDITAR NO WINDONBUILDER
		ConfiguracoesTela configTela = new ConfiguracoesTela(janela);
		configTela.iconeBarra(janela);
		
		janela.setSize(687,435);
		janela.setContentPane( panPrincipal);
		
		lblGerarRelatrio = new JLabel("Gerar Relat\u00F3rio de: ");
		lblGerarRelatrio.setBounds(43, 44, 117, 14);
		panPrincipal.add(lblGerarRelatrio);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(162, 41, 125, 20);
		comboBox.addItem("Venda");
		comboBox.addItem("Compra");
		comboBox.addItem("Compra e Venda");
		panPrincipal.add(comboBox);
		
		JButton btnGerar = new JButton("Gerar");
		btnGerar.setBounds(308, 36, 69, 31);
		panPrincipal.add(btnGerar);
		
		JLabel lblRelatrioDealguma = new JLabel("Relat\u00F3rio de \"Alguma coisa\"");
		lblRelatrioDealguma.setFont(new Font("Arial", Font.BOLD, 16));
		lblRelatrioDealguma.setBounds(220, 91, 230, 20);
		panPrincipal.add(lblRelatrioDealguma);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 228, 651, 158);
		panPrincipal.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio: ");
		lblUsurio.setBounds(35, 148, 60, 14);
		panPrincipal.add(lblUsurio);
		
		JLabel lblGeradoEm = new JLabel("Gerado em: ");
		lblGeradoEm.setBounds(459, 148, 81, 14);
		panPrincipal.add(lblGeradoEm);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(95, 142, 226, 20);
		panPrincipal.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(537, 145, 95, 20);
		panPrincipal.add(textField_1);
		textField_1.setColumns(10);
		ConfigTelas.centralizarFrame(janela);
	}
	
	public static void main(String[] args) {
		new FrmRelatorio();
	}
}
