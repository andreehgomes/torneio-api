ALTER TABLE criador ADD CONSTRAINT fk_id_endereco FOREIGN KEY (fk_id_endereco) REFERENCES endereco (id);

UPDATE criador set fk_id_endereco = 1 WHERE cpf = '07011122241';
UPDATE criador set fk_id_endereco = 2 WHERE cpf = '07011122242';
UPDATE criador set fk_id_endereco = 3 WHERE cpf = '07011122243';