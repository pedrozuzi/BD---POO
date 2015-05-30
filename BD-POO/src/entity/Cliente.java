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
public class Cliente extends Pessoa{

	private String logradouro;
	private int numero;
	private String bairro;
	private String cpf;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
