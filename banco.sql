CREATE DATABASE IF NOT EXISTS db_a3;

USE db_a3;

DROP TABLE IF EXISTS tb_amigos;
DROP TABLE IF EXISTS tb_ferramentas;
DROP TABLE IF EXISTS tb_emprestimos;


# criando a tabela dos amigos
CREATE TABLE tb_amigos (
    id INTEGER NOT NULL,
    nome VARCHAR(100) NULL,
    telefone INTEGER NULL,
    email VARCHAR(100),
    PRIMARY KEY(id)
);

# criando tabela das ferramentas
CREATE TABLE tb_ferramentas (
    IdFerramentas INTEGER NOT NULL,
    NomeFerramentas VARCHAR(100) NULL,
    MarcaFerramentas VARCHAR(100) NULL,
    CustoFerramentas DOUBLE,
    DisponibilidadeFerramentas BOOLEAN NULL,
    PRIMARY KEY(IdFerramentas)
);

# criando tabela dos emprestimos 
CREATE TABLE tb_emprestimos (
    IdEmprestimo INTEGER NOT NULL,
    NomeAmigo VARCHAR(100) NULL,
    IdFerramentas INTEGER NULL ,
    DataEmprestimo DATE NULL,
    PRIMARY KEY(idEmprestimo)
);
