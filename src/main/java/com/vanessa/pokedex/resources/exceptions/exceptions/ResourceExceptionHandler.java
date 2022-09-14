package com.vanessa.pokedex.resources.exceptions.exceptions;

import com.vanessa.pokedex.resources.exceptions.StandardError;
import com.vanessa.pokedex.service.exceptions.ResourceNotFoundExcepetion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundExcepetion.class)
    public ResponseEntity<StandardError> pokemonNotFound(ResourceNotFoundExcepetion e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return  ResponseEntity.status(status).body(err);
    }

}
