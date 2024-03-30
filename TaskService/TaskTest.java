/*
 * Author: Christian Henshaw
 */

package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Task;

class TaskTest {

	public String taskId, taskNameTest, taskDescTest;
	public String taskIdTooLong, taskNameTestTooLong, taskDescTestTooLong;
	
	@BeforeEach
	void testTaskSetUp() {
		taskId = "0102030405";
		taskNameTest = "Connect Internet";
		taskDescTest = "Connecting to the Internet from Device.";
		
		taskIdTooLong = "0102030405060708090";
		taskNameTestTooLong = "Connect to Internet if the North Pole became a Jungle";
		taskDescTestTooLong = "Connecting to the Internet from Device while the Blueberries grow.";
	}
	
	//Tests creating new task. Ensures correct values are utilized for each variable.
	@Test
	void testTask() {
		Task newTask = new Task(taskId, taskNameTest, taskDescTest);
		assertAll("Creating New Task.", 
		() -> assertEquals(taskId, newTask.getTaskId()),
		() -> assertEquals(taskNameTest, newTask.getTaskName()),
		() -> assertEquals(taskDescTest, newTask.getTaskDesc()));
		
		assertAll("Creating New Task with Bad Values.",
		() -> assertThrows(IllegalArgumentException.class, () -> new Task(taskIdTooLong, taskNameTest, taskDescTest)),
		() -> assertThrows(IllegalArgumentException.class, () -> new Task(taskId, taskNameTestTooLong, taskDescTest)),
		() -> assertThrows(IllegalArgumentException.class, () -> new Task(taskId, taskNameTest, taskDescTestTooLong)));
	}	

	//Tests directly updating task name. Ensures new task name is utilized and exceptions are thrown for too long or null values.
	@Test
	void udpateTaskNameTest() {
		Task newTask = new Task(taskId, taskNameTest, taskDescTest);
		assertAll("Task Name Test.", 
		() -> assertEquals(taskNameTest, newTask.getTaskName()),
		() -> assertThrows(IllegalArgumentException.class, () -> newTask.setTaskName(null)),
		() -> assertThrows(IllegalArgumentException.class, () -> newTask.setTaskName(taskNameTestTooLong)));
	}
	
	//Tests directly updating task description. Ensures new task description is utilized and exceptions are thrown for too long or null values.
	@Test
	void udpateTaskDescTest() {
		Task newTask = new Task(taskId, taskNameTest, taskDescTest);
		assertAll("Task Description Test.", 
		() -> assertEquals(taskDescTest, newTask.getTaskDesc()),
		() -> assertThrows(IllegalArgumentException.class, () -> newTask.setTaskDesc(null)),
		() -> assertThrows(IllegalArgumentException.class, () -> newTask.setTaskDesc(taskDescTestTooLong)));
	}
}