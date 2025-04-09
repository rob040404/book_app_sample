package com.bookworld.books.dto.converter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.bookworld.books.dto.GetBookDTO;
import com.bookworld.books.model.Book;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BookDTOConverter {

	public GetBookDTO toGetBookDTO(Book book) {
		
		return GetBookDTO.builder()
				.id(book.getId())
				.title(book.getTitle())
				.authors(book.getAuthors())
				.description(book.getDescription())
				.genders(book.getGenders())
				.lang(book.getLang())
				.image(book.getImage())
				.rating(book.getRating())
				.numVotes(book.getNumVotes())
				.build();
	}
	
	public GetBookDTO toGetOptionalBookDTO(Optional<Book> book) {
		
		return GetBookDTO.builder()
				.id(book.get().getId())
				.title(book.get().getTitle())
				.authors(book.get().getAuthors())
				.description(book.get().getDescription())
				.genders(book.get().getGenders())
				.lang(book.get().getLang())
				.image(book.get().getImage())
				.rating(book.get().getRating())
				.numVotes(book.get().getNumVotes())
				.build();
	}
}
