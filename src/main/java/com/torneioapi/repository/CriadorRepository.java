package com.torneioapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.torneioapi.model.Criador;

@Repository
public interface CriadorRepository extends JpaRepository<Criador, String> {

}
