package entity;

/**
 * Classe para os objetos do tipo Usuário, onde serão contidos
 * os valores e métodos para o mesmo
 * @author Pedro Afonso
 *
 */
public class Usuario {
	
	private String nome;
	private String senha;
	private Funcionario f;

	/**
	 * Método para retorno da senha
	 * @return senha
	 */
	public String getSenha() {
		return senha;
	}
	
	/**
	 * Método para setar o valor da senha
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/**
	 * Método para retorno do objeto Funcionário
	 * @return objeto funcionário
	 */
	public Funcionario getF() {
		return f;
	}
	
	/**
	 * Método para setar o objeto Funcionário
	 * @param f
	 */
	public void setF(Funcionario f) {
		this.f = f;
	}
	
	/**
	 * Método para retorno do nome do usuário
	 * @return nome do Usuário
	 */
	@Coluna(nome="Usuário (Login)", posicao=0)
	public String getNome() {
		return nome;
	}
	
	/**
	 * Método para setar o nome do Usuário
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}
