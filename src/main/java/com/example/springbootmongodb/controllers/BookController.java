package com.example.springbootmongodb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootmongodb.models.Book;
import com.example.springbootmongodb.repositories.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	private Book book;
	
	@GetMapping("")
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	@GetMapping("/{booknumber}")
	public ResponseEntity<Book> getBook(@PathVariable("booknumber") String booknumber) {
		book = bookRepository.findById(booknumber).map(Book::new).get();
		return new ResponseEntity<Book>(book, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("")
	public ResponseEntity<Book> addBook(@RequestBody Book book)	 {
	
		book = bookRepository.save(book);
		return new ResponseEntity<Book>(book, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{booknumber}")
	public String deleteBook(@PathVariable ("booknumber") String booknumber)	 {
	
		bookRepository.deleteById(booknumber);
		return "Booknumber " +booknumber + " deleted.";
	}
}
