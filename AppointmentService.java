/*
 *  William Brandow
 *  william.brandow@snhu.edu
 *  CS-320-H7332
 *  2022-11-26
 */

import java.util.Vector;
import java.util.Date;

public class AppointmentService {
    
	Vector<Appointment> appointments;
	
	public AppointmentService() {
		appointments = new Vector<Appointment>();	
	}
	
/*
 *  Add new appointment to vector	
 */	
		
	public void addAppointment(String id, Date date, String description) {
		for (int i = 0; i < this.appointments.size(); i++) {
	        if (id.equals(this.appointments.elementAt(i).getAppointmentID())) {
				throw new IllegalArgumentException("Appointment ID already exists.");
			}
		}
			
		Appointment newAppointment = new Appointment(id, date, description);
			
		this.appointments.add(newAppointment);
	}
	
/*
 *  Delete existing appointment	
 */
	public void deleteAppointment(String id) {
			
		boolean appointmentFound = false;
			
		for (int i = 0; i < this.appointments.size(); i++) {
			if (id.equals(this.appointments.elementAt(i).getAppointmentID())) {
				this.appointments.remove(i);
				appointmentFound = true;
				break;
			}
		}	
				
		if (appointmentFound == false) {
			throw new IllegalArgumentException("ID does not exist.");
		}
	}
}
