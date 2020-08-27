package com.torneioapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.torneioapi.model.Etapa;

@Repository
public interface EtapaRepository extends JpaRepository<Etapa, Long> {

}
