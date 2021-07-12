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

import com.example.springbootmongodb.models.Todo;
import com.example.springbootmongodb.repositories.TodoRepository;

@RestController
@RequestMapping("/todo")
public class TodoController {
	
	@Autowired
	private TodoRepository todoRepository;
	
	@GetMapping("")
	public List<Todo> getAllTodo() {
		return todoRepository.findAll();
	}
	
	@GetMapping("/{todoId}")
	public Todo getTodo(@PathVariable("todoId") String todoId) {
		return todoRepository.findById(todoId).map(Todo::new).get();
	}
	
	@PostMapping("")
	public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
		Todo newTodo = todoRepository.save(todo);
		return new ResponseEntity<Todo>(newTodo, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{todoId}")
	public String deleteTodo(@PathVariable("todoId") String todoId) {
		todoRepository.deleteById(todoId);
		return "todoId " +todoId + " is done";
	}

}
