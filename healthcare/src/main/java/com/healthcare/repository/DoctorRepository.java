package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

}
