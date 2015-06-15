package entity;

/**
 * Classe para objeto do tipo Funcionario com valores e 
 * tipo do mesmo
 * @author x036157
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
	 * 
	 */
	@Coluna(nome="Nome", posicao=0)
	@Override
	public String getNome() {
		return super.getNome();
	}
	
	/**
	 * 
	 */
	@Override
	public int getIdTipo() {
		return super.getIdTipo();
	}
	
}
