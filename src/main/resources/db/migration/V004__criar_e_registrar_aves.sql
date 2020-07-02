CREATE TABLE IF NOT EXISTS ave(
	id BIGSERIAL PRIMARY KEY,
	nome VARCHAR(100),
	fk_id_especie BIGINT,
	fk_id_orgao BIGINT,
	medida_anilha VARCHAR,
	numero_anilha VARCHAR,
	fk_id_criador VARCHAR(14),
	ativo BOOLEAN DEFAULT TRUE,
	data_cadastro TIMESTAMP NOT NULL DEFAULT 'now()',	
	FOREIGN KEY (fk_id_especie) REFERENCES especie(id),
	FOREIGN KEY (fk_id_criador) REFERENCES criador(cpf)
);

INSERT INTO ave (nome, fk_id_especie, medida_anilha, numero_anilha, fk_id_criador) VALUES ('Chefe', 1, '1,5', '1234', '07011122241');
INSERT INTO ave (nome, fk_id_especie, medida_anilha, numero_anilha, fk_id_criador) VALUES ('Boss', 1, '1,5', '1234', '07011122241');
INSERT INTO ave (nome, fk_id_especie, medida_anilha, numero_anilha, fk_id_criador) VALUES ('Pesado', 1, '1,5', '1234', '07011122241');
INSERT INTO ave (nome, fk_id_especie, medida_anilha, numero_anilha, fk_id_criador) VALUES ('Gritador', 2, '1,5', '1234', '07011122242');
INSERT INTO ave (nome, fk_id_especie, medida_anilha, numero_anilha, fk_id_criador) VALUES ('Cabuloso', 2, '1,5', '1234', '07011122242');
INSERT INTO ave (nome, fk_id_especie, medida_anilha, numero_anilha, fk_id_criador) VALUES ('Boiadeiro', 2, '1,5', '1234', '07011122242');
INSERT INTO ave (nome, fk_id_especie, medida_anilha, numero_anilha, fk_id_criador) VALUES ('Fileh', 3, '1,5', '1234', '07011122243');
INSERT INTO ave (nome, fk_id_especie, medida_anilha, numero_anilha, fk_id_criador) VALUES ('Castanha', 3, '1,5', '1234', '07011122243');