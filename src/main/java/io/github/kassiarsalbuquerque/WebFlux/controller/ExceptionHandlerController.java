package io.github.kassiarsalbuquerque.WebFlux.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.kassiarsalbuquerque.WebFlux.erros.ApiErros;
import io.github.kassiarsalbuquerque.WebFlux.exception.RegraNegocioException;

@RestControllerAdvice
public class ExceptionHandlerController {
	// Toda vez q uma excecao personalizada é lancada essa classe trata a excecao(RegraNegocioException). 
	// Para retornar um STATUS e uma msg de erro customizada
	
	@ExceptionHandler(RegraNegocioException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ApiErros handleRegraNegocioException(RegraNegocioException ex) {
		return new ApiErros(ex.getMessage());
	}
}