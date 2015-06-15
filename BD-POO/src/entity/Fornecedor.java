package entity;

/**
 * Classe para os objetos do tipo Fornecedor, onde serão contidos
 * os valores e métodos para o mesmo
 * @author Pedro Afonso
 * @author Pedro Zuzi
 *
 */
public class Fornecedor extends Pessoa{
	
	/**
	 * Método para retorno do nome do fornecedor
	 * @return Nome do Fornecedor
	 */
	@Coluna(nome="Nome", posicao=0)
	@Override
	public String getNome() {
		return super.getNome();
	}
	
	/**
	 * Método para retorno do telefone do Fornecedor
	 * @return telefone
	 */
	@Coluna(nome="Telefone", posicao=1)
	@Override
	public int getTelefone() {
		return super.getTelefone();
	}	


}
