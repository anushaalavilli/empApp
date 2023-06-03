package com.employeeapp.inter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.employeeapp.inter.model.Employee;
import com.employeeapp.inter.model.EmployeeTaxDeduction;
import com.employeeapp.inter.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	private final EmployeeRepo employeeRepo;
	
	

	public EmployeeService(EmployeeRepo employeeRepo) {
	
		this.employeeRepo = employeeRepo;
	}



	public Employee save(Employee employee) {
		
		return employeeRepo.save(employee);
	}



	public List<EmployeeTaxDeduction> getEmployeeTaxDeductions() {
		List<Employee> employees = employeeRepo.findAll();
		List<EmployeeTaxDeduction> taxDeduction = new ArrayList<>();
		for (Employee employee : employees) {
	        double yearlySalary = calculateYearlySalary(employee);
	        double taxAmount = calculateTaxAmount(yearlySalary);
	        double cessAmount = calculateCessAmount(yearlySalary);

	        EmployeeTaxDeduction deduction = new EmployeeTaxDeduction();
	        deduction.setEmployeeId(employee.getId());
	        deduction.setFirstName(employee.getFirstName());
	        deduction.setLastName(employee.getLastName());
	        deduction.setYearlySalary(yearlySalary);
	        deduction.setTaxAmount(taxAmount);
	        deduction.setCessAmount(cessAmount);

	        taxDeduction.add(deduction);
	    }

	    return taxDeduction;
	}



	private double calculateCessAmount(double yearlySalary) {
		double cess =0 ;
		if(yearlySalary>2500000) {
			cess = (2500000/100)*2;
		}
		return cess;
	}



	private double calculateTaxAmount(double yearlySalary) {
		
		double tax;
		if(yearlySalary<=250000) {
			tax=0;
		}
		else if (yearlySalary>250000 && yearlySalary <=500000) {
			tax=(yearlySalary/100)*5;
			
		}
		else if (yearlySalary>500000 && yearlySalary <=1000000) {
			tax=(yearlySalary/100)*10;
			
		}
		else {
			tax=(yearlySalary/100)*20;
		}
		return tax;
	}



	private double calculateYearlySalary(Employee employee) {
		double yearlySalary = employee.getSalary()*12;
		return yearlySalary;
	}
		
}
