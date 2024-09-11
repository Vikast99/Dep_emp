package com.Dept_Emp.Department_Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Dept_Emp.Department_Employee.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
