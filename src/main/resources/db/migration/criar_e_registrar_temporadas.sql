CREATE TABLE IF NOT EXISTS temporada(
	id BIGSERIAL PRIMARY KEY,
	descricao VARCHAR(250) NOT NULL,
	dataInicio DATE NOT NULL,
	dataFim DATE
)

INSERT INTO temporada (descricao, dataInicio) VALUES ('TEMPORADA 2017', 2017-06-29);
INSERT INTO temporada (descricao, dataInicio) VALUES ('TEMPORADA 2018', 2017-06-29);
INSERT INTO temporada (descricao, dataInicio) VALUES ('TEMPORADA 2017', 2017-06-29);
INSERT INTO temporada (descricao, dataInicio) VALUES ('TEMPORADA 2017', 2017-06-29);