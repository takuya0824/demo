package com.example.demo.exception;

public class NoClothesFoundException extends RuntimeException {
	public NoClothesFoundException(String message) {
        super(message);
    }
}
