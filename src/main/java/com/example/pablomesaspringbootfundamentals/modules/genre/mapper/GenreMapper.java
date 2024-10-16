package com.example.pablomesaspringbootfundamentals.modules.genre.mapper;

import com.example.pablomesaspringbootfundamentals.modules.genre.dto.GenreInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.genre.dto.GenreOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.genre.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GenreMapper {
    Genre toEntity(GenreInputDTO genreInputDTO);

    GenreOutputDTO toOutputDTO(Genre genre);

    List<GenreOutputDTO> toOutputDTOs(List<Genre> genres);
}