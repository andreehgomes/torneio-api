CREATE TABLE IF NOT EXISTS associacao (
	id BIGSERIAL PRIMARY KEY,
	cnpj VARCHAR(15) UNIQUE,
	sigla VARCHAR(10),
	nome VARCHAR(150),
	cidade VARCHAR(150),
	uf VARCHAR(2),
	data_cadastro TIMESTAMP NOT NULL DEFAULT 'now()'
);

INSERT INTO associacao (cnpj, sigla, nome, cidade, uf) VALUES ('09207998000174', 'A.A.A', 'Associacao AA', 'Joaquim Tavora', 'PR');
INSERT INTO associacao (cnpj, sigla, nome, cidade, uf) VALUES ('09207998000185', 'B.B.B', 'Associacao BB', 'Siqueira Campos', 'SP');
INSERT INTO associacao (cnpj, sigla, nome, cidade, uf) VALUES ('09207998000196', 'C.C.C', 'Associacao CC', 'Quatiguá', 'RJ');
INSERT INTO associacao (cnpj, sigla, nome, cidade, uf) VALUES ('09207998000197', 'D.D.D', 'Associacao DD', 'Santo Antonio', 'RJ');
INSERT INTO associacao (cnpj, sigla, nome, cidade, uf) VALUES ('09207998000198', 'E.E.E', 'Associacao EE', 'Quatiguá 2', 'RJ');
INSERT INTO associacao (cnpj, sigla, nome, cidade, uf) VALUES ('09207998000199', 'F.F.F', 'Associacao FF', 'Quatiguá 3', 'RJ');
INSERT INTO associacao (cnpj, sigla, nome, cidade, uf) VALUES ('09207998000191', 'G.G.G', 'Associacao GG', 'Quatiguá 4', 'RJ');
