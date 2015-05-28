package boundary;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.ConfigTelas;

public class FrmAnimal {
	
	private JFrame janela; 
	private JPanel panPrincipal;
	private JPanel panel;
	
	public FrmAnimal() {
		janela = new JFrame("Cliente");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setLayout(null);
		
		janela.setSize(753,624);
		janela.setContentPane( panPrincipal );
		ConfigTelas.centralizarFrame( janela );
	}
	
	public static void main(String[] args) {
		new FrmAnimal();
	}

}
