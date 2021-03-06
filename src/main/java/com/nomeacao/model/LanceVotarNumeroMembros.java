package com.nomeacao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lance_votar_nomero_membro")
public class LanceVotarNumeroMembros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private String nome;

	private Integer valor_voto;

	public LanceVotarNumeroMembros() {
	}

	public LanceVotarNumeroMembros(Long codigo, String nome, Integer valor_voto) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor_voto = valor_voto;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getValor_voto() {
		return valor_voto;
	}

	public void setValor_voto(Integer valor_voto) {
		this.valor_voto = valor_voto;
	}

	@Override
	public int hashCode() {
		return nome.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof LanceVotarNumeroMembros))
			return false;

		LanceVotarNumeroMembros lvnm = (LanceVotarNumeroMembros) obj;
		return lvnm.nome.equals(nome);
	}

}
