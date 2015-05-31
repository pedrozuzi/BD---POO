package entity;

public class Funcionario extends Pessoa{

	private String cpf;
	private double salario;
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	@Coluna(nome="CPF", posicao=1)
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@Coluna(nome="Nome", posicao=0)
	@Override
	public String getNome() {
		return super.getNome();
	}
//	@Coluna(nome="Cargo", posicao=2)
//	@Override
//	public int getIdTipo() {
//		return super.getIdTipo();
//	}
}
