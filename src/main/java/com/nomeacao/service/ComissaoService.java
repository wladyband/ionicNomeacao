package com.nomeacao.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.nomeacao.model.ComissaoNomeacao;
import com.nomeacao.model.GrandeComissao;
import com.nomeacao.repository.ComissaoRepository;
import com.nomeacao.repository.GrandeComissaoRepository;

@Service
public class ComissaoService {

	@Autowired
	private GrandeComissaoRepository grandeComissaoRepository;
	
	@Autowired
	private ComissaoRepository comissaoRepository;
	GrandeComissao grandeComissao = new GrandeComissao();
	ComissaoNomeacao comissao = new ComissaoNomeacao();

	public ComissaoNomeacao salvar(Long codigo, GrandeComissao grandeComissa) {
		GrandeComissao grandeComissaomembroSalva = this.grandeComissaoRepository.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		
		BeanUtils.copyProperties(grandeComissao, comissao );
		comissao.setNome(grandeComissaomembroSalva.getNome());
		comissao.setVoto(1);
		return this.comissaoRepository.save(comissao);
	}

}
