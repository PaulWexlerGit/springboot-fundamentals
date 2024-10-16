// GenreInputDTO.java
package com.example.pablomesaspringbootfundamentals.modules.genre.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenreInputDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;

    private String description;
}