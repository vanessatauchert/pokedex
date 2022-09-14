package com.vanessa.pokedex.service.exceptions;

public class ResourceNotFoundExcepetion extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundExcepetion(Object id) {
        super("Pokemon not found Id: " + id);
    }


}
