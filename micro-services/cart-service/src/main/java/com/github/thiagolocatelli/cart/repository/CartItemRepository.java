package com.github.thiagolocatelli.cart.repository;

import com.github.thiagolocatelli.cart.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.transaction.Transactional;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long>, JpaSpecificationExecutor<CartItem> {

    List<CartItem> findByUserId(Long userId);

    @Transactional
    Long deleteByUserIdAndMovieId(Long userId, Long movieId);

}
