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


# inserindo amigos na BD
INSERT INTO tb_amigos(id,nome,telefone,email) VALUES (1,"Mateus","123456789","emaildomateus@gmail.com");
INSERT INTO tb_amigos(id,nome,telefone,email) VALUES (2,"Maria","987654321","emaildamaria@gmail.com");

# inserindo ferramentas na BD
INSERT INTO tb_ferramentas(IdFerramentas,NomeFerramentas,MarcaFerramentas,CustoFerramentas,DisponibilidadeFerramentas) VALUES (1,"Cortador de Grama","Tramontina","199.99", true);
INSERT INTO tb_ferramentas(IdFerramentas,NomeFerramentas,MarcaFerramentas,CustoFerramentas,DisponibilidadeFerramentas) VALUES (2,"Martelo","Vonder","59.99", true);

# inserindo emprestimos na BD
INSERT INTO tb_emprestimos(IdEmprestimo,NomeAmigo,IdFerramentas,DataEmprestimo) VALUES (1,NULL,NULL,NULL);
INSERT INTO tb_emprestimos(IdEmprestimo,NomeAmigo,IdFerramentas,DataEmprestimo) VALUES (2,NULL,NULL,NULL);
