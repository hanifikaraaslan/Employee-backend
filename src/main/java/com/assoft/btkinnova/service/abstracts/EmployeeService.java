package com.assoft.btkinnova.service.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.assoft.btkinnova.entities.Employee;

public interface EmployeeService {
	
	
	public ResponseEntity<List<Employee>> getallemployees();
	public ResponseEntity<Employee> getOneEmployee(int id);
	public ResponseEntity<Employee > addEmploye(Employee emp);
	public List<Employee>  addEmployees(List<Employee> list);
	public ResponseEntity<?> updateEmployee(int id, Employee employee);
	public ResponseEntity<?> delete(int id);
	public String deletee(int id);
	public List<Employee> getFilter(String firstName );
	
	

}
