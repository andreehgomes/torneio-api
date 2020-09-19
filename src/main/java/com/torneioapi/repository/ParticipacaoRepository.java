package com.torneioapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.torneioapi.model.Participacao;

@Repository
public interface ParticipacaoRepository extends JpaRepository<Participacao, Long> {

}
