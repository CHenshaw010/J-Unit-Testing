/*
 * Author: Christian Henshaw
 */

package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.ContactService;

class ContactServiceTest {
	public String contactId, firstNameTest, lastNameTest, phoneNumTest, addressTest;
	public String contactIdTooLong, firstNameTestTooLong, lastNameTestTooLong, phoneNumTestTooLong;
	public String phoneNumTestTooShort, phoneNumTestWithChars, addressTestTooLong;
	
	@BeforeEach
	void testSetUp() {
		contactId = "1122334455";
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
	
	//Tests creating a new contact and ensures proper values are utilized.
	//Tests creating a duplicate contact and ensures errors are thrown for duplicate contact IDs.
	@Test
	void newContactTest() {
		ContactService newContactService = new ContactService();
		newContactService.addNewContact(contactId, firstNameTest, lastNameTest, phoneNumTest, addressTest);
		assertAll("Add New Contact Tests.",
			() -> assertEquals(contactId, newContactService.getContactList().get(0).getContactId()),
			() -> assertNotNull(newContactService.getContactList().get(0).getContactId()),
			
			() -> assertEquals(firstNameTest, newContactService.getContactList().get(0).getFirstName()),
			() -> assertNotNull(newContactService.getContactList().get(0).getFirstName()),
			
			() -> assertEquals(lastNameTest, newContactService.getContactList().get(0).getLastName()),
			() -> assertNotNull(newContactService.getContactList().get(0).getLastName()),
			
			() -> assertEquals(phoneNumTest, newContactService.getContactList().get(0).getPhoneNum()),
			() -> assertNotNull(newContactService.getContactList().get(0).getPhoneNum()),
			
			() -> assertEquals(addressTest, newContactService.getContactList().get(0).getAddress()),
			() -> assertNotNull(newContactService.getContactList().get(0).getAddress()));
		
		assertThrows(IllegalArgumentException.class, 
				() -> newContactService.addNewContact(contactId, firstNameTest, lastNameTest, phoneNumTest, addressTest));
	}
	
	//Tests deleting a contact after it has been added to Contacts ArrayList.
	@Test
	void deleteOldContactTest() throws Exception {
		ContactService newContactService = new ContactService();
		newContactService.addNewContact(contactId, firstNameTest, lastNameTest, phoneNumTest, addressTest);
		assertAll("Delete Contacts Test", 
			() -> newContactService.deleteOldContact(newContactService.getContactList().get(0).getContactId()));
	}
	
	//Tests updating first name. Ensures new first name is utilized and exceptions are thrown for too long or null values.
	@Test
	void updateFirstNameTest() throws Exception {
		ContactService newContactService = new ContactService();
		newContactService.addNewContact(contactId, firstNameTest, lastNameTest, phoneNumTest, addressTest);
		newContactService.updateFirstName(newContactService.getContactList().get(0).getContactId(), "John");
		assertEquals("John", newContactService.getContactList().get(0).getFirstName());
		assertThrows(IllegalArgumentException.class, 
			() -> newContactService.updateFirstName(newContactService.getContactList().get(0).getContactId(), firstNameTestTooLong));
		assertThrows(IllegalArgumentException.class, 
				() -> newContactService.updateFirstName(newContactService.getContactList().get(0).getContactId(), null));
	}
	
	//Tests updating last name. Ensures new last name is utilized and exceptions are thrown for too long or null values.
	@Test
	void updateLastNameTest() throws Exception {
		ContactService newContactService = new ContactService();
		newContactService.addNewContact(contactId, firstNameTest, lastNameTest, phoneNumTest, addressTest);
		newContactService.updateLastName(newContactService.getContactList().get(0).getContactId(), "Smith");
		assertEquals("Smith", newContactService.getContactList().get(0).getLastName());
		assertThrows(IllegalArgumentException.class, 
			() -> newContactService.updateLastName(newContactService.getContactList().get(0).getContactId(), lastNameTestTooLong));
		assertThrows(IllegalArgumentException.class, 
				() -> newContactService.updateLastName(newContactService.getContactList().get(0).getContactId(), null));
	}
	
	//Tests updating phone number. Ensures new phone number is utilized and exceptions are thrown for too long, too short, character infused, or null values.
	@Test
	void updatePhoneNumTest() throws Exception {
		ContactService newContactService = new ContactService();
		newContactService.addNewContact(contactId, firstNameTest, lastNameTest, phoneNumTest, addressTest);
		newContactService.updatePhoneNum(newContactService.getContactList().get(0).getContactId(), "0010020003");
		assertEquals("0010020003", newContactService.getContactList().get(0).getPhoneNum());
		assertThrows(IllegalArgumentException.class, 
			() -> newContactService.updatePhoneNum(newContactService.getContactList().get(0).getContactId(), phoneNumTestTooLong));
		assertThrows(IllegalArgumentException.class, 
				() -> newContactService.updatePhoneNum(newContactService.getContactList().get(0).getContactId(), phoneNumTestTooShort));
		assertThrows(IllegalArgumentException.class, 
				() -> newContactService.updatePhoneNum(newContactService.getContactList().get(0).getContactId(), phoneNumTestWithChars));
		assertThrows(IllegalArgumentException.class, 
				() -> newContactService.updatePhoneNum(newContactService.getContactList().get(0).getContactId(), null));
	}
	
	//Tests updating addresses. Ensures new address is utilized and exceptions are thrown for too long or null values.
	@Test
	void updateAddressTest() throws Exception {
		ContactService newContactService = new ContactService();
		newContactService.addNewContact(contactId, firstNameTest, lastNameTest, phoneNumTest, addressTest);
		newContactService.updateAddress(newContactService.getContactList().get(0).getContactId(), "1 Main St. Aurora, CO 20202");
		assertEquals("1 Main St. Aurora, CO 20202", newContactService.getContactList().get(0).getAddress());
		assertThrows(IllegalArgumentException.class, 
			() -> newContactService.updateAddress(newContactService.getContactList().get(0).getContactId(), addressTestTooLong));
		assertThrows(IllegalArgumentException.class, 
				() -> newContactService.updateAddress(newContactService.getContactList().get(0).getContactId(), null));
	}
	
	//Tests searching Contacts ArrayList. Ensures set values are correct for each variable.
	@Test
	void searchContactsTest() {
		ContactService newContactService = new ContactService();
		newContactService.addNewContact(contactId, firstNameTest, lastNameTest, phoneNumTest, addressTest);
		assertEquals(contactId, newContactService.getContactList().get(0).getContactId());
		assertEquals(firstNameTest, newContactService.getContactList().get(0).getFirstName());
		assertEquals(lastNameTest, newContactService.getContactList().get(0).getLastName());
		assertEquals(phoneNumTest, newContactService.getContactList().get(0).getPhoneNum());
		assertEquals(addressTest, newContactService.getContactList().get(0).getAddress());
	}
}