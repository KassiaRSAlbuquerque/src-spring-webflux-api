package io.github.kassiarsalbuquerque.WebFlux.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.kassiarsalbuquerque.WebFlux.document.Playlist;
import io.github.kassiarsalbuquerque.WebFlux.service.PlaylistServiceImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

	@Autowired
	private PlaylistServiceImpl playlistService;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Mono<Playlist> createCliente(@RequestBody Playlist playlist) {
		return this.playlistService.save(playlist);
	}
	
	@GetMapping
	public Flux<Playlist> retrieveAll() {
		return this.playlistService.retrieveAll();
	}
	
	@GetMapping("{id}")
	public Mono<Playlist> retriveCliente(@PathVariable String id) {
		return this.playlistService.retrievePlaylist(id);
	}
	
	@GetMapping(value="webflux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, Playlist>> getPlaylistByWebflux(){

		System.out.println("---Start get Playlists by WEBFLUX--- " + LocalDateTime.now());
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(5));
        Flux<Playlist> playlistFlux = playlistService.retrieveAll();

        return Flux.zip(interval, playlistFlux);
        
	}

	@GetMapping(value="mvc")
	public List<String> getPlaylistByMvc() throws InterruptedException {

		System.out.println("---Start get Playlists by MVC--- " + LocalDateTime.now());


		List<String> playlistList = new ArrayList<>();
		playlistList.add("Java 8");
		playlistList.add("Spring Security");
		playlistList.add("Github");
		playlistList.add("Deploy de uma aplicação java no IBM Cloud");
		playlistList.add("Bean no Spring Framework");
		TimeUnit.SECONDS.sleep(15);

		return playlistList;

	}
}
