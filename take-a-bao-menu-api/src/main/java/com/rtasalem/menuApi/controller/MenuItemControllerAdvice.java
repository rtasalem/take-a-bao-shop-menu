package com.rtasalem.menuApi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rtasalem.menuApi.exception.MenuItemNameExistsException;
import com.rtasalem.menuApi.exception.ResourceNotFoundException;

@RestControllerAdvice
public class MenuItemControllerAdvice {

	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

	@ExceptionHandler(value = MenuItemNameExistsException.class)
	public ResponseEntity<String> handleMenuItemNameExistsException(MenuItemNameExistsException ex) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleMethodArgumetnNotValidException(MethodArgumentNotValidException ex) {
		List<ObjectError> errors = ex.getAllErrors();
		StringBuilder stringBuilder = new StringBuilder();
		errors.forEach(error -> stringBuilder.append(error.getDefaultMessage() + " / "));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(stringBuilder.toString());
	}

}