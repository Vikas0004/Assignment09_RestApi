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
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.assignment09.repository.AuthorRepository;
import com.nagarro.entity_class.Authors;
import com.nagarro.entity_class.Books;

@Service
@RestController
public class AuthorController {

	private AuthorRepository authorRepository;

	@Autowired
	public AuthorController(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}
	
	@GetMapping("/authors")
	public List<Authors> getAuthors() {
		List<Authors> listAuthors = authorRepository.findAll();
		
		return listAuthors;
		
	}
	
	@GetMapping("/author/{id}")
	public ResponseEntity<Authors> getUsersById(@PathVariable(value = "id") String authorName)
		      throws AttributeNotFoundException {
		    Authors author =
		    		authorRepository
		            .findById(authorName)
		            .orElseThrow(() -> new AttributeNotFoundException("User not found on :: " + authorName));
		    return ResponseEntity.ok().body(author);
	}
	
	 @PostMapping("/author")
	 public Authors createUser(@RequestBody Authors author) {
	    
		 return authorRepository.save(author);
	 
	 }
	 
	 
	 
	 @PutMapping("/author/{id}")
	 public ResponseEntity<Authors> updateUser(
	      @PathVariable(value = "id")  String authorName, @RequestBody Authors authorDetails)
	      throws AttributeNotFoundException {

	    Authors author =
	    		authorRepository
	            .findById(authorName)
	            .orElseThrow(() -> new AttributeNotFoundException("User not found on :: " + authorName));

	    author.setAuthorName(authorDetails.getAuthorName());
	 

	    final Authors updatedAuthor = authorRepository.save(author);
	    return ResponseEntity.ok(updatedAuthor);
	  }

	 
	 @DeleteMapping("/author/{authorName}")
	 public Map<String, Boolean> deleteBook(@PathVariable(value = "authorName") String authorName) throws Exception {
		    Authors author =
		    		authorRepository
		            .findById(authorName)
		            .orElseThrow(() -> new AttributeNotFoundException("User not found on :: " + authorName));

		    authorRepository.delete(author);
		    Map<String, Boolean> response = new HashMap<>();
		    response.put("deleted", Boolean.TRUE);
		    return response;
	 }
	
}
