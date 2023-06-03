package com.employeeapp.inter.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeapp.inter.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{



}
