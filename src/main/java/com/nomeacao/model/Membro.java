package com.nomeacao.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "membro")
public class Membro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotNull
	private String nome;

	@NotNull
	private String email;

	@JsonIgnore
	private String senha;

	private String telefone;

	private Integer permissao_grande_comissao;

	private Integer permissao_comissao_nomeacao;

	private Integer permissao_voto;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getPermissao_grande_comissao() {
		return permissao_grande_comissao;
	}

	public void setPermissao_grande_comissao(Integer permissao_grande_comissao) {
		this.permissao_grande_comissao = permissao_grande_comissao;
	}

	public Integer getPermissao_comissao_nomeacao() {
		return permissao_comissao_nomeacao;
	}

	public void setPermissao_comissao_nomeacao(Integer permissao_comissao_nomeacao) {
		this.permissao_comissao_nomeacao = permissao_comissao_nomeacao;
	}

	public Integer getPermissao_voto() {
		return permissao_voto;
	}

	public void setPermissao_voto(Integer permissao_voto) {
		this.permissao_voto = permissao_voto;
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
		Membro other = (Membro) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
