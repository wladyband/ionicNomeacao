CREATE TABLE votar_nomero_membro (
    codigo SERIAL,
    nome VARCHAR(50) NOT NULL,
    valor_voto integer NOT NULL,
    PRIMARY KEY(codigo)
);
