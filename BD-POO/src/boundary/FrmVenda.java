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
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class FrmVenda {

	private JFrame janela;
	private JPanel panPrincipal;
	private JTextField txtNumVenda;
	private JTable tableVenda;
	private JScrollPane scrollVenda;
	private JPanel panVenda;
	private JLabel lblData;
	private JTextField txtDataVenda;
	private JTextField txtNomeCli;
	private JTextField txtCodProdServ;
	private JTextField txtNomeProdServ;
	private JTextField txtQtdeProdServ;
	private JTextField txtDinheiroRecebido;
	private JLabel lblCodCli;
	private JLabel lblNewLabel_4;
	private JButton btnPesquisaCli;
	private JRadioButton rdbProduto;
	private JRadioButton rdbServico;
	private JButton btnPesquisaProdServ;
	private JLabel lblPrecoUPS;
	private JLabel lblPrecoTPS;
	private JButton btnAdicionarPS;
	private JButton btnRemovePS;
	private JPanel panConsulta;
	private JButton btnConsultaEstoque;
	private JButton btnCancelar;
	private JButton btnAcao;

	public FrmVenda() {
		janela = new JFrame("Venda");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setLayout(null);

		// CONFIGURACOES DE TELA, PODER SER NECESSARIO COMENTAR PARA EDITAR NO
		// WINDONBUILDER
		ConfiguracoesTela configTela = new ConfiguracoesTela(janela);
		configTela.iconeBarra(janela);
		configTela.selecionaEstilo(3);
		configTela.estilo(janela);

		janela.setSize(849, 768);
		janela.setContentPane(panPrincipal);

		JPanel panAcoes = new JPanel();
		panAcoes.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panAcoes.setBounds(217, 20, 431, 90);
		panPrincipal.add(panAcoes);
		panAcoes.setLayout(null);
		panAcoes.setOpaque(false);

		JPanel panCliente = new JPanel();
		panCliente.setBorder(new TitledBorder(null, "Cliente",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panCliente.setBounds(459, 121, 321, 53);
		panPrincipal.add(panCliente);
		panCliente.setLayout(null);
		panCliente.setOpaque(false);

		panVenda = new JPanel();
		panVenda.setBorder(new TitledBorder(null, "Venda",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panVenda.setBounds(30, 121, 419, 53);
		panPrincipal.add(panVenda);
		panVenda.setLayout(null);
		panVenda.setOpaque(false);

		JPanel panTable = new JPanel();
		panTable.setBorder(new TitledBorder(null,
				"Lista de Produtos/Servi\u00E7os", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panTable.setBounds(30, 193, 488, 416);
		panPrincipal.add(panTable);
		panTable.setLayout(null);
		panTable.setOpaque(false);

		JPanel panProdServ = new JPanel();
		panProdServ.setBorder(new TitledBorder(null,
				"Adicionar Produto/Servi\u00E7o", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panProdServ.setBounds(540, 193, 240, 276);
		panPrincipal.add(panProdServ);
		panProdServ.setLayout(null);
		panProdServ.setOpaque(false);

		panConsulta = new JPanel();// TODO
		panConsulta.setBorder(new TitledBorder(null, "Consulta",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panConsulta.setBounds(540, 469, 240, 53);
		panPrincipal.add(panConsulta);
		panConsulta.setLayout(null);
		panConsulta.setOpaque(false); 

		JPanel panDinheiro = new JPanel();
		panDinheiro.setBorder(new TitledBorder(null, "Dinheiro",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panDinheiro.setBounds(540, 526, 240, 85);
		panPrincipal.add(panDinheiro);
		panDinheiro.setLayout(null);
		panDinheiro.setOpaque(false);

		JPanel panInferior = new JPanel();
		panInferior.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panInferior.setBounds(30, 620, 750, 60);
		panPrincipal.add(panInferior);
		panInferior.setLayout(null);
		panInferior.setOpaque(false);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(FrmVenda.class
				.getResource("/img/Insert.png")));
		btnNewButton.setBounds(17, 11, 75, 44);
		panAcoes.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(FrmVenda.class
				.getResource("/img/Edit.png")));
		btnNewButton_1.setBounds(109, 11, 75, 44);
		panAcoes.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(FrmVenda.class
				.getResource("/img/Delete.png")));
		btnNewButton_2.setBounds(215, 11, 75, 44);
		panAcoes.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(FrmVenda.class
				.getResource("/img/View.png")));
		btnNewButton_3.setBounds(321, 11, 75, 44);
		panAcoes.add(btnNewButton_3);

		JLabel lblNewLabel = new JLabel("<html>Nova<br>Venda</html>");
		lblNewLabel.setBounds(39, 57, 46, 29);
		panAcoes.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("<html>Altera<br>Venda</html>");
		lblNewLabel_1.setBounds(130, 57, 46, 29);
		panAcoes.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("<html>Exclui<br>Venda</html>");
		lblNewLabel_2.setBounds(229, 57, 46, 29);
		panAcoes.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("<html>Consulta<br>Venda</html>");
		lblNewLabel_3.setBounds(328, 57, 46, 29);
		panAcoes.add(lblNewLabel_3);

		JLabel lblNVenda = new JLabel("N\u00B0 Venda:");
		lblNVenda.setBounds(110, 23, 64, 14);
		panVenda.add(lblNVenda);

		txtNumVenda = new JTextField();
		txtNumVenda.setBounds(166, 20, 64, 20);
		panVenda.add(txtNumVenda);
		txtNumVenda.setColumns(10);

		lblData = new JLabel("Data:");
		lblData.setBounds(10, 23, 46, 14);
		panVenda.add(lblData);

		txtDataVenda = new JTextField();
		txtDataVenda.setText("  /  /");
		txtDataVenda.setBounds(54, 20, 46, 20);
		panVenda.add(txtDataVenda);
		txtDataVenda.setColumns(10);

		JLabel lblVendedor = new JLabel("Vendedor");
		lblVendedor.setBounds(248, 23, 46, 14);
		panVenda.add(lblVendedor);

		lblNewLabel_4 = new JLabel("lblVendedor");
		lblNewLabel_4.setBounds(304, 23, 46, 14);
		panVenda.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("cod:");
		lblNewLabel_5.setBounds(10, 23, 27, 14);
		panCliente.add(lblNewLabel_5);

		lblCodCli = new JLabel("lblCodCli");
		lblCodCli.setBounds(36, 23, 46, 14);
		panCliente.add(lblCodCli);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(92, 23, 46, 14);
		panCliente.add(lblNome);

		txtNomeCli = new JTextField();
		txtNomeCli.setBounds(144, 20, 117, 20);
		panCliente.add(txtNomeCli);
		txtNomeCli.setColumns(10);

		btnPesquisaCli = new JButton("New button");
		btnPesquisaCli.setBounds(278, 19, 33, 23);
		panCliente.add(btnPesquisaCli);

		scrollVenda = new JScrollPane();
		scrollVenda.setBounds(10, 58, 468, 267);
		panTable.add(scrollVenda);

		tableVenda = new JTable();
		scrollVenda.setViewportView(tableVenda);

		JLabel lblProdutoServico = new JLabel("Produto/Servi\u00E7o:");
		lblProdutoServico.setBounds(10, 32, 96, 14);
		panTable.add(lblProdutoServico);

		JLabel lblProdServ = new JLabel("lblProdServ");
		lblProdServ.setBounds(133, 32, 73, 14);
		panTable.add(lblProdServ);

		JLabel lblTotal = new JLabel("TOTAL R$:");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTotal.setBounds(288, 358, 96, 30);
		panTable.add(lblTotal);

		JLabel lblNewLabel_13 = new JLabel("0,00");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_13.setBounds(405, 358, 73, 30);
		panTable.add(lblNewLabel_13);

		JLabel lblProduto = new JLabel("Cod:");
		lblProduto.setBounds(39, 81, 33, 14);
		panProdServ.add(lblProduto);

		rdbServico = new JRadioButton("Servi\u00E7o");
		rdbServico.setOpaque(false);
		rdbServico.setBounds(118, 24, 72, 23);
		panProdServ.add(rdbServico);

		rdbProduto = new JRadioButton("Produto");
		rdbProduto.setOpaque(false);
		rdbProduto.setBounds(44, 24, 72, 23);
		panProdServ.add(rdbProduto);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbProduto);
		bg.add(rdbServico);

		txtCodProdServ = new JTextField();
		txtCodProdServ.setBounds(68, 78, 33, 20);
		panProdServ.add(txtCodProdServ);
		txtCodProdServ.setColumns(10);

		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(40, 124, 46, 14);
		panProdServ.add(lblNome_1);

		txtNomeProdServ = new JTextField();
		txtNomeProdServ.setBounds(96, 121, 86, 20);
		panProdServ.add(txtNomeProdServ);
		txtNomeProdServ.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Quantidade:");
		lblNewLabel_8.setBounds(14, 149, 72, 14);
		panProdServ.add(lblNewLabel_8);

		txtQtdeProdServ = new JTextField();
		txtQtdeProdServ.setBounds(96, 146, 86, 20);
		panProdServ.add(txtQtdeProdServ);
		txtQtdeProdServ.setColumns(10);

		btnPesquisaProdServ = new JButton("New button");
		btnPesquisaProdServ.setBounds(149, 77, 33, 23);
		panProdServ.add(btnPesquisaProdServ);

		JLabel lblNewLabel_9 = new JLabel("Pre\u00E7o Unit\u00E1rio:");
		lblNewLabel_9.setBounds(14, 187, 114, 14);
		panProdServ.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Pre\u00E7o Total:");
		lblNewLabel_10.setBounds(14, 208, 114, 14);
		panProdServ.add(lblNewLabel_10);

		lblPrecoUPS = new JLabel("New label");
		lblPrecoUPS.setBounds(157, 187, 46, 14);
		panProdServ.add(lblPrecoUPS);

		lblPrecoTPS = new JLabel("New label");
		lblPrecoTPS.setBounds(157, 208, 46, 14);
		panProdServ.add(lblPrecoTPS);

		btnAdicionarPS = new JButton("Adicionar");
		btnAdicionarPS.setBounds(14, 233, 89, 23);
		panProdServ.add(btnAdicionarPS);

		btnRemovePS = new JButton("Remover");
		btnRemovePS.setBounds(124, 233, 89, 23);
		panProdServ.add(btnRemovePS);

		JButton btnConsultaPreco = new JButton("Pre\u00E7o R$");
		btnConsultaPreco.setBounds(10, 22, 89, 23);
		panConsulta.add(btnConsultaPreco);

		btnConsultaEstoque = new JButton("Estoque");
		btnConsultaEstoque.setBounds(122, 22, 89, 23);
		panConsulta.add(btnConsultaEstoque);

		btnAcao = new JButton("Finalizar");
		btnAcao.setIcon(new ImageIcon(FrmVenda.class.getResource("/img/MiniSalvar.png")));
		btnAcao.setBounds(631, 11, 109, 38);
		panInferior.add(btnAcao);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(FrmVenda.class.getResource("/img/MiniX.png")));
		btnCancelar.setBounds(520, 11, 101, 38);
		panInferior.add(btnCancelar);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FrmVenda.class
				.getResource("/img/teste.png")));
		label.setBounds(0, 0, 763, 14);
		panPrincipal.add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FrmVenda.class
				.getResource("/img/teste2.png")));
		label_1.setBounds(787, 692, 46, 14);
		panPrincipal.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(FrmVenda.class
				.getResource("/img/teste.png")));
		label_2.setBounds(70, 715, 763, 14);
		panPrincipal.add(label_2);

		txtDinheiroRecebido = new JTextField();
		txtDinheiroRecebido.setEnabled(false);
		txtDinheiroRecebido.setBounds(65, 22, 86, 20);
		panDinheiro.add(txtDinheiroRecebido);
		txtDinheiroRecebido.setColumns(10);

		JLabel lblRecebido = new JLabel("Recebido");
		lblRecebido.setBounds(9, 25, 46, 14);
		panDinheiro.add(lblRecebido);

		JLabel lblTroco = new JLabel("TROCO:");
		lblTroco.setBounds(9, 60, 46, 14);
		panDinheiro.add(lblTroco);

		JLabel label_3 = new JLabel("0,0");
		label_3.setBounds(78, 60, 46, 14);
		panDinheiro.add(label_3);

		JButton btnCalculaTroco = new JButton(">");
		btnCalculaTroco.setBounds(161, 21, 41, 23);
		panDinheiro.add(btnCalculaTroco);
		ConfigTelas.centralizarFrame(janela);
	}

	public static void main(String[] args) {
		new FrmVenda();
	}
}
