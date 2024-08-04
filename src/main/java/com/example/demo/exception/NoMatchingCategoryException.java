package com.example.demo.exception;

public class NoMatchingCategoryException extends RuntimeException {
	public NoMatchingCategoryException(String message) {
        super(message);
    }
}
