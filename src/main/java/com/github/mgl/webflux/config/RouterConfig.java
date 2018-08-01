package com.github.mgl.webflux.config;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

import com.github.mgl.webflux.utils.TimeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

  @Autowired
  private TimeHandler timeHandler;

  @Bean
  public RouterFunction<ServerResponse> timeRouter() {
    return RouterFunctions.route(POST("/time"), req -> timeHandler.getTime(req))
        .andRoute(GET("/date"), timeHandler::getDate)
        .andRoute(GET("/times"), timeHandler::getTimePerSec);
  }
}
