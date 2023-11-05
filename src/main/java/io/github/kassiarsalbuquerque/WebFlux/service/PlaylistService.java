package io.github.kassiarsalbuquerque.WebFlux.service;

import io.github.kassiarsalbuquerque.WebFlux.document.Playlist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlaylistService {
	
	Flux<Playlist> retrieveAll();
	Mono<Playlist> retrievePlaylist(String id);
	Mono<Playlist> save(Playlist playlist);
}
