package com.thiagofelipe.workshopmongo.resource.excecoes;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.thiagofelipe.workshopmongo.service.excecoes.ObjetoNaoEncontrado;

@ControllerAdvice // trata possiveis erros
public class ResourceExcecoesHandler {
	
	@ExceptionHandler(ObjetoNaoEncontrado.class)
	public ResponseEntity<StandaError> objetoNaoEncontrado (ObjetoNaoEncontrado e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandaError err =  new StandaError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	
	}
}
