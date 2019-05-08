package com.github.thiagolocatelli.rating.repository;

import com.github.thiagolocatelli.rating.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByMovieId(Long movieId);

    List<Rating> findByUserId(Long movieId);

    Optional<Rating> findByUserIdAndMovieId(Long userId, Long movieId);
}
