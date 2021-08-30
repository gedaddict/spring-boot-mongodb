package com.example.springbootmongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Sharded;

@Document(collection = "todos")
@Sharded(shardKey = { "taskid" })
public class Todo {

	@Id
	private String id;
	@Indexed
	private String taskid;
	private String task;
	private String status;
	
	public Todo() {
		
	}
	
	public Todo (Todo todo) {
		this.taskid = todo.getTaskid();
		this.task = todo.getTask();
		this.status = todo.getStatus();
	}
	
	// for testing only
	public Todo (String taskid, String task, String status) {
		this.taskid = taskid;
		this.task = task;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
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
	
}
