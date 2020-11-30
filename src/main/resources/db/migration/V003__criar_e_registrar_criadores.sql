CREATE TABLE IF NOT EXISTS criador (
	cpf VARCHAR(14) PRIMARY KEY,
	ibama VARCHAR(15),
	nome VARCHAR(100),
	sobrenome VARCHAR(150),
	telefone VARCHAR(15),
	fk_id_endereco BIGINT,
	data_cadastro TIMESTAMP NOT NULL DEFAULT 'now()',
	senha VARCHAR(150) NOT NULL
);

INSERT INTO criador(cpf, ibama, nome, sobrenome, telefone, senha) VALUES ('07011122241', '123451', 'Carlos Eduardo', 'Ovçar Gomes', '43999999999','$2a$10$5.cii4pajc1iqr2IZyc8tetmnhSjwitEAPlRQOfTZAfBDzrCux5wu');
INSERT INTO criador(cpf, ibama, nome, sobrenome, telefone, senha) VALUES ('07011122242', '123452', 'Eduardo', 'Gomes', '43999999999', '$2a$10$5.cii4pajc1iqr2IZyc8tetmnhSjwitEAPlRQOfTZAfBDzrCux5wu');
INSERT INTO criador(cpf, ibama, nome, sobrenome, telefone, senha) VALUES ('07011122243', '123453', 'André Felipe', 'Felício Gomes', '43999999999', '$2a$10$5.cii4pajc1iqr2IZyc8tetmnhSjwitEAPlRQOfTZAfBDzrCux5wu');
INSERT INTO criador(cpf, ibama, nome, sobrenome, telefone, senha) VALUES ('07011122244', '123454', 'Augusto Francisco', 'Felício Gomes', '43999999999', '$2a$10$5.cii4pajc1iqr2IZyc8tetmnhSjwitEAPlRQOfTZAfBDzrCux5wu');
