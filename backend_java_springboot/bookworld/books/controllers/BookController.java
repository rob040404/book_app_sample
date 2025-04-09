package com.bookworld.books.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookworld.books.dto.GetBookDTO;
import com.bookworld.books.dto.converter.BookDTOConverter;
import com.bookworld.books.error.InvalidBookSearchException;
import com.bookworld.books.model.Book;
import com.bookworld.books.services.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private final BookDTOConverter bookDTOConverter;
	
	@PostMapping(value="/book/search")
	public ResponseEntity<?> searchBook(@RequestBody GetBookDTO petitionDTO) {
		
		if(petitionDTO.getId() != null) {
			Optional<Book> book = bookService.findById(petitionDTO.getId());
			GetBookDTO getBookDTO = bookDTOConverter.toGetOptionalBookDTO(book);
			return ResponseEntity.ok(getBookDTO);
		}
		else if(petitionDTO.getTitle() !=null && petitionDTO.getAuthors() != null) {
			List<Book> booksList = bookService.findBooksByTitleAndAuthors(petitionDTO.getTitle(), petitionDTO.getAuthors());
			List<GetBookDTO> getBookDTOList = booksList.stream().map(bookDTOConverter::toGetBookDTO).collect(Collectors.toList()); //Ver si funciona
			return ResponseEntity.ok(getBookDTOList);
		}
		//Búsqueda solo por título
		else if(petitionDTO.getTitle() !=null) {
			List<Book> booksList = bookService.findByTitle(petitionDTO.getTitle());
			List<GetBookDTO> getBookDTOList = booksList.stream().map(bookDTOConverter::toGetBookDTO).collect(Collectors.toList());
			return ResponseEntity.ok(getBookDTOList);
		}
		//Búsqueda solo por autores
		else if(petitionDTO.getAuthors() != null) {
			List<Book> booksList = bookService.findByAuthors(petitionDTO.getAuthors());
			List<GetBookDTO> getBookDTOList = booksList.stream().map(bookDTOConverter::toGetBookDTO).collect(Collectors.toList());
			return ResponseEntity.ok(getBookDTOList);
		}
		else {	
			throw new InvalidBookSearchException();
		}
	}
}
