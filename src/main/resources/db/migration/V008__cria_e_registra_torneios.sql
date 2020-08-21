CREATE TABLE IF NOT EXISTS torneio(
	id BIGSERIAL PRIMARY KEY,
	nome VARCHAR(250) NOT NULL,
	descricao VARCHAR(500),
	datainicio DATE NOT NULL,
	datafim DATE,
	fk_id_temporada BIGINT NOT NULL,
	fk_id_especie BIGINT NOT NULL,
	FOREIGN KEY(fk_id_temporada) REFERENCES temporada(id),
	FOREIGN KEY(fk_id_especie) REFERENCES especie(id)
);

INSERT INTO torneio(nome, descricao, datainicio, fk_id_temporada, fk_id_especie) VALUES ('TRINCA FERRO FIBRA', 'ETAPA DE TRINCA FERRO FIBRA', '2020-07-01', 1, 1);
INSERT INTO torneio(nome, descricao, datainicio, fk_id_temporada, fk_id_especie) VALUES ('CANARIO TERRA FIBRA', 'ETAPA DE CANARIO TERRA FIBRA', '2020-07-01', 1, 2);
INSERT INTO torneio(nome, descricao, datainicio, fk_id_temporada, fk_id_especie) VALUES ('AZULAO FIBRA', 'ETAPA DE AZULAO FIBRA', '2020-07-01', 1, 3);