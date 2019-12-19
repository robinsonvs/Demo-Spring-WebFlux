package com.apirest.demowebflux.handler;

import com.apirest.demowebflux.document.MyPlayListSpotify;
import com.apirest.demowebflux.services.MyPlayListSpotityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class MyPlayListSpotifyHandler {

    @Autowired
    MyPlayListSpotityService service;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), MyPlayListSpotify.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        final String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findById(id), MyPlayListSpotify.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<MyPlayListSpotify> playListSpotify = request.bodyToMono(MyPlayListSpotify.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(playListSpotify.flatMap(service::save), MyPlayListSpotify.class));
    }
}
