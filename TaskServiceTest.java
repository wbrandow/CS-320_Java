/*
 *  William Brandow
 *  william.brandow@snhu.edu
 *  CS-320-H7332
 *  2022-11-17
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

/*
 *  Testing adding tasks		
 */
	@Test
	void testAddTask() {

		TaskService testTaskService = new TaskService();
			
		testTaskService.addTask("TaskID", "Test Name", "Test description");
			
		assertTrue(testTaskService.tasks.lastElement().getTaskID().equals("TaskID"));
		assertTrue(testTaskService.tasks.lastElement().getName().equals("Test Name"));
		assertTrue(testTaskService.tasks.lastElement().getDescription().equals("Test description"));
	}
		
	@Test
	void testAddNotUniqueID() {
		TaskService testTaskService = new TaskService();
			
		testTaskService.addTask("TaskID", "Test Name", "Test description");
			
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testTaskService.addTask("TaskID", "Test Name", "Test description");
		});
	}

/*
 *  Testing updating contacts	
 */
	@Test
	void testUpdateTask() {
		TaskService testTaskService = new TaskService();
			
		testTaskService.addTask("TaskID", "Test Name", "Test description");
			
		assertTrue(testTaskService.tasks.lastElement().getTaskID().equals("TaskID"));
		assertTrue(testTaskService.tasks.lastElement().getName().equals("Test Name"));
		assertTrue(testTaskService.tasks.lastElement().getDescription().equals("Test description"));
			
		testTaskService.updateTask("TaskID", "New Name", "New description");
			
		assertTrue(testTaskService.tasks.lastElement().getTaskID().equals("TaskID"));
		assertTrue(testTaskService.tasks.lastElement().getName().equals("New Name"));
		assertTrue(testTaskService.tasks.lastElement().getDescription().equals("New description"));
	}
		
	@Test
	void testUpdateIdDoesNotExist() {
		TaskService testTaskService = new TaskService();
			
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testTaskService.updateTask("TaskID", "New Name", "New description");
		});
	}

/*
 *  Testing deleting tasks	
 */
	@Test 
	void testDeleteTask() {
		TaskService testTaskService = new TaskService();
		
		testTaskService.addTask("TaskID", "Test Name", "Test description");
			
		assertTrue(testTaskService.tasks.size() == 1);
			
		testTaskService.deleteTask("TaskID");
			
		assertTrue(testTaskService.tasks.size() == 0);
	}

	@Test
	void testDeleteTaskDoesNotExist() {
        TaskService testTaskService = new TaskService();
			
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testTaskService.deleteTask("TaskID");
		});
	}
}
