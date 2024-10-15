package com.example.pablomesaspringbootfundamentals.modules.genre.entity;

import com.example.pablomesaspringbootfundamentals.modules.artist.entity.Artist;
import jakarta.persistence.*;
import lombok.*;

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

    private String name;
    private String description;

    @OneToMany(mappedBy = "genre")
    private List<Artist> artists;
}