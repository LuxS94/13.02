package org.example._302.DTO;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorsList(String message, LocalDateTime timestamp, List<String> errors) {
}
