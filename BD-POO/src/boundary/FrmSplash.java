package boundary;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import control.ConfiguracoesTela;

import javax.swing.ImageIcon;

public class FrmSplash extends JFrame {

	private JPanel contentPane;
	private JFrame janela;

	public FrmSplash() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 290); // 450,300
		contentPane = new JPanel();
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		contentPane.setOpaque(true);

		centralizeFrame();

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmSplash.class
				.getResource("/img/splash.png")));
		lblNewLabel.setBounds(-3, 0, 503, 290);
		contentPane.add(lblNewLabel);

	}


	public static void main(String[] args) {
		FrmSplash frame = new FrmSplash();
		frame.setVisible(true);

		try {

			Thread.sleep(3000);

			new FrmLogin();
			frame.dispose();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void centralizeFrame() {
		int x, y;
		Rectangle scr = this.getGraphicsConfiguration().getBounds();
		Rectangle form = this.getBounds();
		x = (int) (scr.getWidth() - form.getWidth()) / 2;
		y = (int) (scr.getHeight() - form.getHeight()) / 2;
		this.setLocation(x, y);

	}
}
