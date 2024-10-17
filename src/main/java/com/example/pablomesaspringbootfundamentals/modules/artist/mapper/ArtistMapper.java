package com.example.pablomesaspringbootfundamentals.modules.artist.mapper;

import com.example.pablomesaspringbootfundamentals.modules.artist.dto.ArtistInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.artist.dto.ArtistOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.artist.entity.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArtistMapper {
    Artist toEntity(ArtistInputDTO artistInputDTO);

    ArtistOutputDTO toOutputDTO(Artist artist);

    List<ArtistOutputDTO> toOutputDTOs(List<Artist> artists);
}