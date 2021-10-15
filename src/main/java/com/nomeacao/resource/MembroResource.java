package com.nomeacao.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nomeacao.event.RecursoCriadoEvent;
import com.nomeacao.model.GrandeComissao;
import com.nomeacao.model.Membro;
import com.nomeacao.repository.MembroRepository;

@RestController
@RequestMapping("/membros")
public class MembroResource {

	@Autowired
	private MembroRepository membroRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	GrandeComissao grandeComissaoSalva = new GrandeComissao();

	Membro membro = new Membro();

	@GetMapping
	public List<Membro> listar() {

//		Iterable<Membro> iterable = membroRepository.findAll();
//		for(Membro s: iterable){
//			System.out.println(s.getNome());
//		}
		return membroRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Membro> criar(@Valid @RequestBody Membro membro, HttpServletResponse response) {
		Membro membroSalva = membroRepository.save(membro);

		publisher.publishEvent(new RecursoCriadoEvent(this, response, membroSalva.getCodigo()));

		return ResponseEntity.status(HttpStatus.CREATED).body(membroSalva);
	}

	@GetMapping("/{codigo}")
	public Membro buscarPeloCodigo(@PathVariable Long codigo) {
		return this.membroRepository.findById(codigo).orElse(null);
	}

}
