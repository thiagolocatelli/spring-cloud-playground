package com.github.thiagolocatelli.cart.repository;

import com.github.thiagolocatelli.cart.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findByUserId(Long userId);

    @Transactional
    Long deleteByUserIdAndMovieId(Long userId, Long movieId);

}
