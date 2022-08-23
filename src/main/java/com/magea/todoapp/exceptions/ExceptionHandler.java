package com.magea.todoapp.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
	
	//Esta clase sirve para que Spring sepa manejar todas las excepciones con el controlador.
	//Si no tuviera esto, en pantalla se mostraria una excepcion no controlada.

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {ToDoExceptions.class })
    protected ResponseEntity<Object> handleConflict(
            ToDoExceptions ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), ex.getHttpStatus(), request);
    }
}
