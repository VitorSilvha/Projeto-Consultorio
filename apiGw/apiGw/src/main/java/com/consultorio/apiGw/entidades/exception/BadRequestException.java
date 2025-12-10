package com.consultorio.apiGw.entidades.exception;

public class BadRequestException extends RuntimeException{
	 public BadRequestException(String message) {
	        super(message);
	    }
}