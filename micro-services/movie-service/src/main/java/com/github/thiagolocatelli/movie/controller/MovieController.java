package com.github.thiagolocatelli.movie.controller;

import com.github.thiagolocatelli.movie.domain.Movie;
import com.github.thiagolocatelli.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/movie")
    public ResponseEntity<Movie> put(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.save(movie));
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> get() {
        return ResponseEntity.ok(movieService.all());
    }

    @GetMapping("/movies/{movieId}")
    public ResponseEntity<Movie> get(@PathVariable Long movieId) {
        return ResponseEntity.ok(movieService.movie(movieId));
    }

}
