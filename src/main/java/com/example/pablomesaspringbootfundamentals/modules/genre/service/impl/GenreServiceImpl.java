package com.example.pablomesaspringbootfundamentals.modules.genre.service.impl;

import com.example.pablomesaspringbootfundamentals.exception.ResourceNotFoundException;
import com.example.pablomesaspringbootfundamentals.exception.ValidationException;
import com.example.pablomesaspringbootfundamentals.modules.genre.dto.GenreInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.genre.dto.GenreOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.genre.mapper.GenreMapper;
import com.example.pablomesaspringbootfundamentals.modules.genre.repository.GenreRepository;
import com.example.pablomesaspringbootfundamentals.modules.genre.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    public GenreOutputDTO createGenre(GenreInputDTO genreInputDTO) {
        if (genreInputDTO.getName() == null || genreInputDTO.getName().isEmpty()) {
            throw new ValidationException("Genre name cannot be null or empty");
        }
        return genreMapper.toOutputDTO(genreRepository.save(genreMapper.toEntity(genreInputDTO)));
    }

    @Override
    public List<GenreOutputDTO> getAllGenres() {
        return genreMapper.toOutputDTOs(genreRepository.findAll());
    }

    @Override
    public Optional<GenreOutputDTO> getGenreById(Long id) {
        return genreRepository.findById(id).map(genreMapper::toOutputDTO);
    }

    @Override
    public GenreOutputDTO updateGenre(Long id, GenreInputDTO genreInputDTO) {
        if (!genreRepository.existsById(id)) {
            throw new ResourceNotFoundException("Genre not found with id " + id);
        }
        return genreMapper.toOutputDTO(genreRepository.save(genreMapper.toEntity(genreInputDTO)));
    }

    @Override
    public void deleteGenre(Long id) {
        if (!genreRepository.existsById(id)) {
            throw new ResourceNotFoundException("Genre not found with id " + id);
        }
        genreRepository.deleteById(id);
    }
}