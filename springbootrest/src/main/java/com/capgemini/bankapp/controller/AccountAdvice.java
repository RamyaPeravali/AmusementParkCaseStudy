package com.capgemini.bankapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.bankapp.exception.AccountException;

@RestControllerAdvice
public class AccountAdvice {
	@ExceptionHandler(value = { AccountException.class })
	public ResponseEntity<String> handleException1(Exception ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
