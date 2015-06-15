package entity;

/**
 * Classe para objeto do tipo venda com seus valores 
 * e tipos
 * @author Hury
 *
 */

public class Venda {

	private int id;
	private int idcliente;
	private int idfuncionario;
	private double total;
	
	/**
	 * Método para retorno do id da venda
	 * @return valor do id
	 */
	@Coluna(nome = "id", posicao = 0)
	public int getId() {
		return id;
	}
	
	/**
	 * Método para setar o id da venda
	 * @param id valor do id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Método para retorno do id do cliente
	 * @return valor do id
	 */
	@Coluna(nome = "idcliente", posicao = 1)
	public int getIdcliente() {
		return idcliente;
	}
	
	/**
	 * Método para setar o valor do id do cliente
	 * @param idcliente valor do id
	 */
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	
	/**
	 * Método para retorno do id do funcionario
	 * @return valor do id
	 */
	@Coluna(nome = "idfuncionario", posicao = 2)
	public int getIdfuncionario() {
		return idfuncionario;
	}
	
	/**
	 * Método para setar o 
	 * @param idfuncionario
	 */
	public void setIdfuncionario(int idfuncionario) {
		this.idfuncionario = idfuncionario;
	}
	
	/**
	 * Método para retorno do total da venda
	 * @return valor total 
	 */
	@Coluna(nome = "total", posicao = 3)
	public double getTotal() {
		return total;
	}
	
	/**
	 * Método para setar o total da venda
	 * @param total valor total
	 */
	public void setTotal(double total) {
		this.total = total;
	}


}
