package boundary;

import java.awt.Color;
import java.awt.SystemColor;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.CtrlAgenda;
import control.CtrlAnimal;
import control.CtrlCliente;
import control.CtrlServico;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;

import util.ConfiguracoesTela;
import util.ModeloTabela;
import entity.Agenda;
import entity.Animal;
import entity.Cliente;
import entity.Servico;
import entity.Usuario;

public class FrmAgenda extends MouseAdapter {

	private JFrame janela;
	private JPanel panPrincipal;
	private JTable tableAgenda = new JTable();
	private JTextField txtCliente;
	private JButton btnLupaPesquisar;
	private JComboBox<Animal> comboBoxAnimal;
	private JComboBox<String> comboBoxServico;
	private JPanel panel;
	private JDialog jd;
	private JPanel panPrincipalBusca;
	private JTable tableBusca = new JTable();
	private JScrollPane scrollPaneBusca;
	private JButton btnLupaPesquisarBusca;
	private JTextField txtBuscaCliente;
	private CtrlCliente controlCliente;
	private List<Cliente> listaCliente;
	private ModeloTabela modeloAgenda;
	private int idCliente;
	private JScrollPane scrollPaneAgenda;
	private CtrlAnimal controlAnimal;
	private List<Animal> listaAnimal;
	private JButton btnSalvar;
	private CtrlAgenda controlAgenda;
	private List<Agenda> listaAgenda;
	private int idAnimal;
	private CtrlServico controlServico;
	private Agenda agenda;
	private Animal animal;
	private Servico servico;
	private ConfiguracoesTela configTela;
	private JLabel lblAgenda;
	private JLabel lblAnimal;
	private JLabel lblServico;
	private JButton btnEncerrarAgenda;
	private JMenuBar menuBarra;
	private JMenu menu;
	private JMenuItem menuPrincipal;
	private JMenuItem logOff;
	private JLabel lblEncerrarAgenda;

	public FrmAgenda(Usuario u) {
		
		janela = new JFrame("Agenda");
		
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

		
		logOff = new JMenuItem("Log Off");
		logOff.setIcon(new ImageIcon(getClass()
				.getResource("/img/LogOffMenu.png")));
		menu.add(logOff);
		
		logOff.addActionListener(e -> {
			janela.dispose();
			janela = null;
			new FrmLogin();
		});
		
		menuPrincipal.addActionListener(e -> {
			janela.dispose();
			janela = null;
			new FrmPrincipal(u);
		}); 

		lblAgenda = new JLabel("Agenda");
		lblAgenda.setFont(new Font("Arial", Font.BOLD, 16));
		lblAgenda.setBounds(150, 11, 78, 20);
		panPrincipal.add(lblAgenda);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(384, 116, 374, 61);
		panPrincipal.add(panel);
		panel.setLayout(null);

		txtCliente = new JTextField();
		txtCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtCliente.setEnabled(false);
		txtCliente.setBounds(35, 30, 252, 20);
		panel.add(txtCliente);
		txtCliente.setColumns(10);

		btnLupaPesquisar = new JButton("");
		btnLupaPesquisar.setIcon(new ImageIcon(this.getClass()
				.getResource("/img/MiniLupa.png")));
		btnLupaPesquisar.setBounds(297, 27, 63, 25);
		panel.add(btnLupaPesquisar);

		comboBoxAnimal = new JComboBox<Animal>();
		comboBoxAnimal.setBounds(549, 236, 179, 20);
		panPrincipal.add(comboBoxAnimal);

		comboBoxServico = new JComboBox<String>();
		comboBoxServico.addItem("Banho");
		comboBoxServico.addItem("Tosa");
		comboBoxServico.addItem("Banho e Tosa");
		comboBoxServico.setBounds(384, 236, 125, 20);
		panPrincipal.add(comboBoxServico);

		lblAnimal = new JLabel("Animal");
		lblAnimal.setBounds(609, 211, 46, 14);
		panPrincipal.add(lblAnimal);

		lblServico = new JLabel("Tipo de Servi\u00E7o");
		lblServico.setBounds(389, 211, 98, 14);
		panPrincipal.add(lblServico);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(this.getClass().getResource
				("/img/MiniSalvar.png")));
		btnSalvar.setBounds(678, 337, 98, 32);
		panPrincipal.add(btnSalvar);

