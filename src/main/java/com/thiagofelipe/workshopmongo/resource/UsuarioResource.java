package com.thiagofelipe.workshopmongo.resource;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiagofelipe.workshopmongo.dominio.Usuario;
import com.thiagofelipe.workshopmongo.dto.UsuarioDto;
import com.thiagofelipe.workshopmongo.service.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService  service;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDto>> findAll(){
		
		List<Usuario> list = service.findAll();
		List<UsuarioDto> ListDto = list.stream().map(x -> new UsuarioDto(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(ListDto);
	}
	
}
