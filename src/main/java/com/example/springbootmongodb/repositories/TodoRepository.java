package com.example.springbootmongodb.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.springbootmongodb.models.Todo;

public interface TodoRepository extends MongoRepository<Todo, String>{

	@Query("{ 'taskid' : ?0 }")
	Todo findByTaskId(String todoId);
	
	@Query(value="{'taskid' : ?0}", delete = true)
	void deleteByTaskId(String todoId);
	
}
