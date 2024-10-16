package com.example.pablomesaspringbootfundamentals.modules.album.mapper;

import com.example.pablomesaspringbootfundamentals.modules.album.dto.AlbumInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.album.dto.AlbumOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.album.entity.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlbumMapper {

    @Mapping(source = "artist.id", target = "artistId")
    AlbumOutputDTO toOutputDTO(Album album);

    @Mapping(source = "artistId", target = "artist.id")
    Album toEntity(AlbumInputDTO albumInputDTO);
}