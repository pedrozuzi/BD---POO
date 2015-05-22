package entity;

/**
 * 
 * @author Hury
 *
 */

/*
 * create table cliente( id int not null, nome varchar(60) not null, logradouro
 * varchar(100) not null, numero int not null, bairro varchar(60) not null,
 * senha int null primary key(id), foreign key(id) references pessoa(idPessoa))
 */
public class Cliente {

	private int id;
	private String nome;
	private String logradouro;
	private int numero;
	private String bairro;

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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}
