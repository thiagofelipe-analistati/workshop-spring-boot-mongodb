package com.thiagofelipe.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagofelipe.workshopmongo.dominio.Usuario;
import com.thiagofelipe.workshopmongo.dto.UsuarioDto;
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
	
	public Usuario Insert(Usuario obj) {
		return repository.insert(obj);
	}
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
		
	}
	public Usuario fromDTO(UsuarioDto objDto) {
		return new Usuario(objDto.getId(), objDto.getEmail(), objDto.getNome() );
	}
	public Usuario update(Usuario obj) {
		Usuario newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		
	}
	
}
