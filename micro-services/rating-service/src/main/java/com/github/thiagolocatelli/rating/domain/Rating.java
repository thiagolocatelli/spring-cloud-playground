package com.github.thiagolocatelli.rating.domain;

import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long movieId;
    private Integer rating;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @PrePersist
    public void preInsert() {
        if (this.createdAt == null)
            this.createdAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("userId", userId)
                .append("movieId", movieId)
                .append("rating", rating)
                .append("createdAt", createdAt).toString();
    }
}
