package com.thiagofelipe.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.thiagofelipe.workshopmongo.dominio.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {


	
}
