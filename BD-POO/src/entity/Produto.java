package entity;

/**
 * Classe de entidade que possui os atribultos de Produto.
 * @author Hury
 *
 */

public final class Produto {

	private int id;
	private String nome;
	private String descricao;
	private int id_fornecedor;
	private int valor_venda;
	private int valor_compra;
	private int quantidade;


	@Coluna(nome = "id", posicao = 0)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Coluna(nome = "nome", posicao = 1)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Coluna(nome = "descricao", posicao = 2)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Coluna(nome = "id_fornecedor", posicao = 3)
	public int getId_fornecedor() {
		return id_fornecedor;
	}

	public void setId_fornecedor(int id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}

	@Coluna(nome = "valor_venda", posicao = 4)
	public int getValor_venda() {
		return valor_venda;
	}

	public void setValor_venda(int valor_venda) {
		this.valor_venda = valor_venda;
	}

	@Coluna(nome = "valor_compra", posicao = 5)
	public int getValor_compra() {
		return valor_compra;
	}

	public void setValor_compra(int valor_compra) {
		this.valor_compra = valor_compra;
	}

	@Coluna(nome = "quantidade", posicao = 6)
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
