/*
 *  William Brandow
 *  william.brandow@snhu.edu
 *  CS-320-H7332
 *  2022-11-26
 */

import java.util.Date;

public class Appointment {

	private String appointmentID;
	private Date appointmentDate;
	private String description;

/*
 *  Constructor	
 */
	public Appointment(String id, Date date, String description) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID.");
		}
		
		this.appointmentID = id;
		this.setDate(date);
		this.setDescription(description);
	}

/*
 *  Appoinment ID	
 */
    public String getAppointmentID() {
    	return this.appointmentID;
    }
	
/*
 *  Appointment Date	
 */
	public void setDate(Date date) {
		
		if (date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid Date.");
		}
		
		this.appointmentDate = date;
	}
	
	public Date getDate() {
		return this.appointmentDate;
	}

/*
 *  Description	
 */
	public void setDescription(String description) {
		
        if (description == null || description.length() > 50) {
        	throw new IllegalArgumentException("Invalid Description.");
        }
        
        this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
}
