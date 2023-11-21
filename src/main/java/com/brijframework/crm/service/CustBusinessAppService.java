package com.brijframework.crm.service;

import java.util.List;

import com.brijframework.crm.dto.UICustBusinessApp;
import com.brijframework.crm.dto.UICustBusinessAppDetail;

public interface CustBusinessAppService {

	UICustBusinessApp saveCustBusinessApp(UICustBusinessApp inventory);

	UICustBusinessApp getCustBusinessApp(long id);

	boolean deleteCustBusinessApp(long id);

	List<UICustBusinessApp> getCustBusinessAppList();

	UICustBusinessAppDetail getCustBusinessAppDetail(long id);
}
