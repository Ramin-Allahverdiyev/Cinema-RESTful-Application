//package com.CinemaApp.controller;
//
//import com.CinemaApp.dto.request.MovieRequest;
//import com.CinemaApp.dto.response.MovieResponse;
//import com.CinemaApp.service.MovieService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//class MovieControllerTest {
//    @InjectMocks
//    private MovieController movieController;
//
//    @Mock
//    private MovieService movieService;
//
//    @DisplayName("Saving Movie according to given Request")
//    @Test
//    public void testSaveMovie() {
//        MovieRequest movieRequest = new MovieRequest();
//        MovieResponse movieResponse = new MovieResponse();
//
//        when(movieService.saveMovie(movieRequest)).thenReturn(movieResponse);
//
//
//        MovieResponse result = movieController.saveMovie(movieRequest);
//
//        assertEquals(movieResponse, result);
//    }
//
//    @DisplayName("Get Movie according to given Id")
//    @Test
//    public void testGetMovie() {
//        int movieId = 1;
//        MovieResponse movieResponse = new MovieResponse();
//
//        when(movieService.getMovie(movieId)).thenReturn(movieResponse);
//
//        MovieResponse result = movieController.getMovie(movieId);
//
//        assertEquals(movieResponse, result);
//    }
//
//    @DisplayName("Update Movie according to given Request and Id")
//    @Test
//    public void testUpdateMovie() {
//        int movieId = 1;
//        MovieRequest movieRequest = new MovieRequest();
//        MovieResponse movieResponse = new MovieResponse();
//
//        when(movieService.updateMovie(movieId, movieRequest)).thenReturn(movieResponse);
//
//        MovieResponse result = movieController.updateMovie(movieId, movieRequest);
//
//        assertEquals(movieResponse, result);
//    }
//
//    @DisplayName("Get All Movies")
//    @Test
//    public void testGetAllMovies() {
//        List<MovieResponse> movieResponses = Collections.singletonList(new MovieResponse());
//
//        when(movieService.getAllMovies()).thenReturn(movieResponses);
//
//        List<MovieResponse> result = movieController.getAllMovies();
//
//        assertEquals(movieResponses, result);
//    }
//
//    @DisplayName("Delete Movie according to given Id")
//    @Test
//    public void testDeleteMovie() {
//        int movieId = 1;
//
//        ResponseEntity<?> response = movieController.deleteMovie(movieId);
//
//        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
//    }
//
//}