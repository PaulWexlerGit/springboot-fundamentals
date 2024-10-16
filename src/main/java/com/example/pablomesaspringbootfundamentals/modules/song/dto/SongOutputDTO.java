package com.example.pablomesaspringbootfundamentals.modules.song.dto;

import lombok.*;

import java.time.Duration;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SongOutputDTO {
    private Long id;
    private String name;
    private Duration duration;
    private Long albumId;
}