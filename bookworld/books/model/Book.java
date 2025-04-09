package com.bookworld.books.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="books")
@Data
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String title;
	private String authors;
	private String lang;
	
	@Lob	//Hace que la columna en la BD pueda almacenar textos largos, como TEXT o LONGTEXT
	private String description;
	//private int pages; //Cuidado, cada editorial es diferente
	//private int year; //Año de publicación si se puede. Lo mismo hay que cambiarlo a String si hay casos donde es indefinido o un intervalo
	
	//Poner @Lob si no coge todos los géneros
	private String genders;
	private String image;
	
	
	@Column(nullable = true)
	private Float rating; //si es float no admite null, y en este caso necesitamos que si no hay valoraciones esté en null
	private Integer numVotes;

	@CreatedDate
	private LocalDateTime createdAt;

	
	
	
}
