package entity;

import java.util.List;

/**
 * Classse para o objeto do tipo cliente com valores 
 * do mesmo
 * @author Pedro Afonso
 *
 */
public class Cliente extends Pessoa{

	private String logradouro;
	private int numero;
	private String bairro;
	private String cpf;
	private List<Animal> listaAnimal;
	
	/**
	 * Método para retorno do nome do cliente
	 */
	@Override
	public String getNome() {
		return super.getNome();
	}
	
	/**
	 * Método para retorno no logradouro do cliente
	 * @return nome do logradouro
	 */
	@Coluna(nome="Logradouro", posicao=2)
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * Método para setar o nome do logradouro
	 * @param logradouro nome do logradouro
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * Método para retorno do numero do logradouro
	 * do cliente
	 * @return número do logradouro
	 */
	@Coluna(nome="Número", posicao=3)
	public int getNumero() {
		return numero;
	}

	/**
	 * Método para setar o numero do logradouro
	 * do cliente
	 * @param numero do logradouro
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * Método para retonro do bairro do cliente
	 * @return nome do bairro
	 */
	@Coluna(nome="Bairro", posicao=4)
	public String getBairro() {
		return bairro;
	}

	/**
	 * Método para setar o nome do bairro do cliente
	 * @param bairro nome do bairro
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * Método para retorno do cpf do cliente
	 * @return valor do cpf
	 */
	@Coluna(nome="CPF", posicao=1)
	public String getCpf() {
		return cpf;
	}

	/**
	 * Método para 
	 * @param cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * 
	 */
	@Coluna(nome="Telefone", posicao=5)
	@Override
	public int getTelefone() {
		return super.getTelefone();
	}

	/**
	 * Método para retorno da lista de animal do 
	 * cliente
	 * @return lista de animal
	 */
	public List<Animal> getListaAnimal() {
		return listaAnimal;
	}

	/**
	 * Método para setar a lista de animais
	 * @param listaAnimal de animais do cliente
	 */
	public void setListaAnimal(List<Animal> listaAnimal) {
		this.listaAnimal = listaAnimal;
	}
	
	/**
	 * Método para escrever na instância do cliente seu
	 * nome
	 */
	@Override
	public String toString() {
		return super.getNome();
	}

}
