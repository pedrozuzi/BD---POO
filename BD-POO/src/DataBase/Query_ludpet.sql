create database ludpet

use ludpet

create table tipo(
id int identity not null,
descricao varchar(50) not null
primary key(id)) 

INSERT INTO tipo (descricao) VALUES 
('Administrador'), --1
('Atendente'),     --2
('Funcionario'),   --3
('Fornecedor'),    --4
('Cliente')        --5

create table pessoa(
idPessoa int identity not null,
idTipo int not null
primary key(idPessoa),
foreign key(idTipo) references tipo(id))

create table telefone(
numero varchar(9) not null,
idPessoa int not null,
idTipo int not null 
primary key(numero, idPessoa, idTipo)
foreign key(idPessoa) references pessoa(idPessoa),
foreign key(idTipo) references tipo(id))

create table cliente(
id int not null,
nome varchar(60) not null,
logradouro varchar(100) not null,
numero int not null,
bairro varchar(60) not null,
telefone int not null
primary key(id),
foreign key(id) references pessoa(idPessoa))

create table funcionario(
id int not null,
cpf varchar(11) not null,
nome varchar(50) not null,
salario decimal (7,2) not null,
telefone int not null
primary key (id),
foreign key(id) references pessoa(idPessoa))

CREATE TABLE logins(
id int not null,
username varchar(10) unique,
passwor varchar(10),
--primary key(username),
foreign key(id) references funcionario(id))

create table fornecedor(
id int not null,
nome varchar(60) not null,
telefone int not null,
primary key(id),
foreign key(id) references pessoa(idPessoa))

create table venda(
id int identity not null,
id_cliente int not null,
id_funcionario int not null
primary key(id, id_cliente),
foreign key(id_cliente) references cliente(id),
foreign key(id_funcionario) references funcionario(id),)

create table animal(
id int identity not null,
id_cliente int not null,
rga int not null,
nome varchar(60) not null,
raca varchar(50) not null,
especie varchar(50) null,
cor varchar(50) null
primary key (id, id_cliente),
foreign key (id_cliente) references cliente(id))

create table lote(
id int identity not null,
data_validade datetime not null
primary key(id))

create table produto(
id int identity not null,
nome varchar(60) not null,
descricao varchar(60),
id_fornecedor int not null,
valor_venda int not null,
valor_compra int not null,
primary key(id),
foreign key(id_fornecedor) references fornecedor(id),)

create table lote_produto(
idProduto int not null,
idLote int not null,
primary key(idProduto, idLote),
foreign key(idProduto)references produto (id),
foreign key(idLote)references lote (id))

create table venda_produto(
data_venda datetime not null,
id_venda int not null,
id_cliente int not null,
id_produto int not null,
quantidade int not null,
total int not null,
check(data_venda <= getdate()),
primary key(data_venda, id_venda, id_cliente, id_produto),
foreign key(id_venda, id_cliente) references venda(id, id_cliente),
foreign key(id_produto) references produto(id))

create table compra(
id int identity not null,
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
total int not null,
check(data_compra <= getdate()),
primary key(data_compra, id_compra, id_funcionario, id_produto),
foreign key(id_compra, id_funcionario) references compra(id, id_funcionario),
foreign key(id_produto) references produto(id))

INSERT INTO pessoa (idTipo) VALUES
(1), --1 adm
(2), --2 atend
(3), --3 func
(4), --4 forn
(5), --5 cli
(1), --6 adm
(2), --7 atend
(3), --8 func
(4), --9 forn 
(5) --10 cli

INSERT INTO funcionario (id,cpf,nome,salario,telefone) VALUES
(8,11111111111,'Hury Gabriel',99999.99,11111111), --adm
(5,22222222222,'Pedro ZUZI',1200.00,11111111), --atend
(10,33333333333,'Pedro Afonso',850.00,11111111)   --func

INSERT INTO logins (id,username,passwor) VALUES
(8,'hurygg','1234'),
(5,'pedrozz','susi'),
(10,'pedroaa','corinthias')


INSERT INTO fornecedor (id,nome,telefone) VALUES
(4,'burns',11111111),
(9,'aang',22222222)

INSERT INTO cliente (id,nome,logradouro,numero,bairro) VALUES
(5,'Oscar Alho','av 23',157,'se'),
(10,'Paula Tejando','rua cachueira',420,'cracolandia')

INSERT INTO produto (nome,descricao,id_fornecedor,valor_venda,valor_compra) VALUES
('Petimax','ração para cachorro',4,10.00,5.00),
('bonix','ossinhos para cachorro',9,2.00,1.00)

INSERT INTO lote (data_validade) VALUES
('20-06-15'),
('20-07-15'),
('10-08-15'),
('10-09-15')

INSERT INTO lote_produto(idProduto,idLote) VALUES
(1,1),
(1,2),
(2,3),
(2,4)

INSERT INTO lote_produto(idProduto,idLote) VALUES
(5,6)

use master
drop database ludpet

select * from produto
select * from lote

SELECT IDENT_CURRENT('produto');
SELECT IDENT_CURRENT('lote');


select nome as nome, logradouro + ', ' + cast(numero as varchar(9))
	+ ', ' + bairro as endereço_completo, telefone
	from cliente
	order by nome