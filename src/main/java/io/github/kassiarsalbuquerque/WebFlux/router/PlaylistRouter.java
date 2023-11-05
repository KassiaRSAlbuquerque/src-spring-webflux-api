package io.github.kassiarsalbuquerque.WebFlux.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import io.github.kassiarsalbuquerque.WebFlux.handler.PlaylistHandler;

@Configuration
public class PlaylistRouter {

	//MAPEANDO ENDPOINTS C PROGRAMACAO FUNCIONAL
	
	@Bean
	public RouterFunction<ServerResponse> route(PlaylistHandler handler){
		return RouterFunctions
				.route(GET("/playlists").and(accept(MediaType.APPLICATION_JSON)), handler::retrieveAll)
				.andRoute(GET("/playlists/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::retrievePlaylist)
				.andRoute(POST("/playlists").and(accept(MediaType.APPLICATION_JSON)), handler::createPlaylist);
	}
}