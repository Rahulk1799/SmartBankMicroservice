package com.codeblocks.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

	@Bean
	public RouteLocator smartbankRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes()
				.route(p -> p
						.path("/smartbank/accounts/**")
						.filters( f -> f.rewritePath("/smartbank/accounts/(?<segment>.*)","/${segment}"))
						.uri("lb://ACCOUNTS"))
				.route(p -> p
						.path("/smartbank/loans/**")
						.filters( f -> f.rewritePath("/smartbank/loans/(?<segment>.*)","/${segment}"))
						.uri("lb://LOANS"))
				.route(p -> p
						.path("/smartbank/cards/**")
						.filters( f -> f.rewritePath("/smartbank/cards/(?<segment>.*)","/${segment}"))
						.uri("lb://CARDS")).build();

	}

}