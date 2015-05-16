package boundary;

public enum Especie {
	
	CACHORRO("Cachorro"), GATO("Gato");
	
	private final String ESPECIE;

	private Especie(String especie) {
		this.ESPECIE = especie;
	}

	public String getESPECIE() {
		return ESPECIE;
	}


	
	

}
