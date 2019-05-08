package com.github.thiagolocatelli.user.service;

import com.github.thiagolocatelli.user.domain.User;
import com.github.thiagolocatelli.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> all() {
        return userRepository.findAll();
    }

    public User user(Long userId) {
        return userRepository.findById(userId).get();
    }
}