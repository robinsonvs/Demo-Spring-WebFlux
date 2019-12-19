package com.apirest.demowebflux.services;

import com.apirest.demowebflux.document.MyPlayListSpotify;
import com.apirest.demowebflux.repository.MyPlayListSpotifyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MyPlayListSpotityServiceImpl implements MyPlayListSpotityService {

    @Autowired
    MyPlayListSpotifyRepository repository;

    @Override
    public Flux<MyPlayListSpotify> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<MyPlayListSpotify> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<MyPlayListSpotify> save(MyPlayListSpotify listSpotify) {
        return repository.save(listSpotify);
    }
}
