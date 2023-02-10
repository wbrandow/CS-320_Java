/*
 *  William Brandow
 *  william.brandow@snhu.edu
 *  CS-320-H7332
 *  2022-11-16
 */

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
	
	@Test
	void testTask() {
	
		Task testTask = new Task("TestID", "Test Name", "Test description");
		
		assertTrue(testTask.getTaskID().equals("TestID"));
		assertTrue(testTask.getName().equals("Test Name"));
		assertTrue(testTask.getDescription().equals("Test description"));
	}

/*
 *  Testing for exceptions with improper lengths	
 */
	@Test
	void testTaskIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("ThisIDisTooLong", "Test Name", "Test description");
		});
	}
	
	@Test
	void testNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("testID", "This Name Is Too Long and Should Throw Exception", "Test description");
		});
	}
	
	@Test
	void testDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("TestID", "Test Name", "This description is too long and it will throw and exception");
		});
	}

/*
 *  Testing for exceptions with null values	
 */	
	@Test
	void testTaskIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Test Name", "Test description");
		});
	}
	
	@Test
	void testNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("testID", null, "Test description");
		});
	}
	
	@Test
	void testDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("TestID", "Test Name", null);
		});
	}	
}

    
