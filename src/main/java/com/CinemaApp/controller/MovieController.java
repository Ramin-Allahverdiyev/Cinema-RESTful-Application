package com.CinemaApp.controller;

import com.CinemaApp.dto.request.MovieRequest;
import com.CinemaApp.dto.response.MovieResponse;
import com.CinemaApp.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${root.url}/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping("/save")
    public MovieResponse saveMovie(@RequestBody MovieRequest request){
        return movieService.saveMovie(request);
    }

    @GetMapping("/{id}")
    public MovieResponse getMovie(@PathVariable int id){
        return movieService.getMovie(id);
    }

    @PutMapping("/{id}")
    public MovieResponse updateMovie(@PathVariable int id,@RequestBody MovieRequest request){
        return movieService.updateMovie(id,request);
    }

    @GetMapping("/all")
    public List<MovieResponse> getAllMovies(){
        return movieService.getAllMovies();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable int id){
        movieService.deleteMovie(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
