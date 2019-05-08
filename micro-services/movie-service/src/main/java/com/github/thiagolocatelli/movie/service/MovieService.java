package com.github.thiagolocatelli.movie.service;

import com.github.thiagolocatelli.movie.domain.Movie;
import com.github.thiagolocatelli.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return movieRepository.findById(movieId).get();
    }

}
