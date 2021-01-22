package com.torneioapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.torneioapi.model.Associacao;

@Repository
public interface AssociacaoRepository extends JpaRepository<Associacao, Long>{
	
	@Query("SELECT a FROM Associacao a WHERE a.uf = :uf")
	List<Associacao> findAllByUf(@Param("uf") String uf);
	
}
