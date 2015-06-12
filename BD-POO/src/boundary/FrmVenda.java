package boundary;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import java.awt.Font;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import util.ConfiguracoesTela;
import entity.Produto;
import entity.Usuario;

public class FrmVenda {

	private JFrame janela;
	
	private JPanel panPrincipal;
	private JPanel panVenda;
	private JPanel panConsulta;
	
	private JTextField txtIdVenda;
	private JTextField txtIdCliente;
	private JTextField txtIdVendedor;
	private JTextField txtDataVenda;
	private JTextField txtNomeCli;
	private JTextField txtCodProdServ;
	private JTextField txtNomeProdServ;
	private JTextField txtQtdeProdServ;
	private JTextField txtDinheiroRecebido;
	
	private JLabel lblTotal;
	private JLabel lblData;

	private JButton btnPesquisaCli;
	private JButton btnPesquisaProdServ;
	private JButton btnAdicionarPS;
	private JButton btnRemovePS;
	private JButton btnConsultaEstoque;
	private JButton btnCancelar;
	private JButton btnAcao;
	
	private JRadioButton rdbProduto;
	private JRadioButton rdbServico;

	private JLabel lblPrecoUPS;
	private JLabel lblPrecoTPS;
	
	private JTable tableVenda;
	private JScrollPane scrollVenda;
		
	Object[] objetosTela = new Object[25];

	private JPanel panAcoes;

	private JPanel panCliente;

	private JPanel panTable;

	private JPanel panProdServ;

	private JPanel panDinheiro;

	private JPanel panInferior;

	private JButton btnView;

	private JButton btnExcluir;

	private JButton btnAlterar;

	private JButton btnInserir;

	private JLabel lblVenda;

	private JLabel lblNVenda;

	private JLabel lblConsulta;

	private JLabel lblExcluir;

	private JLabel lblAlterar;

	private JLabel lblVendedor;

	private JLabel lblCodigo;

	private JLabel lblNome;

	private JLabel lblProdutoServico;

	private JLabel lblProdServ;

	private JLabel lblT;

	private JLabel lblProduto;

	private JLabel lblNome2;

	private JLabel lblQuantidade;

	private JLabel lblPreco;

	private JLabel lblPrecoTotal;

	private JButton btnConsultaPreco;

	private JLabel lblRecebido;

	private JLabel lblTroco;

