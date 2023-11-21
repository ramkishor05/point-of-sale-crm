package com.brijframework.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.crm.dto.UIBusiness;
import com.brijframework.crm.dto.UIBusinessDetail;
import com.brijframework.crm.entities.EOBusiness;
import com.brijframework.crm.entities.EOVendor;
import com.brijframework.crm.mapper.BusinessDetailMapper;
import com.brijframework.crm.mapper.BusinessMapper;
import com.brijframework.crm.repository.BusinessRepository;
import com.brijframework.crm.repository.VendorRepository;
import com.brijframework.crm.service.BusinessService;

@Service
public class BusinessServiceImpl implements BusinessService {
	
	@Autowired
	private BusinessRepository businessRepository; 
	
	@Autowired
	private BusinessMapper  businessMapper;
	
	@Autowired
	private BusinessDetailMapper businessDetailMapper;
	
	@Autowired
	private VendorRepository vendorRepository; 
	
	@Override
	public UIBusiness saveBusiness(Long ownerId, UIBusiness uiBusiness) {
		EOBusiness eoBusiness=businessMapper.mapToDAO(uiBusiness);
		EOVendor eoVendor = vendorRepository.findById(ownerId).orElseThrow(()-> new RuntimeException("Not fond vendor")) ;
		eoBusiness.setVendor(eoVendor);
		eoBusiness=businessRepository.save(eoBusiness);
		return businessMapper.mapToDTO(eoBusiness);
	}

	@Override
	public UIBusiness getBusiness(Long id) {
		return businessMapper.mapToDTO( businessRepository.findById(id).orElseThrow(()-> new RuntimeException("Not fond")) );
	}

	@Override
	public boolean deleteBusiness(Long id) {
		EOBusiness eoBusiness = businessRepository.findById(id).orElseThrow(()-> new RuntimeException("Not fond")) ;
		
		eoBusiness.setRecordState(false);
		businessRepository.save(eoBusiness);
		return true;
	}

	@Override
	public List<UIBusiness> getBusinessList(Long vendorId) {
		return businessMapper.mapToDTO( businessRepository.findByVendorId(vendorId).orElse(new ArrayList<EOBusiness>()) );
	}
	
	@Override
	public List<UIBusiness> getBusinessList() {
		return businessMapper.mapToDTO( businessRepository.findAll() );
	}

	@Override
	public UIBusinessDetail getBusinessDetail(Long id) {
		return businessDetailMapper.mapToDTO( businessRepository.findById(id).orElseThrow(()-> new RuntimeException("Not fond")) );
	}

}
