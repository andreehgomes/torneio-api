CREATE TABLE IF NOT EXISTS permissao(
	id SERIAL PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL
);

INSERT INTO permissao(descricao) VALUES ('CADASTRAR_ASSOCIACAO');
INSERT INTO permissao(descricao) VALUES ('BUSCAR_ASSOCIACAO');
INSERT INTO permissao(descricao) VALUES ('ALTERAR_ASSOCIACAO');

INSERT INTO permissao(descricao) VALUES ('CADASTRAR_ESPECIE');
INSERT INTO permissao(descricao) VALUES ('BUSCAR_ESPECIE');
INSERT INTO permissao(descricao) VALUES ('ALTERAR_ESPECIE');

INSERT INTO permissao(descricao) VALUES ('CADASTRAR_AVE');
INSERT INTO permissao(descricao) VALUES ('BUSCAR_AVE');
INSERT INTO permissao(descricao) VALUES ('ALTERAR_AVE');

INSERT INTO permissao(descricao) VALUES ('CADASTRAR_ENDERECO');
INSERT INTO permissao(descricao) VALUES ('BUSCAR_ENDERECO');
INSERT INTO permissao(descricao) VALUES ('ALTERAR_ENDERECO');

INSERT INTO permissao(descricao) VALUES ('CADASTRAR_TEMPORADA');
INSERT INTO permissao(descricao) VALUES ('BUSCAR_TEMPORADA');
INSERT INTO permissao(descricao) VALUES ('ALTERAR_TEMPORADA');

INSERT INTO permissao(descricao) VALUES ('CADASTRAR_ETAPA');
INSERT INTO permissao(descricao) VALUES ('BUSCAR_ETAPA');
INSERT INTO permissao(descricao) VALUES ('ALTERAR_ETAPA');

INSERT INTO permissao(descricao) VALUES ('CADASTRAR_TORNEIO');
INSERT INTO permissao(descricao) VALUES ('BUSCAR_TORNEIO');
INSERT INTO permissao(descricao) VALUES ('ALTERAR_TORNEIO');

INSERT INTO permissao(descricao) VALUES ('CADASTRAR_INSCRICAO');
INSERT INTO permissao(descricao) VALUES ('BUSCAR_INSCRICAO');
INSERT INTO permissao(descricao) VALUES ('ALTERAR_INSCRICAO');