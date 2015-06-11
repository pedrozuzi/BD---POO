package entity;

public class Servico {

	private int codigo;
	private String nome;
	private int valor;
	private Cliente cliente;
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	@Coluna(nome="Nome Cliente", posicao=1)
	public String getNomeCliente(){
		return this.cliente.getNome();
	}
	
	@Coluna(nome="Nome Animal", posicao=2)
	public String getNomeAnimal(){
		return cliente.getListaAnimal().get(0).getNome();
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Coluna(nome="Codigo Serviço", posicao=0)
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
	
}
