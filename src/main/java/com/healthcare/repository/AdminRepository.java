package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long>{

}
