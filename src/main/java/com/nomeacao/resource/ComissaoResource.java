package com.nomeacao.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nomeacao.model.Comissao;
import com.nomeacao.model.GrandeComissao;
import com.nomeacao.service.ComissaoService;

@RestController
@RequestMapping("/comissao")
public class ComissaoResource {

	
	@Autowired
	private ComissaoService comissaoService;

	GrandeComissao grandeComissaoSalva = new GrandeComissao();

	@PostMapping("/{codigo}")
	public ResponseEntity<Comissao> salvarComissao(@PathVariable Long codigo, @Valid @RequestBody GrandeComissao grandeComissao) {
		Comissao comissaoSalva = comissaoService.salvar(codigo, grandeComissao); 
		return ResponseEntity.ok(comissaoSalva);
	}

}
