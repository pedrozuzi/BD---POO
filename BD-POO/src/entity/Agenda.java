package entity;

public class Agenda {
	
	private String horario;
	private Boolean escolhaHorario;
	private int auxiliar;
	private Cliente cliente;
	
	@Coluna(nome="Serviço", posicao=1)
	public Boolean getEscolhaHorario() {
		return escolhaHorario;
	}
	public void setEscolhaHorario(Boolean escolhaHorario) {
		this.escolhaHorario = escolhaHorario;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
