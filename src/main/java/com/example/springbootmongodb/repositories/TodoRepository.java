package com.example.springbootmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springbootmongodb.models.Todo;

public interface TodoRepository extends MongoRepository<Todo, String>{

}
