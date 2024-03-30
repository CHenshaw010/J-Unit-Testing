/*
 * Author: Christian Henshaw
 */

package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.TaskService;

class TaskServiceTest {

	public String taskId, taskNameTest, taskDescTest;
	public String taskIdTooLong, taskNameTestTooLong, taskDescTestTooLong;
	
	@BeforeEach
	void testTaskSetUp() {
		taskId = "1122334455";
		taskNameTest = "Connect Device";
		taskDescTest = "Connecting to the Device from Computer.";
		
		taskIdTooLong = "112233445566778899";
		taskNameTestTooLong = "Connect to Device if the Blue Ridge Mountains became an Oasis";
		taskDescTestTooLong = "Connecting to the Device from Computer while the Woodpeckers peck.";
	}

	//Tests creating a new task and ensures proper values are utilized.
	//Tests creating a duplicate task and ensures errors are thrown for duplicate task IDs.
		@Test
		void newTaskTest() {
			TaskService newTaskService = new TaskService();
			newTaskService.addNewTask(taskId, taskNameTest, taskDescTest);
			assertAll("Add New Task Tests.",
				() -> assertEquals(taskId, newTaskService.getTaskList().get(0).getTaskId()),
				() -> assertNotNull(newTaskService.getTaskList().get(0).getTaskId()),
				
				() -> assertEquals(taskNameTest, newTaskService.getTaskList().get(0).getTaskName()),
				() -> assertNotNull(newTaskService.getTaskList().get(0).getTaskName()),
				
				() -> assertEquals(taskDescTest, newTaskService.getTaskList().get(0).getTaskDesc()),
				() -> assertNotNull(newTaskService.getTaskList().get(0).getTaskDesc()));
			
			assertThrows(IllegalArgumentException.class, 
					() -> newTaskService.addNewTask(taskId, taskNameTest, taskDescTest));
		}
		
		//Tests deleting a task after it has been added to Tasks ArrayList.
		@Test
		void deleteOldTaskTest() throws Exception {
			TaskService newTaskService = new TaskService();
			newTaskService.addNewTask(taskId, taskNameTest, taskDescTest);
			assertAll("Delete Contacts Test", 
				() -> newTaskService.deleteOldTask(newTaskService.getTaskList().get(0).getTaskId()));
		}
		
		//Tests updating task name. Ensures new task name is utilized and exceptions are thrown for too long or null values.
		@Test
		void updateTaskNameTest() throws Exception {
			TaskService newTaskService = new TaskService();
			newTaskService.addNewTask(taskId, taskNameTest, taskDescTest);
			newTaskService.updateTaskName(newTaskService.getTaskList().get(0).getTaskId(), "Bluetooth");
			assertEquals("Bluetooth", newTaskService.getTaskList().get(0).getTaskName());
			assertThrows(IllegalArgumentException.class, 
				() -> newTaskService.updateTaskName(newTaskService.getTaskList().get(0).getTaskId(), taskNameTestTooLong));
			assertThrows(IllegalArgumentException.class, 
					() -> newTaskService.updateTaskName(newTaskService.getTaskList().get(0).getTaskId(), null));
		}
		
		//Tests updating task description. Ensures new task description is utilized and exceptions are thrown for too long or null values.
		@Test
		void updateTaskDescTest() throws Exception {
			TaskService newTaskService = new TaskService();
			newTaskService.addNewTask(taskId, taskNameTest, taskDescTest);
			newTaskService.updateTaskDesc(newTaskService.getTaskList().get(0).getTaskId(), "Hummingbird Feeder");
			assertEquals("Hummingbird Feeder", newTaskService.getTaskList().get(0).getTaskDesc());
			assertThrows(IllegalArgumentException.class, 
				() -> newTaskService.updateTaskDesc(newTaskService.getTaskList().get(0).getTaskId(), taskDescTestTooLong));
			assertThrows(IllegalArgumentException.class, 
					() -> newTaskService.updateTaskDesc(newTaskService.getTaskList().get(0).getTaskId(), null));
		}
		
		//Tests searching Tasks ArrayList. Ensures set values are correct for each variable.
		@Test
		void searchContactsTest() {
			TaskService newTaskService = new TaskService();
			newTaskService.addNewTask(taskId, taskNameTest, taskDescTest);
			assertEquals(taskId, newTaskService.getTaskList().get(0).getTaskId());
			assertEquals(taskNameTest, newTaskService.getTaskList().get(0).getTaskName());
			assertEquals(taskDescTest, newTaskService.getTaskList().get(0).getTaskDesc());
		}
}
