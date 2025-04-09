package com.bookworld.books.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class GetBookDTO {

	//Hacer DTO para recibir la info que pasa el usuario y usar este DTO para pasar nosotros la info del libro.
	private Long id;
	private String title;
	private String authors;
	private String description;
	private String genders;
	private String lang;
	private String image;
	private Float rating;
	private Integer numVotes;
}
