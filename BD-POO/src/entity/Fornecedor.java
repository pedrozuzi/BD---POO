package entity;

public class Fornecedor extends Pessoa{
	
	private String empresa;
//	private String nome;
//	private int telefone;
	
	
	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	@Coluna(nome="Nome", posicao=0)
	@Override
	public String getNome() {
		return super.getNome();
	}
	
	@Coluna(nome="Telefone", posicao=1)
	@Override
	public int getTelefone() {
		return super.getTelefone();
	}	
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//	
//	@Coluna(nome="Nome", posicao=0)
//	public String getNome() {
//		return nome;
//	}
//	
//	public void setTelefone(int telefone) {
//		this.telefone = telefone;
//	}
//	
//	@Coluna(nome="Telefone", posicao=1)
//	public int getTelefone() {
//		return telefone;
//	}

}
