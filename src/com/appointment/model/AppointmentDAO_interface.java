package com.appointment.model;

import java.util.*;

public interface AppointmentDAO_interface {
	public void insert(AppointmentVO appointmentVO);
	public void update(AppointmentVO appointmentVO);
	public void delete(Integer aptNo);
	public AppointmentVO findByPrimaryKey(Integer aptNo);
	public List<AppointmentVO> getAll();
	
}
