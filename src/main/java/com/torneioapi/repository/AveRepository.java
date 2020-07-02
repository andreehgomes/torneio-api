package com.torneioapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.torneioapi.model.Ave;

@Repository
public interface AveRepository extends JpaRepository<Ave, Long> {

}
