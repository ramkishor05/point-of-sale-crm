package com.brijframework.production.inventory.service.cust;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.production.cust.dto.UICustStorage;
import com.brijframework.production.cust.entities.EOCustProductionApp;
import com.brijframework.production.cust.entities.EOCustStorage;
import com.brijframework.production.cust.mapper.CustStorageMapper;
import com.brijframework.production.cust.repository.CustProductionAppRepository;
import com.brijframework.production.cust.repository.CustStorageRepository;

@Service
public class CustStorageServiceImpl implements CustStorageService {
	
	@Autowired
	CustProductionAppRepository inventoryApplicationRepository;
	
	@Autowired
	CustStorageRepository inventoryStorageRepository;
	
	@Autowired
	CustStorageMapper inventoryStorageMapper;
	
	@Override
	public UICustStorage saveStorage(long inventoryAppId, UICustStorage Storage) {
		Optional<EOCustProductionApp> findById = inventoryApplicationRepository.findById(inventoryAppId);
		if(!findById.isPresent()) {
			return null;
		}
		return saveStorage(findById.get(), Storage);
	}
	
	@Override
	public UICustStorage saveStorage(UICustStorage Storage) {
		Optional<EOCustProductionApp> findById = inventoryApplicationRepository.findById(Storage.getCustProductionAppId());
		if(!findById.isPresent()) {
			return null;
		}
		return saveStorage(findById.get(), Storage);
	}
	
	@Override
	public UICustStorage saveStorage(EOCustProductionApp eoInventoryApp,UICustStorage Storage) {
		EOCustStorage eoStorage=inventoryStorageMapper.mapToDAO(Storage);
		inventoryStorageRepository.save(eoStorage);
		return inventoryStorageMapper.mapToDTO(eoStorage);
	}

	@Override
	public UICustStorage getStorage(long id) {
		return inventoryStorageMapper.mapToDTO(inventoryStorageRepository.getOne(id));
	}

	@Override
	public List<UICustStorage> getStorageList(long inventoryAppId) {
		return inventoryStorageMapper.mapToDTO(inventoryStorageRepository.findAllByCustProductionAppId(inventoryAppId));
	}
	
	@Override
	public UICustStorage getStorage(long inventoryAppId,String typeId) {
		return inventoryStorageMapper.mapToDTO(inventoryStorageRepository.findByCustProductionAppIdAndTypeId(inventoryAppId, typeId));
	}

}
