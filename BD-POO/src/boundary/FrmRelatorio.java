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

public class FrmRelatorio {
	
	private JFrame janela; 
	private JPanel panPrincipal;
	private JComboBox<String> comboBox;
	private JLabel lblGerarRelatrio;
	
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
		ConfigTelas.centralizarFrame(janela);
	}
	
	public static void main(String[] args) {
		new FrmRelatorio();
	}
}
