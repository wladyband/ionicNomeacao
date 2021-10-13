package com.nomeacao.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nomeacao.event.RecursoCriadoEvent;
import com.nomeacao.model.GrandeComissao;
import com.nomeacao.model.Membro;
import com.nomeacao.repository.GrandeComissaoRepository;
import com.nomeacao.repository.MembroRepository;

@RestController
@RequestMapping("/membros")
public class MembroResource {

	@Autowired
	private MembroRepository membroRepository;

	@Autowired
	private GrandeComissaoRepository grandeComissaoRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	GrandeComissao grandeComissaoSalva = new GrandeComissao();

	@GetMapping
	public List<Membro> listar() {
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

	@PutMapping("/grande_comissao/{codigo}")
	public GrandeComissao salvarGrandeComissao(@PathVariable Long codigo, @Valid @RequestBody Membro membro) {
		Membro membroSalva = this.membroRepository.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		 BeanUtils.copyProperties(membro, grandeComissaoSalva, "codigo");
		grandeComissaoSalva.setNome(membroSalva.getNome());
		grandeComissaoSalva.setVoto(0);
	
		return this.grandeComissaoRepository.save(grandeComissaoSalva);
	}

}
