package com.assoft.btkinnova.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assoft.btkinnova.entities.Employee;




public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	List<Employee> getByFirstNameContains (String firstName);

}
