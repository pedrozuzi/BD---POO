package entity;

/**
 * Classe para objeto do tipo Funcionario com valores e 
 * tipo do mesmo
 * @author Pedro Afonso
 *
 */
public class Funcionario extends Pessoa{

	private String cpf;
	private double salario;
	
	/**
	 * Método para retorno do salário do funcinário
	 * @return valor do salário'
	 */
	public double getSalario() {
		return salario;
	}
	
	/**
	 * Método para setar o salário do funcionario
	 * @param salario
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	/**
	 * Método para retorno do cpf do funcionário
	 * @return valor do cpf
	 */
	@Coluna(nome="CPF", posicao=1)
	public String getCpf() {
		return cpf;
	}
	
	/**
	 * Método para setar o cpf do funcionário
	 * @param cpf valor do cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	/**
	 * Método para retorno do nome do Funcionário
	 * @return nome do Funcionário
	 */
	@Coluna(nome="Nome", posicao=0)
	@Override
	public String getNome() {
		return super.getNome();
	}
	
	/**
	 * Método para retorno do tipo de id do funcionário
	 * @return tipo do id
	 */
	@Override
	public int getIdTipo() {
		return super.getIdTipo();
	}
	
}
