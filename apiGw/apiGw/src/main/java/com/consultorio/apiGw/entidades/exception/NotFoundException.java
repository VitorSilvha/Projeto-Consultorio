package com.consultorio.apiGw.entidades.exception;

public class NotFoundException extends RuntimeException{
	public NotFoundException(String message) {
        super(message);
    }
}