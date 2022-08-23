package com.magea.todoapp.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ToDoExceptions extends RuntimeException {
	private String mensaje;
	private HttpStatus httpStatus;
	
	public ToDoExceptions(String mensaje, HttpStatus httpStatus) {
		super(mensaje);
		this.mensaje = mensaje;
		this.httpStatus = httpStatus;
	}
	
}
