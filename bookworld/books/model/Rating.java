package com.bookworld.books.model;

import com.bookworld.user.model.UserEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ratings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false) // Nombre de la clave foránea en la tabla Rating
    private UserEntity user; // Cambia "UserEntity" si tu clase de usuario tiene otro nombre

	
	@ManyToOne(fetch = FetchType.LAZY, optional = false) // Relación con Book
	@JoinColumn(name = "book_id", nullable = false) // Nombre de la clave foránea en la tabla Rating
	private Book book;
	
	private int rating;
	
}
