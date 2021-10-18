package com.nomeacao.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nomeacao.model.GrandeComissao;
import com.nomeacao.service.GrandeComissaoService;

@RestController
@RequestMapping("/grande_comissao")
public class GrandeComissaoResource {

	
	@Autowired
	private GrandeComissaoService grandeComissaoService;

	GrandeComissao grandeComissaoSalva = new GrandeComissao();

	@PostMapping("/{codigo}")
	public ResponseEntity<GrandeComissao> salvarGrandeComissao(@PathVariable Long codigo) {
		GrandeComissao grandeComissaoSalva = grandeComissaoService.salvar(codigo); 
		return ResponseEntity.ok(grandeComissaoSalva);
	}

}


//Optional<Membro> membro = this.membroRepository.findById(codigo);
//GrandeComissao grandeComissao = new GrandeComissao();
//
//grandeComissao.setNome(membro.get().getNome());
//grandeComissao.setVoto(1);
//grandeComissaoRepository.save(grandeComissao);
