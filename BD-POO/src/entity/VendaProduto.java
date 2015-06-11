package entity;

import java.util.Date;

public final class VendaProduto {

	private Date data;
	private int idvenda;
	private int idproduto;
	private int quantidade;

	@Coluna(nome = "data", posicao = 0)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Coluna(nome = "idvenda", posicao = 1)
	public int getIdvenda() {
		return idvenda;
	}

	public void setIdvenda(int idvenda) {
		this.idvenda = idvenda;
	}

	@Coluna(nome = "idproduto", posicao = 2)
	public int getIdproduto() {
		return idproduto;
	}

	public void setIdproduto(int idproduto) {
		this.idproduto = idproduto;
	}

	@Coluna(nome = "idquantidade", posicao = 3)
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
