package entity;

public class Agenda {
	
	private String horario;
	private Boolean escolhaHorario;
	private int auxiliar;
	private String descricao;
	private Servico servico;
	private Cliente cliente;
	
	@Coluna(nome="Serviço", posicao=1)
	public Boolean getEscolhaHorario() {
		return escolhaHorario;
	}
	public void setEscolhaHorario(Boolean escolhaHorario) {
		this.escolhaHorario = escolhaHorario;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	

	@Coluna(nome="Tipo de Serviço", posicao=2)
	public String getDescricao() {
		return this.servico == null ? "" : this.servico.getNome();
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
	public int getAuxiliar() {
		return auxiliar;
	}
	
	public void setAuxiliar(int auxiliar) {
		if(this.auxiliar == 0){
			setEscolhaHorario(new Boolean(false));
		} else {
			setEscolhaHorario(new Boolean(true));
			System.out.println("true");
		}
	}
	
	@Override
	public String toString() {
		return this.horario;
	}
	
	

}
