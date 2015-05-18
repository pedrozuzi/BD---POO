package entity;

/**
 * 
 * @author Hury
 *
 */

/*
 * create table produto(
id int identity not null,
nome varchar(60) not null,
descricao varchar(60),
id_fornecedor int not null,
valor_venda int not null,
valor_compra int not null,
id_lote int not null
primary key(id)
foreign key(id_fornecedor) references fornecedor(id),
foreign key(id_lote) references lote(id))
 */

public class Produto {

	
	private int id;
	
}
