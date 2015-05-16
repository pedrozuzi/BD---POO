package boundary;

public enum Comportamento {
	
	AGRESSIVO("Agressivo"), NORMAL("Normal");
	
	private final String COMPORTAMENTO;

	private Comportamento(String comportamento) {
		this.COMPORTAMENTO = comportamento;
	}

	public String getCOMPORTAMENTO() {
		return COMPORTAMENTO;
	}



	

}
