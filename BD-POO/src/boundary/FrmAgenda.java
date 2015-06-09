package boundary;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.ConfigTelas;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;

public class FrmAgenda {
	
	private JFrame janela; 
	private JPanel panPrincipal;
	private JTable tableAgenda;
	private JTable tableCliente;
	private JTextField txtData;
	private JTextField txtCliente;
	private JButton btnPesquisar_1;
	
	public FrmAgenda() {
		janela = new JFrame("Agenda");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setLayout(null);
		
		janela.setSize(807,573);
		janela.setContentPane( panPrincipal);
		
		JScrollPane scrollPaneAgenda = new JScrollPane();
		scrollPaneAgenda.setBounds(10, 80, 351, 450);
		panPrincipal.add(scrollPaneAgenda);
		
		tableAgenda = new JTable();
		scrollPaneAgenda.setViewportView(tableAgenda);
		
		JScrollPane scrollPaneCliente = new JScrollPane();
		scrollPaneCliente.setBounds(384, 115, 397, 166);
		panPrincipal.add(scrollPaneCliente);
		
		tableCliente = new JTable();
		scrollPaneCliente.setViewportView(tableCliente);
		
		txtData = new JTextField();
		txtData.setBounds(10, 11, 86, 20);
		panPrincipal.add(txtData);
		txtData.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(106, 10, 89, 23);
		panPrincipal.add(btnPesquisar);
		
		JLabel lblAgenda = new JLabel("Agenda");
		lblAgenda.setFont(new Font("Arial", Font.BOLD, 16));
		lblAgenda.setBounds(150, 54, 78, 20);
		panPrincipal.add(lblAgenda);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(389, 308, 392, 61);
		panPrincipal.add(panel);
		panel.setLayout(null);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(35, 30, 252, 20);
		panel.add(txtCliente);
		txtCliente.setColumns(10);
		
		btnPesquisar_1 = new JButton("Pesquisar");
		btnPesquisar_1.setBounds(297, 29, 89, 23);
		panel.add(btnPesquisar_1);
		
		JComboBox comboBoxAnimal = new JComboBox();
		comboBoxAnimal.setBounds(581, 430, 179, 20);
		panPrincipal.add(comboBoxAnimal);
		
		JComboBox comboBoxServico = new JComboBox();
		comboBoxServico.setBounds(384, 430, 125, 20);
		panPrincipal.add(comboBoxServico);
		
		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setBounds(641, 405, 46, 14);
		panPrincipal.add(lblAnimal);
		
		JLabel lblServico = new JLabel("Servi\u00E7o");
		lblServico.setBounds(389, 405, 46, 14);
		panPrincipal.add(lblServico);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(692, 501, 89, 23);
		panPrincipal.add(btnSalvar);
		
		JLabel lblCliente = new JLabel("Cliente/Animal");
		lblCliente.setFont(new Font("Arial", Font.BOLD, 16));
		lblCliente.setBounds(556, 81, 136, 23);
		panPrincipal.add(lblCliente);
		ConfigTelas.centralizarFrame(janela);
		
	}
	
	public static void main(String[] args) {
		new FrmAgenda();
	}
}
