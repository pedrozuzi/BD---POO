package boundary;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.CtrlFornecedor;

import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import util.ConfiguracoesTela;
import util.ModeloTabela;
import util.TratamentoTextFields;
import entity.Fornecedor;
import entity.Usuario;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que possui os componentes de tela para manipulação
 * dos dados de Fornecedor
 * @author Pedro Zuzi
 *
 */
public class FrmFornecedor extends MouseAdapter{
	
	private JFrame janela; 
	private JPanel panPrincipal;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JLabel lblIncluir;
	private JPanel panel;
	private JLabel lblAlterar;
	private JLabel lblExcluir;
	private JLabel lblTelefone;
	private JLabel lblNome;
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnGravar;
	private JButton btnLimpar;
	private JButton btnVoltar;
	private JLabel lblLogo;
	private CtrlFornecedor control;
	private JButton btnLupaPesquisar;
	private int id;
	private List<Fornecedor> lista;
	private ModeloTabela modelo;
	private JMenuBar menuBarra;
	private JMenu menu;
	private JMenuItem menuPrincipal;
	private JMenuItem logOff;
	private JLabel lblTiraVermelha2;
	private JLabel label;
	private JLabel lblTiraCinza2;
	private JLabel lblTiraVermelha;
	private JLabel lblTiraCinza3;
	private JLabel lblTiraCinza;
	private ConfiguracoesTela configTela;
	
	/**
	 * Contrutor, recebe o usuário logado no sistema
	 * @param u
	 */
	public FrmFornecedor(Usuario u) {
		
		janela = new JFrame("Fornecedor");
		
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setLayout(null);
		
		menuBarra = new JMenuBar();
		janela.setJMenuBar(menuBarra);
		
		menu = new JMenu("Menu");
		menuBarra.add(menu);
		
		menuPrincipal = new JMenuItem("Menu Principal");
		menuPrincipal.setIcon(new ImageIcon(getClass()
				.getResource("/img/HomeMenu.png")));
		menu.add(menuPrincipal);
		
		menuPrincipal.addActionListener(e -> {
			janela.dispose();
			new FrmPrincipal(u);
		}); 
		
		logOff = new JMenuItem("Log Off");
		logOff.setIcon(new ImageIcon(getClass()
				.getResource("/img/LogOffMenu.png")));
		menu.add(logOff);
		
		
		logOff.addActionListener(e -> {
			janela.dispose();
			new FrmLogin();
		});
		
		btnLupaPesquisar = new JButton("");
		btnLupaPesquisar.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniLupa.png")));
		btnLupaPesquisar.setBounds(447, 291, 65, 31);
		btnLupaPesquisar.setVisible(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
				"A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(104, 17, 344, 79);
		panPrincipal.add(panel);
		
		btnIncluir = new JButton("");
		btnIncluir.setBounds(49, 11, 69, 41);
		btnIncluir.setVisible(true);
		panel.add(btnIncluir);
		
		lblIncluir = new JLabel("Incluir");
		btnIncluir.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/Insert.png")));
		lblIncluir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblIncluir.setVisible(true);
		lblIncluir.setBounds(69, 54, 69, 19);
		panel.add(lblIncluir);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/Edit.png")));
		btnAlterar.setBounds(143, 11, 69, 41);
		btnAlterar.setVisible(true);
		panel.add(btnAlterar);
		
		lblAlterar = new JLabel("Alterar");
		lblAlterar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAlterar.setVisible(true);
		lblAlterar.setBounds(162, 54, 44, 19);
		panel.add(lblAlterar);
		
		btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/Delete.png")));
		btnExcluir.setBounds(232, 11, 69, 41);
		btnExcluir.setVisible(true);
		panel.add(btnExcluir);
		
		lblExcluir = new JLabel("Excluir");
		lblExcluir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblExcluir.setVisible(true);
		lblExcluir.setBounds(252, 53, 38, 19);
		panel.add(lblExcluir);
		
		lblTiraCinza2 = new JLabel("");
		lblTiraCinza2.setIcon(new ImageIcon(this.getClass().getResource("/img/TiraCinza.png")));
		lblTiraCinza2.setBounds(-15, 348, 234, 14);
		panPrincipal.add(lblTiraCinza2);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(this.getClass().getResource("/img/TiraCinza.png")));
		label.setBounds(354, 348, 234, 14);
		panPrincipal.add(label);
		
		lblTiraVermelha2 = new JLabel("");
		lblTiraVermelha2.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/TiraVermelha.png")));
		lblTiraVermelha2.setBounds(-15, 365, 599, 14);
		panPrincipal.add(lblTiraVermelha2);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(this.getClass().getResource("/img/logo.png")));
		lblLogo.setBounds(165, 148, 283, 233);
		panPrincipal.add(lblLogo);
		panPrincipal.add(btnLupaPesquisar);
		
