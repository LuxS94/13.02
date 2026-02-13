package org.example._302.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ViaggioDTO(@NotBlank @NotNull String destinazione, @NotNull LocalDate data) {
}
