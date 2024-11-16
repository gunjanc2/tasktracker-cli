package com.projectexample.cli.tasktrackercli;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {  
	
	private static final String FILE_NAME = "C:\\Users\\Dell\\OneDrive\\Desktop\\Personal Projects\\Java\\Task Tracker CLI\\Output - Copy\\tasks.json";
	private List<Task> tasks;
	
	public TaskManager() {
        tasks = new ArrayList<>();
        loadTasksFromFile();
    }
	
	public void addTask(String description) {	    
        int id = tasks.isEmpty() ? 1 : tasks.get(tasks.size() - 1).getId() + 1;
        Task newTask = new Task(id, description);
        tasks.add(newTask);
        saveTasksToFile();
        System.out.println("Task added successfully (ID: " + id + ")");
    }
	
	public void updateTask(int id, String newDescription) {
        Task task = getTaskById(id);
        if (task != null) {
            task.setDescription(newDescription);
            task.setUpdatedAt(LocalDateTime.now());
            saveTasksToFile();
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }
	
	public void deleteTask(int id) {
        Task task = getTaskById(id);
        if (task != null) {
            tasks.remove(task);
            saveTasksToFile();
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }
	
	public void markTaskInProgress(int id) {
        Task task = getTaskById(id);
        if (task != null) {
            task.setTaskStatus("in-progress");
            saveTasksToFile();
            System.out.println("Task marked as in-progress.");
        } else {
            System.out.println("Task not found.");
        }
    }
	
	public void markTaskDone(int id) {
        Task task = getTaskById(id);
        if (task != null) {
            task.setTaskStatus("done");
            saveTasksToFile();
            System.out.println("Task marked as done.");
        } else {
            System.out.println("Task not found.");
        }
    }
	
	public void listTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
	
	public void listTasksByStatus(String status) {
        for (Task task : tasks) {
            if (task.getTaskStatus().equalsIgnoreCase(status)) {
                System.out.println(task);
            }
        }
    }
	
	private void loadTasksFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                Task task = Task.fromJSON(line);
                tasks.add(task);
            }
        } catch (IOException e) {
            System.out.println("Error reading tasks from file.");
        }
    }
	
	private void saveTasksToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                bw.write(task.toJSON());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing tasks to file.");
        }
    }
	
	private Task getTaskById(int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }
	
	/* Rewrite getTaskById() method without using Stream:
	 * private Task getTaskById1(int id) {
	 * for (Task task : tasks) {
	 * 		if (task.getId() == id) {
	 *          return task;
	 *      }
	 *  }
	 *  return null;
	 * }
	 */
	    
}
