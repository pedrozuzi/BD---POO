package boundary;

public enum Comportamento {
	
	AGRESSIVO("Agressivo"), NORMAL("Normal");
	
	private final String comportamento;

	private Comportamento(String nome) {
		this.comportamento = nome;
	}

	public String getNome() {
		return comportamento;
	}

	

}
