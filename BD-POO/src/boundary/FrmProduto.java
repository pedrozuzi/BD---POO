package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import control.ConfigTelas;
import control.CtrlFornecedor;
import control.CtrlProduto;
import control.CtrlTableLote;
import control.CtrlTableProduto;
import control.CtrlTelaProduto;
import control.ModeloTabela;
import entity.Fornecedor;
import entity.Lote;
import entity.Produto;

/**
 * 
 * @author Hury
 *
 */

public class FrmProduto extends MouseAdapter implements ConfigTelas {

	private JFrame janela = new JFrame("Produto");
	private JTextField txtIdProduto;
	private JTextField txtIdLote;
	private JTextField txtDataValidadeLote;
	private JTextField txtNome;
	private JPanel panLote;
	private JPanel panProduto;
	private JLabel lblNome;
	private JLabel lblNewLabel_1;
	private JLabel lblId_1;
	private JLabel lblDataDeValidade;
	private JLabel lblAcao;
	private JTextField txtDescricao;
	private JTextField txtValorVenda;
	private JTextField txtValorCompra;
	private JTextField txtIdFornecedor;

	private JTable tableLote;
	private JTable tableProduto;
	private ModeloTabela modeloProduto;
	private ModeloTabela modeloLote;

	private JScrollPane scrollProduto;
	private JScrollPane scrollLote;

	private CtrlTableProduto controlTableProduto;
	private CtrlTableLote controlTableLote;

	private CtrlProduto ctrlincluiprod;
	private List<Produto> listaProduto;
	private List<Lote> listaLote;


