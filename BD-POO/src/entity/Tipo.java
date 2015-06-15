package entity;

/**
 * Classe para os objetos do tipo Tipo, com seus valores
 * e métodos
 * @author Pedro Afonso
 *
 */
public class Tipo {

	private int id;
	private String descricao;

	/**
	 * Método para retorno no id do tipo
	 * @return valor do id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Método para setar o valor do id 
	 * @param id valor do id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Método para retorno da descrição do tipo
	 * @return descrição do tipo
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Método para setar 
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
