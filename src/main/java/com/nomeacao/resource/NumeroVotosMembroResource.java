package com.nomeacao.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nomeacao.repository.NumeroVotosMembroRepository;

@RestController
@RequestMapping("/numero_votos")
public class NumeroVotosMembroResource {
	
	@Autowired
	private NumeroVotosMembroRepository numeroVotosMembroRepository;
	
	@GetMapping
	public List<String> listar() {
		return numeroVotosMembroRepository.ListarNumeros();
	}
	

}
