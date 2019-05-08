package com.github.thiagolocatelli.user.repository;

import com.github.thiagolocatelli.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
