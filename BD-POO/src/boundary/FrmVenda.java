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

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class FrmVenda {
	
	private JFrame janela; 
	private JPanel panPrincipal;
	private JTextField txtNVenda;
	private JTextField txtData;
	private JTextField textField;
	private JLabel lblCliente;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblTotal;
	private JLabel lblSubtotal;
	private JTextField textField_6;
	private JLabel lblDesconto;
	private JTextField textField_7;
	private JLabel lblDinheiroPago;
	private JLabel lblTroco;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTable tableVenda;
	private JScrollPane scrollVenda;
	private JLabel lblFormaDePagamento;
	private JButton btnConfirmarVenda;
	private JButton btnCancelarVenda;
	
	public FrmVenda() {
		janela = new JFrame("Venda");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setLayout(null);
		
		// CONFIGURACOES DE TELA, PODER SER NECESSARIO COMENTAR PARA EDITAR NO WINDONBUILDER
		ConfiguracoesTela configTela = new ConfiguracoesTela(janela);
		configTela.iconeBarra(janela);
		
		janela.setSize(900,678);
		janela.setContentPane( panPrincipal);
		
		txtNVenda = new JTextField();
		txtNVenda.setEnabled(false);
		txtNVenda.setBounds(68, 46, 86, 20);
		panPrincipal.add(txtNVenda);
		txtNVenda.setColumns(10);
		
		JLabel lblNVenda = new JLabel("N\u00B0 Venda:");
		lblNVenda.setBounds(10, 49, 64, 14);
		panPrincipal.add(lblNVenda);
		
		JLabel lblData = new JLabel("Data: ");
		lblData.setBounds(172, 49, 46, 14);
		panPrincipal.add(lblData);
		
		txtData = new JTextField();
		txtData.setEnabled(false);
		txtData.setBounds(202, 46, 86, 20);
		panPrincipal.add(txtData);
		txtData.setColumns(10);
		
		JLabel txtHora = new JLabel("Hora:");
		txtHora.setBounds(309, 49, 46, 14);
		panPrincipal.add(txtHora);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(342, 46, 56, 20);
		panPrincipal.add(textField);
		textField.setColumns(10);
		
		lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(420, 49, 46, 14);
		panPrincipal.add(lblCliente);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(463, 46, 210, 20);
		panPrincipal.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnPesquisarCliente = new JButton("Pesquisar");
		btnPesquisarCliente.setBounds(683, 45, 100, 23);
		panPrincipal.add(btnPesquisarCliente);
		
		JLabel lblProdutoServico = new JLabel("Produto/Servi\u00E7o:");
		lblProdutoServico.setBounds(10, 103, 157, 14);
		panPrincipal.add(lblProdutoServico);
		
		textField_2 = new JTextField();
		textField_2.setBounds(111, 100, 287, 20);
		panPrincipal.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(530, 103, 77, 14);
		panPrincipal.add(lblQuantidade);
		
		textField_3 = new JTextField();
		textField_3.setBounds(605, 100, 71, 20);
		panPrincipal.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnPesquisarProdutoServico = new JButton("Pesquisar");
		btnPesquisarProdutoServico.setBounds(420, 99, 95, 23);
		panPrincipal.add(btnPesquisarProdutoServico);
		
		JLabel lblQuantidadeEmEstoque = new JLabel("Quantidade em Estoque");
		lblQuantidadeEmEstoque.setBounds(10, 138, 157, 14);
		panPrincipal.add(lblQuantidadeEmEstoque);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setBounds(20, 151, 116, 20);
		panPrincipal.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setFont(new Font("Arial", Font.PLAIN, 24));
		textField_5.setBounds(679, 551, 139, 36);
		panPrincipal.add(textField_5);
		textField_5.setColumns(10);
		
		lblTotal = new JLabel("TOTAL");
		lblTotal.setBounds(679, 537, 46, 14);
		panPrincipal.add(lblTotal);
		
		lblSubtotal = new JLabel("SubTotal:");
		lblSubtotal.setBounds(680, 415, 80, 14);
		panPrincipal.add(lblSubtotal);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setBounds(679, 427, 139, 23);
		panPrincipal.add(textField_6);
		textField_6.setColumns(10);
		
		lblDesconto = new JLabel("Desconto:");
		lblDesconto.setBounds(679, 476, 89, 14);
		panPrincipal.add(lblDesconto);
		
		textField_7 = new JTextField();
		textField_7.setBounds(679, 488, 135, 23);
		panPrincipal.add(textField_7);
		textField_7.setColumns(10);
		
		lblDinheiroPago = new JLabel("Dinheiro Pago: ");
		lblDinheiroPago.setBounds(479, 431, 95, 14);
		panPrincipal.add(lblDinheiroPago);
		
		lblTroco = new JLabel("Troco: ");
		lblTroco.setBounds(491, 456, 46, 14);
		panPrincipal.add(lblTroco);
		
		textField_8 = new JTextField();
		textField_8.setBounds(566, 428, 86, 20);
		panPrincipal.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setEnabled(false);
		textField_9.setBounds(566, 456, 86, 20);
		panPrincipal.add(textField_9);
		textField_9.setColumns(10);
		
		scrollVenda = new JScrollPane();
		scrollVenda.setBounds(30, 184, 828, 181);
		panPrincipal.add(scrollVenda);
		
		tableVenda = new JTable();
		scrollVenda.setViewportView(tableVenda);
		
		lblFormaDePagamento = new JLabel("Forma de Pagamento");
		lblFormaDePagamento.setBounds(34, 415, 133, 14);
		panPrincipal.add(lblFormaDePagamento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(34, 430, 133, 20);
		panPrincipal.add(comboBox);
		
		btnConfirmarVenda = new JButton("Confirmar Venda");
		btnConfirmarVenda.setBounds(463, 551, 144, 34);
		panPrincipal.add(btnConfirmarVenda);
		
		btnCancelarVenda = new JButton("Cancelar Venda");
		btnCancelarVenda.setBounds(233, 551, 139, 34);
		panPrincipal.add(btnCancelarVenda);
		ConfigTelas.centralizarFrame(janela);
	}
	
	public static void main(String[] args) {
		new FrmVenda();
	}
}
