package boundary;

public enum Especie {
	
	CACHORRO("Cachorro"), GATO("Gato");
	
	private final String especie;

	private Especie(String nome) {
		this.especie = nome;
	}

	public String getNome() {
		return especie;
	}
	
	

}
