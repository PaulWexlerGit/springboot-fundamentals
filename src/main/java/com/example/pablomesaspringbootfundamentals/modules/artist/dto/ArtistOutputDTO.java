package com.example.pablomesaspringbootfundamentals.modules.artist.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArtistOutputDTO {
    private Long id;
    private String name;
    private Long genreId;
}