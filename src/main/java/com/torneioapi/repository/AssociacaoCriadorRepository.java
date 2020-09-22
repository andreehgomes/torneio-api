package com.torneioapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.torneioapi.model.AssociacaoCriador;

@Repository
public interface AssociacaoCriadorRepository extends JpaRepository<AssociacaoCriador, Long> {

	@Query("SELECT ac FROM AssociacaoCriador ac WHERE ac.adm = :adm AND ac.ativo = :ativo")
	List<AssociacaoCriador> findByAdmAndAtivo(@Param("adm") boolean adm, @Param("ativo") boolean ativo);	
	
	@Query("SELECT ac FROM AssociacaoCriador ac WHERE ac.adm = :adm AND ac.ativo = :ativo")
	List<AssociacaoCriador> findByAdmAtivo(boolean adm, boolean ativo);
	
	@Query(value = "SELECT * FROM associacao_criador ac WHERE ac.adm = true AND ac.ativo = true", nativeQuery = true)
	List<AssociacaoCriador> findAllAdmAtivos();
	
	
}
