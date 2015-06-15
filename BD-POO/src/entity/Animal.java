package entity;

/**
 * Classe para o tipo do animal com valores e
 * tipo do mesmo
 * @author Pedro Afonso
 *
 */
public class Animal {
	
	private int id;
	private String rga;
	private String nome;
	private String raca;
	private String sexo;
	private String especie;
	private String cor;

	/**
	 * Método para retorno o valor do id do animal
	 * @return valor do id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Método para setar o id do anil
	 * @param id valor do id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Método para retorno do rga do animal
	 * @return valor do rga
	 */
	@Coluna(nome="RGA", posicao=1)
	public String getRga() {
		return rga;
	}
	
	/**
	 * Método para setar o rga do animal
	 * @param rga valor do rga 
	 */
	public void setRga(String rga) {
		this.rga = rga;
	}
	
	/**
	 * Método para retorno do nome do animal
	 * @return nome no animal
	 */
	@Coluna(nome="Nome", posicao=0)
	public String getNome() {
		return nome;
	}
	
	/**
	 * Método para setar o nome do animal 
	 * @param nome do animal
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Método para retorno do da raça do animal
	 * @return nome da raça
	 */
	@Coluna(nome="Raça", posicao=2)
	public String getRaca() {
		return raca;
	}
	
	/**
	 * Método para setar a raça do animal
	 * @param raca nome da raça
	 */
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	/**
	 * Método para escrever o nome do animal
	 * pela instancia do mesmo
	 */
	@Override
	public String toString() {
		return this.nome;
	}
	
	/**
	 * Método para retorno da cor do animal
	 * @return nome da cor 
	 */
	@Coluna(nome="Cor", posicao=5)
	public String getCor() {
		return cor;
	}
	
	/**
	 * Método para setar a cor do animal
	 * @param cor nome da cor 
	 */
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	/**
	 * Método para retorno do sexo do animal
	 * @return
	 */
	@Coluna(nome="Sexo", posicao=4)
	public String getSexo() {
		return sexo;
	}
	
	/**
	 * Método para setar o sexo do animal
	 * @param sexo nome do sexo
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	/**
	 * Método para retorno da espécie do animal
	 * @return nome da espécie 
	 */
	@Coluna(nome="Espécie", posicao=3)
	public String getEspecie() {
		return especie;
	}
	
	/**
	 * Método para setar o nome da espécie do animal
	 * @param especie nome da espécie
	 */
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	

}
