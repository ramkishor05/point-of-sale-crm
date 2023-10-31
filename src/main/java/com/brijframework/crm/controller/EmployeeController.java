package com.brijframework.crm.controller;

import static com.brijframework.crm.contants.Constants.OWNER_ID;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brijframework.crm.dto.UIEmployee;
import com.brijframework.crm.dto.UIEmployeeDetail;
import com.brijframework.crm.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping
	public UIEmployee addEmployee(@RequestHeader(OWNER_ID) long vendorId, @RequestBody UIEmployee uiEmployee) {
		return employeeService.saveEmployee(vendorId,uiEmployee);
	}
	
	@PutMapping
	public UIEmployee updateEmployee(@RequestHeader(OWNER_ID) long vendorId,@RequestBody UIEmployee uiEmployee) {
		return employeeService.saveEmployee(vendorId, uiEmployee);
	}
	
	@GetMapping("/vendors")
	public List<UIEmployee> getVendorEmployeeDetailList(@RequestHeader(OWNER_ID) long vendorId) {
		return employeeService.getEmployeeList(vendorId);
	}
	
	@GetMapping
	public List<UIEmployee> getEmployeeDetailList(@RequestHeader(OWNER_ID) long vendorId) {
		return employeeService.getEmployeeList(vendorId);
	}
	
	
	@DeleteMapping("/{employeeId}")
	public boolean deleteEmployee(@PathVariable("employeeId") long employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}
	
	@GetMapping("/{employeeId}")
	public UIEmployee getEmployee(@PathVariable("employeeId") long employeeId) {
		return employeeService.getEmployee(employeeId);
	}
	
	@GetMapping("/{employeeId}/detail")
	public UIEmployeeDetail getEmployeeDetail(@PathVariable("employeeId") long employeeId) {
		return employeeService.getEmployeeDetail(employeeId);
	}
	
	
}
