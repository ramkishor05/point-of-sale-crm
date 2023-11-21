package com.brijframework.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.crm.dto.UICustBusinessApp;
import com.brijframework.crm.dto.UICustBusinessAppDetail;
import com.brijframework.crm.entities.EOCustBusinessApp;
import com.brijframework.crm.mapper.CustBusinessAppDetailMapper;
import com.brijframework.crm.mapper.CustBusinessAppMapper;
import com.brijframework.crm.repository.CustBusinessAppRepository;
import com.brijframework.crm.service.CustBusinessAppService;

@Service
public class CustBusinessAppServiceImpl implements CustBusinessAppService {
	
	@Autowired
	private CustBusinessAppRepository custBusinessAppRepository;
	
	@Autowired
	private CustBusinessAppMapper  custBusinessAppMapper;
	
	@Autowired
	private CustBusinessAppDetailMapper custBusinessAppDetailMapper;
	
	@Override
	public UICustBusinessApp saveCustBusinessApp(UICustBusinessApp uiCustBusinessApp) {
		EOCustBusinessApp eoCustBusinessApp=custBusinessAppRepository.findByCustIdAndAppIdAndBusinessId(uiCustBusinessApp.getCustId(), uiCustBusinessApp.getAppId(),uiCustBusinessApp.getBusinessId()).orElse(new EOCustBusinessApp());
		eoCustBusinessApp.setAppId(uiCustBusinessApp.getAppId());
		eoCustBusinessApp.setCustId(uiCustBusinessApp.getCustId());
		eoCustBusinessApp.setBusinessId(uiCustBusinessApp.getBusinessId());
		custBusinessAppRepository.save(eoCustBusinessApp);
		return custBusinessAppMapper.mapToDTO(eoCustBusinessApp);
	}

	@Override
	public UICustBusinessApp getCustBusinessApp(long id) {
		return custBusinessAppMapper.mapToDTO( custBusinessAppRepository.findById(id).orElseThrow(()-> new RuntimeException("Not fond")) );
	}

	@Override
	public boolean deleteCustBusinessApp(long id) {
		return false;
	}

	@Override
	public List<UICustBusinessApp> getCustBusinessAppList() {
		return null;
	}

	@Override
	public UICustBusinessAppDetail getCustBusinessAppDetail(long id) {
		return custBusinessAppDetailMapper.mapToDTO( custBusinessAppRepository.findById(id).orElseThrow(()-> new RuntimeException("Not fond")) );

	}
}
