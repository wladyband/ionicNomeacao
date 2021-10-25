CREATE TABLE comissao_nomeacao (
    codigo SERIAL,
    nome VARCHAR(50) NOT NULL,
    voto integer NOT NULL,
    PRIMARY KEY(codigo)
);
