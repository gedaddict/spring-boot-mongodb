package com.example.springbootmongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todos")
public class Todo {

	@Id
	private String id;
	private String task;
	private String status;
	
	public Todo() {
		
	}
	
	public Todo (Todo todo) {
		this.id = todo.getId();
		this.task = todo.getTask();
		this.status = todo.getStatus();
	}
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
