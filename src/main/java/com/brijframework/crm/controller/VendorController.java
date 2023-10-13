package com.brijframework.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brijframework.crm.dto.UIVendor;
import com.brijframework.crm.dto.UIVendorDetail;
import com.brijframework.crm.service.VendorService;

@RestController
@RequestMapping("api/vendor")
public class VendorController {

	@Autowired
	VendorService vendorService;
	
	@PostMapping
	public UIVendor addVendor(@RequestBody UIVendor uiVendor) {
		return vendorService.saveVendor(uiVendor);
	}
	
	@PutMapping
	public UIVendor updateVendor(@RequestBody UIVendor uiVendor) {
		return vendorService.saveVendor(uiVendor);
	}
	
	@GetMapping
	public List<UIVendor> getVendorDetailList() {
		return vendorService.getVendorList();
	}
	
	@DeleteMapping("/{vendorId}")
	public boolean deleteVendor(@PathVariable("vendorId") long vendorId) {
		return vendorService.deleteVendor(vendorId);
	}
	
	@GetMapping("/{vendorId}")
	public UIVendor getVendor(@PathVariable("vendorId") long vendorId) {
		return vendorService.getVendor(vendorId);
	}
	
	@GetMapping("/{vendorId}/detail")
	public UIVendorDetail getVendorDetail(@PathVariable("vendorId") long vendorId) {
		return vendorService.getVendorDetail(vendorId);
	}
	
}
