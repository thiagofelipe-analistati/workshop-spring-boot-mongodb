package com.thiagofelipe.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.thiagofelipe.workshopmongo.dominio.Post;
import com.thiagofelipe.workshopmongo.dominio.Usuario;
import com.thiagofelipe.workshopmongo.dto.AutorDTO;
import com.thiagofelipe.workshopmongo.dto.ComentarioDTO;
import com.thiagofelipe.workshopmongo.repository.PostRepository;
import com.thiagofelipe.workshopmongo.repository.UsuarioRepository;

@Configuration
public class Intaciacao implements CommandLineRunner{

	@Autowired
	private UsuarioRepository UsuarioRepository;
	@Autowired
	private PostRepository PostRepository;
	@Override
	public void run(String... args) throws Exception {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		UsuarioRepository.deleteAll(); // limpar dados cadastrados 
		PostRepository.deleteAll(); 
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");

		UsuarioRepository.saveAll(Arrays.asList(maria, alex, bob));
		Post post = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AutorDTO(maria));
		
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AutorDTO(maria));
		
		ComentarioDTO c1 = new ComentarioDTO("Boa viagem mano", sdf.parse("21/03/2018"), new AutorDTO(alex));
		ComentarioDTO c2 = new ComentarioDTO("aproveite", sdf.parse("22/03/2018"), new AutorDTO(bob));
		ComentarioDTO c3 = new ComentarioDTO("Tenha uma otima viagem", sdf.parse("23/03/2018"), new AutorDTO(alex));
		
		
		post.getComentarios().addAll(Arrays.asList(c1,c2));
		post2.getComentarios().add(c3);
		PostRepository.saveAll(Arrays.asList(post, post2));
		maria.getPosts().addAll(Arrays.asList(post, post2));
		UsuarioRepository.save(maria);
	}

}
