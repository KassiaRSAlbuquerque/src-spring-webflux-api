package io.github.kassiarsalbuquerque.WebFlux.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document
@Data
@Builder
public class Playlist{
	
	@Id
	private String id;
	private String nome;
}
