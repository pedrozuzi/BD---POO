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
import control.ConfiguracoesTela;
import control.CtrlProduto;
import control.CtrlTableLote;
import control.CtrlTableProduto;
import control.CtrlTelaProduto;
import control.ModeloTabela;
import entity.Lote;
import entity.Produto;

/**
 * Classe que possui os elementos de tela do Produto e Lote
 * 
 * @author Hury
 *
 */

public class FrmProduto extends MouseAdapter {

	private JFrame janela = new JFrame("Produto");

	private JTextField txtIdProduto;
	private JTextField txtIdLote;
	private JTextField txtDataValidadeLote;
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JTextField txtValorVenda;
	private JTextField txtValorCompra;
	private JTextField txtIdFornecedor;

	private JPanel panLote;
	private JPanel panProduto;

	private JLabel lblNome;
	private JLabel lblNewLabel_1;
	private JLabel lblId_1;
	private JLabel lblDataDeValidade;
	private JLabel lblAcao;

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

	private int idprod = 0;

	/**
	 * Construtor
	 */

	public FrmProduto() {

		JPanel panPrincipal = new JPanel();
		panPrincipal.setBackground(Color.WHITE);

		// XXX DELETAR APÒS EDIÇÂO!!
		janela.setSize(942, 702);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// XXX

		// CONFIGURACOES DE TELA, COMENTAR PARA EDITAR NO WINDOW BUILDER!!
		ConfiguracoesTela configTela = new ConfiguracoesTela(janela);
		configTela.iconeBarra(janela);
		configTela.tamanho(janela, 942, 702);
		configTela.centralizeFrame(janela);
		configTela.selecionaEstilo(0); // 1=nimbus
		configTela.estilo(janela);
		// COMENTAR ATÈ AQUI!!

		janela.setContentPane(panPrincipal);
		panPrincipal.setLayout(null);

		JPanel panAcoes = new JPanel();
		panAcoes.setBorder(new TitledBorder(null, "A\u00E7\u00F5es",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panAcoes.setBounds(120, 18, 687, 100);
		panPrincipal.add(panAcoes);
		panAcoes.setLayout(null);
		panAcoes.setOpaque(false);

		JPanel panInferior = new JPanel();
		panInferior.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panInferior.setBounds(105, 322, 705, 290);
		panPrincipal.add(panInferior);
		panInferior.setOpaque(false);
		panInferior.setLayout(null);

		JPanel panSuperior = new JPanel();
		panSuperior.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panSuperior.setBounds(24, 121, 896, 181);
		panPrincipal.add(panSuperior);
		panSuperior.setLayout(null);
		panSuperior.setOpaque(false);

		panLote = new JPanel();
		panLote.setBounds(12, 202, 472, 82);
		panInferior.add(panLote);
		panLote.setBorder(new TitledBorder(null, "Lote", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panLote.setLayout(null);
		panLote.setOpaque(false);

		JPanel panProduto = new JPanel();
		panProduto.setBounds(12, 12, 677, 193);
		panInferior.add(panProduto);
		panProduto.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Produto",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panProduto.setLayout(null);
		panProduto.setOpaque(false);

		JPanel panAcoes2 = new JPanel();
		panAcoes2.setBounds(494, 216, 195, 64);
		panInferior.add(panAcoes2);
		panAcoes2.setLayout(null);
		panAcoes2.setOpaque(false);

		JMenuBar menuBarProduto = new JMenuBar();
		janela.setJMenuBar(menuBarProduto);

		JMenu mnMenu = new JMenu("Menu");
		menuBarProduto.add(mnMenu);

		// TODO action temporario
		JMenuItem mntmMenuPrincipal = new JMenuItem("Menu Principal");

		mntmMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FrmPrincipal telaprincipal = new FrmPrincipal(null);
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

		JButton btnIncluir = new JButton("");
		btnIncluir.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/Insert.png")));
		btnIncluir.setBounds(30, 21, 69, 41);
		panAcoes.add(btnIncluir);

		JButton btnIncluirProduto = new JButton("");
		btnIncluirProduto.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/Insert.png")));
		btnIncluirProduto.setBounds(124, 21, 69, 41);
		panAcoes.add(btnIncluirProduto);

		JButton btnIncluirNovoLote = new JButton("");
		btnIncluirNovoLote.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/Insert.png")));
		btnIncluirNovoLote.setBounds(213, 21, 69, 41);
		panAcoes.add(btnIncluirNovoLote);

		JLabel lblIncluirProduto = new JLabel(
				"<html>Incluir  Produto<br><p align=\u201Dcenter\u201D>e Lote</center></html>\r\n");
		lblIncluirProduto.setBounds(30, 61, 84, 33);
		panAcoes.add(lblIncluirProduto);

		JLabel label_5 = new JLabel("<html>Inclui<br>Produto</html>");
		label_5.setBounds(134, 61, 46, 33);
		panAcoes.add(label_5);

		JLabel label = new JLabel(
				"<html>Inclui novo Lote<br> a um Produto</html>");
		label.setBounds(209, 61, 92, 33);
		panAcoes.add(label);

		JButton btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/Edit.png")));
		btnAlterar.setBounds(313, 21, 69, 41);
		panAcoes.add(btnAlterar);

		JLabel lblalterar = new JLabel("<html>Alterar</html>");
		lblalterar.setBounds(333, 68, 40, 19);
		panAcoes.add(lblalterar);

		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/Delete.png")));
		btnExcluir.setBounds(402, 21, 69, 41);
		panAcoes.add(btnExcluir);

		JLabel lblexcluirproduto = new JLabel("<html>Excluir<br>Produto</html>");
		lblexcluirproduto.setBounds(412, 61, 53, 33);
		panAcoes.add(lblexcluirproduto);

		JButton btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/View.png")));
		btnPesquisar.setBounds(588, 21, 69, 41);
		panAcoes.add(btnPesquisar);

		JLabel lblpesquisar = new JLabel("<html>Pesquisar</html>");
		lblpesquisar.setBounds(598, 68, 59, 19);
		panAcoes.add(lblpesquisar);

		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(10, 0, 69, 18);
		panSuperior.add(lblProduto);

		JLabel lblLote = new JLabel("Lote");
		lblLote.setBounds(701, 0, 69, 18);
		panSuperior.add(lblLote);

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
		tableLote.addMouseListener(this);
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

		txtIdLote = new JTextField();
		txtIdLote.setEditable(false);
		txtIdLote.setBounds(123, 11, 40, 25);
		panLote.add(txtIdLote);
		txtIdLote.setColumns(10);

		lblId_1 = new JLabel("ID:");
		lblId_1.setBounds(102, 14, 15, 20);
		panLote.add(lblId_1);

		lblDataDeValidade = new JLabel("Data de Validade:");
		lblDataDeValidade.setBounds(25, 42, 101, 20);
		panLote.add(lblDataDeValidade);

		txtDataValidadeLote = new JTextField();
		txtDataValidadeLote.setBounds(123, 39, 106, 25);
		panLote.add(txtDataValidadeLote);
		txtDataValidadeLote.setColumns(10);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(103, 22, 16, 14);
		panProduto.add(lblId);

		txtNome = new JTextField();
		txtNome.setBounds(122, 52, 199, 25);
		panProduto.add(txtNome);
		txtNome.setColumns(10);

		txtIdProduto = new JTextField();
		txtIdProduto.setEditable(false);
		txtIdProduto.setBounds(122, 16, 45, 25);
		panProduto.add(txtIdProduto);
		txtIdProduto.setColumns(10);

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(82, 55, 37, 20);
		panProduto.add(lblNome);

		lblNewLabel_1 = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel_1.setBounds(55, 91, 64, 20);
		panProduto.add(lblNewLabel_1);

		JButton btnPesquisaProduto = new JButton("");
		btnPesquisaProduto.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/MiniLupa.png")));
		btnPesquisaProduto.setBounds(187, 19, 30, 25);
		panProduto.add(btnPesquisaProduto);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(122, 88, 356, 25);
		panProduto.add(txtDescricao);
		txtDescricao.setColumns(10);

		JLabel lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setFont(new Font("Arial", Font.BOLD, 10));
		lblPesquisar.setBounds(231, 16, 61, 25);
		panProduto.add(lblPesquisar);

		txtValorVenda = new JTextField();
		txtValorVenda.setColumns(10);
		txtValorVenda.setBounds(122, 124, 61, 25);
		panProduto.add(txtValorVenda);

		txtValorCompra = new JTextField();
		txtValorCompra.setColumns(10);
		txtValorCompra.setBounds(122, 160, 61, 25);
		panProduto.add(txtValorCompra);

		JLabel lblValorDeVenda = new JLabel("Valor de Venda:");
		lblValorDeVenda.setBounds(31, 127, 100, 20);
		panProduto.add(lblValorDeVenda);

		JLabel lblValorDeCompra = new JLabel("Valor de Compra:");
		lblValorDeCompra.setBounds(19, 163, 100, 20);
		panProduto.add(lblValorDeCompra);

		JLabel lblFornecedor = new JLabel("Fornecedor:");
		lblFornecedor.setBounds(346, 46, 88, 20);
		panProduto.add(lblFornecedor);

		txtIdFornecedor = new JTextField();
		txtIdFornecedor.setColumns(10);
		txtIdFornecedor.setBounds(417, 46, 61, 25);
		panProduto.add(txtIdFornecedor);

		JButton btnPesquisaFornecedor = new JButton("");
		btnPesquisaFornecedor.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/MiniLupa.png")));
		btnPesquisaFornecedor.setBounds(488, 45, 30, 25);
		panProduto.add(btnPesquisaFornecedor);

		JLabel label_4 = new JLabel("Pesquisar");
		label_4.setFont(new Font("Arial", Font.BOLD, 10));
		label_4.setBounds(528, 45, 61, 25);
		panProduto.add(label_4);

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
		lblAcao.setBounds(130, 39, 59, 19);
		panAcoes2.add(lblAcao);

		JButton btnExcluirLote = new JButton("");
		btnExcluirLote.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/Delete.png")));
		btnExcluirLote.setActionCommand("EXCLUIR");
		btnExcluirLote.setBounds(495, 21, 69, 41);
		panAcoes.add(btnExcluirLote);

		JLabel lblexcluirlote = new JLabel("<html>Excluir<br>Lote</html>");
		lblexcluirlote.setBounds(505, 61, 46, 33);
		panAcoes.add(lblexcluirlote);

		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/teste.png")));
		label_6.setBounds(0, 0, 926, 16);
		panPrincipal.add(label_6);

		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/teste2.png")));
		label_7.setBounds(0, 18, 113, 16);
		panPrincipal.add(label_7);

		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/teste.png")));
		label_8.setBounds(0, 624, 926, 16);
		panPrincipal.add(label_8);

		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/teste2.png")));
		label_9.setBounds(755, 607, 171, 16);
		panPrincipal.add(label_9);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FrmProduto.class
				.getResource("/img/teste2.png")));
		label_1.setBounds(813, 18, 113, 16);
		panPrincipal.add(label_1);

		btnIncluir.setActionCommand("INCLUIR");
		btnIncluirProduto.setActionCommand("INCLUIRPRODUTO");
		btnIncluirNovoLote.setActionCommand("INCLUIRLOTE");

		btnAlterar.setActionCommand("ALTERAR");
		btnExcluir.setActionCommand("EXCLUIR");
		btnExcluirLote.setActionCommand("EXCLUIRLOTE");

		btnPesquisar.setActionCommand("PESQUISAR");

		btnVolta.setActionCommand("VOLTA");
		btnLimpa.setActionCommand("LIMPA");

		CtrlProduto ctrlprod = new CtrlProduto(txtIdProduto, txtNome,
				txtDescricao, txtValorVenda, txtValorCompra, txtIdFornecedor,
				txtIdLote, txtDataValidadeLote);

		CtrlTelaProduto ctrltela = new CtrlTelaProduto(txtIdProduto, txtNome,
				txtDescricao, txtValorVenda, txtValorCompra, txtIdFornecedor,
				txtIdLote, txtDataValidadeLote, btnIncluirNovoLote, btnAlterar,
				btnExcluirLote, btnPesquisar, btnPesquisaProduto,
				btnPesquisaFornecedor, btnVolta, btnLimpa, btnSalva, panAcoes,
				panInferior, panSuperior, panAcoes2, panProduto, panLote,
				lblAcao);

		btnLimpa.addActionListener(ctrltela);
		btnVolta.addActionListener(ctrltela);

		btnIncluir.addActionListener(ctrltela);
		btnIncluirProduto.addActionListener(ctrltela);
		btnIncluirNovoLote.addActionListener(ctrltela);

		btnAlterar.addActionListener(ctrltela);
		btnExcluir.addActionListener(ctrltela);
		btnExcluirLote.addActionListener(ctrltela);
		btnPesquisar.addActionListener(ctrltela);

		ctrltela.resetaTela(); // configura a tela para abertura

		btnSalva.addActionListener(e -> {

			String acao = e.getActionCommand();

			if (acao.equalsIgnoreCase("ACAOSALVA")) {

				if (ctrltela.camposProduto() == false
						|| ctrltela.camposLote() == false) {
					JOptionPane.showMessageDialog(null, "Campos Obrigatorios!");
				} else {
					ctrlprod.actionPerformed(e);
					ctrltela.actionPerformed(e);
				}

			} else if (acao.equalsIgnoreCase("ACAOSALVAPRODUTO")) {
				if (ctrltela.camposProduto() == false){
					JOptionPane.showMessageDialog(null, "Campos Obrigatorios!");
				}else{
					ctrlprod.actionPerformed(e);
					ctrltela.actionPerformed(e);
				}
			} else if (acao.equalsIgnoreCase("ACAOSALVALOTE")) {

				if (ctrltela.camposProduto() == false
						|| ctrltela.camposLote() == false) {
					JOptionPane.showMessageDialog(null, "Campos Obrigatorios!");
				} else {
					ctrlprod.actionPerformed(e);
					ctrltela.actionPerformed(e);
				}
			} else if (acao.equalsIgnoreCase("ACAOGRAVA")) {
				if (ctrltela.camposProduto() == false){
					JOptionPane.showMessageDialog(null, "Campos Obrigatorios!");
				}else{
					ctrlprod.actionPerformed(e);
					ctrltela.actionPerformed(e);
				}
			} else if (acao.equalsIgnoreCase("ACAOEXCLUI")) {
				if (ctrltela.camposPesquisa() == false){
					JOptionPane.showMessageDialog(null, "Campos Obrigatorios!");
				}else{
					ctrlprod.actionPerformed(e);
					ctrltela.actionPerformed(e);
				}
			} else if (acao.equalsIgnoreCase("ACAOEXCLUILOTE")) {
				if (ctrltela.camposPesquisa() == false){
					JOptionPane.showMessageDialog(null, "Campos Obrigatorios!");
				}else{
					ctrlprod.actionPerformed(e);
					ctrltela.actionPerformed(e);
				}
			} else if (acao.equalsIgnoreCase("ACAOPESQUISA")) {

			}

		});

		btnPesquisaProduto.addActionListener(e -> {

			// Procura produto
				listaProduto = new ArrayList<Produto>();
				try {

					listaProduto = ctrlprod.buscaProdutoPorNome(txtNome
							.getText());
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

		});

		janela.repaint(); // CORRIGE BUG DE CARREGAMENTO DOS COMPONENENTES

	}// fim construtor

	/**
	 * Mouse Click das Tables
	 */

	public void mouseClicked(MouseEvent e) {

		Object a = new Object();
		a = e.getSource();

		if (a.equals(tableProduto)) { // Chamada da TableProduto
			System.out.println("table produto");

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

			idprod = Integer.parseInt(txtIdProduto.getText());// XXX

			// PESQUISA LOTE A PARTIR DO CLICK NA TABLE PRODUTO
			if (idprod != 0) {
				listaLote = new ArrayList<Lote>();
				List<String> listanula = new ArrayList<String>();

				CtrlProduto ctrlprod = new CtrlProduto(txtIdProduto, txtNome,
						txtDescricao, txtValorVenda, txtValorCompra,
						txtIdFornecedor, txtIdLote, txtDataValidadeLote);
				try {
					listaLote = ctrlprod.buscaLotePorProduto(idprod);// TODO
																		// Arrumar

					if (!listaLote.isEmpty()) {
						modeloLote = new ModeloTabela(listaLote);
						tableLote.getTableHeader().setReorderingAllowed(false);
						tableLote.setModel(modeloLote);
					} else {
						System.out.println("Nenhum Lote");
						listanula.add("Sem");
						modeloLote = new ModeloTabela(listanula);
						tableLote.getTableHeader().setReorderingAllowed(false);
						tableLote.setModel(modeloLote);

					}

				} catch (NullPointerException e1) {
					System.out.println("NullPointer, Lote");
				} catch (SQLException e2) {
					System.out.println("ERRO - SQL - Lote");
				}
			}

		} else if (a.equals(tableLote)) { // Chamada da TableLote
			System.out.println("table lote");

			Object[] valores = new Object[2];
			int linha = tableLote.getSelectedRow();
			int coluna = tableLote.getSelectedColumn();

			for (coluna = 0; coluna < tableLote.getColumnCount(); coluna++) {
				valores[coluna] = tableLote.getValueAt(linha, coluna);

				txtIdLote.setText(String.valueOf(valores[0]));
				txtDataValidadeLote.setText(String.valueOf(valores[1]));
			}

		}

	}

	/**
	 * Metodo Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new FrmProduto();

	}
}// end class
