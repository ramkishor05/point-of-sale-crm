package com.brijframework.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.crm.contants.RecordStatus;
import com.brijframework.crm.dto.UIVendor;
import com.brijframework.crm.dto.UIVendorDetail;
import com.brijframework.crm.entities.EOVendor;
import com.brijframework.crm.mapper.VendorDetailMapper;
import com.brijframework.crm.mapper.VendorMapper;
import com.brijframework.crm.repository.VendorRepository;
import com.brijframework.crm.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService {
	
	@Autowired
	private VendorRepository vendorRepository; 
	
	@Autowired
	private VendorMapper  vendorMapper;
	
	@Autowired
	private VendorDetailMapper vendorDetailMapper;
	
	@Override
	public UIVendor saveVendor(UIVendor uiVendor) {
		EOVendor eoVendor=vendorMapper.mapToDAO(uiVendor);
		eoVendor=vendorRepository.save(eoVendor);
		return vendorMapper.mapToDTO(eoVendor);
	}

	@Override
	public UIVendor getVendor(Long id) {
		return vendorMapper.mapToDTO( vendorRepository.findById(id).orElseThrow(()-> new RuntimeException("Not fond")) );
	}

	@Override
	public boolean deleteVendor(Long id) {
		EOVendor eoVendor = vendorRepository.findById(id).orElseThrow(()-> new RuntimeException("Not fond")) ;
		eoVendor.setRecordState(RecordStatus.DACTIVETED.getStatus());
		vendorRepository.save(eoVendor);
		return true;
	}

	@Override
	public List<UIVendor> getVendorList() {
		return vendorMapper.mapToDTO( vendorRepository.findAll() );
	}

	@Override
	public UIVendorDetail getVendorDetail(Long id) {
		return vendorDetailMapper.mapToDTO( vendorRepository.findById(id).orElseThrow(()-> new RuntimeException("Not fond")) );
	}

}
