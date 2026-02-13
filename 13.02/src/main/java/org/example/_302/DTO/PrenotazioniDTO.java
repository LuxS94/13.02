package org.example._302.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PrenotazioniDTO(String note, @NotBlank @NotNull String dipendente,
                              @NotBlank @NotNull String viaggio) {
}
