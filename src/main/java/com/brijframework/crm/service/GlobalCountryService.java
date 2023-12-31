package com.brijframework.crm.service;

import java.util.List;

import com.brijframework.crm.contants.RecordStatus;
import com.brijframework.crm.dto.UIGlobalCountry;

public interface GlobalCountryService {

	UIGlobalCountry saveCountry(UIGlobalCountry unitGroup);

	UIGlobalCountry getCountry(long id);

	List<UIGlobalCountry> getCountryList();

	List<UIGlobalCountry> getCountryList(RecordStatus dataStatus);

	boolean deleteCountry(Long id);

}
