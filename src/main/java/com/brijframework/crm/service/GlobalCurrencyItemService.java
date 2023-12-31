package com.brijframework.crm.service;

import java.util.List;

import com.brijframework.crm.dto.GlobalCurrencyItemRequest;
import com.brijframework.crm.dto.GlobalCurrencyItemResponse;


public interface GlobalCurrencyItemService {

	GlobalCurrencyItemResponse saveCurrencyItem(GlobalCurrencyItemRequest globalCurrencyItemRequest);

	GlobalCurrencyItemResponse getCurrencyItem(Long id);

	List<GlobalCurrencyItemResponse> getCurrencyItemList();

	List<GlobalCurrencyItemResponse> findAllByType(String typeId);

	boolean deleteCurrencyItem(Long id);

}
