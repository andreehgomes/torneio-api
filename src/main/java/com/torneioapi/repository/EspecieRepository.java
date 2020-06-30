package com.torneioapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.torneioapi.model.Especie;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Long> {
	
	
}
