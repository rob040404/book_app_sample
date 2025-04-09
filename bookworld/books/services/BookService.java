package com.bookworld.books.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bookworld.books.model.Book;
import com.bookworld.books.model.BookRepository;
import com.bookworld.services.base.BaseService;

@Service 
public class BookService extends BaseService<Book, Long, BookRepository>{
	
	@Autowired
	BookRepository bookRepository;
	
	@Override
	public Book save(Book t) {
		// TODO Auto-generated method stub
		return super.save(t);
	}

	@Override
	public Optional<Book> findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Page<Book> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return super.findAll(pageable);
	}

	@Override
	public Book edit(Book t) {
		// TODO Auto-generated method stub
		return super.edit(t);
	}

	@Override
	public void delete(Book t) {
		// TODO Auto-generated method stub
		super.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	public List<Book> findBooksByTitleAndAuthors(String title, String authors){
		
	   List<Book> exactList = bookRepository.findByTitleIgnoreCaseAndAuthorsIgnoreCase(title, authors);
	   List<Book> exactTitleContainsAuthors = bookRepository.findByTitleIgnoreCaseAndAuthorsContainsIgnoreCase(title, authors);
	   List<Book> containsTitleAndAuthors = bookRepository.findByTitleContainsIgnoreCaseAndAuthorsContainsIgnoreCase(title, authors);
	   
	   //Esto funciona pra más de una lista
	   return Stream.of(exactList, exactTitleContainsAuthors, containsTitleAndAuthors)
               .flatMap(Collection::stream)
               .distinct()
               .collect(Collectors.toList());

	   /**
	    * Stream.of crea un flujo de listas.
		* flatMap transforma ese flujo de listas en un único flujo de elementos.
		* distinct elimina duplicados basándose en el método equals del objeto Book.
		* Finalmente, collect genera la lista resultante.
	    */
	   
	}
	
	public List<Book> findByTitle(String title){
		
		List<Book> booksList = bookRepository.findByTitleExact(title);
		List<Book> booksListLike = bookRepository.findByTitleContainingIgnoreCase(title);
		
		//A partir de JAVA 8
		return Stream.concat(booksList.stream(), booksListLike.stream())
						.distinct()
						.collect(Collectors.toList());
		
		//Para sumar las dos listas (títulos exactos y títulos aproximados) hay que hacer un set
		//Set<Book> set = new LinkedHashSet<>(booksList);
		//set.addAll(booksListLike);	//Sumamos la segunda lista al set
		
		//Volvemos a convertir en lista 
		//return new ArrayList<>(set);
	}
	
	public List<Book> findByAuthors(String authors){
		
		List<Book> exactList = bookRepository.findByAuthorsIgnoreCase(authors);
		List<Book> aproxList = bookRepository.findByAuthorsContainingIgnoreCase(authors);
		
		return Stream.concat(exactList.stream(), aproxList.stream())
				.distinct()
				.collect(Collectors.toList());
		
	}
	
	
}
