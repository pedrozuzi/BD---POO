package entity;

/**
 * Classe para os objetos do tipo Pessoa, onde serão contidos
 * os valores e métodos para o mesmo
 * @author Pedro Afonso
 *
 */
public class Pessoa {
	
	private int id;
	private int idTipo;
	private int telefone;
	private String nome;
	
	/**
	 * Método para retorno do id
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Método para setar o valor do id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Método para retorno do idTipo da pessoa
	 * @return tipo do id da pessoa
	 */
	public int getIdTipo() {
		return idTipo;
	}
	
	/**
	 * Método para setar o valor do tipo de id da pessoa
	 * @param idTipo
	 */
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	
	/**
	 * Método para retorno do nome da pessoa
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Método para setar o nome da pessoa
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Método para retorno do telefone da pessoa
	 * @return telefone
	 */
	public int getTelefone() {
		return telefone;
	}
	
	/**
	 * Método para setar o telefone da pessoa
	 * @param telefone
	 */
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

}
