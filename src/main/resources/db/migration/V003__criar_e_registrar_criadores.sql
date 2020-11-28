CREATE TABLE IF NOT EXISTS criador (
	cpf VARCHAR(14) PRIMARY KEY,
	ibama VARCHAR(15),
	nome VARCHAR(100),
	sobrenome VARCHAR(150),
	telefone VARCHAR(15),
	email VARCHAR(150),
	password VARCHAR,
	fk_id_endereco BIGINT,
	data_cadastro TIMESTAMP NOT NULL DEFAULT 'now()'
);

INSERT INTO criador(cpf, ibama, nome, sobrenome, telefone, email, password) VALUES ('07011122241', '123451', 'Carlos Eduardo', 'Ovçar Gomes', '43999999999', 'andrefelipefeliciogomes@gmail.com', '$2a$10$ZnlYo7H447f85JmOc5SygOccHTGK.c6Ki7ARIE1.zZ1UHC8I3GK22');
INSERT INTO criador(cpf, ibama, nome, sobrenome, telefone, email, password) VALUES ('07011122242', '123452', 'Eduardo', 'Gomes', '43999999999', 'andrefelipefeliciogomes@gmail.com', '$2a$10$ZnlYo7H447f85JmOc5SygOccHTGK.c6Ki7ARIE1.zZ1UHC8I3GK22');
INSERT INTO criador(cpf, ibama, nome, sobrenome, telefone, email, password) VALUES ('07011122243', '123453', 'André Felipe', 'Felício Gomes', '43999999999', 'andrefelipefeliciogomes@gmail.com', '$2a$10$ZnlYo7H447f85JmOc5SygOccHTGK.c6Ki7ARIE1.zZ1UHC8I3GK22');
INSERT INTO criador(cpf, ibama, nome, sobrenome, telefone, email, password) VALUES ('07011122244', '123454', 'Augusto Francisco', 'Felício Gomes', '43999999999', 'andrefelipefeliciogomes@gmail.com', '$2a$10$ZnlYo7H447f85JmOc5SygOccHTGK.c6Ki7ARIE1.zZ1UHC8I3GK22');
