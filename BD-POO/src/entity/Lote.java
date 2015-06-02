package entity;

import java.sql.Date;

/**
 * 
 * @author Hury
 *
 */

/*
 * create table lote( id int identity not null, data_validade datetime not null
 * primary key(id))
 */
public class Lote {

	private int id;
	private Date data_validade;

	@Coluna(nome="id", posicao=0)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Coluna(nome="data_validade", posicao=1)
	public Date getData_validade() {
		return data_validade;
	}

	public void setData_validade(Date data_validade) {
		this.data_validade = data_validade;
	}

}
