package com.example.pablomesaspringbootfundamentals.modules.song.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SongInputDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Duration is mandatory")
    @Pattern(regexp = "PT(\\d+H)?(\\d+M)?(\\d+S)?", message = "Duration must be in ISO-8601 format (e.g., PT3M45S)")
    private String duration;

    @NotNull(message = "Album ID is mandatory")
    private Long albumId;
}