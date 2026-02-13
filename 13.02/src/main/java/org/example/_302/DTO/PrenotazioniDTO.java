package org.example._302.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example._302.entities.Dipendente;
import org.example._302.entities.Viaggio;

public record PrenotazioniDTO(String note, @NotBlank @NotNull Dipendente dipendente,
                              @NotBlank @NotNull Viaggio viaggio) {
}
