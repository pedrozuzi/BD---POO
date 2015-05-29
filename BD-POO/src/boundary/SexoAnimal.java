package boundary;

public enum SexoAnimal {
	
	MACHO("M"), FEMEA("F");
	
	private final String SEXO;
	
	private SexoAnimal(String sEXO) {
		SEXO = sEXO;
	}
	
	public String getSEXO() {
		return SEXO;
	}

}
