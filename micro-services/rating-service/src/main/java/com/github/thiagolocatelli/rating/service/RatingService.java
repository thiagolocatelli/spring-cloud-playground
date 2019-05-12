package com.github.thiagolocatelli.rating.service;

import com.github.thiagolocatelli.rating.client.MovieServiceClient;
import com.github.thiagolocatelli.rating.client.UserServiceClient;
import com.github.thiagolocatelli.rating.domain.Rating;
import com.github.thiagolocatelli.rating.repository.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RatingService {

    private static final Logger logger = LoggerFactory.getLogger(RatingService.class);

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private MovieServiceClient movieServiceClient;

    @Autowired
    private UserServiceClient userServiceClient;

    public Rating save(Rating rating) {

        if(movieServiceClient.fetchMovie(rating.getMovieId()).getStatusCode() != HttpStatus.OK) {
            logger.warn("Unable to create cart entry, movieId {} is invalid");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Movie");
        }

        if(userServiceClient.fetchUser(rating.getUserId()).getStatusCode() != HttpStatus.OK) {
            logger.warn("Unable to create cart entry, movieId {} is invalid");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid User");
        }

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
