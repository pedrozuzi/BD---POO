package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import control.ConfigTelas;
import control.CtrlAnimal;
import control.CtrlCliente;
import control.ModeloTabela;
import entity.Animal;
import entity.Cliente;

public class FrmAnimal extends MouseAdapter {
	
	private JFrame janelaAnimal;
	private JPanel panPrincipalAnimal;
	private JPanel panelAnimal;
	private JButton btnIncluir;
	private JLabel lblIncluir;
	private JButton btnAlterar;
	private JLabel lblAlterar;
	private JButton btnExcluir;
	private JLabel lblExcluir;
	private JButton btnGravar;
	private JButton btnLimpar;
	private JButton btnVoltar;
	private JButton btnLupaPesquisar;
	private JTextField txtNome;
	private JTextField txtRga;
	private JTextField txtRaca;
	private JTextField txtCor;
	private JTable tableAnimal;
	private JTable tableBusca;
	private JTextField txtCliente;
	private JLabel lblEspecie;
	private JComboBox<String> comboBoxEspecie;
	private JScrollPane scrollPane;
	private JLabel lblRaca;
	private JLabel lblCor;
	private JLabel lblSexo;
	private JLabel lblRga;
	private JComboBox<String> comboBoxSexo;
	private ModeloTabela modelo;
	private CtrlCliente controlCliente;
	private List<Cliente> listaCliente;
	private List<Animal> listaAnimal;
	private JPanel panPrincipalBusca;
	private JScrollPane scrollPaneBusca;
	private JButton btnLupaPesquisarBusca;
	private JTextField txtBuscaCliente;
	private JLabel lblNome;
	private int idCliente;
	private CtrlAnimal controlAnimal;
	private int idAnimal;
	private JDialog jd;
	private JPanel panelCliente;
	private JLabel lblLogo;
	
	public FrmAnimal() {
		janelaAnimal = new JFrame();
		janelaAnimal.setTitle("Animal");
		panPrincipalAnimal = new JPanel();
		panPrincipalAnimal.setBackground(SystemColor.text);
		panPrincipalAnimal.setForeground(Color.WHITE);
		panPrincipalAnimal.setLayout(null);
		
		txtCliente = new JTextField();
		txtCliente.setEnabled(false);
		txtCliente.setVisible(false);
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(37, 277, 546, 199);
		panPrincipalAnimal.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(FrmAnimal.class.getResource
				("/img/LogoLudpet.png")));
		txtCliente.setBounds(145, 301, 238, 20);
		panPrincipalAnimal.add(txtCliente);
		txtCliente.setColumns(10);
		
		panelAnimal = new JPanel();
		panelAnimal.setLayout(null);
		panelAnimal.setForeground(Color.WHITE);
		panelAnimal.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
				"A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelAnimal.setBackground(Color.WHITE);
		panelAnimal.setBounds(112, 11, 343, 79);
		panPrincipalAnimal.add(panelAnimal);
		
		btnIncluir = new JButton("");
		btnIncluir.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/Insert.png")));
		btnIncluir.setBounds(49, 11, 69, 41);
		btnIncluir.setVisible(true);
		panelAnimal.add(btnIncluir);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/Edit.png")));
		btnAlterar.setBounds(143, 11, 69, 41);
		btnAlterar.setVisible(true);
		panelAnimal.add(btnAlterar);
		
		lblAlterar = new JLabel("Alterar");
		lblAlterar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAlterar.setVisible(true);
		lblAlterar.setBounds(162, 54, 44, 19);
		panelAnimal.add(lblAlterar);
		
		btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/Delete.png")));
		btnExcluir.setBounds(232, 11, 69, 41);
		btnExcluir.setVisible(true);
		panelAnimal.add(btnExcluir);
		
		lblExcluir = new JLabel("Excluir");
		lblExcluir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblExcluir.setVisible(true);
		lblExcluir.setBounds(252, 53, 38, 19);
		panelAnimal.add(lblExcluir);
		
		lblIncluir = new JLabel("(F2) Incluir");
		lblIncluir.setBounds(49, 54, 69, 19);
		panelAnimal.add(lblIncluir);
		lblIncluir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblIncluir.setVisible(true);
		
