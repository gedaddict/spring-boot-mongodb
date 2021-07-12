package com.example.springbootmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springbootmongodb.models.Book;

public interface BookRepository extends MongoRepository<Book, String>{

}
