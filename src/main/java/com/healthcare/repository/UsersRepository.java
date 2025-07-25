package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

	Users findByUsername(String username);

}
