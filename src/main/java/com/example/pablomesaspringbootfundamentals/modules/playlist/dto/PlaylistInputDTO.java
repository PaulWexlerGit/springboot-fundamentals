package com.example.pablomesaspringbootfundamentals.modules.playlist.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaylistInputDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;

    private String description;
}