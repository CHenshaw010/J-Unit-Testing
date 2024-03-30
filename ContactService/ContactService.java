/*
 * Author: Christian Henshaw
 */

package main;

import java.util.ArrayList;

public class ContactService {
	private ArrayList<Contact> Contacts = new ArrayList<Contact>();
	
	public void addNewContact(String contactId, String firstName, String lastName, String phoneNum, String address) {
		boolean contactIdExists = false;
		if (!Contacts.isEmpty()) {
			for (int i = 0; i < Contacts.size(); ++i) {
				if (contactId.equals(Contacts.get(i).getContactId())) {
					contactIdExists = true;
					throw new IllegalArgumentException("Contact ID Already Exists. No New Contact Added.");
				}
			}
		}
		if (contactIdExists == false) {
			Contact newContact = new Contact(contactId, firstName, lastName, phoneNum, address);
			Contacts.add(newContact);
			System.out.println("New Contact Created Successfully!");
		}
	}

	public void deleteOldContact(String contactId) throws Exception {
		Contacts.remove(searchContacts(contactId));
		System.out.println("Contact Deleted Successfully!");
	}

	public void updateFirstName(String contactId, String newFirstName) throws Exception {
		searchContacts(contactId).setFirstName(newFirstName);
		System.out.println("Contact First Name Updated Successfully!");
	}

	public void updateLastName(String contactId, String newLastName) throws Exception {
		searchContacts(contactId).setLastName(newLastName);
		System.out.println("Contact Last Name Updated Successfully!");
	}

	public void updatePhoneNum(String contactId, String newPhoneNum) throws Exception {
		searchContacts(contactId).setPhoneNum(newPhoneNum);
		System.out.println("Contact Phone Number Updated Successfully!");
	}

	public void updateAddress(String contactId, String newAddress) throws Exception {
		searchContacts(contactId).setAddress(newAddress);
		System.out.println("Contact Address Updated Successfully!");
	}
	
	public ArrayList<Contact> getContactList() {
		return Contacts;
	}
	
	public Contact searchContacts(String contactId) throws Exception {
		int iterator = 0;
		while (iterator < Contacts.size()) {
			if (contactId.equals(Contacts.get(iterator).getContactId())) {
				return Contacts.get(iterator);
			}
			iterator++;
		}
		throw new Exception("Contact does not exist.");
	}
}
