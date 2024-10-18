package com.example.pablomesaspringbootfundamentals.modules.playlist.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaylistOutputDTO {
    private Long id;
    private String name;
    private String description;
}