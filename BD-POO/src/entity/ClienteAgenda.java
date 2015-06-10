package entity;

public class ClienteAgenda {
	
	private Cliente cliente;
	private Animal animal;
	private String hora;
	
	@Coluna(nome="Cliente", posicao=0)
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Coluna(nome="Animal", posicao=1)
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	@Coluna(nome="Hora Marcada", posicao=2)
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}

}
