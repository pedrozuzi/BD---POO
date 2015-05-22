package control;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public final class TratamentoTextFields extends JTextField{
	private static final long serialVersionUID = 4693065480438008645L;
	
	private  int tamanhoMaximo;
	
	public TratamentoTextFields() {
		addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        apenasLetras(evt);
		    }
		});
	}
	
	public TratamentoTextFields(int maximo) {
	    setTamanhoCaracteres(maximo);
	    
	    addKeyListener(new java.awt.event.KeyAdapter() {
	    	 @Override
	    	    public void keyTyped(java.awt.event.KeyEvent evt) {
	    	        apenasNumeros(evt);
	    	     }
	    });
	}
	
	
	private void apenasLetras(KeyEvent e) {
		String caracteres = "1234567890'!@#$%¨&*()_+/\\;.[{}]°*-+,=<>?|";
		
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

	public int getTamanhoMaximo() {
		return tamanhoMaximo;
	}

	public void setTamanhoCaracteres(int tamanhoCaracteres) {
		this.tamanhoMaximo = tamanhoCaracteres;
	}
	
	
}

