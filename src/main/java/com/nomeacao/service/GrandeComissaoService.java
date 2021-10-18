package com.nomeacao.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.nomeacao.model.GrandeComissao;
import com.nomeacao.model.Membro;
import com.nomeacao.repository.GrandeComissaoRepository;
import com.nomeacao.repository.MembroRepository;

@Service
public class GrandeComissaoService {
	
	@Autowired
	private MembroRepository membroRepository;

	@Autowired
	private GrandeComissaoRepository grandeComissaoRepository;
	
	Membro membro = new Membro();
	
	

	public GrandeComissao salvar(Long codigo) {
		GrandeComissao grandeComissao = new GrandeComissao();
		Membro membroSalva = this.membroRepository.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		
		grandeComissao.setNome(membroSalva.getNome());
		grandeComissao.setVoto(1);
		return this.grandeComissaoRepository.save(grandeComissao);
	}
}
