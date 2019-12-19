package com.apirest.demowebflux.controller;

import com.apirest.demowebflux.document.MyPlayListSpotify;
import com.apirest.demowebflux.services.MyPlayListSpotityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

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

    @GetMapping(value = "/playlist/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, MyPlayListSpotify>> getMyPlayListSpotifyByEvents() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<MyPlayListSpotify> events = service.findAll();
        System.out.println("events ...");
        return Flux.zip(interval, events);
    }
}
