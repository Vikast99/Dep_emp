package com.Dept_Emp.Department_Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Dept_Emp.Department_Employee.Service.EmployeeService;
import com.Dept_Emp.Department_Employee.entity.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/department/{departmentId}")
	public ResponseEntity<Employee> saveEmp(@PathVariable Long departmentId,@RequestBody Employee e){
		Employee savedEmployee=employeeService.saveEmp(departmentId, e);
		return ResponseEntity.ok(savedEmployee);
	}
	
	@PutMapping("/department/{departmentId}/employee/{employeeId}")
	public ResponseEntity<Employee> updateEmp(@PathVariable Long departmentId,@PathVariable Long employeeId,@RequestBody Employee e){
		Employee updated=employeeService.updateEmp(departmentId, employeeId, e);
		return ResponseEntity.ok(updated);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> findById(@PathVariable Long id){
		return new ResponseEntity<Employee>(employeeService.findById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmp(@PathVariable Long id) {
		employeeService.deleteEmp(id);
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> findAll(){
		return new ResponseEntity<List<Employee>>(employeeService.findAll(),HttpStatus.OK);
	}

}
