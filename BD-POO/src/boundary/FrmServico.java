package boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.ConfigTelas;
import control.ConfiguracoesTela;
import control.CtrlAnimal;
import control.CtrlCliente;
import control.CtrlServico;
import control.ModeloTabela;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

import entity.Animal;
import entity.Cliente;
import entity.Servico;

public class FrmServico implements MouseListener, ActionListener{
	
	private JFrame janela;
	private JPanel panel;
	private ConfiguracoesTela configTela;
	private JTextField txtCodigoServico;
	private JTextField txtNomeCliente;
	private JTextField txtValor;
	private JTextField txtRaca;
	private JLabel lblCodigoServico;
	private JMenuBar menuBar;
	private JMenu mnPrincipal;
	private JMenuItem mntmMenuPrincipal;
	private JMenuItem mntmLogOff;
	private JPanel panelClienteAnimal;
	private JLabel lblNomeCliente;
	private JButton btnPesquisarCliente;
	private JLabel lblAnimal;
	private JLabel lblRaca;
	private JPanel panelOperacao;
	private JLabel lblNovoServico;
	private JButton btnServicoAgendado;
	private JButton btnNovoServico;
	private JLabel lblServicoAgendado;
	private JLabel lblLogoLudPet;
	private JPanel panelServico;
	private JRadioButton rdbtnBanho;
	private JRadioButton rdbtnTosa;
	private JRadioButton rdbtnBanhoTosa;
	private JLabel lblValor;
	private JButton btnFinalizar;
	private JButton btnCancelar;
	private JButton btnLimpar;
	private int index;
	private int controle = 0;
	private JComboBox<Animal> cbAnimal;
	private ButtonGroup bg;
	private JDialog jd;
	private JPanel panBuscaCliente;
	private JScrollPane scrollPaneBusca;
	private JTable tableBuscaCliente;
	private CtrlCliente controlCliente;
	private List<Cliente> listaCliente;
	private Cliente cliente;
	private List<Animal> listaAnimal;
	private Animal animal;
	private ModeloTabela modelo;
	private Servico servico;
	private List<Servico> listaServico;//= new ArrayList<Servico>();
	private CtrlAnimal controlAnimal;
	private CtrlServico controlServico= new CtrlServico();
	private JTextField txtNomeAnimal;

	public FrmServico() {
		
		janela = new JFrame("Servico");
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		lblCodigoServico = new JLabel("C\u00F3digo Serviço : ");
		lblCodigoServico.setVisible(false);
		lblCodigoServico.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCodigoServico.setBounds(23, 175, 111, 14);
		panel.add(lblCodigoServico);
		
		txtCodigoServico = new JTextField();
		txtCodigoServico.setVisible(false);
		txtCodigoServico.setBackground(SystemColor.info);
		txtCodigoServico.setBounds(132, 173, 63, 20);
		txtCodigoServico.setColumns(10);
		txtCodigoServico.setEditable(false);
		panel.add(txtCodigoServico);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 499, 21);
		panel.add(menuBar);
		
		mnPrincipal = new JMenu("Menu");
		mnPrincipal.setBorderPainted(true);
		menuBar.add(mnPrincipal);
		
		mntmMenuPrincipal = new JMenuItem("Menu Principal");
		mntmMenuPrincipal.setIcon(new ImageIcon(FrmServico.class.getResource("/img/HomeMenu.png")));
		mnPrincipal.add(mntmMenuPrincipal);
		
		mntmLogOff = new JMenuItem("Log Off");
		mntmLogOff.setIcon(new ImageIcon(FrmServico.class.getResource("/img/LogOffMenu.png")));
		mnPrincipal.add(mntmLogOff);
		
		panelClienteAnimal = new JPanel();
		panelClienteAnimal.setVisible(false);
		panelClienteAnimal.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cliente/Animal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelClienteAnimal.setBackground(Color.WHITE);
		panelClienteAnimal.setBounds(10, 219, 460, 106);
		panel.add(panelClienteAnimal);
		panelClienteAnimal.setLayout(null);
		
