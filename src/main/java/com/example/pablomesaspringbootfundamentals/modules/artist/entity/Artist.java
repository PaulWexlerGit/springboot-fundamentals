package com.example.pablomesaspringbootfundamentals.modules.artist.entity;

import com.example.pablomesaspringbootfundamentals.modules.album.entity.Album;
import com.example.pablomesaspringbootfundamentals.modules.genre.entity.Genre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "artist")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToMany(mappedBy = "artist")
    private List<Album> albums;
}