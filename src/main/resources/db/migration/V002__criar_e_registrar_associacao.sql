CREATE TABLE IF NOT EXISTS associacao (
	id BIGSERIAL PRIMARY KEY,
	cnpj VARCHAR(15) UNIQUE,
	sigla VARCHAR(10),
	nome VARCHAR(150),
	cidade VARCHAR(150)
);

INSERT INTO associacao (cnpj, sigla, nome, cidade) VALUES ('09207998000174', 'A.A.A', 'Associacao AA', 'Joaquim Tavora');
INSERT INTO associacao (cnpj, sigla, nome, cidade) VALUES ('09207998000185', 'A.B.B', 'Associacao BB', 'Siqueira Campos');
INSERT INTO associacao (cnpj, sigla, nome, cidade) VALUES ('09207998000196', 'A.C.C', 'Associacao CC', 'Quatiguá');
