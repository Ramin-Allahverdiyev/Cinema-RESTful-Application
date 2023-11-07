package com.CinemaApp.service;

import com.CinemaApp.dto.request.MovieRequest;
import com.CinemaApp.dto.response.MovieResponse;

import java.util.List;

public interface MovieService {
    MovieResponse saveMovie(MovieRequest request);
    MovieResponse getMovie(int id);
    MovieResponse updateMovie(int id,MovieRequest request);
    List<MovieResponse> getAllMovies();
    void deleteMovie(int id);

}
