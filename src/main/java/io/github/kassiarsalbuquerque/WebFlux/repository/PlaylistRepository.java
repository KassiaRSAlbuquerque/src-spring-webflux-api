package io.github.kassiarsalbuquerque.WebFlux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import io.github.kassiarsalbuquerque.WebFlux.document.Playlist;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String>{

}
