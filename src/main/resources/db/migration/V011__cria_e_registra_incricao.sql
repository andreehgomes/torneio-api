CREATE TABLE IF NOT EXISTS inscricao
(
   id BIGSERIAL PRIMARY KEY,
   fk_id_torneio BIGINT,
   fk_id_criador VARCHAR,
   data TIMESTAMP,
   FOREIGN KEY (fk_id_torneio) REFERENCES torneio (id),
   FOREIGN KEY (fk_id_criador) REFERENCES criador (cpf)  
);
INSERT INTO inscricao
(
   fk_id_torneio,
   fk_id_criador,
   data
)
VALUES
(
   1,
   '07011122241',
   '2020-11-01 10:00:00'
);
INSERT INTO inscricao
(
   fk_id_torneio,
   fk_id_criador,
   data
)
VALUES
(
   1,
   '07011122242',
   '2020-11-01 10:01:00'
);
INSERT INTO inscricao
(
   fk_id_torneio,
   fk_id_criador,
   data
)
VALUES
(
   1,
   '07011122243',
   '2020-11-01 10:05:00'
);
INSERT INTO inscricao
(
   fk_id_torneio,
   fk_id_criador,
   data
)
VALUES
(
   2,
   '07011122241',
   '2020-11-01 10:10:00'
);
INSERT INTO inscricao
(
   fk_id_torneio,
   fk_id_criador,
   data
)
VALUES
(
   2,
   '07011122242',
   '2020-11-01 10:22:00'
);
INSERT INTO inscricao
(
   fk_id_torneio,
   fk_id_criador,
   data
)
VALUES
(
   2,
   '07011122243',
   '2020-11-01 10:26:00'
);
INSERT INTO inscricao
(
   fk_id_torneio,
   fk_id_criador,
   data
)
VALUES
(
   3,
   '07011122241',
   '2020-11-01 10:35:00'
);
INSERT INTO inscricao
(
   fk_id_torneio,
   fk_id_criador,
   data
)
VALUES
(
   3,
   '07011122242',
   '2020-11-01 10:45:00'
);