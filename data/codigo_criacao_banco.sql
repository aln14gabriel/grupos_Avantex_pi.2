-- Coloque neste arquivo todo o código de criação do banco de dados

--Criando tabela
CREATE DATABASE academia;

-- Tabela 'membro'
CREATE TABLE membro (
    id INT PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(14) UNIQUE,
    plano VARCHAR(20),
    data_inicio VARCHAR(10)
);

-- Tabela 'funcionario'
CREATE TABLE funcionario (
    id INT PRIMARY KEY,
    nome VARCHAR(100),
    cargo VARCHAR(50),
    salario INT
);

-- Tabela 'aula'
CREATE TABLE aula (
    codigo INT PRIMARY KEY,
    nome VARCHAR(50),
    horario VARCHAR(5),
    capacidade INT
);

-- Tabela 'pagamento'
CREATE TABLE pagamento (
    id INT PRIMARY KEY,
    membro_id INT,
    valor INT,
    status VARCHAR(20),
    FOREIGN KEY (membro_id) REFERENCES membro(id)
);

-- Tabela 'equipamento'
CREATE TABLE equipamento (
    id INT PRIMARY KEY,
    nome VARCHAR(50),
    status VARCHAR(20)
);
