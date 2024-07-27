package com.rocketseat.planner.exception;

public class DatesAreInvalidException extends RuntimeException {
    public DatesAreInvalidException() {
        super ("Dates are not valid!");
    }
}
