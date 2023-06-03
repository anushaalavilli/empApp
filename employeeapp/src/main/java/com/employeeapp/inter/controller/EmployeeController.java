package com.employeeapp.inter.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeeapp.inter.model.Employee;
import com.employeeapp.inter.model.EmployeeTaxDeduction;
import com.employeeapp.inter.service.EmployeeService;

@RestController
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		
		this.employeeService = employeeService;
	}
	
	@PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
	}
	
	@GetMapping("/tax-deductions")
    public List<EmployeeTaxDeduction> getEmployeeTaxDeductions() {
        return employeeService.getEmployeeTaxDeductions();
    }
	
	

}