		tableAgenda = new JTable();
		tableAgenda.addMouseListener(this);
		tableAgenda.setBorder(new LineBorder(Color.BLACK));
		tableAgenda.setGridColor(Color.BLACK);
		tableAgenda.setShowGrid(true);

		scrollPaneAgenda = new JScrollPane();
		scrollPaneAgenda.getViewport().setBorder(null);
		scrollPaneAgenda.setViewportView(tableAgenda);
		scrollPaneAgenda.setBounds(10, 37, 351, 332);
		scrollPaneAgenda.setVisible(true);
		panPrincipal.add(scrollPaneAgenda);

		montarAgenda();

		janela.setSize(807, 430);
		janela.setContentPane(panPrincipal);
		
		btnEncerrarAgenda = new JButton("");
		btnEncerrarAgenda.setIcon(new ImageIcon(this.getClass()
				.getResource("/img/encerrarAgenda.png")));
		btnEncerrarAgenda.setBounds(384, 337, 98, 32);
		panPrincipal.add(btnEncerrarAgenda);
		
		lblEncerrarAgenda = new JLabel("Encerrar Agenda");
		lblEncerrarAgenda.setBounds(384, 322, 103, 14);
		panPrincipal.add(lblEncerrarAgenda);
		configTela = new ConfiguracoesTela();
		configTela.iconeBarra(janela);
		configTela.tamanho(janela);

		btnLupaPesquisar.addActionListener(e -> {
			cliente(jd);
		});

		btnSalvar.addActionListener(e -> {
			String horaServico = horaMarcada();
			if (horaServico != null) {
				if (!validaCampos()) {
					adicionaServicoAgenda();
					atualizaAgenda(horaServico);
					montarAgenda();
					limpaCampos();
					JOptionPane.showMessageDialog(null, 
							"Serviço agendado para as: " + agenda.getHorario());
				}else{
					JOptionPane.showMessageDialog(null, 
							"Defina um cliente e um animal para agendar o serviço");
				}
			}else{
				JOptionPane.showMessageDialog(null, 
						"Escolha um horário para agendar");
			}
		});

		comboBoxAnimal.addActionListener(a -> {
			acaoComboBox();
		});
		
