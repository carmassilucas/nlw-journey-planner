package com.rocketseat.planner.exception;

public class TripNotFoundException extends RuntimeException {
    public TripNotFoundException() {
        super("Trip not found!");
    }
}