		btnGravar = new JButton("Gravar");
		btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniSalvar.png")));
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravar.setVisible(false);
		btnGravar.setBounds(417, 543, 96, 31);
		panPrincipalAnimal.add(btnGravar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniClear.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(258, 543, 96, 31);
		btnLimpar.setVisible(false);
		panPrincipalAnimal.add(btnLimpar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniBack.png")));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(94, 543, 96, 31);
		btnVoltar.setVisible(false);
		panPrincipalAnimal.add(btnVoltar);
		
		btnLupaPesquisar = new JButton("");
		btnLupaPesquisar.setVisible(false);
		btnLupaPesquisar.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniLupa.png")));
		btnLupaPesquisar.setBounds(417, 290, 65, 31);
		panPrincipalAnimal.add(btnLupaPesquisar);
		
		txtNome = new JTextField();
		txtNome.setVisible(false);
		txtNome.setBounds(157, 369, 238, 20);
		panPrincipalAnimal.add(txtNome);
		txtNome.setColumns(10);
		
		lblNome = new JLabel("Nome: ");
		lblNome.setVisible(false);
		lblNome.setBounds(83, 372, 46, 14);
		panPrincipalAnimal.add(lblNome);
		
		txtRga = new JTextField();
		txtRga.setVisible(false);
		txtRga.setBounds(157, 410, 128, 20);
		panPrincipalAnimal.add(txtRga);
		txtRga.setColumns(10);
		
		lblRga = new JLabel("RGA:");
		lblRga.setVisible(false);
		lblRga.setBounds(83, 410, 46, 14);
		panPrincipalAnimal.add(lblRga);
		
		txtRaca = new JTextField();
		txtRaca.setVisible(false);
		txtRaca.setBounds(157, 448, 138, 20);
		panPrincipalAnimal.add(txtRaca);
		txtRaca.setColumns(10);
		
		lblRaca = new JLabel("Ra\u00E7a:");
		lblRaca.setVisible(false);
		lblRaca.setBounds(83, 451, 46, 14);
		panPrincipalAnimal.add(lblRaca);
		
		lblCor = new JLabel("Cor:");
		lblCor.setVisible(false);
		lblCor.setBounds(315, 451, 46, 14);
		panPrincipalAnimal.add(lblCor);
		
		txtCor = new JTextField();
		txtCor.setVisible(false);
		txtCor.setBounds(358, 448, 86, 20);
		panPrincipalAnimal.add(txtCor);
		txtCor.setColumns(10);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setVisible(false);
		lblSexo.setBounds(83, 485, 46, 14);
		panPrincipalAnimal.add(lblSexo);
		
		lblEspecie = new JLabel("Esp\u00E9cie:");
		lblEspecie.setVisible(false);
		lblEspecie.setBounds(207, 482, 68, 14);
		panPrincipalAnimal.add(lblEspecie);
		
		comboBoxEspecie = new JComboBox<String>();
		comboBoxEspecie.setVisible(false);
		comboBoxEspecie.setBounds(274, 479, 138, 20);
		comboBoxEspecie.addItem("Cachorro");
		comboBoxEspecie.addItem("Gato");	
		panPrincipalAnimal.add(comboBoxEspecie);
			
		comboBoxSexo = new JComboBox<String>();
		comboBoxSexo.setVisible(false);
		comboBoxSexo.setBounds(129, 482, 38, 20);
		comboBoxSexo.addItem(SexoAnimal.MACHO.getSEXO());
		comboBoxSexo.addItem(SexoAnimal.FEMEA.getSEXO());
		panPrincipalAnimal.add(comboBoxSexo);
		
		tableAnimal = new JTable();
		tableAnimal.setVisible(false);
		tableAnimal.addMouseListener(this);
		tableAnimal.setBorder(new LineBorder(Color.BLACK));
		tableAnimal.setGridColor(Color.BLACK);
		tableAnimal.setShowGrid(true);
		
		scrollPane = new JScrollPane();
		scrollPane.setVisible(false);
		scrollPane.getViewport().setBorder(null);
		scrollPane.setViewportView(tableAnimal);
		scrollPane.setBounds(10, 107, 591, 159);
		panPrincipalAnimal.add(scrollPane);
		
		panelCliente = new JPanel();
		panelCliente.setVisible(false);
		panelCliente.setForeground(Color.WHITE);
		panelCliente.setBackground(Color.WHITE);
		panelCliente.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCliente.setBounds(129, 278, 363, 65);
		panPrincipalAnimal.add(panelCliente);
		
		janelaAnimal.setSize(627,656);
		janelaAnimal.setContentPane( panPrincipalAnimal );
		ConfigTelas.centralizarFrame( janelaAnimal );
		
		btnLupaPesquisar.addActionListener(l -> {
			animal(jd);
		});
		
		btnIncluir.addActionListener(l -> {
			btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
					("/img/MiniSalvar.png")));
			btnGravar.setText("Gravar");
			montarTela();
			btnGravar.setActionCommand("Incluir");
		});
		
