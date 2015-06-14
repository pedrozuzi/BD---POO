package entity;

/**
 * Classe de entidade que possui os atribultos de uma Venda.
 * @author Hury
 *
 */

public class Venda {

	private int id;
	private int idcliente;
	private int idfuncionario;
	private double total;
	
	@Coluna(nome = "id", posicao = 0)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Coluna(nome = "idcliente", posicao = 1)
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	
	@Coluna(nome = "idfuncionario", posicao = 2)
	public int getIdfuncionario() {
		return idfuncionario;
	}
	public void setIdfuncionario(int idfuncionario) {
		this.idfuncionario = idfuncionario;
	}
	
	@Coluna(nome = "total", posicao = 3)
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}


}
