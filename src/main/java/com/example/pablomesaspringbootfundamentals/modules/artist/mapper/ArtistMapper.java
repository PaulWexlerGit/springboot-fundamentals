package com.example.pablomesaspringbootfundamentals.modules.artist.mapper;

import com.example.pablomesaspringbootfundamentals.modules.artist.dto.ArtistInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.artist.dto.ArtistOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.artist.entity.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArtistMapper {

    @Mapping(source = "genre.id", target = "genreId")
    ArtistOutputDTO toOutputDTO(Artist artist);

    @Mapping(source = "genreId", target = "genre.id")
    Artist toEntity(ArtistInputDTO artistInputDTO);
}