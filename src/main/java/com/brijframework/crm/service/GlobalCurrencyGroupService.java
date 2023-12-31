package com.brijframework.crm.service;

import java.util.List;

import com.brijframework.crm.contants.RecordStatus;
import com.brijframework.crm.dto.UIGlobalCurrencyGroup;

public interface GlobalCurrencyGroupService {

	UIGlobalCurrencyGroup saveCurrencyGroup(UIGlobalCurrencyGroup unitGroup);

	UIGlobalCurrencyGroup getCurrencyGroup(long id);

	List<UIGlobalCurrencyGroup> getCurrencyGroupList();

	List<UIGlobalCurrencyGroup> getCurrencyGroup( String typeId);

	List<UIGlobalCurrencyGroup> getCurrencyGroupList(RecordStatus dataStatus);

	boolean deleteCurrencyGroup(Long id);

}
