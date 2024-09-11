package com.Dept_Emp.Department_Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Dept_Emp.Department_Employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
