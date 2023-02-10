/*
 *  William Brandow
 *  william.brandow@snhu.edu
 *  CS-320-H7332
 *  2022-11-14
 */

import java.util.Vector;

public class ContactService {
	public Vector<Contact> contacts;
	
	public ContactService() {
		contacts = new Vector<Contact>();
	}

/*
 *  Add new contact to vector	
 */
	public void addContact(String id, String firstName, String lastName, String phone, String address) {
		for (int i = 0; i < this.contacts.size(); i++) {
	        if (id.equals(this.contacts.elementAt(i).getContactID())) {
				throw new IllegalArgumentException("Contact ID already exists.");
			}
		}
		
		Contact newContact = new Contact(id, firstName, lastName, phone, address);
		
		this.contacts.add(newContact);
	}	
	

/*
 *  Update existing contact	
 */
	public void updateContact(String id, String firstName, String lastName, String phone, String address) {
		int i;
		boolean contactFound = false;
		
		for (i = 0; i < this.contacts.size(); i++) {
			if (id.equals(this.contacts.elementAt(i).getContactID())) {
				this.contacts.elementAt(i).setFirstName(firstName);
				this.contacts.elementAt(i).setLastName(lastName);
				this.contacts.elementAt(i).setPhone(phone);
				this.contacts.elementAt(i).setAddress(address);
				contactFound = true;
				break;
			}
		}
		
		if (contactFound == false) {
			throw new IllegalArgumentException("ID does not exist.");
		}    
	}
	
/*
 *  Delete existing contact	
 */
	public void deleteContact(String id) {
		int i;
		boolean contactFound = false;
		
		for (i = 0; i < this.contacts.size(); i++) {
			if (id.equals(this.contacts.elementAt(i).getContactID())) {
				this.contacts.remove(i);
				contactFound = true;
				break;
			}
		}	
		
		if (contactFound == false) {
			throw new IllegalArgumentException("ID does not exist.");
		}
	}
	
/*	
	private static void displayMainMenu() {
	    System.out.println("Select an option:");
	    System.out.println();
	    System.out.println("[1] Add contact.");
	    System.out.println("[2] Print contact.");
	    System.out.println("[3] Delete contact.");
	    System.out.println("[4] Update contact.");
	    System.out.println("[Q] Exit.");
	    System.out.println();
	    System.out.print("Enter your choice: ");;
	}
*/	
	
}
