package com.github.thiagolocatelli.cart.domain;

import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
                .append("id", id)
                .append("userId", userId)
                .append("movieId", movieId)
                .append("createdAt", createdAt).toString();
    }
}
