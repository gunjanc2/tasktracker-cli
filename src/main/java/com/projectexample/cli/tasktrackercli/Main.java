package com.projectexample.cli.tasktrackercli;

public class Main {

	public static void main(String[] args) {
		TaskManager mgr = new TaskManager();
		if (args.length == 0) {
            System.out.println("No command provided. \nUse commands: 'add', 'update', 'delete', "
            		+ "'mark-in-progress', 'mark-done', 'list'");
            return;
        }
		
		String command = args[0];
		
		switch(command) {
		case "add": 
			if(args.length<2) {
				System.out.println("Please provide a task description.");
			} else {
				mgr.addTask(args[1]);
			}
			break;
		case "update":
			if(args.length<2) {
				System.out.println("Please provide task ID and new description.");
			} else {
				mgr.updateTask(Integer.parseInt(args[1]), args[2]);
			}
			break;
		case "delete":
			if(args.length<2) {
				System.out.println("Please provide task ID to delete.");
			} else {
				mgr.deleteTask(Integer.parseInt(args[1]));
			}
			break;
		case "mark-in-progress":
			if(args.length<2) {
				System.out.println("Please provide task ID to mark in-progress.");
			} else {
				mgr.markTaskInProgress(Integer.parseInt(args[1]));
			}
			break;
		case "mark-done":
			if(args.length<2) {
				System.out.println("Please provide task ID to mark done.");
			} else {
				mgr.markTaskDone(Integer.parseInt(args[1]));
			}
			break;
		case "list":
				mgr.listTasks();
			break;
			
		default: System.out.println("Invalid command:: "+command);
		
		}
	}
	
}
