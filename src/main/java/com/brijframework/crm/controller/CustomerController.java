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

import com.brijframework.crm.dto.UICustomer;
import com.brijframework.crm.dto.UICustomerDetail;
import com.brijframework.crm.service.CustomerService;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping
	public UICustomer addCustomer(@RequestHeader(CUST_APP_ID) long custAppId, @RequestBody UICustomer uiCustomer) {
		return customerService.saveCustomer(custAppId,uiCustomer);
	}
	
	@PutMapping
	public UICustomer updateCustomer(@RequestHeader(CUST_APP_ID) long custAppId,@RequestBody UICustomer uiCustomer) {
		return customerService.saveCustomer(custAppId, uiCustomer);
	}
	
	@GetMapping("/vendors")
	public List<UICustomer> getVendorCustomerDetailList(@RequestHeader(CUST_APP_ID) long custAppId) {
		return customerService.getCustomerList(custAppId);
	}
	
	@GetMapping
	public List<UICustomer> getCustomerDetailList(@RequestHeader(CUST_APP_ID) long custAppId) {
		return customerService.getCustomerList(custAppId);
	}
	
	
	@DeleteMapping("/{customerId}")
	public boolean deleteCustomer(@PathVariable("customerId") long customerId) {
		return customerService.deleteCustomer(customerId);
	}
	
	@GetMapping("/{customerId}")
	public UICustomer getCustomer(@PathVariable("customerId") long customerId) {
		return customerService.getCustomer(customerId);
	}
	
	@GetMapping("/{customerId}/detail")
	public UICustomerDetail getCustomerDetail(@PathVariable("customerId") long customerId) {
		return customerService.getCustomerDetail(customerId);
	}
	
	
}
