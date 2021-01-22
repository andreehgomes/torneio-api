CREATE TABLE IF NOT EXISTS endereco (
	id BIGSERIAL PRIMARY KEY,
	logradouro VARCHAR(250),
	numero VARCHAR,
	bairro VARCHAR(150),
	complemento VARCHAR(150),
	cep VARCHAR(15),
	cidade VARCHAR(100),
	uf VARCHAR(2)
);

INSERT INTO endereco(logradouro, numero, bairro, complemento, cep, cidade, uf) VALUES ('Rua 1', '1', 'Bairro 1', 'Casa', '86455000','Joaquim Távora','PR');
INSERT INTO endereco(logradouro, numero, bairro, complemento, cep, cidade, uf) VALUES ('Rua 2', '2', 'Bairro 2', 'Casa', '86455000','Joaquim Távora','PR');
INSERT INTO endereco(logradouro, numero, bairro, complemento, cep, cidade, uf) VALUES ('Rua 3', '3', 'Bairro 3', 'Casa', '86455000','Joaquim Távora','PR');
