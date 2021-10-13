package com.nomeacao.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nomeacao.model.GrandeComissao;
import com.nomeacao.model.Membro;
import com.nomeacao.service.GrandeComissaoService;

@RestController
@RequestMapping("/grande_comissao")
public class GrandeComissaoResource {

	
	@Autowired
	private GrandeComissaoService grandeComissaoService;

	GrandeComissao grandeComissaoSalva = new GrandeComissao();

	@PostMapping("/{codigo}")
	public ResponseEntity<GrandeComissao> salvarGrandeComissao(@PathVariable Long codigo, @Valid @RequestBody Membro membro) {
		GrandeComissao grandeComissaoSalva = grandeComissaoService.salvar(codigo, membro); 
		return ResponseEntity.ok(grandeComissaoSalva);
	}

}
