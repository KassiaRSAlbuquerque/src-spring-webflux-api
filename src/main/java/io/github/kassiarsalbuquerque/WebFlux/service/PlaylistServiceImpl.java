package io.github.kassiarsalbuquerque.WebFlux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.kassiarsalbuquerque.WebFlux.document.Playlist;
import io.github.kassiarsalbuquerque.WebFlux.repository.PlaylistRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaylistServiceImpl implements PlaylistService{

	@Autowired
	private PlaylistRepository playlistRepository;
	
	@Override
	public Flux<Playlist> retrieveAll() {
		return this.playlistRepository.findAll();
	}

	@Override
	public Mono<Playlist> retrievePlaylist(String id) {
		return this.playlistRepository.findById(id);
	}
	
	@Override
	public Mono<Playlist> save(Playlist playlist) {
		return this.playlistRepository.save(playlist);
	}
}