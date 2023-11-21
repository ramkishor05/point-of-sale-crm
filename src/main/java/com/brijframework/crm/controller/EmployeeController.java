package com.brijframework.crm.controller;

import static com.brijframework.crm.contants.Constants.CUST_APP_ID;

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
	public UIEmployee addEmployee(@RequestHeader(CUST_APP_ID) long custAppId, @RequestBody UIEmployee uiEmployee) {
		return employeeService.saveEmployee(custAppId,uiEmployee);
	}
	
	@PutMapping
	public UIEmployee updateEmployee(@RequestHeader(CUST_APP_ID) long custAppId,@RequestBody UIEmployee uiEmployee) {
		return employeeService.saveEmployee(custAppId, uiEmployee);
	}
	
	@GetMapping("/vendors")
	public List<UIEmployee> getVendorEmployeeDetailList(@RequestHeader(CUST_APP_ID) long custAppId) {
		return employeeService.getEmployeeList(custAppId);
	}
	
	@GetMapping
	public List<UIEmployee> getEmployeeDetailList(@RequestHeader(CUST_APP_ID) long custAppId) {
		return employeeService.getEmployeeList(custAppId);
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
