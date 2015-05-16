package boundary;

public enum Comportamento {
	
	AGRESSIVO("Agressivo"), NORMAL("Normal");
	
	private final String COMPORTAMENTO;

	private Comportamento(String nome) {
		this.COMPORTAMENTO = nome;
	}

	public String getNome() {
		return COMPORTAMENTO;
	}

	

}
