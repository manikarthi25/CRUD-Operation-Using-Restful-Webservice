package com.manikarthi25.restfullservice.demo.controller;

import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

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

import com.manikarthi25.restfullservice.demo.dto.Employee;
import com.manikarthi25.restfullservice.demo.exception.UserdefinedException;
import com.manikarthi25.restfullservice.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class RestfullServiceController {

	Map<String, Employee> employeeMap;

	@Autowired
	private EmployeeService employeeService;

	@GetMapping // sample
	public String getEmpIdAndEmpName(@RequestParam(value = "empId") String empId,
			@RequestParam(value = "empName", required = false) String empName) {
		return "Employee Id :" + empId + " Employee Name : " + empName;
	}

	@GetMapping(path = "/get/{empId}", consumes = { MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML }, produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ResponseEntity<Employee> getEmployeeByEmpId(@PathVariable String empId) {
		Employee employee = employeeService.getEmployeeByEmpId(empId);
		if (employee != null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping(path = "add", consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML }, produces = {
			MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ResponseEntity<Employee> addNewEmployee(@Valid @RequestBody Employee employee) {
		Employee addNewEmployee = employeeService.addNewEmployee(employee);
		return new ResponseEntity<Employee>(addNewEmployee, HttpStatus.OK);
	}

	@PutMapping(path = "update/{empId}", consumes = { MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML }, produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee updateExistingEmployee(@PathVariable String empId, @RequestBody Employee employee) {
		return employeeService.updateExistingEmployee(empId, employee);
	}

	@DeleteMapping(path = "/delete/{empId}")
	public ResponseEntity<Void> deleteEmployeeByEmpId(@PathVariable String empId) {
		String employeeId = employeeService.deleteEmployeeByEmpId(empId);
		if (null != employeeId) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@GetMapping(path = "/testpredefinedexception")
	public ResponseEntity testPredefinedException() {
		String empName = null;
		int empLength = empName.length();

		return ResponseEntity.noContent().build();
	}

	@GetMapping(path = "/testuserdefinedexception")
	public ResponseEntity testUserDefinedException() {
		if (true)
			throw new UserdefinedException("User Defined Exception");

		return ResponseEntity.noContent().build();
	}
}