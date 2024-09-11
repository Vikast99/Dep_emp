package com.Dept_Emp.Department_Employee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dept_Emp.Department_Employee.Repository.DepartmentRepository;
import com.Dept_Emp.Department_Employee.Repository.EmployeeRepository;
import com.Dept_Emp.Department_Employee.entity.Department;
import com.Dept_Emp.Department_Employee.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Employee saveEmp(Long departmentId,Employee e) {
		Department department=departmentRepository.findById(departmentId).orElseThrow(() -> new RuntimeException("department not found"));
		e.setDepartment(department);
		return employeeRepository.save(e);
	}
	
	public Employee updateEmp(Long departmentId,Long employeeId,Employee e) {
		Department department=departmentRepository.findById(departmentId).orElseThrow(() -> new RuntimeException("department not found"));
		Employee employee=employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("employee not found"));
		employee.setName(e.getName());
		employee.setDepartment(department);
		return employeeRepository.save(e);
	}
	
	public Employee findById(Long id){
		return employeeRepository.findById(id).get();
	}
	
	public void deleteEmp(Long id) {
		employeeRepository.deleteById(id);
		
	}
	
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}

}