		btnAlterar.addActionListener(l -> {
			btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
					("/img/MiniSalvar.png")));
			btnGravar.setText("Alterar");
			montarTela();
			btnGravar.setActionCommand("Alterar");
		});
		
		btnExcluir.addActionListener(l -> {
			btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
					("/img/trash.png")));
			btnGravar.setText("Excluir");
			montarTela();
			btnGravar.setActionCommand("Excluir");
		});
		
		btnGravar.addActionListener(e -> {
			String cmd = e.getActionCommand();
			try {
				acaoGravar(cmd);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
	}
	
	private void montarTela() {
		lblLogo.setVisible(false);
		tableAnimal.setVisible(true);
		scrollPane.setVisible(true);
		panelCliente.setVisible(true);
		txtCliente.setVisible(true);
		btnLupaPesquisar.setVisible(true);
		lblNome.setVisible(true);
		txtNome.setVisible(true);
		lblRga.setVisible(true);
		txtRga.setVisible(true);
		comboBoxSexo.setVisible(true);
		comboBoxEspecie.setVisible(true);
		lblSexo.setVisible(true);
		lblEspecie.setVisible(true);
		txtCor.setVisible(true);
		lblCor.setVisible(true);
		txtRaca.setVisible(true);
		lblRaca.setVisible(true);
		btnGravar.setVisible(true);
		btnLimpar.setVisible(true);
		btnVoltar.setVisible(true);
	}

	public  void animal(JDialog jd) {
		jd = new JDialog(jd, "Buscar Cliente", true);
		panPrincipalBusca = new JPanel();
		panPrincipalBusca.setBackground(SystemColor.text);
		panPrincipalBusca.setForeground(Color.WHITE);
		panPrincipalBusca.setLayout(null);
		
		tableBusca = new JTable();
		tableBusca.addMouseListener(this);
		tableBusca.setBorder(new LineBorder(Color.BLACK));
		tableBusca.setGridColor(Color.BLACK);
		tableBusca.setShowGrid(true);
		
		scrollPaneBusca = new JScrollPane();
		scrollPaneBusca.getViewport().setBorder(null);
		scrollPaneBusca.setViewportView(tableBusca);
		scrollPaneBusca.setBounds(10, 64, 539, 159);
		panPrincipalBusca.add(scrollPaneBusca);
		
		btnLupaPesquisarBusca = new JButton("");
		btnLupaPesquisarBusca.setIcon(new ImageIcon(FrmAnimal.class.getResource("/img/MiniLupa.png")));
		btnLupaPesquisarBusca.setBounds(368, 22, 65, 31);
		btnLupaPesquisarBusca.setVisible(true);
		panPrincipalBusca.add(btnLupaPesquisarBusca);
		
		txtBuscaCliente = new JTextField();
		txtBuscaCliente.setBounds(92, 33, 264, 20);
		panPrincipalBusca.add(txtBuscaCliente);
		txtBuscaCliente.setColumns(10);
		
		btnLupaPesquisarBusca.addActionListener(l -> {
			buscaCliente();
		});
		
		jd.setContentPane( panPrincipalBusca );
		jd.setSize(580,280);
		jd.setLocationRelativeTo(null);
		jd.setVisible(true);
		
	}
	
	private void acaoGravar(String cmd) throws SQLException {
		Animal a = new Animal();
		controlAnimal = new CtrlAnimal();
		
		if("Incluir".equalsIgnoreCase(cmd)){
			a.setId(idCliente);
			a.setNome(txtNome.getText());
			a.setRaca(txtRaca.getText());
			a.setCor(txtCor.getText());
			a.setEspecie(String.valueOf(comboBoxEspecie.getSelectedItem()));
			a.setSexo(String.valueOf(comboBoxSexo.getSelectedItem()));
			a.setRga(txtRga.getText());
			controlAnimal.inserir(a);
		}else if ("Alterar".equalsIgnoreCase(cmd)) {
			a.setId(idAnimal);
			a.setNome(txtNome.getText());
			a.setRaca(txtRaca.getText());
			a.setCor(txtCor.getText());
			a.setEspecie(String.valueOf(comboBoxEspecie.getSelectedItem()));
			a.setSexo(String.valueOf(comboBoxSexo.getSelectedItem()));
			a.setRga(txtRga.getText());
			controlAnimal.atualiza(a);
		}else if ("Excluir".equalsIgnoreCase(cmd)) {
			a.setId(idAnimal);
			a.setNome(txtNome.getText());
			a.setRaca(txtRaca.getText());
			a.setCor(txtCor.getText());
			a.setEspecie(String.valueOf(comboBoxEspecie.getSelectedItem()));
			a.setSexo(String.valueOf(comboBoxSexo.getSelectedItem()));
			a.setRga(txtRga.getText());
			controlAnimal.excluir(a);
		}
		
	}

	private void buscaCliente() {
		controlCliente = new CtrlCliente();
		listaCliente = new ArrayList<Cliente>();

			try {
				listaCliente = controlCliente.buscaClientePorNome(txtBuscaCliente.getText());
				if (!listaCliente.isEmpty()) {
					modelo = new ModeloTabela(listaCliente);
					tableBusca.getTableHeader().setReorderingAllowed(false);
					tableBusca.setModel(modelo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		limpaCampos();

	}

	private void limpaCampos() {
	//	txtNome.setText("");
	//	txtCor.setText("");
	//	txtRaca.setText("");
	//	txtRga.setText("");
	
}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object acao = e.getSource();
		Object valorCliente;
		if (tableBusca.equals(acao)) {
			int linha = tableBusca.getSelectedRow();
			idCliente = listaCliente.get(linha).getId();
			valorCliente = tableBusca.getValueAt(linha, 0);
			txtCliente.setText(String.valueOf(valorCliente));
			
			buscaAnimaisDoCliente();
		}
		
		if (tableAnimal.equals(acao)) {
			System.out.println("Tabela animal");
			int linha = tableAnimal.getSelectedRow();
			int coluna = tableAnimal.getSelectedColumn();
			Object[] valoresAnimal = new Object[6];
			
			for (coluna = 0; coluna < tableAnimal.getColumnCount(); coluna++) {
				valoresAnimal[coluna] = tableAnimal.getValueAt(linha, coluna);
			}
			
			idAnimal = listaAnimal.get(linha).getId();
			System.out.println(idAnimal);
			txtNome.setText( String.valueOf(valoresAnimal[0]));
			txtRga.setText( String.valueOf(valoresAnimal[1]));
			txtRaca.setText( String.valueOf(valoresAnimal[2]));
			comboBoxEspecie.setSelectedItem(valoresAnimal[3]);
			comboBoxSexo.setSelectedItem(valoresAnimal[4]);
			txtCor.setText( String.valueOf(valoresAnimal[5]));
		}
	}

	private void buscaAnimaisDoCliente() {
		controlAnimal = new CtrlAnimal();
		listaAnimal = new ArrayList<Animal>();
		
		try {
			listaAnimal = controlAnimal.buscaCliente(idCliente);
			
			if (!listaAnimal.isEmpty()) {
				modelo = new ModeloTabela(listaAnimal);
				tableAnimal.getTableHeader().setReorderingAllowed(false);
				tableAnimal.setModel(modelo);
			}else{
				System.out.println("LISTA VAZIA");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FrmAnimal();
	}
}
