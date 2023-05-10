package com.workshop.mongo.resources.exception;

import com.workshop.mongo.business.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourcesExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        StandardError err = new StandardError(System.currentTimeMillis(), String.valueOf(HttpStatus.NOT_FOUND.value()), "Registro não encontrato", e.getStackTrace().toString(), "Não foi possível encontrar o usuário informado", request.getContextPath());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
