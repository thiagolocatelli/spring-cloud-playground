package com.github.thiagolocatelli.load.client;

import com.github.thiagolocatelli.load.client.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("user-service")
public interface UserServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/user/{userId}", consumes = "application/json")
    User fetchUser(@PathVariable("userId") Long userId);

    @RequestMapping(method = RequestMethod.POST, value = "/api/v1/user", consumes = "application/json")
    User saveUser(User user);

}
