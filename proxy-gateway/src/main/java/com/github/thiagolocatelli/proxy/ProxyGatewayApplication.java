package com.github.thiagolocatelli.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableZuulProxy
@EnableDiscoveryClient
public class ProxyGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyGatewayApplication.class, args);
	}

}
