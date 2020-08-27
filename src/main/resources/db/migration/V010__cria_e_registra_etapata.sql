CREATE TABLE IF NOT EXISTS etapa (
	id BIGSERIAL PRIMARY KEY,
	descricao VARCHAR(250),
	data TIMESTAMPTZ,
	fk_id_torneio BIGINT,
	fk_id_endereco BIGINT,
	FOREIGN KEY(fk_id_torneio) REFERENCES torneio(id),
	FOREIGN KEY(fk_id_endereco) REFERENCES endereco(id)
);

INSERT INTO etapa(descricao, data, fk_id_torneio, fk_id_endereco) VALUES ('ETAPA 1', '2020-10-26 10:00:00.000000-03:00', 1, 1);
INSERT INTO etapa(descricao, data, fk_id_torneio, fk_id_endereco) VALUES ('ETAPA 2', '2020-11-07 10:00:00.000000-03:00', 1, 1);
INSERT INTO etapa(descricao, data, fk_id_torneio, fk_id_endereco) VALUES ('ETAPA 3', '2020-11-14 10:00:00.000000-03:00', 1, 1);
INSERT INTO etapa(descricao, data, fk_id_torneio, fk_id_endereco) VALUES ('ETAPA 4', '2020-11-21 10:00:00.000000-03:00', 1, 1);