package entity;

import java.util.Date;

public class Agenda {
	
	private String horario;
	private Boolean servico;
	private String descricao;
	
	@Coluna(nome="Serviço", posicao=1)
	public Boolean getServico() {
		return servico;
	}
	
	public void setServico(Boolean boolean1) {
		this.servico = boolean1;
	}
	
	@Coluna(nome="Tipo de Serviço", posicao=2)
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Coluna(nome="Horário", posicao=0)
	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	

}
