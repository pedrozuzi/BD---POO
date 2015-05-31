package entity;

/**
 * 
 * @author Hury
 *
 */
public class Pessoa {
	
	private int id;
	private String nome;
	private int idTipo;
	private int telefone;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	@Coluna(nome="Nome", posicao=0)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Coluna(nome="Telefone", posicao=1)
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

}
