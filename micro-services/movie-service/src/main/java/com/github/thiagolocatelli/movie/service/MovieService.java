package com.github.thiagolocatelli.movie.service;

import com.github.thiagolocatelli.movie.domain.Movie;
import com.github.thiagolocatelli.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> all() {
        return movieRepository.findAll();
    }

    public Movie movie(Long movieId) {
        return movieRepository.findById(movieId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie does not exist")
        );
    }

}
