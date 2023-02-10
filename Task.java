/*
 *  William Brandow
 *  william.brandow@snhu.edu
 *  CS-320-H7332
 *  2022-11-16
 */

public class Task {
	
	private String taskID;
	private String name;
	private String description;
	
/*
 *  Constructor	
 */
	public Task(String id, String name, String description) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID.");
		}
			
		this.taskID = id;
		this.setName(name);
		this.setDescription(description);
	}

/*
 *  TaskID	
 */
	public String getTaskID() {
		return this.taskID;
	}
	
/*
 *  Name	
 */
	public void setName(String name) {
		if (name == null || name.length() > 20) {
	        throw new IllegalArgumentException("Invalid name.");
		}
			
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}	

/*
 *  Description
 */
	public void setDescription(String description) {
		if (description == null || description.length() > 50) {
	        throw new IllegalArgumentException("Invalid description.");
		}		
		
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}	
	
}
