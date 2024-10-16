package com.example.pablomesaspringbootfundamentals.modules.song.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Duration;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SongInputDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Duration is mandatory")
    private Duration duration;

    @NotNull(message = "Album ID is mandatory")
    private Long albumId;
}