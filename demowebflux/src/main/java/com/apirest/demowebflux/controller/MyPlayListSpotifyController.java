package com.apirest.demowebflux.controller;

import com.apirest.demowebflux.document.MyPlayListSpotify;
import com.apirest.demowebflux.services.MyPlayListSpotityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MyPlayListSpotifyController {

    @Autowired
    MyPlayListSpotityService service;

    @GetMapping(value = "/playlist")
    public Flux<MyPlayListSpotify> getMyPlayListSpotify() {
        return service.findAll();
    }

    @GetMapping(value = "/playlist/{id}")
    public Mono<MyPlayListSpotify> getMyPlayListSpotifyById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping(value = "/playlist")
    public Mono<MyPlayListSpotify> save(@RequestBody MyPlayListSpotify playListSpotify) {
        return service.save(playListSpotify);
    }
}
