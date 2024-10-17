package com.example.pablomesaspringbootfundamentals.modules.song.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SongOutputDTO {
    private Long id;
    private String name;
    private String duration;
    private Long albumId;
}