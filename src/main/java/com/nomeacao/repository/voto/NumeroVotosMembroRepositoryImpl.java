package com.nomeacao.repository.voto;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.nomeacao.model.NumeroVotosMembro;

@Repository
public class NumeroVotosMembroRepositoryImpl implements NumeroVotosMembroRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;

	//EXEMPLO 1
	
	@Override
	public List<NumeroVotosMembro> ListarNumeros() {
	  TypedQuery<Tuple> consulta = manager.createQuery("SELECT nvm.nome AS nome FROM NumeroVotosMembro nvm", Tuple.class);
	  List<Tuple> resultado = consulta.getResultList();

	  return resultado.stream()
			  .map(tuple -> new NumeroVotosMembro(tuple.get("nome", String.class)))
	    .collect(Collectors.toList());
	}

}	
