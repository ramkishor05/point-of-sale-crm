package com.brijframework.crm.controller;

import static com.brijframework.crm.contants.Constants.VENDOR_APP_ID;

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

import com.brijframework.crm.dto.UIBusiness;
import com.brijframework.crm.dto.UIBusinessDetail;
import com.brijframework.crm.service.BusinessService;

@RestController
@RequestMapping("api/business")
public class BusinessController {

	@Autowired
	BusinessService businessService;
	
	@PostMapping
	public UIBusiness addBusiness(@RequestHeader(VENDOR_APP_ID) long vendorId, @RequestBody UIBusiness uiBusiness) {
		return businessService.saveBusiness(vendorId,uiBusiness);
	}
	
	@PutMapping
	public UIBusiness updateBusiness(@RequestHeader(VENDOR_APP_ID) long vendorId,@RequestBody UIBusiness uiBusiness) {
		return businessService.saveBusiness(vendorId, uiBusiness);
	}
	
	@GetMapping("/vendors")
	public List<UIBusiness> getVendorBusinessDetailList(@RequestHeader(VENDOR_APP_ID) long vendorId) {
		return businessService.getBusinessList(vendorId);
	}
	
	@GetMapping
	public List<UIBusiness> getBusinessDetailList() {
		return businessService.getBusinessList();
	}
	
	@DeleteMapping("/{businessId}")
	public boolean deleteBusiness(@PathVariable("businessId") long businessId) {
		return businessService.deleteBusiness(businessId);
	}
	
	@GetMapping("/{businessId}")
	public UIBusiness getBusiness(@PathVariable("businessId") long businessId) {
		return businessService.getBusiness(businessId);
	}
	
	@GetMapping("/{businessId}/detail")
	public UIBusinessDetail getBusinessDetail(@PathVariable("businessId") long businessId) {
		return businessService.getBusinessDetail(businessId);
	}
	
	
}
