package com.thiagofelipe.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.thiagofelipe.workshopmongo.dominio.Post;
import com.thiagofelipe.workshopmongo.dominio.Usuario;
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
		
		Post post = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
		
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);
		
		UsuarioRepository.saveAll(Arrays.asList(maria, alex, bob));
		PostRepository.saveAll(Arrays.asList(post, post2));
	}

}
