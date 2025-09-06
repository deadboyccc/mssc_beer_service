package dev.dead.mssc_beer_service.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class MvcExceptionHanlder {
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<List<String>> validationErrorHandler(ConstraintViolationException ex) {
    List<String> errors = new ArrayList<>(ex.getConstraintViolations().size());
    ex.getConstraintViolations().forEach(e -> errors.add(e.toString()));
    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

  }

}
