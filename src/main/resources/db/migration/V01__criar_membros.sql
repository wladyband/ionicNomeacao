CREATE TABLE membro (
    codigo SERIAL,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    telefone VARCHAR(50) NOT NULL,
    permissao_grande_comissao integer NULL,
	permissao_comissao integer NULL,
	permissao_voto integer NULL,
	PRIMARY KEY(codigo)
);


INSERT INTO membro (nome, email, telefone) values ('Paulo cesar', 'paulo@gmail.com', '8134342071');
INSERT INTO membro (nome, email, telefone) values ('Paulo testa', 'testa@gmail.com', '8134342071');
INSERT INTO membro (nome, email, telefone) values ('Paulo gilson', 'gilton@gmail.com', '8134342071');