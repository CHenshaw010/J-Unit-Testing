/*
 * Author: Christian Henshaw
 */

package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.AppointmentService;

class AppointmentServiceTest {

	public String appointmentId, appointmentDescTest;
	public Date appointmentDateTest, appointmentDateTestInPast;
	public String appointmentIdTooLong, appointmentDescTestTooLong;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void testAppointmentSetUp() {
		appointmentId = "5544332211";
		appointmentDateTest = new Date(5020, Calendar.JANUARY, 10);
		appointmentDescTest = "Repair Mic.";
		
		appointmentIdTooLong = "998877665544332211";
		appointmentDateTestInPast = new Date(0);
		appointmentDescTestTooLong = "Repair Mic after the Boston Red Sox won the World Series.";
	}
	
	//Tests creating a new appointment and ensures proper values are utilized.
	//Tests creating a duplicate appointment and ensures errors are thrown for duplicate appointment IDs.
	@Test
	void newAppointmentTest() {
		AppointmentService newAppointmentService = new AppointmentService();
		newAppointmentService.addNewAppointment(appointmentId, appointmentDateTest, appointmentDescTest);
		assertAll("Add New Appointment Tests.",
			() -> assertEquals(appointmentId, newAppointmentService.getAppointmentList().get(0).getAppointmentId()),
			() -> assertNotNull(newAppointmentService.getAppointmentList().get(0).getAppointmentId()),
			
			() -> assertEquals(appointmentDateTest, newAppointmentService.getAppointmentList().get(0).getAppointmentDate()),
			() -> assertNotNull(newAppointmentService.getAppointmentList().get(0).getAppointmentDate()),
			
			() -> assertEquals(appointmentDescTest, newAppointmentService.getAppointmentList().get(0).getAppointmentDesc()),
			() -> assertNotNull(newAppointmentService.getAppointmentList().get(0).getAppointmentDesc()));
		
		assertThrows(IllegalArgumentException.class, 
				() -> newAppointmentService.addNewAppointment(appointmentId, appointmentDateTest, appointmentDescTest));
	}
	
	//Tests deleting an appointment after it has been added to Appointments ArrayList.
	@Test
	void deleteOldAppointmentTest() throws Exception {
		AppointmentService newAppointmentService = new AppointmentService();
		newAppointmentService.addNewAppointment(appointmentId, appointmentDateTest, appointmentDescTest);
		assertAll("Delete Appointment Test", 
			() -> newAppointmentService.deleteOldAppointment(newAppointmentService.getAppointmentList().get(0).getAppointmentId()));
	}
	
	//Tests updating appointment date. Ensures new appointment date is utilized and exceptions are thrown for past or null values.
	@SuppressWarnings("deprecation")
	@Test
	void updateAppointmentDateTest() throws Exception {
		AppointmentService newAppointmentService = new AppointmentService();
		newAppointmentService.addNewAppointment(appointmentId, appointmentDateTest, appointmentDescTest);
		newAppointmentService.updateAppointmentDate(newAppointmentService.getAppointmentList().get(0).getAppointmentId(), new Date (2100, Calendar.JANUARY, 01));
		assertEquals(new Date (2100, Calendar.JANUARY, 01), newAppointmentService.getAppointmentList().get(0).getAppointmentDate());
		assertThrows(IllegalArgumentException.class, 
			() -> newAppointmentService.updateAppointmentDate(newAppointmentService.getAppointmentList().get(0).getAppointmentId(), appointmentDateTestInPast));
		assertThrows(IllegalArgumentException.class, 
			() -> newAppointmentService.updateAppointmentDate(newAppointmentService.getAppointmentList().get(0).getAppointmentId(), null));
	}
	
	//Tests updating appointment description. Ensures new appointment description is utilized and exceptions are thrown for too long or null values.
	@Test
	void updateAppointmentDescTest() throws Exception {
		AppointmentService newAppointmentService = new AppointmentService();
		newAppointmentService.addNewAppointment(appointmentId, appointmentDateTest, appointmentDescTest);
		newAppointmentService.updateAppointmentDesc(newAppointmentService.getAppointmentList().get(0).getAppointmentId(), "Seat Cushion");
		assertEquals("Seat Cushion", newAppointmentService.getAppointmentList().get(0).getAppointmentDesc());
		assertThrows(IllegalArgumentException.class, 
			() -> newAppointmentService.updateAppointmentDesc(newAppointmentService.getAppointmentList().get(0).getAppointmentId(), appointmentDescTestTooLong));
		assertThrows(IllegalArgumentException.class, 
			() -> newAppointmentService.updateAppointmentDesc(newAppointmentService.getAppointmentList().get(0).getAppointmentId(), null));
	}
	
	//Tests searching Appointments ArrayList. Ensures set values are correct for each variable.
	@Test
	void searchAppointmentsTest() {
		AppointmentService newAppointmentService = new AppointmentService();
		newAppointmentService.addNewAppointment(appointmentId, appointmentDateTest, appointmentDescTest);
		assertEquals(appointmentId, newAppointmentService.getAppointmentList().get(0).getAppointmentId());
		assertEquals(appointmentDateTest, newAppointmentService.getAppointmentList().get(0).getAppointmentDate());
		assertEquals(appointmentDescTest, newAppointmentService.getAppointmentList().get(0).getAppointmentDesc());
	}
}
