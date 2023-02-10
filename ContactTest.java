/*
 *  William Brandow
 *  william.brandow@snhu.edu
 *  CS-320-H7332
 *  2022-11-14
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testContact() {
	
		Contact testContact = new Contact("wbrandow", "Bill", "Brandow", "6812859575", "904 Charles Avenue");
		
		assertTrue(testContact.getContactID().equals("wbrandow"));
		assertTrue(testContact.getFirstName().equals("Bill"));
		assertTrue(testContact.getLastName().equals("Brandow"));
		assertTrue(testContact.getPhone().equals("6812859575"));
		assertTrue(testContact.getAddress().equals("904 Charles Avenue"));
	}

/*
 *  Testing for exceptions with improper lengths	
 */
	@Test
	void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678987654321", "Bill", "Brandow", "6812859575", "904 Charles Avenue");
		});
	}
	
	@Test
	void testFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testFName", "ThisIsTooLong", "Brandow", "6812859575", "904 Charles Avenue");
		});
	}
	
	@Test
	void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testLName", "Bill", "ThisIsTooLong", "6812859575", "904 Charles Avenue");
		});
	}
	
	@Test
	void testPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testFName", "Bill", "Brandow", "12345678909876", "904 Charles Avenue");
		});
	}
	
	@Test
	void testPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testFName", "Bill", "Brandow", "123", "904 Charles Avenue");
		});
	}	
	
	@Test
	void testAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testFName", "Bill", "Brandow", "6812859575", "904 Charles Avenue is fine but this is TOO LONG");
		});
	}

/*
 *  Testing for exceptions with null values	
 */
	@Test
	void testContactIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Bill", "Brandow", "6812859575", "904 Charles Avenue");
		});
	}
	
	@Test
	void testFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testFName", null, "Brandow", "6812859575", "904 Charles Avenue");
		});
	}
	
	@Test
	void testLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testLName", "Bill", null, "6812859575", "904 Charles Avenue");
		});
	}
	
	@Test
	void testPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testFName", "Bill", "Brandow", null, "904 Charles Avenue");
		});
	}	
	
	@Test
	void testAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testFName", "Bill", "Brandow", "6812859575", null);
		});
	}
}
