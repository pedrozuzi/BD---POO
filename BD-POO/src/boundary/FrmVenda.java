package boundary;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.ConfigTelas;
import control.ConfiguracoesTela;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class FrmVenda {
	
	private JFrame janela; 
	private JPanel panPrincipal;
	private JTextField txtNVenda;
	private JTable tableVenda;
	private JScrollPane scrollVenda;
	private JPanel panVenda;
	private JLabel lblData;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	public FrmVenda() {
		janela = new JFrame("Venda");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setLayout(null);
		
		// CONFIGURACOES DE TELA, PODER SER NECESSARIO COMENTAR PARA EDITAR NO WINDONBUILDER
		ConfiguracoesTela configTela = new ConfiguracoesTela(janela);
		configTela.iconeBarra(janela);
		
		janela.setSize(849,768);
		janela.setContentPane( panPrincipal);
		
		JPanel panAcoes = new JPanel();
		panAcoes.setBounds(218, 25, 431, 74);
		panPrincipal.add(panAcoes);
		panAcoes.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(FrmVenda.class.getResource("/img/Insert.png")));
		btnNewButton.setBounds(10, 11, 89, 23);
		panAcoes.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(FrmVenda.class.getResource("/img/Edit.png")));
		btnNewButton_1.setBounds(109, 11, 89, 23);
		panAcoes.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(FrmVenda.class.getResource("/img/Delete.png")));
		btnNewButton_2.setBounds(208, 11, 89, 23);
		panAcoes.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(FrmVenda.class.getResource("/img/View.png")));
		btnNewButton_3.setBounds(307, 11, 89, 23);
		panAcoes.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("<html>Nova<br>Venda</html>");
		lblNewLabel.setBounds(31, 34, 46, 29);
		panAcoes.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Altera<br>Venda</html>");
		lblNewLabel_1.setBounds(130, 34, 46, 29);
		panAcoes.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html>Exclui<br>Venda</html>");
		lblNewLabel_2.setBounds(229, 34, 46, 29);
		panAcoes.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("<html>Consulta<br>Venda</html>");
		lblNewLabel_3.setBounds(328, 34, 46, 29);
		panAcoes.add(lblNewLabel_3);
		
		panVenda = new JPanel();
		panVenda.setBorder(new TitledBorder(null, "Venda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panVenda.setBounds(30, 121, 419, 53);
		panPrincipal.add(panVenda);
		panVenda.setLayout(null);
		
		JLabel lblNVenda = new JLabel("N\u00B0 Venda:");
		lblNVenda.setBounds(110, 17, 64, 14);
		panVenda.add(lblNVenda);
		
		txtNVenda = new JTextField();
		txtNVenda.setBounds(166, 14, 64, 20);
		panVenda.add(txtNVenda);
		txtNVenda.setEnabled(false);
		txtNVenda.setColumns(10);
		
		lblData = new JLabel("Data:");
		lblData.setBounds(10, 14, 46, 14);
		panVenda.add(lblData);
		
		textField = new JTextField();
		textField.setText("  /  /");
		textField.setBounds(54, 14, 46, 20);
		panVenda.add(textField);
		textField.setColumns(10);
		
		JLabel lblVendedor = new JLabel("Vendedor");
		lblVendedor.setBounds(248, 17, 46, 14);
		panVenda.add(lblVendedor);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(304, 17, 46, 14);
		panVenda.add(lblNewLabel_4);
		
		JPanel panCliente = new JPanel();
		panCliente.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panCliente.setBounds(459, 121, 321, 53);
		panPrincipal.add(panCliente);
		panCliente.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("cod:");
		lblNewLabel_5.setBounds(10, 11, 46, 14);
		panCliente.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(36, 11, 46, 14);
		panCliente.add(lblNewLabel_6);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(92, 11, 46, 14);
		panCliente.add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setBounds(144, 8, 117, 20);
		panCliente.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(278, 7, 33, 23);
		panCliente.add(btnNewButton_4);
		
		JPanel panTable = new JPanel();
		panTable.setBorder(new TitledBorder(null, "Lista de Produtos/Servi\u00E7os", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panTable.setBounds(30, 193, 488, 416);
		panPrincipal.add(panTable);
		panTable.setLayout(null);
		
		scrollVenda = new JScrollPane();
		scrollVenda.setBounds(10, 58, 468, 267);
		panTable.add(scrollVenda);
		
		tableVenda = new JTable();
		scrollVenda.setViewportView(tableVenda);
		
		JLabel lblProdutoServico = new JLabel("Produto/Servi\u00E7o:");
		lblProdutoServico.setBounds(20, 32, 157, 14);
		panTable.add(lblProdutoServico);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(133, 32, 46, 14);
		panTable.add(lblNewLabel_7);
		
		JLabel lblTotal = new JLabel("TOTAL R$:");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTotal.setBounds(288, 358, 96, 30);
		panTable.add(lblTotal);
		
		JLabel lblNewLabel_13 = new JLabel("0,00");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_13.setBounds(405, 358, 73, 30);
		panTable.add(lblNewLabel_13);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Adicionar Produto/Servi\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(540, 193, 240, 276);
		panPrincipal.add(panel);
		panel.setLayout(null);
		
		JLabel lblProduto = new JLabel("Cod:");
		lblProduto.setBounds(39, 81, 46, 14);
		panel.add(lblProduto);
		
		JRadioButton rdbServico = new JRadioButton("Servi\u00E7o");
		rdbServico.setBounds(133, 38, 72, 23);
		panel.add(rdbServico);
		
		JRadioButton rdbProduto = new JRadioButton("Produto");
		rdbProduto.setBounds(39, 38, 72, 23);
		panel.add(rdbProduto);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbProduto);
		bg.add(rdbServico);
		
		textField_2 = new JTextField();
		textField_2.setBounds(68, 78, 33, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(40, 124, 46, 14);
		panel.add(lblNome_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(96, 121, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Quantidade:");
		lblNewLabel_8.setBounds(14, 149, 72, 14);
		panel.add(lblNewLabel_8);
		
		textField_4 = new JTextField();
		textField_4.setBounds(96, 146, 86, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(149, 77, 33, 23);
		panel.add(btnNewButton_5);
		
		JLabel lblNewLabel_9 = new JLabel("Pre\u00E7o Unit\u00E1rio:");
		lblNewLabel_9.setBounds(14, 187, 114, 14);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Pre\u00E7o Total:");
		lblNewLabel_10.setBounds(14, 208, 114, 14);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setBounds(157, 187, 46, 14);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setBounds(157, 208, 46, 14);
		panel.add(lblNewLabel_12);
		
		JButton btnNewButton_6 = new JButton("Adicionar");
		btnNewButton_6.setBounds(14, 233, 89, 23);
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Remover");
		btnNewButton_7.setBounds(124, 233, 89, 23);
		panel.add(btnNewButton_7);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Consulta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(540, 469, 240, 53);
		panPrincipal.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_8 = new JButton("Pre\u00E7o R$");
		btnNewButton_8.setBounds(10, 22, 89, 23);
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Estoque");
		btnNewButton_9.setBounds(122, 22, 89, 23);
		panel_1.add(btnNewButton_9);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(30, 620, 750, 60);
		panPrincipal.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_10 = new JButton("Finalizar");
		btnNewButton_10.setBounds(631, 11, 89, 23);
		panel_2.add(btnNewButton_10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(532, 11, 89, 23);
		panel_2.add(btnCancelar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FrmVenda.class.getResource("/img/teste.png")));
		label.setBounds(0, 0, 763, 14);
		panPrincipal.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FrmVenda.class.getResource("/img/teste2.png")));
		label_1.setBounds(787, 692, 46, 14);
		panPrincipal.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(FrmVenda.class.getResource("/img/teste.png")));
		label_2.setBounds(70, 715, 763, 14);
		panPrincipal.add(label_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Dinheiro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(540, 526, 240, 85);
		panPrincipal.add(panel_3);
		panel_3.setLayout(null);
		
		textField_5 = new JTextField();
		textField_5.setBounds(65, 22, 86, 20);
		panel_3.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblRecebido = new JLabel("Recebido");
		lblRecebido.setBounds(9, 25, 46, 14);
		panel_3.add(lblRecebido);
		
		JLabel lblTroco = new JLabel("TROCO:");
		lblTroco.setBounds(9, 60, 46, 14);
		panel_3.add(lblTroco);
		
		JLabel label_3 = new JLabel("0,0");
		label_3.setBounds(78, 60, 46, 14);
		panel_3.add(label_3);
		
		JButton btnNewButton_11 = new JButton(">");
		btnNewButton_11.setBounds(161, 21, 41, 23);
		panel_3.add(btnNewButton_11);
		ConfigTelas.centralizarFrame(janela);
	}
	
	public static void main(String[] args) {
		new FrmVenda();
	}
}
