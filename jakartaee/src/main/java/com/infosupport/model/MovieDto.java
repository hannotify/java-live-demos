package com.infosupport.model;

import jakarta.json.bind.annotation.JsonbDateFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MovieDto(
        String name,
        BigDecimal rating,
        @JsonbDateFormat("dd-MM-yyyy") LocalDate releaseDate) {
}
