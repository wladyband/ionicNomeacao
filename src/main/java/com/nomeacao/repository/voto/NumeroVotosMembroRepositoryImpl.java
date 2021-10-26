package com.nomeacao.repository.voto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.nomeacao.model.NumeroVotosMembro;

@Repository
public class NumeroVotosMembroRepositoryImpl implements NumeroVotosMembroRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;

	//EXEMPLO difinitivo
	
	@Override
	public List<NumeroVotosMembro> ListarNumeros() {
	  TypedQuery<NumeroVotosMembro> consulta = manager.createQuery("select NEW NumeroVotosMembro(nvm.codigo, nvm.nome, nvm.valor_voto ) FROM NumeroVotosMembro nvm ORDER BY nvm.valor_voto desc", NumeroVotosMembro.class);
	  return consulta.getResultList();
	
	}

}	
