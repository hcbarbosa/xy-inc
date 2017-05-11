#CREATE DATABASE xy_inc;
#USE xy_inc;

CREATE TABLE PONTO_INTERESSE (
	id int auto_increment primary key,
	nome varchar(255) not null,
	x int not null,
	y int not null
);

#describe ponto_interesse;

insert into ponto_interesse (nome, x, y) values ('Lanchonete', 27, 12);
insert into ponto_interesse (nome, x, y) values ('Posto', 31, 18);
insert into ponto_interesse (nome, x, y) values ('Joalheria', 15, 12);
insert into ponto_interesse (nome, x, y) values ('Floricultura', 19, 21);
insert into ponto_interesse (nome, x, y) values ('Pub', 12, 8);
insert into ponto_interesse (nome, x, y) values ('Supermercado', 23, 6);
insert into ponto_interesse (nome, x, y) values ('Churrascaria', 28, 2);

#select * from ponto_interesse;

#drop table ponto_interesse;