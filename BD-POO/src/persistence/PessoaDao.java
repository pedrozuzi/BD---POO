package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Pessoa;

public interface PessoaDao {
	int inserePessoa(Pessoa pes) throws SQLException;

	void atualizaPessoa(Pessoa pes) throws SQLException;

	void excluiPessoa(Pessoa pes) throws SQLException;

	Pessoa consultaPessoa(Pessoa pes) throws SQLException;

	List<Pessoa> listaPessoa() throws SQLException;
}
