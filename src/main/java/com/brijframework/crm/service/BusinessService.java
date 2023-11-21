package com.brijframework.crm.service;

import java.util.List;

import com.brijframework.crm.dto.UIBusiness;
import com.brijframework.crm.dto.UIBusinessDetail;

public interface BusinessService {

	UIBusiness saveBusiness(Long ownerId, UIBusiness uiBusiness);

	UIBusiness getBusiness(Long id);

	boolean deleteBusiness(Long id);

	List<UIBusiness> getBusinessList(Long ownerId);

	UIBusinessDetail getBusinessDetail(Long id);

	List<UIBusiness> getBusinessList();
}
