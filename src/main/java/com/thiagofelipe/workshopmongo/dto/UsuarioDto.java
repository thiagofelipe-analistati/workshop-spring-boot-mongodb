package com.thiagofelipe.workshopmongo.dto;

import java.io.Serializable;

import com.thiagofelipe.workshopmongo.dominio.Usuario;

public class UsuarioDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String nome;
	private String email;
	
	public UsuarioDto() {
		
	}
	
	public UsuarioDto(Usuario obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	
}
