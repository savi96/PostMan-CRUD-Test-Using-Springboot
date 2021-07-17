package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api") 	//request mapping for the class level
//@ComponentScan(basePackageClasses = EmployeeController.class)
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value ="/employee")
	public List<Employee> get(){
		return employeeService.get();

	}
	

	@PostMapping("/employee")
	public Employee save(@RequestBody Employee employeeobj) {
		employeeService.save(employeeobj);
		return employeeobj;
		
	}
	

	@GetMapping("/employee/{id}")  //{id} is called as path variable
	public Employee get(@PathVariable int id) {
		Employee employeeobj = employeeService.get(id);
		if(employeeobj == null) {
			throw new RuntimeException("Employee cannot be found");
		}
		
		return employeeobj;
	}

	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable int id) {
		employeeService.delete(id);
		return "Employee has been deleted with id : "+id;
		
	}
	
	@PutMapping("/employee")
	public Employee update(@RequestBody Employee employeeobj) {
		employeeService.save(employeeobj);
		return employeeobj;
	}
}
