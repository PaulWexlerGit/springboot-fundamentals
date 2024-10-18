package com.example.pablomesaspringbootfundamentals.modules.album.mapper;

import com.example.pablomesaspringbootfundamentals.modules.album.dto.AlbumInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.album.dto.AlbumOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.album.entity.Album;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
public interface AlbumMapper {
    Album toEntity(AlbumInputDTO albumInputDTO);

    AlbumOutputDTO toOutputDTO(Album album);

    List<AlbumOutputDTO> toOutputDTOs(List<Album> albums);
}