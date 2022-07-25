package com.assoft.btkinnova.service.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.assoft.btkinnova.dataAccess.EmployeeRepository;
import com.assoft.btkinnova.entities.Employee;
import com.assoft.btkinnova.service.abstracts.EmployeeService;

@Service
public class EmployeeManager implements EmployeeService {
	private EmployeeRepository empRepo;

	@Autowired
	public EmployeeManager(EmployeeRepository empRepo) {
		super();
		this.empRepo = empRepo;
	}

	@Override
	public ResponseEntity<List<Employee>> getallemployees() {
		List <Employee> list= empRepo.findAll();
		return new ResponseEntity<List<Employee>>(list , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Employee> getOneEmployee(int id) {
		Optional<Employee> emp= empRepo.findById(id);
		if(emp.isPresent()) {
			return ResponseEntity.ok(emp.get());
		}
		throw new RuntimeException(String.format("Employee with %s id could not found", id));
	}

	@Override
	public ResponseEntity<Employee> addEmploye(Employee emp) {
		empRepo.save(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}

	@Override
	public List<Employee> addEmployees(List<Employee> list) {
		empRepo.saveAll(list);
		return list;
	}

	@Override
	public ResponseEntity<?> updateEmployee(int id, Employee employee) {
		Employee emp= empRepo.findById(id).orElse(null);
		if(emp!=null) {
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		return new ResponseEntity<>(empRepo.save(emp), HttpStatus.ACCEPTED);
		}
		throw new RuntimeException("Error");
	}

	@Override
	public ResponseEntity<?> delete(int id) {
		Employee emp= empRepo.findById(id).orElse(null);
		if(emp!=null) {
		 empRepo.delete(emp);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		throw new RuntimeException("Error") ;
		}

	@Override
	public String deletee(int id) {
		Employee emp= empRepo.findById(id).orElse(null);
		if(emp!=null) {
		 empRepo.delete(emp);
		 return "silindi";
			}
		throw new RuntimeException("Error");
	}

	@Override
	public List<Employee> getFilter(String firstName) {
		List <Employee> emp=empRepo.getByFirstNameContains(firstName);
		   return emp;
	}
	


}
