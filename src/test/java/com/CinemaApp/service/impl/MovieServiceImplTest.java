//package com.CinemaApp.service.impl;
//
//import com.CinemaApp.dto.request.MovieRequest;
//import com.CinemaApp.dto.response.MovieResponse;
//import com.CinemaApp.entity.Movie;
//import com.CinemaApp.exception.NotFoundException;
//import com.CinemaApp.mapper.MovieMapper;
//import com.CinemaApp.repository.MovieRepository;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Arrays;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//class MovieServiceImplTest {
//    @Mock
//    private MovieRepository movieRepository;
//    @InjectMocks
//    private MovieServiceImpl movieService;
//
//    @DisplayName("According to given id , finding a Movie")
//    @Test
//    public void getMovieTest(){
//        int id=1;
//        var movie= Movie.builder().id(id).title("MrBean").movieStatus(1).build();
//
//        when(movieRepository.findByIdAndMovieStatus(id,1)).thenReturn(Optional.of(movie));
//
//        var movieResponse = movieService.getMovie(id);
//
//        assertNotNull(movieResponse);
//        assertEquals(1, movieResponse.getId());
//        assertEquals("MrBean", movieResponse.getTitle());
//    }
//
//    @DisplayName("According to given id , finding exception")
//    @Test
//    public void getMovieExceptionTest(){
//        int movieId = 1;
//        when(movieRepository.findByIdAndMovieStatus(movieId, 1)).thenReturn(Optional.empty());
//        when(movieRepository.findByIdAndMovieStatus(movieId, 0)).thenReturn(Optional.empty());
//        assertThrows(NotFoundException.class, () -> movieService.getMovie(movieId));
//    }
//
//    @DisplayName("According to given data , save movie")
//    @Test
//    public void saveMovieTest(){
//
//        MovieRequest movieRequest = new MovieRequest();
//        Movie movie = MovieMapper.INSTANCE.dtoToEntity(movieRequest);
//        Movie savedMovie = new Movie();
//        savedMovie.setId(1);
//
//        when(movieRepository.save(movie)).thenReturn(savedMovie);
//
//        MovieResponse result = movieService.saveMovie(movieRequest);
//
//        assertNotNull(result);
//        assertEquals(savedMovie.getId(), result.getId());
//
//    }
//
//    @DisplayName("According to given id , finding all movies")
//    @Test
//    public void getAllMovieTest(){
//
//        var movie1= Movie.builder().title("MrBean").build();
//        var movie2= Movie.builder().title("John Wick").build();
//
//        when(movieRepository.findAllByMovieStatus(1)).thenReturn(Arrays.asList(movie1,movie2));
//
//        var allMovies = movieService.getAllMovies();
//
//        assertEquals(allMovies.size(),2);
//
//    }
//
//    @DisplayName("According to given id , delete movie")
//    @Test
//    public void deleteMovieTest(){
//        int movieId = 1;
//        Movie movie = new Movie();
//        movie.setId(movieId);
//
//        when(movieRepository.findByIdAndMovieStatus(movieId, 1)).thenReturn(Optional.of(movie));
//        when(movieRepository.save(movie)).thenReturn(movie);
//
//        movieService.deleteMovie(movieId);
//        assertEquals(0, movie.getMovieStatus());
//    }
//
//    @Test
//    public void deleteMovieExceptionTest(){
//        int movieId=1;
//        when(movieRepository.findByIdAndMovieStatus(movieId,1)).thenReturn(Optional.empty());
//        when(movieRepository.findByIdAndMovieStatus(movieId,0)).thenReturn(Optional.empty());
//
//        assertThrows(NotFoundException.class,()-> movieService.deleteMovie(movieId));
//    }
//
//    @DisplayName("According to given id , update the movie")
//    @Test
//    public void updateMovieTest(){
//
//        int id=1;
//        var movieRequest=new MovieRequest("MrBean",1);
//        var movie = Movie.builder().id(id).title("Adventure of MrBean").build();
//        given(movieRepository.findByIdAndMovieStatus(id,1)).willReturn(Optional.of(movie));
//        movie.setTitle(movieRequest.getTitle());
//
//        when(movieRepository.save(any(Movie.class))).thenReturn(movie);
//        var movieResponse = movieService.updateMovie(id, movieRequest);
//
//        assertNotNull(movieResponse);
//
//    }
//
//    @Test
//    public void updateMovieExceptionTest(){
//
//        var request=new MovieRequest("MrBean",1);
//        when(movieRepository.findByIdAndMovieStatus(1,1)).thenReturn(Optional.empty());
//        when(movieRepository.findByIdAndMovieStatus(1,0)).thenReturn(Optional.empty());
//
//        assertThrows(NotFoundException.class,()-> movieService.updateMovie(1,request));
//    }
//
//
//
//}