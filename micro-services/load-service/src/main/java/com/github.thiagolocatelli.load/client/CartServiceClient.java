package com.github.thiagolocatelli.load.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("cart-service")
public interface CartServiceClient {
}