		lblTiraVermelha = new JLabel("");
		lblTiraVermelha.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/TiraVermelha.png")));
		lblTiraVermelha.setBounds(0, 0, 576, 14);
		panPrincipal.add(lblTiraVermelha);
		
		lblTiraCinza = new JLabel("");
		lblTiraCinza.setBounds(447, 17, 131, 14);
		panPrincipal.add(lblTiraCinza);
		lblTiraCinza.setIcon(new ImageIcon(this.getClass().getResource("/img/TiraCinza.png")));
		
		lblTiraCinza3 = new JLabel("");
		lblTiraCinza3.setBounds(0, 17, 119, 14);
		lblTiraCinza3.setIcon(new ImageIcon(this.getClass().getResource("/img/TiraCinza.png")));
		panPrincipal.add(lblTiraCinza3);
		
		txtNome = new TratamentoTextFields();
		txtNome.setBounds(126, 302, 296, 20);
		txtNome.setVisible(false);
		panPrincipal.add(txtNome);
		txtNome.setColumns(10);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(51, 305, 65, 14);
		lblNome.setVisible(false);
		panPrincipal.add(lblNome);
		
		txtTelefone = new TratamentoTextFields(9);
		txtTelefone.setBounds(126, 348, 109, 20);
		txtTelefone.setVisible(false);
		panPrincipal.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(51, 351, 58, 14);
		lblTelefone.setVisible(false);
		panPrincipal.add(lblTelefone);
		
		btnGravar = new JButton("Gravar");
		btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniSalvar.png")));
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravar.setVisible(false);
		btnGravar.setBounds(434, 416, 96, 31);
		panPrincipal.add(btnGravar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniClear.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(240, 416, 96, 31);
		btnLimpar.setVisible(false);
		panPrincipal.add(btnLimpar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniBack.png")));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(46, 416, 96, 31);
		btnVoltar.setVisible(false);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setBorder(new LineBorder(Color.BLACK));
		table.setGridColor(Color.BLACK);
		table.setShowGrid(true);
		
		scrollPane = new JScrollPane();
		scrollPane.getViewport().setBorder(null);
		scrollPane.setViewportView(table);
		scrollPane.setBounds(10, 107, 549, 159);
		scrollPane.setVisible(false);
		panPrincipal.add(scrollPane);
		panPrincipal.add(btnVoltar);
		
		janela.setContentPane( panPrincipal);
		configTela = new ConfiguracoesTela();
		janela.setSize(581,511);
		configTela.iconeBarra(janela);
		configTela.tamanho(janela);
		
		btnVoltar.addActionListener( e -> {
			janela.dispose();
			janela = null;
			new FrmCadastros(u);
		});
		
		btnAlterar.addActionListener(e -> {
			btnGravar.setEnabled(true);
			btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
					("/img/MiniSalvar.png")));
			btnGravar.setText("Alterar");
			btnGravar.setActionCommand("Alterar");
			telaAlterarExcluirFornecedor();
			
		});
		
