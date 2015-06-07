package entity;

public class Usuario {
	
	private String nome;
	private String senha;
	private Funcionario f;

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Funcionario getF() {
		return f;
	}
	public void setF(Funcionario f) {
		this.f = f;
	}
	
	@Coluna(nome="Usuário (Login)", posicao=0)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
