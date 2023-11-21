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

import com.brijframework.crm.dto.UISupplier;
import com.brijframework.crm.dto.UISupplierDetail;
import com.brijframework.crm.service.SupplierService;

@RestController
@RequestMapping("api/supplier")
public class SupplierController {

	@Autowired
	SupplierService supplierService;
	
	@PostMapping
	public UISupplier addSupplier(@RequestHeader(CUST_APP_ID) long custAppId, @RequestBody UISupplier uiSupplier) {
		return supplierService.saveSupplier(custAppId,uiSupplier);
	}
	
	@PutMapping
	public UISupplier updateSupplier(@RequestHeader(CUST_APP_ID) long custAppId,@RequestBody UISupplier uiSupplier) {
		return supplierService.saveSupplier(custAppId, uiSupplier);
	}
	
	@GetMapping("/vendors")
	public List<UISupplier> getVendorSupplierDetailList(@RequestHeader(CUST_APP_ID) long custAppId) {
		return supplierService.getSupplierList(custAppId);
	}
	
	@GetMapping
	public List<UISupplier> getSupplierDetailList(@RequestHeader(CUST_APP_ID) long custAppId) {
		return supplierService.getSupplierList(custAppId);
	}
	
	@DeleteMapping("/{supplierId}")
	public boolean deleteSupplier(@PathVariable("supplierId") long supplierId) {
		return supplierService.deleteSupplier(supplierId);
	}
	
	@GetMapping("/{supplierId}")
	public UISupplier getSupplier(@PathVariable("supplierId") long supplierId) {
		return supplierService.getSupplier(supplierId);
	}
	
	@GetMapping("/{supplierId}/detail")
	public UISupplierDetail getSupplierDetail(@PathVariable("supplierId") long supplierId) {
		return supplierService.getSupplierDetail(supplierId);
	}
	
	
}
