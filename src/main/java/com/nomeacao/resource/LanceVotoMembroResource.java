package com.nomeacao.resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nomeacao.event.RecursoCriadoEvent;
import com.nomeacao.model.LanceVotarNumeroMembros;
import com.nomeacao.model.NumeroVotosMembro;
import com.nomeacao.repository.LanceVotoMembroRepository;
import com.nomeacao.repository.NumeroVotosMembroRepository;

@RestController
@RequestMapping("/lance_voto_membro")
public class LanceVotoMembroResource {

	@Autowired
	private LanceVotoMembroRepository lanceVotoMembroRepository;

	@Autowired
	private NumeroVotosMembroRepository numeroVotosMembroRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<LanceVotarNumeroMembros> listar() {
		ArrayList<LanceVotarNumeroMembros> lanceVotarNumeroMembros = (ArrayList<LanceVotarNumeroMembros>) lanceVotoMembroRepository
				.findAll();
		List<NumeroVotosMembro> numeroVotosMembros = numeroVotosMembroRepository.findAll();
		Set<LanceVotarNumeroMembros> membros = new HashSet<LanceVotarNumeroMembros>(lanceVotarNumeroMembros);
		
		for(NumeroVotosMembro numeroVotos : numeroVotosMembros ) {
			if(!numeroVotos.getNome().isEmpty()) {
				numeroVotosMembroRepository.deleteAll();
			}
		}

		for (LanceVotarNumeroMembros lanceMembros : membros) {
			NumeroVotosMembro numeroVotosMembro = new NumeroVotosMembro();
			System.out.println(
					lanceMembros.getNome() + ":" + Collections.frequency(lanceVotarNumeroMembros, lanceMembros));
			numeroVotosMembro.setNome(lanceMembros.getNome());
			numeroVotosMembro.setValor_voto(Collections.frequency(lanceVotarNumeroMembros, lanceMembros));
			numeroVotosMembroRepository.save(numeroVotosMembro);
		}

		return lanceVotoMembroRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<LanceVotarNumeroMembros> criar(
			@Valid @RequestBody LanceVotarNumeroMembros lanceVotarNumeroMembros, HttpServletResponse response) {
		LanceVotarNumeroMembros lanceVotarNumeroMembrosSalva = lanceVotoMembroRepository.save(lanceVotarNumeroMembros);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, lanceVotarNumeroMembrosSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(lanceVotarNumeroMembrosSalva);
	}

}
