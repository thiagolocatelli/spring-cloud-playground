package com.github.thiagolocatelli.rating.service;

import com.github.thiagolocatelli.rating.domain.Rating;
import com.github.thiagolocatelli.rating.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }

    public List<Rating> userRatings(Long userId) {
        return ratingRepository.findByUserId(userId);
    }

    public List<Rating> movieRatings(Long movieId) {
        return ratingRepository.findByMovieId(movieId);
    }

    public Rating rating(Long userId, Long movieId) {
        return ratingRepository.findByUserIdAndMovieId(userId, movieId).get();
    }
}
