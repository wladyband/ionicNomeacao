package com.nomeacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nomeacao.model.ComissaoNomeacao;

public interface ComissaoRepository extends JpaRepository<ComissaoNomeacao, Long> {

}
