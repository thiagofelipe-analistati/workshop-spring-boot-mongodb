package com.thiagofelipe.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagofelipe.workshopmongo.dominio.Usuario;
import com.thiagofelipe.workshopmongo.repository.UsuarioRepository;
import com.thiagofelipe.workshopmongo.service.excecoes.ObjetoNaoEncontrado;

@Service
public class UsuarioService {
	
	@Autowired //
	private UsuarioRepository repository;
	public List<Usuario> findAll(){
		return repository.findAll();
	}

	public Usuario findById(String id){
		Optional<Usuario> obj = repository.findById(id);
		
		return obj.orElseThrow(()-> new ObjetoNaoEncontrado("Obejto não encontrado"));
		
	}
}
