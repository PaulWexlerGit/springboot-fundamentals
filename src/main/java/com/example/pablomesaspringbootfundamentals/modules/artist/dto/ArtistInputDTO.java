package com.example.pablomesaspringbootfundamentals.modules.artist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArtistInputDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Genre ID is mandatory")
    private Long genreId;
}