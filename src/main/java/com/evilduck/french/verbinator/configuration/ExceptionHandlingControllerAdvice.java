package com.evilduck.french.verbinator.configuration;


import com.evilduck.french.verbinator.exception.VerbNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ExceptionHandlingControllerAdvice {

    @ExceptionHandler(VerbNotFoundException.class)
    public ResponseEntity<String> handleVerbNotFound(final VerbNotFoundException exception) {
        return ResponseEntity.status(NOT_FOUND).body(exception.getMessage());
    }

}
