package util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public final class TratamentoTextFields extends JTextField{
	private static final long serialVersionUID = 4693065480438008645L;
	
	private int tamanhoMaximo;
	
	public TratamentoTextFields() {
		addKeyListener(new KeyAdapter() {
			@Override
		    public void keyTyped(KeyEvent evt) {
		        apenasLetras(evt);
		    }
		});
	}
	
	public TratamentoTextFields(int maximo) {
	    setTamanhoCaracteres(maximo);
	    
	    addKeyListener(new KeyAdapter() {
	    	 @Override
	    	    public void keyTyped(KeyEvent evt) {
	    	        apenasNumeros(evt);
	    	     }
	    });
	}
	
	public TratamentoTextFields(JTextField txtUsuario) {
		addKeyListener(new KeyAdapter() {
			@Override
		    public void keyTyped(KeyEvent evt) {
		        usuario(evt);
		    }
		});
	}
	
	public TratamentoTextFields(JTextField txtUsuario, int maximo) {
		setTamanhoCaracteres(maximo);
		
	    addKeyListener(new KeyAdapter() {
	    	 @Override
	    	    public void keyTyped(KeyEvent evt) {
	    	        salario(evt);
	    	     }
	    });
	}
	
	private void apenasLetras(KeyEvent e) {
		String caracteres = "1234567890'!@#$%¨&*()_+/\\;.[{}]°ºª§*-+,=<>?|\"";
		
		if (caracteres.contains(e.getKeyChar() + "")) {
			e.consume();
		}
	}
	
	private void apenasNumeros(KeyEvent e) {
		String caracteres = "0987654321";
		if (!caracteres.contains(e.getKeyChar() + "")) {
			e.consume();
		}
		if ((getText().length() >= getTamanhoMaximo())
				&& (getTamanhoMaximo() != -1)) {
			e.consume();
			setText(getText().substring(0, getTamanhoMaximo()));
		}
	}
	
	public static JTextField mascara(JTextField txtField, String mascara) {
		if (mascara.equalsIgnoreCase("cpf")) {
			try {
				MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
				txtField = new JFormattedTextField(maskCpf);
				return txtField;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else if (mascara.equalsIgnoreCase("data")) {
			try {
				MaskFormatter maskCpf = new MaskFormatter("##/##/####");
				txtField = new JFormattedTextField(maskCpf);
				return txtField;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return txtField;
	}
	
	private void salario( KeyEvent e ) {
		String caracteres = "0987654321.,";
		if (getText().contains(".") || getText().contains(",")) {
			caracteres = "0987654321";
		}
		if (!caracteres.contains(e.getKeyChar() + "")) {
			e.consume();
		}
		if ((getText().length() >= getTamanhoMaximo())
				&& (getTamanhoMaximo() != -1)) {
			e.consume();
			setText(getText().substring(0, getTamanhoMaximo()));
		}
	}

	public int getTamanhoMaximo() {
		return tamanhoMaximo;
	}

	public void setTamanhoCaracteres(int tamanhoCaracteres) {
		this.tamanhoMaximo = tamanhoCaracteres;
	}

	private void usuario(KeyEvent e) {
		String caracteres = " '!@#$%¨&*()+/\\;.[{}]°ºª§*´`^~+,=<>?|\"";
		
		if (caracteres.contains(e.getKeyChar() + "")) {
			e.consume();
		}
	}
	
}

