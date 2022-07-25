package com.assoft.btkinnova.business;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assoft.btkinnova.dataAccess.EmployeeRepository;
import com.assoft.btkinnova.entities.Employee;
import com.assoft.btkinnova.service.abstracts.EmployeeService;


//Dependency Injection(DI)

@RestController
@RequestMapping("api/employees/")
@CrossOrigin
public class EmployeeController {
	
	private EmployeeService empService;
	@Autowired
	public EmployeeController(EmployeeService empService) {
		this.empService = empService;
	}

	//AOP çalışan bir metodun arasına girme olayı
	// break point kullanma
	//super ile base classa ait özellikleri eşitleriz
	

//	Employee emp1=new Employee(1 ,"abc","asd");
//	Employee emp2=new Employee(2, "fgh", "cvbn");
//	Employee emp3=new Employee(3, "alkd","djksfjd");
//	Employee emp4=new Employee(4, "fjdljfn", "ghgh");

	@GetMapping("/selam")
	public String hello() {
		return "Selam";
	}
	
//	@GetMapping("/getallemployees")
//	public List<Employee> getAllEmployyes(){
//		return Arrays.asList(emp1,emp2,emp3,emp4);
//	}
	@GetMapping("getall")
	public ResponseEntity<List<Employee>> getallemployees(){
		return empService.getallemployees() ;
	}
	@GetMapping("getoneemployee/{id}")
	public ResponseEntity<Employee> getOneEmployee(@PathVariable int id){
		return empService.getOneEmployee(id);
	}
	@PostMapping("add")
	public ResponseEntity<Employee > addEmploye(@RequestBody Employee emp) {
		return empService.addEmploye(emp);
	}
	@PostMapping("adds")
	public List<Employee>  addEmployees(@RequestBody List<Employee> list) {
		return empService.addEmployees(list);
	}
	@PutMapping("update/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable(name="id", required = true )int id, @RequestBody Employee employee) {
		return empService.updateEmployee(id, employee);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		return empService.delete(id);
		
	}
	@DeleteMapping("deletee")
	public String deletee(@RequestParam(name="id") int id) {
	return empService.deletee(id);
		
	}
	
   @GetMapping("getfilter")
   public List<Employee> getFilter(@RequestParam String firstName ){
	  return empService.getFilter(firstName);
   }
	

}
