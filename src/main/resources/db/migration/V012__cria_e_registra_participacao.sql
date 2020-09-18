CREATE TABLE IF NOT EXISTS participacao
(
   id BIGSERIAL PRIMARY KEY,
   fk_id_inscricao BIGINT,
   fk_id_etapa BIGINT,
   fk_id_ave BIGINT,
   marcacao VARCHAR,
   pontos INT,
   FOREIGN KEY (fk_id_inscricao) REFERENCES inscricao (id),
   FOREIGN KEY (fk_id_etapa) REFERENCES etapa (id),
   FOREIGN KEY (fk_id_ave) REFERENCES ave (id)
);
INSERT INTO participacao
(
   fk_id_inscricao,
   fk_id_etapa,
   fk_id_ave
)
VALUES
(
   1,
   1,
   1
);