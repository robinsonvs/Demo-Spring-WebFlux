package com.apirest.demowebflux.router;

import com.apirest.demowebflux.handler.MyPlayListSpotifyHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

//@Configuration
public class MyPlayListSpotifyRouter {

    @Bean
    public RouterFunction<ServerResponse> route(MyPlayListSpotifyHandler handler) {
        return RouterFunctions
                .route(GET("/playlist").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/playlist/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
                .andRoute(POST("/playlist").and(accept(MediaType.APPLICATION_JSON)), handler::save);
    }
}
