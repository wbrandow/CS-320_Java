import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class AppointmentServiceTest {

/*
 *  Testing adding appointments		
 */
	@Test
	void testAddAppointment() throws ParseException {

		AppointmentService testAppointmentService = new AppointmentService();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		
		Date testDate = sdf.parse("2100-11-30");
		
		testAppointmentService.addAppointment("TestID", testDate, "Test description");
				
		assertTrue(testAppointmentService.appointments.lastElement().getAppointmentID().equals("TestID"));
		assertTrue(testAppointmentService.appointments.lastElement().getDate().equals(testDate));
		assertTrue(testAppointmentService.appointments.lastElement().getDescription().equals("Test description"));
	}
	
	@Test
	void testAddNotUniqueID() {
		AppointmentService testAppointmentService = new AppointmentService();
			
		testAppointmentService.addAppointment("TestID", new Date(), "Test description");
			
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testAppointmentService.addAppointment("TestID", new Date(), "Test description");
		});
	}

/*
 *  Testing deleting tasks	
 */
	@Test 
	void testDeleteAppointment() {
		AppointmentService testAppointmentService = new AppointmentService();
			
		testAppointmentService.addAppointment("TestID", new Date(), "Test description");
				
		assertTrue(testAppointmentService.appointments.size() == 1);
				
		testAppointmentService.deleteAppointment("TestID");
				
		assertTrue(testAppointmentService.appointments.size() == 0);
	}

	@Test
	void testDeleteAppointmentDoesNotExist() {
		AppointmentService testAppointmentService = new AppointmentService();
				
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testAppointmentService.deleteAppointment("TestID");
		});
	}	
}
