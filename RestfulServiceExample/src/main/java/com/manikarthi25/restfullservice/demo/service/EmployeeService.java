package com.manikarthi25.restfullservice.demo.service;

import com.manikarthi25.restfullservice.demo.dto.Employee;

public interface EmployeeService {

	Employee getEmployeeByEmpId(String empId);

	Employee addNewEmployee(Employee employee);

	Employee updateExistingEmployee(String empId, Employee employee);

	String deleteEmployeeByEmpId(String empId);
}
