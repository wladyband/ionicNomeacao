package com.nomeacao.model;

public class LanceVotarNumeroMembroDTO {

	private String nome;

	private Integer valor_voto;

	public LanceVotarNumeroMembroDTO() {
	}

	public LanceVotarNumeroMembroDTO(String nome) {
		this.nome = nome;
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

}
