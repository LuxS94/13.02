package org.example._302.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DipendenteDTO(@NotBlank @NotNull String username,
                            @NotBlank @NotNull
                            String nome,
                            @NotBlank @NotNull
                            String cognome,
                            @NotBlank @NotNull @Email
                            String email) {
}