		btnIncluir.addActionListener( e -> {
			scrollPane.setVisible(false);
			btnGravar.setEnabled(true);
			btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
					("/img/MiniSalvar.png")));
			btnGravar.setText("Gravar");
			btnGravar.setActionCommand("Incluir");
			telaInserirFornecedor();
		});
		
		btnExcluir.addActionListener(e -> {
			btnGravar.setEnabled(true);
			btnGravar.setText("Excluir");
			btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
					("/img/trash.png")));
			btnGravar.setActionCommand("Excluir");
			telaAlterarExcluirFornecedor();
		});
		
		btnLupaPesquisar.addActionListener(e -> {
			control = new CtrlFornecedor();
			lista = new ArrayList<Fornecedor>();
			try {
				lista = control.buscaFornecedorPorNome(txtNome.getText());
				if (!lista.isEmpty()) {
					modelo = new ModeloTabela(lista);
					table.getTableHeader().setReorderingAllowed(false);
					table.setModel(modelo);
				}else{
					JOptionPane.showMessageDialog(null, "Nenhum registro encontrado",
							"Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
				
			} catch (NullPointerException e1) {
				System.out.println("NullPointer");
			} catch (SQLException e2) {
				System.out.println("ERRO - SQL");
			}
			limpaCampos();
		});
		
		btnLimpar.addActionListener(l -> limpaCampos() );
		
		btnGravar.addActionListener(e -> {
			if (!validaCampos()) {
				String cmd = e.getActionCommand();
				acaoGravar(cmd);
			}else{
				JOptionPane.showMessageDialog(null, "Digite nome e telefone para gravar",
						"Aviso", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
	}
	
	/**
	 * Método para validação dos campos
	 * @return true se campos vazios, false se campos preenchidos
	 */
	private boolean validaCampos() {
		return txtNome.getText().isEmpty() || txtTelefone.getText().isEmpty();
	}
	
	/**
	 * Método chamado para invocar uma ação ao botão pressionado
	 * @param cmd recebe um comando ao qual será chamado uma ação
	 */
	private void acaoGravar(String cmd) {
		Fornecedor f = new Fornecedor();
		control = new CtrlFornecedor();
		if("Alterar".equalsIgnoreCase(cmd)){
			f.setId(id);
			f.setNome(txtNome.getText());
			f.setTelefone(Integer.parseInt(txtTelefone.getText()));
			control.atualiza(f);
		}else if("Incluir".equalsIgnoreCase(cmd)){
			f.setIdTipo(4);
			f.setNome(txtNome.getText());
			f.setTelefone(Integer.parseInt(txtTelefone.getText()));
			control.inserir(f);
		}else if("Excluir".equalsIgnoreCase(cmd)){
			f.setId(id);
			f.setNome(txtNome.getText());
			f.setTelefone(Integer.parseInt(txtTelefone.getText()));
			control.excluir(f);
		}
		limpaCampos();
	}

	/**
	 * Método para montar a tela para alteração e exclusão
	 * de um fornecedor
	 */
	private void telaAlterarExcluirFornecedor() {
		btnLupaPesquisar.setVisible(true);
		txtNome.setVisible(true);
		txtTelefone.setVisible(true);
		lblNome.setVisible(true);
		lblTelefone.setVisible(true);
		btnGravar.setVisible(true);
		btnLimpar.setVisible(true);
		btnVoltar.setVisible(true);
		lblLogo.setVisible(false);
		lblTiraVermelha2.setVisible(false);
		lblTiraCinza2.setVisible(false);
		label.setVisible(false);
		scrollPane.setVisible(true);
		table.setVisible(true);
		
	}

	/**
	 * Método para limpar os campos
	 */
	private void limpaCampos() {
		txtNome.setText("");
		txtTelefone.setText("");
	}

	/**
	 * Método para montar a tela para inserção de um novo
	 * fornecedor
	 */
	private void telaInserirFornecedor(){
		btnLupaPesquisar.setVisible(false);
		txtNome.setVisible(true);
		txtTelefone.setVisible(true);
		lblNome.setVisible(true);
		lblTelefone.setVisible(true);
		btnGravar.setVisible(true);
		btnLimpar.setVisible(true);
		btnVoltar.setVisible(true);
		lblLogo.setVisible(false);
		lblTiraVermelha2.setVisible(false);
		lblTiraCinza2.setVisible(false);
		label.setVisible(false);
	}
	
	/**
	 * Método chamado quando ocorre um clique na tabela
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		Object[] valores = new Object[2];
		int linha = table.getSelectedRow();
		int coluna = table.getSelectedColumn();
		
		for (coluna = 0; coluna < table.getColumnCount(); coluna++) {
			valores[coluna] = table.getValueAt(linha, coluna);
		}
		
			id = lista.get(linha).getId();
			txtNome.setText( String.valueOf(valores[0]));
			txtTelefone.setText(String.valueOf(valores[1]));

	}
	
}
