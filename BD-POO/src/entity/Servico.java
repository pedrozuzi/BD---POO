package entity;

/**
 * Classe para os objetos do tipo Serviço, onde serão contidos
 * os valores e métodos para o mesmo
 * @author Pedro Afonso
 *
 */
public class Servico {

	private int codigo;
	private String nome;
	private int valor;
	private Cliente cliente;
	private Animal animal;
	
	/**
	 * Método para retorno do valor
	 * @return valor
	 */
	public int getValor() {
		return valor;
	}
	
	/**
	 * Método para setar o valor
	 * @param valor
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	/**
	 * Método para retorno do nome do cliente
	 * @return nome do cliente
	 */
	@Coluna(nome="Nome Cliente", posicao=1)
	public String getNomeCliente(){
		return this.cliente.getNome();
	}
	
	/**
	 * Método para retorno do nome do animal
	 * @return nome do animal
	 */
	@Coluna(nome="Nome Animal", posicao=2)
	public String getNomeAnimal(){
		return animal.getNome();
	}
	
	/**
	 * Método para retorno da raça do animal
	 * @return raça do animal
	 */
	@Coluna(nome="Raca Animal", posicao=3)
	public String getRacaAnimal(){
		return animal.getRaca();
	}
	
	/**
	 * Método para retorno do objeto do tipo cliente
	 * @return objeto cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Método para setar o valor do objeto cliente
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	/**
	 * Método para retorno do código do serviço
	 * @return código do serviço
	 */
	@Coluna(nome="Codigo Serviço", posicao=0)
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Método para setar o código do serviço
	 * @param codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Método para retorno do nome do serviço
	 * @return nome do serviço
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método para setar o nome do serviço
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Método para escrever na instância do serviço
	 * seu nome
	 */
	@Override
	public String toString() {
		return this.nome;
	}

	/**
	 * Método para retorno do objeto animal
	 * @return Objeto animal
	 */
	public Animal getAnimal() {
		return animal;
	}

	/**
	 * Método para setar o objeto animal
	 * @param animal
	 */
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
}
