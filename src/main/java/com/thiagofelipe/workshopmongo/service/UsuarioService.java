package com.thiagofelipe.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagofelipe.workshopmongo.dominio.Usuario;
import com.thiagofelipe.workshopmongo.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired //
	private UsuarioRepository repository;
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
}
