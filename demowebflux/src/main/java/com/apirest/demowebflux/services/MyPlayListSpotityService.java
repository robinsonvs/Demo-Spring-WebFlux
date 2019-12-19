package com.apirest.demowebflux.services;

import com.apirest.demowebflux.document.MyPlayListSpotify;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MyPlayListSpotityService {
    Flux<MyPlayListSpotify> findAll();
    Mono<MyPlayListSpotify> findById(String id);
    Mono<MyPlayListSpotify> save(MyPlayListSpotify listSpotify);
}
