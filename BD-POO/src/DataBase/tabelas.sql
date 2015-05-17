create database trabalho

use trabalho

create table cliente(
id int identity(1,1) not null,
nome varchar(50)not null,
logradouro varchar(50) not null,
numero int not null,
bairro varchar(50) not null
primary key(id) )

create table funcionario(
id int identity(1,1) not null,
nome varchar(50) not null,
cpf int not null
primary key (id),
)

create table venda(
id int identity(1,1) not null,
id_cliente int not null,
id_funcionario int not null
primary key(id, id_cliente),
foreign key(id_cliente) references cliente(id),
foreign key(id_funcionario) references funcionario(id),
)

create table animal(
id int identity(1,1) not null,
id_cliente int not null,
rga int not null,
nome varchar(50) not null,
raca varchar(50) not null,
especie varchar(50) not null,
cor varchar(50) not null
primary key (id, id_cliente),
foreign key (id_cliente) references cliente(id))

create table telefone(
numero int not null,
id_cliente int not null
primary key(numero, id_cliente),
foreign key(id_cliente) references cliente(id))

create table fornecedor(
id int identity(1,1) not null,
nome varchar(50) not null 
primary key(id))

create table lote(
id int identity(1,1) not null,
data_validade datetime not null
primary key(id))

create table produto(
id int identity(1,1) not null,
id_fornecedor int not null,
valor_venda int not null,
valor_compra int not null,
id_lote int not null
primary key(id)
foreign key(id_fornecedor) references fornecedor(id),
foreign key(id_lote) references lote(id))


create table venda_produto(
data_venda datetime not null,
id_venda int not null,
id_cliente int not null,
id_produto int not null,
quantidade int not null,
total int not null
primary key(data_venda, id_venda, id_cliente, id_produto),
foreign key(id_venda, id_cliente) references venda(id, id_cliente),
foreign key(id_produto) references produto(id))

create table compra(
id int identity(1,1) not null,
id_funcionario int not null,
quantidade int not null,
total int not null
primary key(id, id_funcionario),
foreign key(id_funcionario) references funcionario(id))

create table compra_produto(
data_compra datetime not null,
id_compra int not null,
id_funcionario int not null,
id_produto int not null,
quantidade int not null,
total int not null
primary key(data_compra, id_compra, id_funcionario, id_produto),
foreign key(id_compra, id_funcionario) references compra(id, id_funcionario),
foreign key(id_produto) references produto(id))


