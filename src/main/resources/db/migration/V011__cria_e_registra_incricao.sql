CREATE TABLE IF NOT EXISTS inscricao (
	id BIGSERIAL PRIMARY KEY,
	fk_id_torneio BIGINT,
	fk_id_criador VARCHAR,
	fk_id_ave BIGINT,
	data TIMESTAMP,
	FOREIGN KEY(fk_id_torneio) REFERENCES torneio(id),
	FOREIGN KEY(fk_id_criador) REFERENCES criador(cpf),
	FOREIGN KEY(fk_id_ave) REFERENCES ave(id)
);

INSERT INTO inscricao(fk_id_torneio, fk_id_criador, fk_id_ave, data) VALUES(1, '07011122241', 1, '2020-11-01 10:00:00');
INSERT INTO inscricao(fk_id_torneio, fk_id_criador, fk_id_ave, data) VALUES(1, '07011122242', 4, '2020-11-01 10:01:00');
INSERT INTO inscricao(fk_id_torneio, fk_id_criador, fk_id_ave, data) VALUES(1, '07011122243', 7, '2020-11-01 10:05:00');
INSERT INTO inscricao(fk_id_torneio, fk_id_criador, fk_id_ave, data) VALUES(2, '07011122241', 2, '2020-11-01 10:10:00');
INSERT INTO inscricao(fk_id_torneio, fk_id_criador, fk_id_ave, data) VALUES(2, '07011122242', 5, '2020-11-01 10:22:00');
INSERT INTO inscricao(fk_id_torneio, fk_id_criador, fk_id_ave, data) VALUES(2, '07011122243', 8, '2020-11-01 10:26:00');
INSERT INTO inscricao(fk_id_torneio, fk_id_criador, fk_id_ave, data) VALUES(3, '07011122241', 3, '2020-11-01 10:35:00');
INSERT INTO inscricao(fk_id_torneio, fk_id_criador, fk_id_ave, data) VALUES(3, '07011122242', 6, '2020-11-01 10:45:00');