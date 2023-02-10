import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class AppointmentTest {

	
	@Test
	void testAppoinment() {
		
		Date currentDate = new Date();
		
		Appointment testAppointment = new Appointment("TestID", currentDate, "Test description");
		
		assertTrue(testAppointment.getAppointmentID().equals("TestID"));
		assertTrue(testAppointment.getDate().equals(currentDate));
		assertTrue(testAppointment.getDescription().equals("Test description"));
	}
	
/*
 *  Testing for exceptions with invalid ID	
 */
	@Test
	void testAppointmentIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Date currentDate = new Date();
			new Appointment("ThisIDisTooLong", currentDate, "Test description");
		});
	}
	
	@Test 
	void testIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, new Date(), "Test Description");
		});
	}
	
	
/*
 *  Testing for exceptions with invalid Date	
 */
	@Test
	void testDateInPast() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date testDate = sdf.parse("2022-11-26");
			new Appointment("TestID", testDate, "Test Description");
		});
	}
	
	@Test 
	void testDateNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("TestID", null, "Test Description");
		});
	}

/*
 *  Testing for exceptions with invalid description 
 */
	@Test
	void testDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("TestID", new Date(), "This description is over 50 characters and should, therefore, throw an exception.");
		});
	}
	
	@Test
	void testDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("TestID", new Date(), null);
		});
	}
}	
