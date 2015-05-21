package entity;

/**
 * 
 * @author Hury
 *
 */

/*
 * create table produto( id int identity not null, nome varchar(60) not null,
 * descricao varchar(60), id_fornecedor int not null, valor_venda int not null,
 * valor_compra int not null, id_lote int not null primary key(id) foreign
 * key(id_fornecedor) references fornecedor(id), foreign key(id_lote) references
 * lote(id))
 */

public class Produto {

	private int id;
	private String nome;
	private String descricao;
	private int id_fornecedor;
	private int valor_venda;
	private int valor_compra;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId_fornecedor() {
		return id_fornecedor;
	}

	public void setId_fornecedor(int id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}

	public int getValor_venda() {
		return valor_venda;
	}

	public void setValor_venda(int valor_venda) {
		this.valor_venda = valor_venda;
	}

	public int getValor_compra() {
		return valor_compra;
	}

	public void setValor_compra(int valor_compra) {
		this.valor_compra = valor_compra;
	}

}
