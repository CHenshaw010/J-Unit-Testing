/*
 * Author: Christian Henshaw
 */

package main;

public class Contact {

		private static final byte MAX_ID_LENGTH = 10;
		private static final byte MAX_FIRSTNAME_LENGTH = 10;
		private static final byte MAX_LASTNAME_LENGTH = 10;
		private static final int EXACT_PHONENUM_LENGTH = 10;
		private static final byte MAX_ADDRESS_LENGTH = 30;
		
		private String contactId;
		private String firstName;
		private String lastName;
		private String phoneNum;
		private String address;
		
		public Contact(String contactId, String firstName, String lastName, String phoneNum, String address) {
			String allDigitRegex = "[0-9]+";
			if (contactId == null || contactId.length() > MAX_ID_LENGTH) {
				throw new IllegalArgumentException("Invalid Contact ID.");
			}
			if (firstName == null || firstName.length() > MAX_FIRSTNAME_LENGTH) {
				throw new IllegalArgumentException("Invalid First Name.");
			}
			if (lastName == null || lastName.length() > MAX_LASTNAME_LENGTH) {
				throw new IllegalArgumentException("Invalid Last Name.");
			}
			if (phoneNum == null || phoneNum.length() != EXACT_PHONENUM_LENGTH) {
				throw new IllegalArgumentException("Invalid Phone Number.");
			} else if (!phoneNum.matches(allDigitRegex)) {
				throw new IllegalArgumentException("Phone number can only contain digits.");
			}
			if (address == null || address.length() > MAX_ADDRESS_LENGTH) {
				throw new IllegalArgumentException("Invalid Address.");
			}
			this.contactId = contactId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phoneNum = phoneNum;
			this.address = address;
		}
		
		public String getContactId() {
			return contactId;
		}
		
		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}
		
		public String getPhoneNum() {
			return phoneNum;
		}
		
		public String getAddress() {
			return address;
		}
		
		public void setFirstName(String newFirstName) {
			if (newFirstName == null || newFirstName.length() > MAX_FIRSTNAME_LENGTH) {
				throw new IllegalArgumentException("Invalid First Name.");
			} else {
				this.firstName = newFirstName;
			}
		}
		
		public void setLastName(String newLastName) {
			if (newLastName == null || newLastName.length() > MAX_LASTNAME_LENGTH) {
				throw new IllegalArgumentException("Invalid Last Name.");
			} else {
				this.lastName = newLastName;
			}
		}
		
		public void setPhoneNum(String newPhoneNum) {
			String allDigitRegex = "[0-9]+";
			if (newPhoneNum == null || newPhoneNum.length() != EXACT_PHONENUM_LENGTH) {
				throw new IllegalArgumentException("Invalid Phone Number.");
			} else if (!newPhoneNum.matches(allDigitRegex)) {
				throw new IllegalArgumentException("Phone number can only contain digits.");
			} else {
				this.phoneNum = newPhoneNum;
			}
		}
		
		public void setAddress(String newAddress) {
			if (newAddress == null || newAddress.length() > MAX_ADDRESS_LENGTH) {
				throw new IllegalArgumentException("Invalid Address.");
			} else {
				this.address = newAddress;
			}
		}
}
