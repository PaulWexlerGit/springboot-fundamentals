package com.example.pablomesaspringbootfundamentals.modules.genre.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenreInputDTO {
    @NotNull(message = "Release date is mandatory")
    private LocalDate releaseDate;

    private String description;
}