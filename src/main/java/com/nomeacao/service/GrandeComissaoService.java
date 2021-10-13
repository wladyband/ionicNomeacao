package com.nomeacao.service;

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
	GrandeComissao grandeComissao = new GrandeComissao();
	

	public GrandeComissao salvar(Long codigo, Membro membro) {
		Membro membroSalva = this.membroRepository.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		
		BeanUtils.copyProperties(membro, grandeComissao);
		grandeComissao.setNome(membroSalva.getNome());
		grandeComissao.setVoto(0);
		return this.grandeComissaoRepository.save(grandeComissao);
	}
}
