package com.brijframework.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.crm.contants.RecordStatus;
import com.brijframework.crm.dto.UISupplier;
import com.brijframework.crm.dto.UISupplierDetail;
import com.brijframework.crm.entities.EOCustBusinessApp;
import com.brijframework.crm.entities.EOSupplier;
import com.brijframework.crm.mapper.SupplierDetailMapper;
import com.brijframework.crm.mapper.SupplierMapper;
import com.brijframework.crm.repository.CustBusinessAppRepository;
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
	private CustBusinessAppRepository custBusinessAppRepository; 
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@Override
	public UISupplier saveSupplier(Long custAppId, UISupplier uiSupplier) {
		EOSupplier eoSupplier=supplierMapper.mapToDAO(uiSupplier);
		EOCustBusinessApp eoCustBusinessApp = custBusinessAppRepository.findById(custAppId).orElseThrow(()-> new RuntimeException("Not fond app")) ;
		eoSupplier.setCustBusinessApp(eoCustBusinessApp);
		eoSupplier.setVendor(vendorRepository.getOne(eoCustBusinessApp.getCustId()));
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
		eoSupplier.setRecordState(RecordStatus.DACTIVETED.getStatus());
		supplierRepository.save(eoSupplier);
		return true;
	}

	@Override
	public List<UISupplier> getSupplierList(Long custAppId) {
		return supplierMapper.mapToDTO( supplierRepository.findByCustAppId(custAppId));
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
