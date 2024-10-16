package com.example.pablomesaspringbootfundamentals.modules.song.mapper;

import com.example.pablomesaspringbootfundamentals.modules.song.dto.SongInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.song.dto.SongOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.song.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SongMapper {
    Song toEntity(SongInputDTO songInputDTO);

    SongOutputDTO toOutputDTO(Song song);

    List<SongOutputDTO> toOutputDTOs(List<Song> songs);
}