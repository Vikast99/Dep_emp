package com.Dept_Emp.Department_Employee.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dept_Emp.Department_Employee.Repository.DepartmentRepository;
import com.Dept_Emp.Department_Employee.entity.Department;
import com.Dept_Emp.Department_Employee.entity.Employee;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	private ThreadPoolExecutor threadPoolExecutor=(ThreadPoolExecutor)Executors.newFixedThreadPool(5);
	
	public void updateSalaryByDepartment(Long departmentId,double newSalary) {
	
		
		
		List<Employee> employees=departmentRepository.findById(departmentId).orElseThrow(() -> new RuntimeException("Department not found")).getEmployees();
		
		for(Employee employee: employees) {
			
			threadPoolExecutor.execute(() -> {
				synchronized(employee) {
					employee.setSalary(newSalary);
				}
			});
		}
	}
	
	
	public Department saveDept(Department d) {
		
		return departmentRepository.save(d);
	}
	
	public Department updateDepartment(Department d) {
		return departmentRepository.save(d);
	}

	public Department findById(Long id) {
		return departmentRepository.findById(id).get();
	}
	
	public List<Department> findAll(){
		return departmentRepository.findAll();
	}
	
	public void deleteDept(Long id) {
		 departmentRepository.deleteById(id);
	}
}
