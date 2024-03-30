/*
 * Author: Christian Henshaw
 */

package main;

import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {
	private ArrayList<Appointment> Appointments = new ArrayList<Appointment>();
	
	public void addNewAppointment(String appointmentId, Date appointmentDate, String appointmentDesc) {
		boolean appointmentIdExists = false;
		if (!Appointments.isEmpty()) {
			for (int i = 0; i < Appointments.size(); ++i) {
				if (appointmentId.equals(Appointments.get(i).getAppointmentId())) {
					appointmentIdExists = true;
					throw new IllegalArgumentException("Appointment ID Already Exists. No New Appointment Added.");
				}
			}
		}
		if (appointmentIdExists == false) {
			Appointment newAppointment = new Appointment(appointmentId, appointmentDate, appointmentDesc);
			Appointments.add(newAppointment);
			System.out.println("New Appointment Created Successfully!");
		}
	}

	public void deleteOldAppointment(String appointmentId) throws Exception {
		Appointments.remove(searchAppointments(appointmentId));
		System.out.println("Appointment Deleted Successfully!");
	}

	public void updateAppointmentDate(String appointmentId, Date newAppointmentDate) throws Exception {
		searchAppointments(appointmentId).setAppointmentDate(newAppointmentDate);
		System.out.println("Appointment Date Updated Successfully!");
	}

	public void updateAppointmentDesc(String appointmentId, String newAppointmentDesc) throws Exception {
		searchAppointments(appointmentId).setAppointmentDesc(newAppointmentDesc);
		System.out.println("Appointment Description Updated Successfully!");
	}
	
	public ArrayList<Appointment> getAppointmentList() {
		return Appointments;
	}
	
	public Appointment searchAppointments(String appointmentId) throws Exception {
		int iterator = 0;
		while (iterator < Appointments.size()) {
			if (appointmentId.equals(Appointments.get(iterator).getAppointmentId())) {
				return Appointments.get(iterator);
			}
			iterator++;
		}
		throw new Exception("Appointment does not exist.");
	}
}
