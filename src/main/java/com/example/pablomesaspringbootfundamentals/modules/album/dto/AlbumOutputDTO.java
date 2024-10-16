package com.example.pablomesaspringbootfundamentals.modules.album.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlbumOutputDTO {
    private Long id;
    private String name;
    private LocalDate releaseDate;
    private Long artistId;
}