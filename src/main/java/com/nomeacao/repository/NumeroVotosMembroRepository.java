package com.nomeacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nomeacao.model.NumeroVotosMembro;
import com.nomeacao.repository.voto.NumeroVotosMembroRepositoryQuery;

@Repository
public interface NumeroVotosMembroRepository extends JpaRepository<NumeroVotosMembro, Long>, NumeroVotosMembroRepositoryQuery{

}
