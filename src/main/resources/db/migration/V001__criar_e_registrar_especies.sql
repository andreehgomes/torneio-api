CREATE TABLE IF NOT EXISTS especie(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(150) NOT NULL,
	nomeCientifico VARCHAR(150)
);

INSERT INTO especie(nome) VALUES ('Trinca Ferro');
INSERT INTO especie(nome) VALUES ('Canário Terra');
INSERT INTO especie(nome) VALUES ('Azulão');