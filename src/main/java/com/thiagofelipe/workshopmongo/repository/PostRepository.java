package com.thiagofelipe.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.thiagofelipe.workshopmongo.dominio.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
