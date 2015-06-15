package entity;

/**
 * Classe para os objetos do tipo agenda, onde serão contidos
 * os valores e métodos para o mesmo
 * @author Pedro Zuzi
 *
 */
public class Agenda {
	
	private String horario;
	private Boolean escolhaHorario;
	private Servico servico;
	private Cliente cliente;
	private int auxiliar;
	
	/**
	 * Método para retorno da escolha do horário
	 * @return Horário escolhido
	 */
	@Coluna(nome="Serviço", posicao=1)
	public Boolean getEscolhaHorario() {
		return escolhaHorario;
	}
	
	/**
	 * Método para setar o valor da escolha do horário
	 * @param escolhaHorario
	 */
	public void setEscolhaHorario(Boolean escolhaHorario) {
		this.escolhaHorario = escolhaHorario;
	}
	
	/**
	 * Método para retorno do objeto Cliente
	 * @return Um Objeto cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	
	/**
	 * Método para setar o objeto cliente
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	

	/**
	 * Método para retorno do horário
	 * @return horario
	 */
	@Coluna(nome="Horário", posicao=0)
	public String getHorario() {
		return horario;
	}

	/**
	 * Método para setar o horário
	 * @param horario
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	/**
	 * 
	 * @return auxiliar
	 */
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
	
	/**
	 * Método para retorno do horário formatado
	 */
	@Override
	public String toString() {
		return this.horario;
	}
	
	/**
	 * Método para retorno do objeto serviço
	 * @return Objeto serviço
	 */
	public Servico getServico() {
		return servico;
	}
	
	/**
	 * Métod para setar o objeto serviço
	 * @param servico
	 */
	public void setServico(Servico servico) {
		this.servico = servico;
	}
}
