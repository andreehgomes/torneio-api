CREATE TABLE IF NOT EXISTS temporada(
	id BIGSERIAL PRIMARY KEY,
	fk_id_associacao BIGINT,
	descricao VARCHAR(250) NOT NULL,
	dataInicio DATE NOT NULL,
	dataFim DATE,
	FOREIGN KEY(fk_id_associacao) REFERENCES associacao(id)
);

INSERT INTO temporada (descricao, dataInicio, dataFim, fk_id_associacao) VALUES ('TEMPORADA 2017', '2017-06-29', '2017-12-20', 1);
INSERT INTO temporada (descricao, dataInicio, dataFim, fk_id_associacao) VALUES ('TEMPORADA 2018', '2018-06-29', '2018-12-20', 1);
INSERT INTO temporada (descricao, dataInicio, dataFim, fk_id_associacao) VALUES ('TEMPORADA 2019', '2019-06-29', '2019-12-20', 1);
INSERT INTO temporada (descricao, dataInicio, fk_id_associacao) VALUES ('TEMPORADA 2020', '2020-06-29', 1);