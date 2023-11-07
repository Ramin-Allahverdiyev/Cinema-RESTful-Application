package com.CinemaApp.repository;


import com.CinemaApp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findAllByMovieStatus(int movieStatus);
    Optional<Movie> findByIdAndMovieStatus(int id, int status);
}
