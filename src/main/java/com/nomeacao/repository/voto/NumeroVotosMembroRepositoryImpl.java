package com.nomeacao.repository.voto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.nomeacao.model.NumeroVotosMembro;

@Component
public class NumeroVotosMembroRepositoryImpl implements NumeroVotosMembroRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<NumeroVotosMembro> ListarNumeros() {
		return manager.createQuery("select from NumeroVotosMembro", NumeroVotosMembro.class).getResultList();
	}

}	
