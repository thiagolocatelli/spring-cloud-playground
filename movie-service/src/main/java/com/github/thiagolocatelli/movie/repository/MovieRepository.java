package com.github.thiagolocatelli.movie.repository;

import com.github.thiagolocatelli.movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
