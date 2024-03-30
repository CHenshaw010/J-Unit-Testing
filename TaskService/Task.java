/*
 * Author: Christian Henshaw
 */

package main;

public class Task {
	
	private static final byte MAX_TASK_ID_LENGTH = 10;
	private static final byte MAX_TASK_NAME_LENGTH = 20;
	private static final byte MAX_TASK_DESC_LENGTH = 50;
	
	private String taskId;
	private String taskName;
	private String taskDesc;
	
	public Task(String taskId, String taskName, String taskDesc) {
		if (taskId == null || taskId.length() > MAX_TASK_ID_LENGTH) {
			throw new IllegalArgumentException("Invalid Task ID.");
		}
		if (taskName == null || taskName.length() > MAX_TASK_NAME_LENGTH) {
			throw new IllegalArgumentException("Invalid Task Name.");
		}
		if (taskDesc == null || taskDesc.length() > MAX_TASK_DESC_LENGTH) {
			throw new IllegalArgumentException("Invalid Task Description.");
		}
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDesc = taskDesc;
	}
	
	public String getTaskId() {
		return taskId;
	}
	
	public String getTaskName() {
		return taskName;
	}

	public String getTaskDesc() {
		return taskDesc;
	}
	
	public void setTaskName(String newTaskName) {
		if (newTaskName == null || newTaskName.length() > MAX_TASK_NAME_LENGTH) {
			throw new IllegalArgumentException("Invalid Task Name.");
		} else {
			this.taskName = newTaskName;
		}
	}
	
	public void setTaskDesc(String newTaskDesc) {
		if (newTaskDesc == null || newTaskDesc.length() > MAX_TASK_DESC_LENGTH) {
			throw new IllegalArgumentException("Invalid Task Description.");
		} else {
			this.taskDesc = newTaskDesc;
		}
	}
}
