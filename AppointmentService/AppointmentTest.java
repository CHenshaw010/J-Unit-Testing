/*
 * Author: Christian Henshaw
 */

package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import main.Appointment;

class AppointmentTest {

	public String appointmentId, appointmentDescTest, appointmentDescValidTest;
	public Date appointmentDateTest, appointmentDateValidTest, appointmentDateTestInPast;
	public String appointmentIdTooLong, appointmentDescTestTooLong;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void testAppointmentSetUp() {
		appointmentId = "504030201";
		appointmentDateTest = new Date(2050, Calendar.JANUARY, 10);
		appointmentDateValidTest = new Date(2055, Calendar.JANUARY, 10);
		appointmentDescTest = "Repair Screen.";
		appointmentDescValidTest = "Fix Charger.";
		
		appointmentIdTooLong = "090807060504030201";
		appointmentDateTestInPast = new Date(0);
		appointmentDescTestTooLong = "Repair Screen after the New York Yankees won the World Series.";
	}
	
	//Tests creating new appointment. Ensures correct values are utilized for each variable.
	@Test
	void testAppointment() {
		Appointment newAppointment = new Appointment(appointmentId, appointmentDateTest, appointmentDescTest);
		assertAll("Creating New Appointment.", 
		() -> assertEquals(appointmentId, newAppointment.getAppointmentId()),
		() -> assertEquals(appointmentDateTest, newAppointment.getAppointmentDate()),
		() -> assertEquals(appointmentDescTest, newAppointment.getAppointmentDesc()));
		
		assertAll("Creating New Appointment with Bad Values.",
		() -> assertThrows(IllegalArgumentException.class, () -> new Appointment(appointmentIdTooLong, appointmentDateTest, appointmentDescTest)),
		() -> assertThrows(IllegalArgumentException.class, () -> new Appointment(appointmentId, appointmentDateTestInPast, appointmentDescTest)),
		() -> assertThrows(IllegalArgumentException.class, () -> new Appointment(appointmentId, appointmentDateTest, appointmentDescTestTooLong)));
	}	

	//Tests directly updating appointment date. Ensures new appointment date is utilized and exceptions are thrown for past or null values.
	@Test
	void udpateAppointmentDateTest() {
		Appointment newAppointment = new Appointment(appointmentId, appointmentDateTest, appointmentDescTest);
		assertAll("Appointment Date Test.", 
		() -> assertEquals(appointmentDateTest, newAppointment.getAppointmentDate()),
		() -> assertThrows(IllegalArgumentException.class, () -> newAppointment.setAppointmentDate(null)),
		() -> assertThrows(IllegalArgumentException.class, () -> newAppointment.setAppointmentDate(appointmentDateTestInPast)));
		
		newAppointment.setAppointmentDate(appointmentDateValidTest);
		assertEquals(appointmentDateValidTest, newAppointment.getAppointmentDate());
	}
	
	//Tests directly updating appointment description. Ensures new appointment description is utilized and exceptions are thrown for too long or null values.
	@Test
	void udpateAppointmentDescTest() {
		Appointment newAppointment = new Appointment(appointmentId, appointmentDateTest, appointmentDescTest);
		assertAll("Appointment Description Test.", 
		() -> assertEquals(appointmentDescTest, newAppointment.getAppointmentDesc()),
		() -> assertThrows(IllegalArgumentException.class, () -> newAppointment.setAppointmentDesc(null)),
		() -> assertThrows(IllegalArgumentException.class, () -> newAppointment.setAppointmentDesc(appointmentDescTestTooLong)));
		
		newAppointment.setAppointmentDesc(appointmentDescValidTest);
		assertEquals(appointmentDescValidTest, newAppointment.getAppointmentDesc());
	}
}
