package com.torneioapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.torneioapi.model.Associacao;

@Repository
public interface AssociacaoRepository extends JpaRepository<Associacao, Long>{
}
