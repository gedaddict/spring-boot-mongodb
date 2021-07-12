package com.example.springbootmongodb.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class Book {
	
	@Id
	private String booknumber;
	private String name;
	private String author;
	private List<String> genre;
	private int edition;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book(Book book) {
		this.booknumber = book.getBooknumber();
		this.name = book.getName();
		this.author = book.getAuthor();
		this.genre = book.getGenre();
		this.edition = book.getEdition();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public List<String> getGenre() {
		return genre;
	}
	public void setGenre(List<String> genre) {
		this.genre = genre;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}

	public String getBooknumber() {
		return booknumber;
	}

	public void setBooknumber(String booknumber) {
		this.booknumber = booknumber;
	}
	
	
}
