package com.manikarthi25.restfullservice.demo.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manikarthi25.restfullservice.demo.dto.Employee;
import com.manikarthi25.restfullservice.demo.helper.Utils;
import com.manikarthi25.restfullservice.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	Map<String, Employee> employeeMap;

	public EmployeeServiceImpl() {
	}

	private Utils utils;

	@Autowired
	public EmployeeServiceImpl(Utils utils) {
		this.utils = utils;
	}

	public Employee getEmployeeByEmpId(String empId) {
		return employeeMap.get(empId);
	}

	@Override
	public Employee addNewEmployee(Employee employee) {
		String empId = utils.generateEmpId();
		employee.setEmpId(empId);
		if (employeeMap == null)
			employeeMap = new HashMap<>();
		employeeMap.put(empId, employee);
		return employee;
	}

	@Override
	public Employee updateExistingEmployee(String empId, Employee employee) {
		Employee empUpdate = employeeMap.get(empId);
		if (employeeMap.containsKey(empId)) {
			empUpdate.setEmpName(employee.getEmpName());
			employeeMap.put(empId, empUpdate);
		}
		return empUpdate;
	}

	@Override
	public String deleteEmployeeByEmpId(String empId) {
		if (employeeMap.containsKey(empId)) {
			employeeMap.remove(empId);
			return empId;
		} else {
			return null;
		}
	}
}