	public FrmVenda(Usuario u) {
		
		janela = new JFrame("Venda");
		
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setLayout(null);
		
		panAcoes = new JPanel();
		panAcoes.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panAcoes.setBounds(217, 20, 431, 90);
		panPrincipal.add(panAcoes);
		panAcoes.setLayout(null);
		panAcoes.setOpaque(false);

		panCliente = new JPanel();
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

		panTable = new JPanel();
		panTable.setBorder(new TitledBorder(null,
				"Lista de Produtos/Servi\u00E7os", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panTable.setBounds(30, 193, 488, 416);
		panPrincipal.add(panTable);
		panTable.setLayout(null);
		panTable.setOpaque(false);

		panProdServ = new JPanel();
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

		panDinheiro = new JPanel();
		panDinheiro.setBorder(new TitledBorder(null, "Dinheiro",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panDinheiro.setBounds(540, 526, 240, 85);
		panPrincipal.add(panDinheiro);
		panDinheiro.setLayout(null);
		panDinheiro.setOpaque(false);

		panInferior = new JPanel();
		panInferior.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panInferior.setBounds(30, 620, 750, 60);
		panPrincipal.add(panInferior);
		panInferior.setLayout(null);
		panInferior.setOpaque(false);

		btnInserir = new JButton("");
		btnInserir.setIcon(new ImageIcon(FrmVenda.class
				.getResource("/img/Insert.png")));
		btnInserir.setBounds(17, 11, 75, 44);
		panAcoes.add(btnInserir);

		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(FrmVenda.class
				.getResource("/img/Edit.png")));
		btnAlterar.setBounds(109, 11, 75, 44);
		panAcoes.add(btnAlterar);

		btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(FrmVenda.class
				.getResource("/img/Delete.png")));
		btnExcluir.setBounds(215, 11, 75, 44);
		panAcoes.add(btnExcluir);

		btnView = new JButton("");
		btnView.setIcon(new ImageIcon(FrmVenda.class
				.getResource("/img/View.png")));
		btnView.setBounds(321, 11, 75, 44);
		panAcoes.add(btnView);

		lblVenda = new JLabel("<html>Nova<br>Venda</html>");
		lblVenda.setBounds(39, 57, 46, 29);
		panAcoes.add(lblVenda);

		lblAlterar = new JLabel("<html>Altera<br>Venda</html>");
		lblAlterar.setBounds(130, 57, 46, 29);
		panAcoes.add(lblAlterar);

		lblExcluir = new JLabel("<html>Exclui<br>Venda</html>");
		lblExcluir.setBounds(229, 57, 46, 29);
		panAcoes.add(lblExcluir);

		lblConsulta = new JLabel("<html>Consulta<br>Venda</html>");
		lblConsulta.setBounds(328, 57, 46, 29);
		panAcoes.add(lblConsulta);

		lblNVenda = new JLabel("N\u00B0 Venda:");
		lblNVenda.setBounds(110, 23, 64, 14);
		panVenda.add(lblNVenda);

		txtIdVenda = new JTextField();
		txtIdVenda.setBounds(166, 20, 64, 20);
		panVenda.add(txtIdVenda);
		txtIdVenda.setColumns(10);

		lblData = new JLabel("Data:");
		lblData.setBounds(10, 23, 46, 14);
		panVenda.add(lblData);

		txtDataVenda = new JTextField();
		txtDataVenda.setText("  /  /");
		txtDataVenda.setBounds(54, 20, 46, 20);
		panVenda.add(txtDataVenda);
		txtDataVenda.setColumns(10);

		lblVendedor = new JLabel("Vendedor");
		lblVendedor.setBounds(248, 23, 46, 14);
		panVenda.add(lblVendedor);
		
		txtIdVendedor = new JTextField();
		txtIdVendedor.setBounds(307, 20, 86, 20);
		panVenda.add(txtIdVendedor);
		txtIdVendedor.setColumns(10);

		lblCodigo = new JLabel("cod:");
		lblCodigo.setBounds(10, 23, 27, 14);
		panCliente.add(lblCodigo);

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(92, 23, 46, 14);
		panCliente.add(lblNome);

		txtNomeCli = new JTextField();
		txtNomeCli.setBounds(144, 20, 117, 20);
		panCliente.add(txtNomeCli);
		txtNomeCli.setColumns(10);

		btnPesquisaCli = new JButton("New button");
		btnPesquisaCli.setBounds(278, 19, 33, 23);
		panCliente.add(btnPesquisaCli);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setBounds(42, 20, 40, 20);
		panCliente.add(txtIdCliente);
		txtIdCliente.setColumns(10);

		scrollVenda = new JScrollPane();
		scrollVenda.setBounds(10, 58, 468, 267);
		panTable.add(scrollVenda);

		tableVenda = new JTable();
		scrollVenda.setViewportView(tableVenda);

		lblProdutoServico = new JLabel("Produto/Servi\u00E7o:");
		lblProdutoServico.setBounds(10, 32, 96, 14);
		panTable.add(lblProdutoServico);

		lblProdServ = new JLabel("lblProdServ");
		lblProdServ.setBounds(133, 32, 73, 14);
		panTable.add(lblProdServ);

		lblT = new JLabel("TOTAL R$:");
		lblT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblT.setBounds(288, 358, 96, 30);
		panTable.add(lblT);

		lblTotal = new JLabel("0,00");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTotal.setBounds(405, 358, 73, 30);
		panTable.add(lblTotal);

		lblProduto = new JLabel("Cod:");
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

		lblNome2 = new JLabel("Nome");
		lblNome2.setBounds(40, 124, 46, 14);
		panProdServ.add(lblNome2);

		txtNomeProdServ = new JTextField();
		txtNomeProdServ.setBounds(96, 121, 86, 20);
		panProdServ.add(txtNomeProdServ);
		txtNomeProdServ.setColumns(10);

		lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(14, 149, 72, 14);
		panProdServ.add(lblQuantidade);

		txtQtdeProdServ = new JTextField();
		txtQtdeProdServ.setBounds(96, 146, 86, 20);
		panProdServ.add(txtQtdeProdServ);
		txtQtdeProdServ.setColumns(10);

		btnPesquisaProdServ = new JButton("New button");
		btnPesquisaProdServ.setBounds(149, 77, 33, 23);
		panProdServ.add(btnPesquisaProdServ);

		lblPreco = new JLabel("Pre\u00E7o Unit\u00E1rio:");
		lblPreco.setBounds(14, 187, 114, 14);
		panProdServ.add(lblPreco);

		lblPrecoTotal = new JLabel("Pre\u00E7o Total:");
		lblPrecoTotal.setBounds(14, 208, 114, 14);
		panProdServ.add(lblPrecoTotal);

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

		btnConsultaPreco = new JButton("Pre\u00E7o R$");
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

		lblRecebido = new JLabel("Recebido");
		lblRecebido.setBounds(9, 25, 46, 14);
		panDinheiro.add(lblRecebido);

		lblTroco = new JLabel("TROCO:");
		lblTroco.setBounds(9, 60, 46, 14);
		panDinheiro.add(lblTroco);

		JLabel label_3 = new JLabel("0,0");
		label_3.setBounds(78, 60, 46, 14);
		panDinheiro.add(label_3);

		JButton btnCalculaTroco = new JButton(">");
		btnCalculaTroco.setBounds(161, 21, 41, 23);
		panDinheiro.add(btnCalculaTroco);
		
		janela.setContentPane(panPrincipal);
		janela.setSize(849, 768);
		ConfiguracoesTela configTela = new ConfiguracoesTela();
		configTela.iconeBarra(janela);
		configTela.tamanho(janela);
		
		
	}
	
	public static void main(String[] args) {
		new FrmVenda(new Usuario());
	}
}
