/*
 *  William Brandow
 *  william.brandow@snhu.edu
 *  CS-320-H7332
 *  2022-11-17
 */

import java.util.Vector;

public class TaskService {
	public Vector<Task> tasks;
	
	public TaskService() {
		tasks = new Vector<Task>();
	}

/*
 *  Add new contact to vector	
 */	
	
	public void addTask(String id, String name, String description) {
		for (int i = 0; i < this.tasks.size(); i++) {
	        if (id.equals(this.tasks.elementAt(i).getTaskID())) {
				throw new IllegalArgumentException("Task ID already exists.");
			}
		}
		
		Task newTask = new Task(id, name, description);
		
		this.tasks.add(newTask);
	}
/*
 *  Update existing task	
 */
	public void updateTask(String id, String name, String description) {
		
		boolean taskFound = false;
			
		for (int i = 0; i < this.tasks.size(); i++) {
			if (id.equals(this.tasks.elementAt(i).getTaskID())) {
				this.tasks.elementAt(i).setName(name);
				this.tasks.elementAt(i).setDescription(description);
				taskFound = true;
				break;
			}
		}
			
		if (taskFound == false) {
			throw new IllegalArgumentException("ID does not exist.");
		}    
	}
	
/*
 *  Delete existing task	
 */
	public void deleteTask(String id) {
		
		boolean taskFound = false;
			
		for (int i = 0; i < this.tasks.size(); i++) {
			if (id.equals(this.tasks.elementAt(i).getTaskID())) {
				this.tasks.remove(i);
				taskFound = true;
				break;
			}
		}	
			
		if (taskFound == false) {
			throw new IllegalArgumentException("ID does not exist.");
		}
	}	
}
