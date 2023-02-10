/*
 *  William Brandow
 *  william.brandow@snhu.edu
 *  CS-320-H7332
 *  2022-11-14
 */

public class Contact {

	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
/*
 *  Constructor	
 */
	public Contact(String id, String firstName, String lastName, String phone, String address) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID.");
		}
		
		this.contactID = id;
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhone(phone);
		this.setAddress(address);
	}

/*
 *  ContactID	
 */
	public String getContactID() {
		return this.contactID;
	}

/*
 *  First Name	
 */
	public void setFirstName(String name) {
		if (name == null || name.length() > 10) {
	        throw new IllegalArgumentException("Invalid first name.");
		}
	
		this.firstName = name;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
/*
 *  Last Name	
 */
	public void setLastName(String name) {
		if (name == null || name.length() > 10) {
	        throw new IllegalArgumentException("Invalid last name.");
		}		
		
		this.lastName = name;
	}
	
	public String getLastName() {
		return this.lastName;
	}	
	
/*
 *  Phone	
 */
	public void setPhone(String phone) {
		if (phone == null || phone.length() != 10) {
	        throw new IllegalArgumentException("Invalid phone number.");
		}		
		
		this.phone = phone;
	}	
	
	public String getPhone() {
		return this.phone;
	}	

/*
 *  Address	
 */
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
	        throw new IllegalArgumentException("Invalid address.");
		}		
		
		this.address = address;
	}	
	
	public String getAddress() {
		return this.address;
	}	
	
	
}
