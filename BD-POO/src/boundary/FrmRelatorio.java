package boundary;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.ConfigTelas;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FrmRelatorio {
	
	private JFrame janela; 
	private JPanel panPrincipal;
	private JComboBox<String> comboBox;
	private JLabel lblGerarRelatrio;
	private JTable table;
	
	public FrmRelatorio() {
		janela = new JFrame("Relatório");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setLayout(null);
		
		janela.setSize(687,348);
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
		scrollPane.setBounds(10, 130, 651, 158);
		panPrincipal.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		ConfigTelas.centralizarFrame(janela);
	}
	
	public static void main(String[] args) {
		new FrmRelatorio();
	}
}
