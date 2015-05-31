package entity;

public class Fornecedor extends Pessoa{
	
	private String empresa;
	
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


}
