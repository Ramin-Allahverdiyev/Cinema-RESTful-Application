package com.CinemaApp.service.impl;

import com.CinemaApp.Model.ExistStatus;
import com.CinemaApp.dto.request.MovieRequest;
import com.CinemaApp.dto.response.MovieResponse;
import com.CinemaApp.exception.NotFoundException;
import com.CinemaApp.mapper.MovieMapper;
import com.CinemaApp.repository.MovieRepository;
import com.CinemaApp.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    @Override
    public MovieResponse saveMovie(MovieRequest request) {
        var movie = MovieMapper.INSTANCE.dtoToEntity(request);
        var savedMovie = movieRepository.save(movie);
        return MovieMapper.INSTANCE.entityToDto(savedMovie);
    }

    @Override
    public MovieResponse getMovie(int id) {
        var movie = movieRepository.findByIdAndMovieStatus(id,ExistStatus.ACTIVE.getId())
                .orElseThrow(() -> new NotFoundException("Movie is not found for this id!"));
        return MovieMapper.INSTANCE.entityToDto(movie);
    }



    @Override
    public MovieResponse updateMovie(int id, MovieRequest request) {
        var movie = movieRepository.findByIdAndMovieStatus(id,ExistStatus.ACTIVE.getId())
                .orElseThrow(() -> new NotFoundException("Movie is not found for this id!"));
        MovieMapper.INSTANCE.dtoToEntity(movie,request);
        var updatedMovie = movieRepository.save(movie);
        return MovieMapper.INSTANCE.entityToDto(updatedMovie);
    }

    @Override
    public List<MovieResponse> getAllMovies() {
        var allMovies = movieRepository.findAllByMovieStatus(ExistStatus.ACTIVE.getId());
        return MovieMapper.INSTANCE.entityListToDtoList(allMovies);
    }

    @Override
    public void deleteMovie(int id) {
        var movie = movieRepository.findByIdAndMovieStatus(id,ExistStatus.ACTIVE.getId())
                .orElseThrow(() -> new NotFoundException("Movie is not found for this id!"));
        movie.setMovieStatus(ExistStatus.DEACTIVE.getId());
        movieRepository.save(movie);
    }
}
