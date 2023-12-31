package com.brijframework.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.crm.contants.RecordStatus;
import com.brijframework.crm.dto.UIGlobalCountry;
import com.brijframework.crm.entities.EOGlobalCountry;
import com.brijframework.crm.mapper.GlobalCountryMapper;
import com.brijframework.crm.repository.GlobalCountryRepository;
import com.brijframework.crm.service.GlobalCountryService;

@Service
public class GlobalCountryServiceImpl implements GlobalCountryService {
	
	@Autowired
	private GlobalCountryRepository globalCountryRepository;
	
	@Autowired
	private GlobalCountryMapper inventoryCountryMapper;
	
	@Override
	public UIGlobalCountry saveCountry(UIGlobalCountry unitGroup) {
		EOGlobalCountry eoCountry=inventoryCountryMapper.mapToDAO(unitGroup);
		globalCountryRepository.save(eoCountry);
		return inventoryCountryMapper.mapToDTO(eoCountry);
	}

	@Override
	public UIGlobalCountry getCountry(long id) {
		return inventoryCountryMapper.mapToDTO(globalCountryRepository.getOne(id));
	}

	@Override
	public List<UIGlobalCountry> getCountryList() {
		return inventoryCountryMapper.mapToDTO(globalCountryRepository.findAll());
	}
	
	@Override
	public List<UIGlobalCountry> getCountryList(RecordStatus dataStatus) {
		List<EOGlobalCountry> findAllByStatus = globalCountryRepository.getCountryListByStatus(dataStatus.getStatusIds());
		return inventoryCountryMapper.mapToDTO(findAllByStatus);
	}

	@Override
	public boolean deleteCountry(Long id) {
		EOGlobalCountry eoGlobalCountry = globalCountryRepository.getOne(id);
		eoGlobalCountry.setRecordState(RecordStatus.DACTIVETED.getStatus());
		globalCountryRepository.save(eoGlobalCountry);
		return true;
	}

}
