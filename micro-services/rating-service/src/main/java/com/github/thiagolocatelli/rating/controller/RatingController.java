package com.github.thiagolocatelli.rating.controller;

import com.github.thiagolocatelli.rating.domain.Rating;
import com.github.thiagolocatelli.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/rating")
    public ResponseEntity<Rating> save(@RequestBody Rating rating) {
        return ResponseEntity.ok(ratingService.save(rating));
    }

    @GetMapping("/ratings/user/{userId}")
    public ResponseEntity<List<Rating>> userRatings(@PathVariable Long userId) {
        return ResponseEntity.ok(ratingService.userRatings(userId));
    }

    @GetMapping("/ratings/movies/{movieId}")
    public ResponseEntity<List<Rating>> movieRatings(@PathVariable Long movieId) {
        return ResponseEntity.ok(ratingService.movieRatings(movieId));
    }

    @GetMapping("/ratings/{userId}/{movieId}")
    public ResponseEntity<Rating> rating(@PathVariable Long userId, @PathVariable Long movieId) {
        return ResponseEntity.ok(ratingService.rating(userId, movieId));
    }

}
