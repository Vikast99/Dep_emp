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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Dept_Emp.Department_Employee.Service.DepartmentService;
import com.Dept_Emp.Department_Employee.entity.Department;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PutMapping("/{departmentId}/update-salary")
	public ResponseEntity<String> updateSalaryByDepartment(@PathVariable Long departmentId,@RequestParam double newSalary){
		departmentService.updateSalaryByDepartment(departmentId, newSalary);
		return ResponseEntity.ok("salary upadted");
	}
	
	
	@PostMapping
	public ResponseEntity<Department> saveDept(@RequestBody Department d){
		return new ResponseEntity<Department>(departmentService.saveDept(d),HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Department> updateDept(@RequestBody Department d){
		return new ResponseEntity<Department>(departmentService.updateDepartment(d),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Department> findById(@PathVariable Long id){
		return new ResponseEntity<Department>(departmentService.findById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDept(@PathVariable Long id){
	  departmentService.deleteDept(id);
	}
	
	@GetMapping
	public ResponseEntity<List<Department>> findAll(){
		return new ResponseEntity<List<Department>>(departmentService.findAll(),HttpStatus.OK);
	}
	

}
