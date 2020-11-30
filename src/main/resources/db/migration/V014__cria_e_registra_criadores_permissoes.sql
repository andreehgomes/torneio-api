CREATE TABLE IF NOT EXISTS criador_permissao(
	fk_id_criador VARCHAR(14),
	fk_id_permissao BIGINT,
	PRIMARY KEY (fk_id_criador, fk_id_permissao),
	FOREIGN KEY (fk_id_criador) REFERENCES criador(cpf),
	FOREIGN KEY (fk_id_permissao) REFERENCES permissao(id)
);

INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',1);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',2);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',3);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',4);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',5);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',6);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',7);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',8);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',9);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',10);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',11);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',12);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',13);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',14);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',15);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',16);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',17);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',18);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',19);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',20);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',21);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',22);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',23);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122243',24);

INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122244',5);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122244',7);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122244',8);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122244',9);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122244',10);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122244',11);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122244',12);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122244',17);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122244',20);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122244',22);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122244',23);
INSERT INTO criador_permissao(fk_id_criador, fk_id_permissao) VALUES ('07011122244',24);
