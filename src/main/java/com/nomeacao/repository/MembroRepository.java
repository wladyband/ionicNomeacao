package com.nomeacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nomeacao.model.Membro;

public interface MembroRepository extends JpaRepository<Membro, Long> {

}
