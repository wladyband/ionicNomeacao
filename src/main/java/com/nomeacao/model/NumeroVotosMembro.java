package com.nomeacao.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "numero_votos_membro")
public class NumeroVotosMembro implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private String nome;

	private Integer valor_voto;

	public NumeroVotosMembro() {
	}

	public NumeroVotosMembro(String nome) {
		this.nome = nome;
	}

	public NumeroVotosMembro(Long codigo, String nome, Integer valor_voto) {
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
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NumeroVotosMembro other = (NumeroVotosMembro) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
