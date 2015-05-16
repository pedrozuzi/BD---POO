package boundary;

public enum Especie {
	
	CACHORRO("Cachorro"), GATO("Gato");
	
	private final String ESPECIE;

	private Especie(String nome) {
		this.ESPECIE = nome;
	}

	public String getNome() {
		return ESPECIE;
	}
	
	

}
