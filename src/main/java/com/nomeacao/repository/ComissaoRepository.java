package com.nomeacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nomeacao.model.Comissao;

public interface ComissaoRepository extends JpaRepository<Comissao, Long> {

}
