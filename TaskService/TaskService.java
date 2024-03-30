/*
 * Author: Christian Henshaw
 */

package main;

import java.util.ArrayList;

public class TaskService {
	private ArrayList<Task> Tasks = new ArrayList<Task>();
	
	public void addNewTask(String taskId, String taskName, String taskDesc) {
		boolean taskIdExists = false;
		if (!Tasks.isEmpty()) {
			for (int i = 0; i < Tasks.size(); ++i) {
				if (taskId.equals(Tasks.get(i).getTaskId())) {
					taskIdExists = true;
					throw new IllegalArgumentException("Task ID Already Exists. No New Task Added.");
				}
			}
		}
		if (taskIdExists == false) {
			Task newTask = new Task(taskId, taskName, taskDesc);
			Tasks.add(newTask);
			System.out.println("New Task Created Successfully!");
		}
	}

	public void deleteOldTask(String taskId) throws Exception {
		Tasks.remove(searchTasks(taskId));
		System.out.println("Task Deleted Successfully!");
	}

	public void updateTaskName(String taskId, String newTaskName) throws Exception {
		searchTasks(taskId).setTaskName(newTaskName);
		System.out.println("Task Name Updated Successfully!");
	}

	public void updateTaskDesc(String taskId, String newTaskDesc) throws Exception {
		searchTasks(taskId).setTaskDesc(newTaskDesc);
		System.out.println("Task Description Updated Successfully!");
	}
	
	public ArrayList<Task> getTaskList() {
		return Tasks;
	}
	
	public Task searchTasks(String taskId) throws Exception {
		int iterator = 0;
		while (iterator < Tasks.size()) {
			if (taskId.equals(Tasks.get(iterator).getTaskId())) {
				return Tasks.get(iterator);
			}
			iterator++;
		}
		throw new Exception("Task does not exist.");
	}
}
