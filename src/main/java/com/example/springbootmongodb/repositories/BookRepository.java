package com.example.springbootmongodb.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.springbootmongodb.models.Book;

public interface BookRepository extends MongoRepository<Book, String>{

	@Query("{ 'booknumber' : ?0 }")
	Book findByBooknumber(String booknumber);
	
	@Query(value="{'booknumber' : ?0}", delete = true)
	void deleteByBooknumber(String booknumber);
}
