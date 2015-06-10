package entity;

import java.util.List;

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

	private String nome;
	private String logradouro;
	private int numero;
	private String bairro;
	private String cpf;
	private List<Animal> listaAnimal;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Coluna(nome="Nome", posicao=0)
	public String getNome() {
		return nome;
	}
	
	@Coluna(nome="Logradouro", posicao=2)
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	@Coluna(nome="Número", posicao=3)
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Coluna(nome="Bairro", posicao=4)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Coluna(nome="CPF", posicao=1)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Coluna(nome="Telefone", posicao=5)
	@Override
	public int getTelefone() {
		// TODO Auto-generated method stub
		return super.getTelefone();
	}

	public List<Animal> getListaAnimal() {
		return listaAnimal;
	}

	public void setListaAnimal(List<Animal> listaAnimal) {
		this.listaAnimal = listaAnimal;
	}

}
