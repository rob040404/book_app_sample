package com.bookworld.lists.model;

import com.bookworld.books.model.Book;

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
@Table(name="list_books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListBook {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idlist_book;
	
	// Relación con UserList (una lista puede tener muchos libros)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "list_id", nullable = false)
	private User_list list;
	
	// Relación con Book (un libro puede estar en muchas listas)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "book_id", nullable = false)
	private Book book;
}
