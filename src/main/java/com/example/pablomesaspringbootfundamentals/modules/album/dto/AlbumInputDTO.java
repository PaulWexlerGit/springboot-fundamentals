package com.example.pablomesaspringbootfundamentals.modules.album.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlbumInputDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Release date is mandatory")
    private LocalDate releaseDate;

    @NotNull(message = "Artist ID is mandatory")
    private Long artistId;
}