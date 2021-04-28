package com.thiagofelipe.workshopmongo.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiagofelipe.workshopmongo.dominio.Usuario;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@GetMapping
	public ResponseEntity<List<Usuario>> finAll(){
		Usuario maria = new Usuario("1", "Marua", "thiago@1");
		Usuario alex = new Usuario("1", "Marua", "thiago@1");
		List<Usuario> list = new ArrayList<>();
		
		list.addAll(Arrays.asList(maria, alex));
		
		return ResponseEntity.ok().body(list);
	}
	
}
