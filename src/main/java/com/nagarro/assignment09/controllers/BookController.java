package com.nagarro.assignment09.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.assignment09.entity_class.Authors;
import com.nagarro.assignment09.entity_class.Books;
import com.nagarro.assignment09.repository.BookRepository;

@Service
@RestController
public class BookController {

	
	private BookRepository bookRepository;
	
	
	@Autowired
	public BookController(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}
	

	@GetMapping("/books")
	public List<Books> getBooks() {
		List<Books> books = bookRepository.findAll();
		return books;
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Books> getUsersById(@PathVariable(value = "id") int bookId)
		      throws AttributeNotFoundException {
		    Books book =
		    		bookRepository
		            .findById(bookId)
		            .orElseThrow(() -> new AttributeNotFoundException("User not found on :: " + bookId));
		    return ResponseEntity.ok().body(book);
	}
	
	 @PostMapping("/book")
	 public Books createUser(@RequestBody Books book) {
	    
		 return bookRepository.save(book);
	 
	 }
	 	 
	 @DeleteMapping("/book/{bookCode}")
	 public Map<String, Boolean> deleteBook(@PathVariable(value = "bookCode") int bookCode) throws Exception {
		    Books book =
		        bookRepository
		            .findById(bookCode)
		            .orElseThrow(() -> new AttributeNotFoundException("User not found on :: " + bookCode));

		    bookRepository.delete(book);
		    Map<String, Boolean> response = new HashMap<>();
		    response.put("deleted", Boolean.TRUE);
		    return response;
	 }
	 
	 
	 @PutMapping("/book/{id}")
	 public ResponseEntity<Books> updateUser(
	      @PathVariable(value = "id") int bookId, @RequestBody Books bookDetails)
	      throws AttributeNotFoundException {

	    Books book =
	        bookRepository
	            .findById(bookId)
	            .orElseThrow(() -> new AttributeNotFoundException("User not found on :: " + bookId));

	    book.setBookCode(bookDetails.getBookCode());
	    book.setBookName(bookDetails.getBookName());
	    book.setCreatedAt(bookDetails.getCreatedAt());
	    book.setAuthor(bookDetails.getAuthor());

	    final Books updatedBooks = bookRepository.save(book);
	    return ResponseEntity.ok(updatedBooks);
	  }
}
