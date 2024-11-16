package com.projectexample.cli.tasktrackercli;

import java.time.LocalDateTime;
import java.io.*;
import java.util.*;

public class Task {

	/*
	 * o	id: Unique identifier for each task.
	   o	description: A description of the task.
	   o	status: Either "todo", "in-progress", or "done".
	   o	createdAt: When the task was created.
	   o	updatedAt: Last time the task was updated.

	 */
	private int id;
	private String description;
	private String taskStatus; // "todo", "in-progress", "done"
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public Task(int id, String description) {
		this.id = id;
		this.description = description;
		this.taskStatus = "todo"; //default status
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getTaskStatus() {
		return taskStatus;
	}
	
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
		this.updatedAt = LocalDateTime.now();
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public String toJSON() {
        return "{"
            + "\"id\":" + id + ","
            + "\"description\":\"" + description + "\","
            + "\"status\":\"" + taskStatus + "\","
            + "\"createdAt\":\"" + createdAt + "\","
            + "\"updatedAt\":\"" + updatedAt + "\""
            + "}";
    }
	
	public static Task fromJSON(String json) {
        // Parse JSON and create Task object (simplified for brevity)
        // You'd need to manually extract the fields from the JSON string
        return null;
    }
	
	@Override
    public String toString() {
        return "Task [id=" + id + ", description=" + description + ", status=" + taskStatus + 
               ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }
	

}
