package com.nomeacao.repository.voto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class NumeroVotosMembroRepositoryImpl implements NumeroVotosMembroRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;

	//EXEMPLO 2
	
	@Override
	public List<String> ListarNumeros() {
	    TypedQuery<String> consulta = manager.createQuery("select nvm.nome FROM NumeroVotosMembro nvm", String.class);
	    return consulta.getResultList();
	}

}	
