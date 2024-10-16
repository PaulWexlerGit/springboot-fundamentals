package com.example.pablomesaspringbootfundamentals.modules.genre.mapper;

import com.example.pablomesaspringbootfundamentals.modules.genre.dto.GenreInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.genre.dto.GenreOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.genre.entity.Genre;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreOutputDTO toOutputDTO(Genre genre);

    Genre toEntity(GenreInputDTO genreInputDTO);
}