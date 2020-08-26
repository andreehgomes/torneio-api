CREATE TABLE IF NOT EXISTS associacao_criador (
	id BIGSERIAL PRIMARY KEY,
	fk_id_associacao BIGINT,
	fk_id_criador VARCHAR(14),
	adm BOOLEAN,
	ativo BOOLEAN,
	data DATE,
	FOREIGN KEY(fk_id_associacao) REFERENCES associacao(id),
	FOREIGN KEY(fk_id_criador) REFERENCES criador(cpf)
);

INSERT INTO associacao_criador(fk_id_associacao, fk_id_criador, adm, ativo,data) VALUES (1, '07011122241', true, true, '2020-08-26');
INSERT INTO associacao_criador(fk_id_associacao, fk_id_criador, adm, ativo,data) VALUES (1, '07011122242', false, true, '2020-08-26');
INSERT INTO associacao_criador(fk_id_associacao, fk_id_criador, adm, ativo,data) VALUES (1, '07011122243', false, false, '2020-08-26');
INSERT INTO associacao_criador(fk_id_associacao, fk_id_criador, adm, ativo,data) VALUES (1, '07011122244', false, true, '2020-08-26');