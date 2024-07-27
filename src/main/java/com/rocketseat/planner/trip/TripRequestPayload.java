package com.rocketseat.planner.trip;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record TripRequestPayload(
        @NotBlank
        String destination,

        @NotBlank
        String starts_at,

        @NotBlank
        String ends_at,

        List<@Email String> emails_to_invite,

        @NotBlank
        String owner_name,

        @Email
        @NotBlank
        String owner_email
) { }
