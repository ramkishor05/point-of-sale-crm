package com.brijframework.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.crm.dto.GlobalCurrencyItemRequest;
import com.brijframework.crm.dto.GlobalCurrencyItemResponse;
import com.brijframework.crm.entities.EOGlobalCurrencyItem;
import com.brijframework.crm.mapper.GlobalCurrencyItemRequestMapper;
import com.brijframework.crm.mapper.GlobalCurrencyItemResponseMapper;
import com.brijframework.crm.repository.GlobalCurrencyItemRepository;
import com.brijframework.crm.service.GlobalCurrencyItemService;

@Service
public class GlobalCurrencyItemServiceImpl implements GlobalCurrencyItemService {
	
	@Autowired
	private GlobalCurrencyItemRepository globalCurrencyItemRepository;
	
	@Autowired
	private GlobalCurrencyItemRequestMapper globalCurrencyItemRequestMapper;
	
	@Autowired
	private GlobalCurrencyItemResponseMapper globalCurrencyItemResponseMapper;

	@Override
	public GlobalCurrencyItemResponse saveCurrencyItem(GlobalCurrencyItemRequest uiGlobalCurrencyItem) {
		EOGlobalCurrencyItem eoGlobalCurrencyItem = globalCurrencyItemRequestMapper.mapToDAO(uiGlobalCurrencyItem);
		eoGlobalCurrencyItem=globalCurrencyItemRepository.saveAndFlush(eoGlobalCurrencyItem);
		return globalCurrencyItemResponseMapper.mapToDTO(eoGlobalCurrencyItem);
	}

	@Override
	public GlobalCurrencyItemResponse getCurrencyItem(Long id) {
	    return globalCurrencyItemResponseMapper.mapToDTO(globalCurrencyItemRepository.findById(id).orElse(null));
	}

	@Override
	public List<GlobalCurrencyItemResponse> getCurrencyItemList() {
		return globalCurrencyItemResponseMapper.mapToDTO(globalCurrencyItemRepository.findAll());
	}

	@Override
	public List<GlobalCurrencyItemResponse> findAllByType(String typeId) {
		return globalCurrencyItemResponseMapper.mapToDTO(globalCurrencyItemRepository.findOneByTypeId(typeId));
	}
	
	@Override
	public boolean deleteCurrencyItem(Long id) {
		globalCurrencyItemRepository.deleteById(id);
		return true;
	}

}
