package com.brijframework.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.crm.dto.UISupplier;
import com.brijframework.crm.dto.UISupplierDetail;
import com.brijframework.crm.entities.EOSupplier;
import com.brijframework.crm.entities.EOVendor;
import com.brijframework.crm.mapper.SupplierDetailMapper;
import com.brijframework.crm.mapper.SupplierMapper;
import com.brijframework.crm.repository.SupplierRepository;
import com.brijframework.crm.repository.VendorRepository;
import com.brijframework.crm.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository; 
	
	@Autowired
	private SupplierMapper  supplierMapper;
	
	@Autowired
	private SupplierDetailMapper supplierDetailMapper;
	
	@Autowired
	private VendorRepository vendorRepository; 
	
	@Override
	public UISupplier saveSupplier(Long vendorId, UISupplier uiSupplier) {
		EOSupplier eoSupplier=supplierMapper.mapToDAO(uiSupplier);
		EOVendor eoVendor = vendorRepository.findById(vendorId).orElseThrow(()-> new RuntimeException("Not fond vendor")) ;
		eoSupplier.setVendor(eoVendor);
		supplierRepository.save(eoSupplier);
		return supplierMapper.mapToDTO(eoSupplier);
	}

	@Override
	public UISupplier getSupplier(Long id) {
		return supplierMapper.mapToDTO( supplierRepository.findById(id).orElseThrow(()-> new RuntimeException("Not fond")) );
	}

	@Override
	public boolean deleteSupplier(Long id) {
		EOSupplier eoSupplier = supplierRepository.findById(id).orElseThrow(()-> new RuntimeException("Not fond")) ;
		eoSupplier.setRecordState(false);
		supplierRepository.save(eoSupplier);
		return true;
	}

	@Override
	public List<UISupplier> getSupplierList(Long vendorId) {
		return supplierMapper.mapToDTO( supplierRepository.findByVendorId(vendorId));
	}
	
	@Override
	public List<UISupplier> getSupplierList() {
		return supplierMapper.mapToDTO( supplierRepository.findAll() );
	}

	@Override
	public UISupplierDetail getSupplierDetail(Long id) {
		return supplierDetailMapper.mapToDTO( supplierRepository.findById(id).orElseThrow(()-> new RuntimeException("Not fond")) );
	}

}
