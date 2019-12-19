package com.apirest.demowebflux.repository;

import com.apirest.demowebflux.document.MyPlayListSpotify;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MyPlayListSpotifyRepository extends ReactiveMongoRepository<MyPlayListSpotify, String> {
}
