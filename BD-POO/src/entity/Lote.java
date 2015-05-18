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
	private Date datetime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

}