		lblNomeCliente = new JLabel("Nome Cliente : ");
		lblNomeCliente.setVisible(false);
		lblNomeCliente.setBounds(20, 24, 111, 14);
		panelClienteAnimal.add(lblNomeCliente);
		lblNomeCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setVisible(false);
		txtNomeCliente.setBounds(116, 22, 191, 20);
		txtNomeCliente.setBackground(SystemColor.info);
		txtNomeCliente.setColumns(10);
		panelClienteAnimal.add(txtNomeCliente);
		
		btnPesquisarCliente = new JButton("");
		btnPesquisarCliente.setVisible(false);
		btnPesquisarCliente.setBounds(317, 19, 43, 23);
		panelClienteAnimal.add(btnPesquisarCliente);
		btnPesquisarCliente.setIcon(new ImageIcon(FrmServico.class.getResource("/img/MiniLupa.png")));
		
		lblAnimal = new JLabel("Animal : ");
		lblAnimal.setVisible(false);
		lblAnimal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAnimal.setBounds(20, 59, 68, 14);
		panelClienteAnimal.add(lblAnimal);
		
		cbAnimal = new JComboBox<Animal>();
		cbAnimal.setVisible(false);
		cbAnimal.setMaximumRowCount(10);
		cbAnimal.setBounds(116, 57, 111, 20);
		panelClienteAnimal.add(cbAnimal);
		
		lblRaca = new JLabel("Ra\u00E7a : ");
		lblRaca.setVisible(false);
		lblRaca.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRaca.setBounds(237, 60, 46, 14);
		panelClienteAnimal.add(lblRaca);
		
		txtRaca = new JTextField();
		txtRaca.setVisible(false);
		txtRaca.setBackground(SystemColor.info);
		txtRaca.setBounds(293, 57, 86, 20);
		txtRaca.setColumns(10);
		txtRaca.setEditable(false);
		panelClienteAnimal.add(txtRaca);
		
		txtNomeAnimal = new JTextField();
		txtNomeAnimal.setBackground(SystemColor.info);
		txtNomeAnimal.setBounds(116, 57, 111, 20);
		txtNomeAnimal.setColumns(10);
		txtNomeAnimal.setEditable(false);
		txtNomeAnimal.setVisible(false);
		panelClienteAnimal.add(txtNomeAnimal);
		
