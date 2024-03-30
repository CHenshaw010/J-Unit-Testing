/*
 * Author: Christian Henshaw
 */

package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Contact;

public class ContactTest {
	
	public String contactId, firstNameTest, lastNameTest, phoneNumTest, addressTest;
	public String contactIdTooLong, firstNameTestTooLong, lastNameTestTooLong, phoneNumTestTooLong;
	public String phoneNumTestTooShort, phoneNumTestWithChars, addressTestTooLong;
	
	@BeforeEach
	void testSetUp() {
		contactId = "1020304050";
		firstNameTest = "Jane";
		lastNameTest = "Doe";
		phoneNumTest = "0123456789";
		addressTest = "0 Broad St. Mount, CO 12345";
		
		contactIdTooLong = "10203040506070809";
		firstNameTestTooLong = "Janneferrentialism";
		lastNameTestTooLong = "Doeistablishmentarianism";
		phoneNumTestTooLong = "0123456789012345";
		phoneNumTestTooShort = "012";
		phoneNumTestWithChars = "A123456789";
		addressTestTooLong = "5 Broad St. Mount of the Great White Lake, CO 12345";
	}
	
	//Tests creating new contact. Ensures correct values are utilized for each variable.
	@Test
	void testContact() {
		Contact newContact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumTest, addressTest);
		assertAll("Creating New Contact.", 
		() -> assertEquals(contactId, newContact.getContactId()),
		() -> assertEquals(firstNameTest, newContact.getFirstName()),
		() -> assertEquals(lastNameTest, newContact.getLastName()),
		() -> assertEquals(phoneNumTest, newContact.getPhoneNum()),
		() -> assertEquals(addressTest, newContact.getAddress()));
		
		assertAll("Creating New Contact with Bad Values.",
		() -> assertThrows(IllegalArgumentException.class, () -> new Contact(contactIdTooLong, firstNameTest, lastNameTest, phoneNumTest, addressTest)),
		() -> assertThrows(IllegalArgumentException.class, () -> new Contact(contactId, firstNameTestTooLong, lastNameTest, phoneNumTest, addressTest)),
		() -> assertThrows(IllegalArgumentException.class, () -> new Contact(contactId, firstNameTest, lastNameTestTooLong, phoneNumTest, addressTest)),
		() -> assertThrows(IllegalArgumentException.class, () -> new Contact(contactId, firstNameTest, lastNameTest, phoneNumTestTooLong, addressTest)),
		() -> assertThrows(IllegalArgumentException.class, () -> new Contact(contactId, firstNameTest, lastNameTest, phoneNumTestWithChars, addressTest)),
		() -> assertThrows(IllegalArgumentException.class, () -> new Contact(contactId, firstNameTest, lastNameTest, phoneNumTest, addressTestTooLong)));
	}	

	//Tests directly updating first name. Ensures new first name is utilized and exceptions are thrown for too long or null values.
	@Test
	void udpateFirstNameTest() {
		Contact newContact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumTest, addressTest);
		assertAll("First Name Test.", 
		() -> assertEquals(firstNameTest, newContact.getFirstName()),
		() -> assertThrows(IllegalArgumentException.class, () -> newContact.setFirstName(null)),
		() -> assertThrows(IllegalArgumentException.class, () -> newContact.setFirstName(firstNameTestTooLong)));
	}
	
	//Tests directly updating last name. Ensures new last name is utilized and exceptions are thrown for too long or null values.
	@Test
	void udpateLastNameTest() {
		Contact newContact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumTest, addressTest);
		assertAll("Last Name Test.", 
		() -> assertEquals(lastNameTest, newContact.getLastName()),
		() -> assertThrows(IllegalArgumentException.class, () -> newContact.setLastName(null)),
		() -> assertThrows(IllegalArgumentException.class, () -> newContact.setLastName(lastNameTestTooLong)));
	}
	
	//Tests directly updating phone number. Ensures new phone number is utilized and exceptions are thrown for too long, too short, character infused, or null values.
	@Test
	void udpatePhoneNumTest() {
		Contact newContact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumTest, addressTest);
		assertAll("Phone Number Test.", 
		() -> assertEquals(phoneNumTest, newContact.getPhoneNum()),
		() -> assertThrows(IllegalArgumentException.class, () -> newContact.setPhoneNum(null)),
		() -> assertThrows(IllegalArgumentException.class, () -> newContact.setPhoneNum(phoneNumTestTooShort)),
		() -> assertThrows(IllegalArgumentException.class, () -> newContact.setPhoneNum(phoneNumTestWithChars)),
		() -> assertThrows(IllegalArgumentException.class, () -> newContact.setPhoneNum(phoneNumTestTooLong)));
	}
	
	//Tests directly updating address. Ensures new address is utilized and exceptions are thrown for too long or null values.
	@Test
	void udpateAddressTest() {
		Contact newContact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumTest, addressTest);
		assertAll("Address Test.", 
		() -> assertEquals(addressTest, newContact.getAddress()),
		() -> assertThrows(IllegalArgumentException.class, () -> newContact.setAddress(null)),
		() -> assertThrows(IllegalArgumentException.class, () -> newContact.setAddress(addressTestTooLong)));
	}
}
