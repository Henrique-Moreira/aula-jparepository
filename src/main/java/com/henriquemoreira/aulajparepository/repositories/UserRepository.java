package com.henriquemoreira.aulajparepository.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.henriquemoreira.aulajparepository.entites.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT obj FROM User obj WHERE obj.salary >= :minSalary AND obj.salary <= :maxSalary")
	Page<User> searchBySalary(Double minSalary, Double maxSalary, Pageable pageable);

	@Query("SELECT obj FROM User obj WHERE LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%'))")
	Page<User> searchByName(String name, Pageable pageable);
	
	Page<User> findBySalaryBetween(Double minSalary, Double maxSalary, Pageable pageable);

	Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);
	
}
