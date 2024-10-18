package com.example.pablomesaspringbootfundamentals.modules.genre.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenreOutputDTO {
    private Long id;
    private LocalDate releaseDate;
    private String description;
}