		panelServico = new JPanel();
		panelServico.setVisible(false);
		panelServico.setBorder(new TitledBorder(null, "Servi\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelServico.setBackground(Color.WHITE);
		panelServico.setBounds(10, 336, 460, 63);
		panel.add(panelServico);
		panelServico.setLayout(null);
		
		rdbtnBanho = new JRadioButton("Banho");
		rdbtnBanho.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnBanho.setBackground(Color.WHITE);
		rdbtnBanho.setActionCommand("Banho");
		rdbtnBanho.setBounds(49, 21, 109, 23);
		panelServico.add(rdbtnBanho);
		
		rdbtnTosa = new JRadioButton("Tosa");
		rdbtnTosa.setBackground(Color.WHITE);
		rdbtnTosa.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnTosa.setActionCommand("Tosa");
		rdbtnTosa.setBounds(160, 21, 109, 23);
		panelServico.add(rdbtnTosa);
		
		rdbtnBanhoTosa = new JRadioButton("Banho/Tosa");
		rdbtnBanhoTosa.setBackground(Color.WHITE);
		rdbtnBanhoTosa.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnBanhoTosa.setActionCommand("Banho/Tosa");
		rdbtnBanhoTosa.setBounds(271, 21, 109, 23);
		panelServico.add(rdbtnBanhoTosa);
		
		bg = new ButtonGroup();
		bg.add(rdbtnBanho);
		bg.add(rdbtnBanhoTosa);
		bg.add(rdbtnTosa);
		
		lblValor = new JLabel("Valor : ");
		lblValor.setVisible(false);
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblValor.setBounds(318, 427, 56, 14);
		panel.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setVisible(false);
		txtValor.setBackground(SystemColor.info);
		txtValor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtValor.setBounds(384, 425, 86, 20);
		panel.add(txtValor);
		txtValor.setColumns(10);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setVisible(false);
		btnFinalizar.setIcon(new ImageIcon(FrmServico.class.getResource("/img/miniFinalizar.png")));
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFinalizar.setBounds(366, 476, 111, 31);
		panel.add(btnFinalizar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setVisible(false);
		btnCancelar.setIcon(new ImageIcon(FrmServico.class.getResource("/img/MiniX.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(23, 476, 111, 31);
		panel.add(btnCancelar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setVisible(false);
		btnLimpar.setIcon(new ImageIcon(FrmServico.class.getResource("/img/MiniClear.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(187, 476, 111, 31);
		panel.add(btnLimpar);
		
		janela.setSize(503, 570);
		janela.setContentPane(panel);
		
		panelOperacao = new JPanel();
		panelOperacao.setLayout(null);
		panelOperacao.setBorder(new TitledBorder(null, "Opera\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelOperacao.setBackground(Color.WHITE);
		panelOperacao.setBounds(120, 47, 261, 96);
		panel.add(panelOperacao);
		
		lblNovoServico = new JLabel("Novo servi\u00E7o");
		lblNovoServico.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNovoServico.setBounds(22, 67, 87, 17);
		panelOperacao.add(lblNovoServico);
		
		btnServicoAgendado = new JButton("");
		btnServicoAgendado.setIcon(new ImageIcon(FrmServico.class.getResource("/img/CalendarioMedio.png")));
		btnServicoAgendado.setBounds(156, 23, 65, 41);
		btnServicoAgendado.setActionCommand("ServicoAgendado");
		panelOperacao.add(btnServicoAgendado);
		
		btnNovoServico = new JButton("");
		btnNovoServico.setBounds(31, 23, 65, 41);
		btnNovoServico.setActionCommand("NovoServico");
		btnNovoServico.setIcon(new ImageIcon(FrmServico.class.getResource("/img/Insert.png")));
		panelOperacao.add(btnNovoServico);
		
		lblServicoAgendado = new JLabel("Servi\u00E7o agendado");
		lblServicoAgendado.setBounds(137, 65, 124, 20);
		panelOperacao.add(lblServicoAgendado);
		lblServicoAgendado.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblLogoLudPet = new JLabel("");
		lblLogoLudPet.setIcon(new ImageIcon(FrmServico.class.getResource("/img/LogoPetShop100.png")));
		lblLogoLudPet.setBounds(17, 200, 470, 193);
		panel.add(lblLogoLudPet);
		
		configTela = new ConfiguracoesTela();
		configTela.iconeBarra(janela);
		configTela.tamanho(janela);
		
		cliente = new Cliente();
//		servico = new Servico();
//		animal = new Animal();
		
		btnPesquisarCliente.addActionListener(e -> {
			listaCliente = new ArrayList<Cliente>();
			controlCliente = new CtrlCliente();
			controle = 1;
			try {
				listaCliente = controlCliente.buscaClientePorNome(txtNomeCliente
						.getText());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			acaoPesquisarCliente(listaCliente);
		});
		
		btnLimpar.addActionListener(e -> {
			limpaCampos();
		});
		
		btnFinalizar.addActionListener(e -> {
			acaoFinalizar();
		});
		
//		btnCancelar.addActionListener(e -> { //TODO
//			janela.dispose();
//			janela = null;
//			new FrmPrincipal(usuario);
//		});
		
		cbAnimal.addActionListener(e -> {
			acaoComboBox();
		});
		
		mntmLogOff.addActionListener(e -> {
			janela.dispose();
			janela = null;
			new FrmLogin();
		});
		
		mntmMenuPrincipal.addActionListener(e -> {
			janela.dispose();
			janela = null;
		});
		
		btnServicoAgendado.addActionListener(this);
		btnNovoServico.addActionListener(this);
		
	}//FIM CONSTRUTOR

	private void acaoFinalizar() {
		if(!validaCampos()){
			servico.setCodigo( Integer.parseInt(txtCodigoServico.getText()) );
			servico.setCliente( cliente );
			servico.setAnimal( animal );
			servico.setNome( bg.getSelection().getActionCommand() );
			servico.setValor( Integer.parseInt( txtValor.getText() ));
			controlServico.incluirServico(servico);
			int a = JOptionPane.showConfirmDialog(null, "Serviço espera para ser pago", "ERRO", 
					JOptionPane.ERROR_MESSAGE);
			limpaCampos();
		} else {
			JOptionPane.showMessageDialog(null, "Sem dados para processar",
					"Erro", JOptionPane.QUESTION_MESSAGE);
		}
		
	}

	private boolean validaCampos() {
		return txtValor.getText().isEmpty() || txtNomeCliente.getText().isEmpty();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String am = e.getActionCommand();
		limpaCampos();
		controlServico = new CtrlServico();
		lblLogoLudPet.setVisible(false);
		btnCancelar.setVisible(true);
		btnFinalizar.setVisible(true);
		btnLimpar.setVisible(true);
		
		if(am.equalsIgnoreCase("ServicoAgendado")){
			listaServico = new ArrayList<Servico>();
			controlServico = new CtrlServico();
			montarTelaServicoAgendado();
			buscarServicosAgendados();
			controle = 2;
		} else {
			txtCodigoServico.setText( Integer.toString(controlServico.buscarNovaEntrada()) );
			montarTelaNovoServico();			
		}
		
	}
	
	private void buscarServicosAgendados() {
		try{
			listaServico = controlServico.buscarServicosAgendados();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		acaoPesquisarCliente(listaServico);
	}

	private void acaoPesquisarCliente(List<?> lista) {
			
		Class<?> classe = lista.isEmpty() ? null : lista.get(0).getClass();
		
		if(classe != null ){
			if(classe.getName().equalsIgnoreCase("entity.Cliente")){
				jd = new JDialog(janela, "Pesquisar Cliente", true);
			} else {
				jd = new JDialog(janela, "Buscar serviço", true);
			}	
		} else {
			jd = new JDialog(janela, "ERRO", true);
		}

		jd.setSize(600, 300);
		
		panBuscaCliente = new JPanel();
		panBuscaCliente.setBackground(SystemColor.text);
		panBuscaCliente.setForeground(Color.WHITE);
		panBuscaCliente.setLayout(null);
		
		tableBuscaCliente = new JTable();
		tableBuscaCliente.addMouseListener(this);
		tableBuscaCliente.setBorder(new LineBorder(Color.BLACK));
		tableBuscaCliente.setGridColor(Color.BLACK);
		tableBuscaCliente.setShowGrid(true);
		
		scrollPaneBusca = new JScrollPane();
		scrollPaneBusca.getViewport().setBorder(null);
		scrollPaneBusca.setViewportView(tableBuscaCliente);
		scrollPaneBusca.setBounds(jd.getX(), jd.getY(), jd.getWidth(), jd.getHeight());
		panBuscaCliente.add(scrollPaneBusca);
		
		montarTabelaCliente(lista);
		
		jd.setResizable(false);
		jd.setLocationRelativeTo(null);
		jd.setContentPane(panBuscaCliente);
		jd.setVisible(true);
		
	}

	private void montarTabelaCliente(List<?> lista) {
		
		if(!lista.isEmpty()){
			modelo = new ModeloTabela(lista);
			tableBuscaCliente.getTableHeader().setReorderingAllowed(false);
			tableBuscaCliente.setModel(modelo);
		}
		
	}

	private void acaoComboBox() {
		animal = new Animal();
		if(cbAnimal.getItemCount() > 0){
			animal = (Animal) cbAnimal.getSelectedItem();
			txtRaca.setText( animal.getRaca() );
			index = cbAnimal.getSelectedIndex();
		} 
	}
	
	private void limpaCampos() {
		txtNomeCliente.setText("");
		txtRaca.setText("");
		cbAnimal.removeAllItems();
		bg.clearSelection();
		txtValor.setText("");
		txtNomeAnimal.setText("");
	}

	public static void main(String[] args) {
		new FrmServico();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		int linha = tableBuscaCliente.getSelectedRow();
		
		if (controle == 1) {
			listaAnimal = new ArrayList<Animal>();
			controlAnimal = new CtrlAnimal();

			cliente = listaCliente.get(linha);

			try {
				listaAnimal = controlAnimal.buscaCliente(cliente.getId());
				cliente.setListaAnimal(listaAnimal);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			montarComboBox();
			
		} else {
			
			controlServico = new CtrlServico();
			servico = new Servico();
			
			servico = listaServico.get(linha);
			montarTelaAgenda();
			
		}
	
		jd.dispose();
		jd = null;
	}

	private void montarTelaAgenda() {
		txtCodigoServico.setText( String.valueOf(servico.getCodigo()) );
		txtNomeCliente.setText( servico.getCliente().getNome());
		txtRaca.setText( servico.getAnimal().getRaca() );
		txtNomeAnimal.setText( servico.getAnimal().getNome() );
		if( rdbtnBanho.getActionCommand().equalsIgnoreCase(servico.getNome()) )	rdbtnBanho.setSelected(true);
	    else if( rdbtnBanhoTosa.getActionCommand().equalsIgnoreCase(servico.getNome())) rdbtnBanhoTosa.setSelected(true);
		else if( rdbtnTosa.getActionCommand().equalsIgnoreCase(servico.getNome()) ) rdbtnTosa.setSelected(true);
	}

	private void montarComboBox() {
		if(cbAnimal.getItemCount() > 0){
			cbAnimal.removeAllItems();
			txtRaca.setText("");
		}
		if(listaAnimal != null){
			listaAnimal.forEach((m) -> cbAnimal.addItem(m) );
			txtNomeCliente.setText( cliente.getNome() );
		}
	}
	
	private void montarTelaNovoServico() {
		panelServico.setVisible(true);
		panelServico.setEnabled(true);
		panelClienteAnimal.setVisible(true);
		panelClienteAnimal.setEnabled(true);
		txtNomeCliente.setVisible(true);
		txtNomeCliente.setEnabled(true);
		txtValor.setVisible(true);
		txtCodigoServico.setVisible(true);
		txtRaca.setVisible(true);
		txtNomeAnimal.setVisible(false);
		lblNomeCliente.setVisible(true);
		lblNomeCliente.setEnabled(true);
		lblCodigoServico.setVisible(true);
		lblAnimal.setVisible(true);
		lblAnimal.setEnabled(true);
		lblRaca.setVisible(true);
		lblRaca.setEnabled(true);
		lblValor.setVisible(true);
		btnPesquisarCliente.setVisible(true);
		cbAnimal.setVisible(true);
		cbAnimal.setEnabled(true);
		rdbtnBanho.setEnabled(true);
		rdbtnBanhoTosa.setEnabled(true);
		rdbtnTosa.setEnabled(true);
	}

	private void montarTelaServicoAgendado() {
		panelServico.setVisible(true);
		panelServico.setEnabled(false);
		panelClienteAnimal.setVisible(true);
		panelClienteAnimal.setEnabled(false);
		txtNomeCliente.setVisible(true);
		txtNomeCliente.setEnabled(false);
		txtValor.setVisible(true);
		txtCodigoServico.setVisible(true);
		txtNomeAnimal.setEnabled(false);
		txtRaca.setVisible(true);
		txtRaca.setEnabled(false);
		txtNomeAnimal.setVisible(true);
		lblNomeCliente.setVisible(true);
		lblNomeCliente.setEnabled(false);
		lblCodigoServico.setVisible(true);
		lblAnimal.setVisible(true);
		lblAnimal.setEnabled(false);
		lblRaca.setVisible(true);
		lblRaca.setEnabled(false);
		lblValor.setVisible(true);
		btnPesquisarCliente.setVisible(false);
		cbAnimal.setVisible(false);
		rdbtnBanho.setEnabled(false);
		rdbtnBanhoTosa.setEnabled(false);
		rdbtnTosa.setEnabled(false);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {		
	}
}
