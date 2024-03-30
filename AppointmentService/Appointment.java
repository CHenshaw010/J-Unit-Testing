/*
 * Author: Christian Henshaw
 */

package main;

import java.util.Date;

public class Appointment {
	private static final byte MAX_APPOINTMENT_ID_LENGTH = 10;
	private static final byte MAX_APPOINTMENT_DESC_LENGTH = 50;
	
	private String appointmentId;
	private Date appointmentDate;
	private String appointmentDesc;
	
	public Appointment(String appointmentId, Date appointmentDate, String appointmentDesc) {
		if (appointmentId == null || appointmentId.length() > MAX_APPOINTMENT_ID_LENGTH) {
			throw new IllegalArgumentException("Invalid Appointment ID.");
		}
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid Appointment Date.");
		}
		if (appointmentDesc == null || appointmentDesc.length() > MAX_APPOINTMENT_DESC_LENGTH) {
			throw new IllegalArgumentException("Invalid Appointment Description.");
		}
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.appointmentDesc = appointmentDesc;
	}
	
	public String getAppointmentId() {
		return appointmentId;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public String getAppointmentDesc() {
		return appointmentDesc;
	}
	
	public void setAppointmentDate(Date newAppointmentDate) {
		if (newAppointmentDate == null || newAppointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid Appointment Date.");
		} else {
			this.appointmentDate = newAppointmentDate;
		}
	}
	
	public void setAppointmentDesc(String newAppointmentDesc) {
		if (newAppointmentDesc == null || newAppointmentDesc.length() > MAX_APPOINTMENT_DESC_LENGTH) {
			throw new IllegalArgumentException("Invalid Appointment Description.");
		} else {
			this.appointmentDesc = newAppointmentDesc;
		}
	}
}
