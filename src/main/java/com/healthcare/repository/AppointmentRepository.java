package com.healthcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.Appointment;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

	

	List<Appointment> findByPatient_UserId(Long id);

	List<Appointment> findByDoctor_UserId(Long id);

}
