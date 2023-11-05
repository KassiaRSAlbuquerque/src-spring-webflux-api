package io.github.kassiarsalbuquerque.WebFlux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import io.github.kassiarsalbuquerque.WebFlux.document.Playlist;
import io.github.kassiarsalbuquerque.WebFlux.service.PlaylistServiceImpl;
import reactor.core.publisher.Mono;

//@Component
public class PlaylistHandler {

	@Autowired
	private PlaylistServiceImpl playlistService;
	
	public Mono<ServerResponse> createPlaylist(ServerRequest request) {
		Mono<Playlist> mono = request.bodyToMono(Playlist.class);
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromPublisher(mono.flatMap(playlistService::save), Playlist.class));
	}
	
	public Mono<ServerResponse> retrieveAll(ServerRequest request) {
		return ServerResponse.ok()
					.contentType(MediaType.APPLICATION_JSON)
					.body(this.playlistService.retrieveAll(), Playlist.class);
	}
	
	public Mono<ServerResponse> retrievePlaylist(ServerRequest request) {
		
		String id = request.pathVariable("id");
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(this.playlistService.retrievePlaylist(id), Playlist.class);
	}
}