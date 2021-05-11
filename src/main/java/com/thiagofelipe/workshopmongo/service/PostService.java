package com.thiagofelipe.workshopmongo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagofelipe.workshopmongo.dominio.Post;
import com.thiagofelipe.workshopmongo.repository.PostRepository;
import com.thiagofelipe.workshopmongo.service.excecoes.ObjetoNaoEncontrado;

@Service
public class PostService {
	
	@Autowired //
	private PostRepository repository;
	
	

	public Post findById(String id){
		Optional<Post> obj = repository.findById(id);
		
		return obj.orElseThrow(()-> new ObjetoNaoEncontrado("Obejto não encontrado"));
		
	}
	
}
