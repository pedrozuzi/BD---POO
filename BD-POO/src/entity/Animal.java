package entity;


public class Animal {
	
	private int id;
	private String rga;
	private String nome;
	private String raca;
	private String sexo;
	private String especie;
	private String cor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Coluna(nome="RGA", posicao=1)
	public String getRga() {
		return rga;
	}
	public void setRga(String rga) {
		this.rga = rga;
	}
	
	@Coluna(nome="Nome", posicao=0)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Coluna(nome="Raça", posicao=2)
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
	
	@Coluna(nome="Cor", posicao=5)
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	@Coluna(nome="Sexo", posicao=4)
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	@Coluna(nome="Espécie", posicao=3)
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}

}
