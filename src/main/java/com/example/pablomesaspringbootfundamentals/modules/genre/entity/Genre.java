package com.example.pablomesaspringbootfundamentals.modules.genre.entity;

import com.example.pablomesaspringbootfundamentals.modules.artist.entity.Artist;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "genre")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Release date is mandatory")
    private LocalDate releaseDate;

    private String description;

    @OneToMany(mappedBy = "genre")
    private List<Artist> artists;
}