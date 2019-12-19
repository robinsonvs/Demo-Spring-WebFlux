package com.apirest.demowebflux;

import com.apirest.demowebflux.document.MyPlayListSpotify;
import com.apirest.demowebflux.repository.MyPlayListSpotifyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

//@Component
//public class DummyData implements CommandLineRunner {
//    private final MyPlayListSpotifyRepository repository;
//
//    public DummyData(MyPlayListSpotifyRepository repository) {
//        this.repository = repository;
//    }
//
//    public void run(String... args) throws Exception {
//        repository.deleteAll()
//                .thenMany(
//                        Flux.just("Theatre Of Tragedy",
//                                    "Vader",
//                                    "Korzus",
//                                    "Judas Priest",
//                                    "Kreator",
//                                    "Carcass",
//                                    "Exodus")
//                        .map(name -> new MyPlayListSpotify(UUID.randomUUID().toString(), name))
//                        .flatMap(repository::save))
//                .subscribe(System.out::println);
//    }
//}