		btnEncerrarAgenda.addActionListener(e -> {
			confirmaEncerrar();
		});

	}
	
	private void confirmaEncerrar(){
		Object[] opcoes = {"Sim", "Não"};
		int escolha = JOptionPane.showOptionDialog(null, ""
				+ "Deseja realmente encerrar a tabela ? \n"
				+ "Ao fazer isso todos os serviços agendados serão excluidos.", 
				"Aviso", JOptionPane.DEFAULT_OPTION, 
				JOptionPane.WARNING_MESSAGE, 
				null, opcoes, opcoes[1]);
			
		if (escolha == JOptionPane.YES_OPTION) {
			encerrarAgenda();
		}
	}

	private void encerrarAgenda() {
		controlAgenda.encerraAgenda();
		montarAgenda();
		
	}

	private boolean validaCampos() {
		return txtCliente.getText().isEmpty() || comboBoxAnimal.getItemCount() == 0;
	}

	private String horaMarcada() {
		int linhasTabela = tableAgenda.getRowCount();
		String horaServico = null;

		for (int linha = 0; linha < linhasTabela; linha++) {
			if (tableAgenda.getValueAt(linha, 1).equals(true)) {
				horaServico = String.valueOf(tableAgenda.getValueAt(linha, 0));
			}
		}
		
		return horaServico;
	}

	private void acaoComboBox() {
		animal = new Animal();
		if (comboBoxAnimal.getItemCount() > 0) {
			animal = (Animal) comboBoxAnimal.getSelectedItem();
			idAnimal = animal.getId();
		}
	}

	private void atualizaAgenda(String horaServico) {
		agenda.setHorario(horaServico);
		controlAgenda.atualizaAgenda(agenda);
	}

	private void adicionaServicoAgenda() {
		agenda = new Agenda();
		servico = new Servico();
		Animal animal = new Animal();
		Cliente cliente = new Cliente();
		controlServico = new CtrlServico();
		servico.setCodigo(controlServico.buscarNovaEntrada());
		animal.setId(idAnimal);
		animal.setNome(String.valueOf(comboBoxAnimal.getSelectedItem()));
		servico.setAnimal(animal);
		cliente.setId(idCliente);
		servico.setCliente(cliente);
		servico.setNome(String.valueOf(comboBoxServico.getSelectedItem()));
		agenda.setCliente(cliente);
		agenda.setServico(servico);

		controlServico.incluiServicoAgenda(servico);
	}

	private void montarAgenda() {
		
		listaAgenda = new ArrayList<Agenda>();
		controlAgenda = new CtrlAgenda();
		listaAgenda = controlAgenda.buscarAgenda();
		
		modeloAgenda = new ModeloTabela(listaAgenda);
		tableAgenda.getTableHeader().setReorderingAllowed(false);
		tableAgenda.setModel(modeloAgenda);

	}

	private void cliente(JDialog jd) {
		
		jd = new JDialog(jd, "Buscar Cliente", true);

		try {
			BufferedImage image = ImageIO.read(this.getClass().getResource(
					"/img/icon.png"));
			jd.setIconImage(image);
		} catch (IOException e) {
			e.printStackTrace();
		}

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
		btnLupaPesquisarBusca.setIcon(new ImageIcon(FrmAnimal.class
				.getResource("/img/MiniLupa.png")));
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

		jd.setContentPane(panPrincipalBusca);
		jd.setSize(580, 280);
		jd.setLocationRelativeTo(null);
		jd.setVisible(true);
	}

	private void buscaCliente() {
		controlCliente = new CtrlCliente();
		listaCliente = new ArrayList<Cliente>();

		try {
			listaCliente = controlCliente.buscaClientePorNome(txtBuscaCliente
					.getText());
			if (!listaCliente.isEmpty()) {
				modeloAgenda = new ModeloTabela(listaCliente);
				tableBusca.getTableHeader().setReorderingAllowed(false);
				tableBusca.setModel(modeloAgenda);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void limpaCampos() {
		txtCliente.setText("");
		comboBoxAnimal.removeAllItems();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object acao = e.getSource();
		Object valorCliente;
		if (tableBusca.equals(acao)) {
			comboBoxAnimal.removeAllItems();
			int linha = tableBusca.getSelectedRow();
			idCliente = listaCliente.get(linha).getId();
			valorCliente = tableBusca.getValueAt(linha, 0);
			txtCliente.setText(String.valueOf(valorCliente));
			buscaAnimaisDoCliente(linha);

		} else if (tableAgenda.equals(acao)) {
			Object[] valores = new Object[2];
			int linha = tableAgenda.getSelectedRow();
			int coluna = tableAgenda.getSelectedColumn();

			for (coluna = 0; coluna < tableAgenda.getColumnCount(); coluna++) {
				valores[coluna] = tableAgenda.getValueAt(linha, coluna);
			}
		}
	}

	private void buscaAnimaisDoCliente(int linha) {
		controlAnimal = new CtrlAnimal();
		listaAnimal = new ArrayList<Animal>();

		try {
			listaAnimal = controlAnimal.buscaAnimal(idCliente);
			if (!listaAnimal.isEmpty()) {
				listaAnimal.forEach(a -> comboBoxAnimal.addItem(a));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
