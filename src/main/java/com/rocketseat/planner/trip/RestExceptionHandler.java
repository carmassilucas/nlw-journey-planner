package com.rocketseat.planner.trip;

import com.rocketseat.planner.exception.DatesAreInvalidException;
import com.rocketseat.planner.exception.TripNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(DatesAreInvalidException.class)
    public ResponseEntity<String> handleDatesAreInvalidException(DatesAreInvalidException e) {
        return ResponseEntity.unprocessableEntity().body(e.getMessage());
    }

    @ExceptionHandler(TripNotFoundException.class)
    public ResponseEntity<String> handleDatesAreInvalidException(TripNotFoundException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<InvalidParam>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        var fieldErrors = e.getFieldErrors()
                .stream()
                .map(f -> new InvalidParam(f.getField(), f.getDefaultMessage()))
                .toList();

        return ResponseEntity.unprocessableEntity().body(fieldErrors);
    }

    public record InvalidParam(String name, String reason) { }
}
