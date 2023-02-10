/*
 *  William Brandow
 *  william.brandow@snhu.edu
 *  CS-320-H7332
 *  2022-11-14
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

/*
 *  Testing adding contacts		
 */
	@Test
	void testAddContact() {

		ContactService testContactService = new ContactService();
		
		testContactService.addContact("wbrandow", "Bill", "Brandow", "6812859575", "904 Charles Avenue");
		
		assertTrue(testContactService.contacts.lastElement().getContactID().equals("wbrandow"));
		assertTrue(testContactService.contacts.lastElement().getFirstName().equals("Bill"));
		assertTrue(testContactService.contacts.lastElement().getLastName().equals("Brandow"));
		assertTrue(testContactService.contacts.lastElement().getPhone().equals("6812859575"));
		assertTrue(testContactService.contacts.lastElement().getAddress().equals("904 Charles Avenue"));
	}
	
	@Test
	void testAddNotUniqueID() {
		ContactService testContactService = new ContactService();
		
		testContactService.addContact("wbrandow", "Bill", "Brandow", "6812859575", "904 Charles Avenue");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContactService.addContact("wbrandow", "Bill", "Brandow", "6812859575", "904 Charles Avenue");
		});
	}

/*
 *  Testing updating contacts	
 */
	@Test
	void testUpdateContact() {
		ContactService testContactService = new ContactService();
		
		testContactService.addContact("wbrandow", "Bill", "Brandow", "6812859575", "904 Charles Avenue");
		
		assertTrue(testContactService.contacts.lastElement().getContactID().equals("wbrandow"));
		assertTrue(testContactService.contacts.lastElement().getFirstName().equals("Bill"));
		assertTrue(testContactService.contacts.lastElement().getLastName().equals("Brandow"));
		assertTrue(testContactService.contacts.lastElement().getPhone().equals("6812859575"));
		assertTrue(testContactService.contacts.lastElement().getAddress().equals("904 Charles Avenue"));
		
		testContactService.updateContact("wbrandow", "Billy", "Brandaddy", "5759582186", "409 Charles Avenue");
		
		assertTrue(testContactService.contacts.lastElement().getContactID().equals("wbrandow"));
		assertTrue(testContactService.contacts.lastElement().getFirstName().equals("Billy"));
		assertTrue(testContactService.contacts.lastElement().getLastName().equals("Brandaddy"));
		assertTrue(testContactService.contacts.lastElement().getPhone().equals("5759582186"));
		assertTrue(testContactService.contacts.lastElement().getAddress().equals("409 Charles Avenue"));
	}
	
	@Test
	void testUpdateIdDoesNotExist() {
		ContactService testContactService = new ContactService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContactService.updateContact("wbrandow", "Bill", "Brandow", "6812859575", "904 Charles Avenue");
		});
	}

/*
 *  Testing deleting contacts	
 */
	@Test 
	void testDeleteContact() {
		ContactService testContactService = new ContactService();
		
		testContactService.addContact("wbrandow", "Bill", "Brandow", "6812859575", "904 Charles Avenue");
		
		assertTrue(testContactService.contacts.size() == 1);
		
		testContactService.deleteContact("wbrandow");
		
		assertTrue(testContactService.contacts.size() == 0);
	}

	@Test
	void testDeleteContactDoesNotExist() {
        ContactService testContactService = new ContactService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContactService.deleteContact("wbrandow");
		});
	}
}