	public FrmProduto() {

		JPanel panPrincipal = new JPanel();
		JPanel panForm = new JPanel();

		JMenuBar menuBarProduto = new JMenuBar();
		janela.setJMenuBar(menuBarProduto);

		JMenu mnMenu = new JMenu("Menu");
		menuBarProduto.add(mnMenu);

		// TODO action temporario
		JMenuItem mntmMenuPrincipal = new JMenuItem("Menu Principal");

		mntmMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FrmPrincipal telaprincipal = new FrmPrincipal();
				telaprincipal.main(null);
				janela.dispose();

			}
		});

		mntmMenuPrincipal.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/HomeMenu.png")));
		mnMenu.add(mntmMenuPrincipal);

		JMenuItem mntmLogOff = new JMenuItem("Log Off");
		mntmLogOff.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/LogOffMenu.png")));
		mnMenu.add(mntmLogOff);

		JMenuItem mntmFechar = new JMenuItem("Fechar");
		mntmFechar.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/CloseMenu.png")));
		mnMenu.add(mntmFechar);

		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBarProduto.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem);

		janela.setContentPane(panPrincipal);
		panPrincipal.setLayout(null);

		JPanel panAcoes = new JPanel();
		panAcoes.setBorder(new TitledBorder(null, "A\u00E7\u00F5es",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panAcoes.setBounds(179, 0, 426, 84);
		panPrincipal.add(panAcoes);
		panAcoes.setLayout(null);
		panAcoes.setOpaque(false);

		JButton btnIncluir = new JButton("");
		btnIncluir.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/Insert.png")));
		btnIncluir.setBounds(49, 11, 69, 41);
		panAcoes.add(btnIncluir);

		JLabel label = new JLabel("Incluir");
		label.setBounds(59, 58, 40, 19);
		panAcoes.add(label);

		JButton btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/Edit.png")));
		btnAlterar.setBounds(143, 11, 69, 41);
		panAcoes.add(btnAlterar);

		JLabel label_1 = new JLabel("Alterar");
		label_1.setBounds(163, 58, 40, 19);
		panAcoes.add(label_1);

		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/Delete.png")));
		btnExcluir.setBounds(232, 11, 69, 41);
		panAcoes.add(btnExcluir);

		JLabel label_2 = new JLabel("Excluir");
		label_2.setBounds(242, 58, 40, 19);
		panAcoes.add(label_2);

		JButton btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/View.png")));
		btnPesquisar.setBounds(326, 11, 69, 41);
		panAcoes.add(btnPesquisar);

		JLabel label_3 = new JLabel("Pesquisar");
		label_3.setBounds(336, 58, 59, 19);
		panAcoes.add(label_3);

		JPanel panSuperior = new JPanel();
		panSuperior.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panSuperior.setBounds(20, 86, 896, 191);
		panPrincipal.add(panSuperior);
		panSuperior.setLayout(null);
		panSuperior.setOpaque(false);

		JButton btnRewind = new JButton("");
		btnRewind.setBounds(241, 162, 69, 18);
		panSuperior.add(btnRewind);
		btnRewind.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/MiniRewind.png")));

		JButton btnBack = new JButton("");
		btnBack.setBounds(309, 162, 69, 18);
		panSuperior.add(btnBack);
		btnBack.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/MiniBack.png")));

		JButton btnNext = new JButton("");
		btnNext.setBounds(379, 162, 69, 18);
		panSuperior.add(btnNext);
		btnNext.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/MiniNext.png")));

		JButton btnFoward = new JButton("");
		btnFoward.setBounds(447, 162, 69, 18);
		panSuperior.add(btnFoward);
		btnFoward.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/MiniFoward.png")));

		// TABLE PRODUTO
		tableProduto = new JTable();
		tableProduto.addMouseListener(this);
		tableProduto.setBorder(new LineBorder(Color.BLACK));
		tableProduto.setGridColor(Color.BLACK);
		tableProduto.setShowGrid(true);
		tableProduto.setVisible(true);

		// SCROLL PRODUTO
		scrollProduto = new JScrollPane();
		scrollProduto.getViewport().setBorder(null);
		scrollProduto.setViewportView(tableProduto);
		scrollProduto.setBounds(10, 21, 681, 134);
		scrollProduto.setVisible(true);

		panSuperior.add(scrollProduto);

		// TABLE LOTE
		tableLote = new JTable();
		// mouse listener
		tableLote.setBorder(new LineBorder(Color.BLACK));
		tableLote.setGridColor(Color.BLACK);
		tableLote.setShowGrid(true);
		tableLote.setVisible(true);

		// SCROLL LOTE

		scrollLote = new JScrollPane();
		scrollLote.getViewport().setBorder(null);
		scrollLote.setViewportView(tableLote);
		scrollLote.setBounds(701, 21, 185, 134);
		scrollLote.setVisible(true);

		panSuperior.add(scrollLote);

		JPanel panInferior = new JPanel();
		panInferior
				.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panInferior.setBounds(20, 288, 741, 290);
		panPrincipal.add(panInferior);
		panInferior.setOpaque(false);
		panInferior.setLayout(null);

		panLote = new JPanel();
		panLote.setBounds(35, 201, 472, 82);
		panInferior.add(panLote);
		panLote.setBorder(new TitledBorder(null, "Lote", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panLote.setLayout(null);
		panLote.setOpaque(false);

		txtIdLote = new JTextField();
		txtIdLote.setBounds(108, 21, 86, 20);
		panLote.add(txtIdLote);
		txtIdLote.setColumns(10);

		lblId_1 = new JLabel("Id:");
		lblId_1.setBounds(65, 21, 33, 20);
		panLote.add(lblId_1);

		lblDataDeValidade = new JLabel("Data de Validade:");
		lblDataDeValidade.setBounds(10, 52, 101, 20);
		panLote.add(lblDataDeValidade);

		txtDataValidadeLote = new JTextField();
		txtDataValidadeLote.setBounds(108, 52, 106, 20);
		panLote.add(txtDataValidadeLote);
		txtDataValidadeLote.setColumns(10);

		JPanel panProduto = new JPanel();
		panProduto.setBounds(35, 11, 677, 193);
		panInferior.add(panProduto);
		panProduto.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Produto",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panProduto.setLayout(null);
		panProduto.setOpaque(false);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(83, 16, 15, 14);
		panProduto.add(lblId);

		txtNome = new JTextField();
		txtNome.setBounds(106, 50, 168, 20);
		panProduto.add(txtNome);
		txtNome.setColumns(10);

		txtIdProduto = new JTextField();
		txtIdProduto.setBounds(104, 15, 61, 20);
		panProduto.add(txtIdProduto);
		txtIdProduto.setColumns(10);

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(62, 46, 36, 20);
		panProduto.add(lblNome);

		lblNewLabel_1 = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel_1.setBounds(46, 82, 52, 20);
		panProduto.add(lblNewLabel_1);

		JButton btnPesquisaProduto = new JButton("");
		btnPesquisaProduto.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/MiniLupa.png")));
		btnPesquisaProduto.setBounds(189, 5, 30, 25);
		panProduto.add(btnPesquisaProduto);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(106, 85, 168, 20);
		panProduto.add(txtDescricao);
		txtDescricao.setColumns(10);

		JLabel lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setFont(new Font("Arial", Font.BOLD, 10));
		lblPesquisar.setBounds(177, 24, 61, 25);
		panProduto.add(lblPesquisar);

		txtValorVenda = new JTextField();
		txtValorVenda.setColumns(10);
		txtValorVenda.setBounds(104, 113, 61, 20);
		panProduto.add(txtValorVenda);

		txtValorCompra = new JTextField();
		txtValorCompra.setColumns(10);
		txtValorCompra.setBounds(106, 154, 61, 20);
		panProduto.add(txtValorCompra);

		JLabel lblValorDeVenda = new JLabel("Valor de Venda:");
		lblValorDeVenda.setBounds(14, 118, 84, 20);
		panProduto.add(lblValorDeVenda);

		JLabel lblValorDeCompra = new JLabel("Valor de Compra:");
		lblValorDeCompra.setBounds(10, 154, 88, 20);
		panProduto.add(lblValorDeCompra);

		JLabel lblFornecedor = new JLabel("Fornecedor:");
		lblFornecedor.setBounds(346, 46, 88, 20);
		panProduto.add(lblFornecedor);

		txtIdFornecedor = new JTextField();
		txtIdFornecedor.setColumns(10);
		txtIdFornecedor.setBounds(417, 46, 126, 20);
		panProduto.add(txtIdFornecedor);

		// configs básicas de janela
		janela.setSize(942, 670);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnPesquisaFornecedor = new JButton("");
		btnPesquisaFornecedor.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/MiniLupa.png")));
		btnPesquisaFornecedor.setBounds(594, 46, 30, 25);
		panProduto.add(btnPesquisaFornecedor);

		JLabel label_4 = new JLabel("Pesquisar");
		label_4.setFont(new Font("Arial", Font.BOLD, 10));
		label_4.setBounds(579, 69, 61, 25);
		panProduto.add(label_4);

		JPanel panAcoes2 = new JPanel();
		panAcoes2.setBounds(517, 215, 195, 64);
		panInferior.add(panAcoes2);
		panAcoes2.setLayout(null);

		JLabel lblVoltar = new JLabel("Voltar");
		lblVoltar.setBounds(20, 40, 40, 19);
		panAcoes2.add(lblVoltar);

		JButton btnVolta = new JButton("");
		btnVolta.setBounds(10, 11, 49, 25);
		panAcoes2.add(btnVolta);
		btnVolta.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/MiniBack.png")));

		JLabel lblLimpar = new JLabel("Limpar");
		lblLimpar.setBounds(80, 40, 40, 19);
		panAcoes2.add(lblLimpar);

		JButton btnLimpa = new JButton("");
		btnLimpa.setBounds(70, 11, 49, 25);
		panAcoes2.add(btnLimpa);
		btnLimpa.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/MiniClear.png")));

		JButton btnSalva = new JButton("");
		btnSalva.setBounds(130, 11, 49, 25);
		panAcoes2.add(btnSalva);
		btnSalva.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/MiniSalvar.png")));

		lblAcao = new JLabel("Salvar");
		lblAcao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAcao.setBounds(130, 39, 55, 19);
		panAcoes2.add(lblAcao);

		btnIncluir.setActionCommand("INCLUIR");
		btnAlterar.setActionCommand("ALTERAR");
		btnExcluir.setActionCommand("EXCLUIR");
		btnPesquisar.setActionCommand("PESQUISAR");

		btnVolta.setActionCommand("VOLTA");
		btnLimpa.setActionCommand("LIMPA");
		// btnSalva.setActionCommand("SALVA");

		CtrlProduto ctrlprod = new CtrlProduto(txtIdProduto, txtNome,
				txtDescricao, txtValorVenda, txtValorCompra, txtIdFornecedor,
				txtIdLote, txtDataValidadeLote);

		CtrlTelaProduto ctrltela = new CtrlTelaProduto(txtIdProduto, txtNome,
				txtDescricao, txtValorVenda, txtValorCompra, txtIdFornecedor,
				txtIdLote, txtDataValidadeLote, btnIncluir, btnAlterar,
				btnExcluir, btnPesquisar, btnRewind, btnBack, btnNext,
				btnFoward, btnPesquisaProduto, btnPesquisaFornecedor, btnVolta,
				btnLimpa, btnSalva, panAcoes, panInferior, panSuperior,
				panAcoes2, panProduto, panLote, lblAcao);

		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(10, 0, 69, 18);
		panSuperior.add(lblProduto);

		JLabel lblLote = new JLabel("Lote");
		lblLote.setBounds(701, 0, 69, 18);
		panSuperior.add(lblLote);

		btnLimpa.addActionListener(ctrltela);
		btnVolta.addActionListener(ctrltela);

		btnIncluir.addActionListener(ctrltela);

		btnAlterar.addActionListener(ctrltela);
		btnExcluir.addActionListener(ctrltela);
		btnPesquisar.addActionListener(ctrltela);

		ctrltela.inicio();

		btnSalva.addActionListener(e -> {

			ctrlprod.actionPerformed(e);
			ctrltela.actionPerformed(e);
		});

		btnPesquisaProduto.addActionListener(e -> {
			
			//Procura produto
			listaProduto = new ArrayList<Produto>();
			try {

				listaProduto = ctrlprod.BuscaProdutoPorNome(txtNome.getText());
				// modeloProduto = new ModeloTabela(listaProduto);
				if (!listaProduto.isEmpty()) {
					modeloProduto = new ModeloTabela(listaProduto);
					tableProduto.getTableHeader().setReorderingAllowed(false);
					tableProduto.setModel(modeloProduto);
				} else {
					JOptionPane.showMessageDialog(null,
							"Nenhum registro encontrado", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} catch (NullPointerException e1) {
				System.out.println("NullPointer, Produto");
			} catch (SQLException e2) {
				System.out.println("ERRO - SQL - Produto");
			}
            
			//Procura Lote
		    listaLote = new ArrayList<Lote>();
		    try {
				listaLote = ctrlprod.BuscaLotePorProduto(1);//TODO Arrumar id mouse listener
				if (!listaLote.isEmpty()) {
					modeloLote = new ModeloTabela(listaLote);
					tableLote.getTableHeader().setReorderingAllowed(false);
					tableLote.setModel(modeloLote);
				} else {
					JOptionPane.showMessageDialog(null,
							"Nenhum Lote?", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				}
		    	
			} catch (NullPointerException e1) {
				System.out.println("NullPointer, Lote");
			} catch (SQLException e2) {
				System.out.println("ERRO - SQL - Lote");
			}
			
		});

		// btnLupaPesquisar.addActionListener(e -> {
		// control = new CtrlFornecedor();
		// lista = new ArrayList<Fornecedor>();
		// //modelo.setNumRows(0); //apagar Jtable para uma nova consulta
		// //buscarDadosTabelaPorNome(modelo);
		// try {
		// lista = control.buscaFornecedorPorNome(txtNome.getText());
		// if (!lista.isEmpty()) {
		// modelo = new ModeloTabela(lista);
		// table.getTableHeader().setReorderingAllowed(false);
		// table.setModel(modelo);
		// }else{
		// JOptionPane.showMessageDialog(null, "Nenhum registro encontrado",
		// "Aviso", JOptionPane.INFORMATION_MESSAGE);
		// }
		//
		// } catch (NullPointerException e1) {
		// System.out.println("NullPointer");
		// } catch (SQLException e2) {
		// System.out.println("ERRO - SQL");
		// }
		// limpaCampos();
		// });

	}// fim construtor

	public void mouseClicked(MouseEvent e) {
		Object[] valores = new Object[6];
		int linha = tableProduto.getSelectedRow();
		int coluna = tableProduto.getSelectedColumn();

		for (coluna = 0; coluna < tableProduto.getColumnCount(); coluna++) {
			valores[coluna] = tableProduto.getValueAt(linha, coluna);
		}

		txtIdProduto.setText(String.valueOf(valores[0]));
		txtNome.setText(String.valueOf(valores[1]));
		txtDescricao.setText(String.valueOf(valores[2]));
		txtIdFornecedor.setText(String.valueOf(valores[3]));
		txtValorCompra.setText(String.valueOf(valores[4]));
		txtValorVenda.setText(String.valueOf(valores[5]));

	}

	public static void main(String[] args) {
		new FrmProduto();

	}

	// public DefaultTableModel montarTabelaProduto () {
	// String[] colunas = new String[6];
	// colunas[0] = "ID";
	// colunas[1] = "Nome";
	// colunas[2] = "Descricao";
	// colunas[3] = "ID: Fornecedor";
	// colunas[4] = "Compra R$:";
	// colunas[5] = "Venda R$:";
	//
	//
	// modelo = new CtrlTabela(new Object[][] {}, colunas);
	//
	// tableProduto.setModel(modelo);
	// tableProduto.addMouseListener(this);
	// tableProduto.getTableHeader().setReorderingAllowed(false); //deixar as
	// colunas para nao serem movidas de seu lugar original
	// tableProduto.getColumnModel().getColumn(0).setResizable(false);
	// tableProduto.getColumnModel().getColumn(1).setPreferredWidth(268);
	// tableProduto.getColumnModel().getColumn(2).setPreferredWidth(143);
	// tableProduto.getColumnModel().getColumn(3).setPreferredWidth(100);
	// tableProduto.getColumnModel().getColumn(4).setPreferredWidth(50);
	// // tableProduto.setVisible(false);
	// scrollProduto.setViewportView(tableProduto);
	// return modelo;
	// }

	// public DefaultTableModel montarTabelaLote(){
	//
	// String[] colunas = new String[2];
	// colunas[0] = "Lote";
	// colunas[1] = "Qtde";
	//
	// modelo = new CtrlTabela(new Object[][] {}, colunas);
	//
	// modelo = new CtrlTabela(new Object[][] {}, colunas);
	//
	// tableProduto.setModel(modelo);
	// tableProduto.addMouseListener(this);
	// //scrollPane.setViewportView( );
	//
	// return modelo;
	// }

	// public void buscarDadosTabelaPorNome(DefaultTableModel modelo) {
	// controlTable = new CtrlProduto(txtIdProduto, txtNome, txtDescricao,
	// txtValorVenda, txtValorCompra,
	// txtIdFornecedor, txtIdLote, txtDataValidadeLote); //instanciado comoa
	// tribulto
	//
	// lista = new ArrayList<Produto>();
	//
	// if (true) {
	// if (!txtNome.getText().equals("")) { //FIXME if
	// try {
	// lista = controlTable.BuscaProdutoPorNome(txtNome.getText());
	//
	// if (!lista.isEmpty()) {
	// for (Produto p : lista) {
	// Object[] linha = new Object[6];
	// linha[0] = p.getId();
	// linha[1] = p.getNome();
	// linha[2] = p.getDescricao();
	// linha[3] = p.getId_fornecedor();
	// linha[4] = p.getValor_venda();
	// linha[5] = p.getValor_compra();
	//
	// System.out.println(" for:"+p.getNome());
	//
	// modelo.addRow(linha);
	//
	// }
	//
	// lista.forEach(p -> {
	// System.out.println(p.getNome());
	// });
	// }else{
	// JOptionPane.showMessageDialog(null, "Nenhum registro encontrado",
	// "Aviso", JOptionPane.INFORMATION_MESSAGE);
	// }
	//
	// }catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }else{
	// System.out.println("campo vazio");
	// }
	// }
	// }

}// end class
