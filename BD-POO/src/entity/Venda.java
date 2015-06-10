package entity;

import java.sql.Date;

/**
 * 
 * @author Hury
 *
 * @Entity
 */

public class Venda {

	private int codVenda;
	private Date data;

	@Coluna(nome = "codvenda", posicao = 0)
	public int getCodVenda() {
		return codVenda;
	}

	public void setCodVenda(int codVenda) {
		this.codVenda = codVenda;
	}

	// @Coluna()
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
