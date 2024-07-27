package com.rocketseat.planner.trip;

import com.rocketseat.planner.exception.DatesAreInvalidException;
import com.rocketseat.planner.exception.TripNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TripService {
    private final TripRepository repository;

    public TripService(TripRepository repository) {
        this.repository = repository;
    }

    public Trip create(TripRequestPayload payload) {
        var trip = new Trip(payload);

        if (!trip.isDatesAreValid())
            throw new DatesAreInvalidException();

        return this.repository.save(trip);
    }

    public Trip read(UUID id) {
        return this.repository.findById(id).orElseThrow(TripNotFoundException::new);
    }
}
