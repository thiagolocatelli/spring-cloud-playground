package com.github.thiagolocatelli.rating.client;

import com.github.thiagolocatelli.rating.client.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("user-service")
public interface UserServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/user/{userId}", consumes = "application/json")
    ResponseEntity<User> fetchUser(@PathVariable("userId") Long userId);

}
