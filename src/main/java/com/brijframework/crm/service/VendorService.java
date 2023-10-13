package com.brijframework.crm.service;

import java.util.List;

import com.brijframework.crm.dto.UIVendor;
import com.brijframework.crm.dto.UIVendorDetail;

public interface VendorService {

	UIVendor saveVendor(UIVendor uiVendor);

	UIVendor getVendor(Long id);

	boolean deleteVendor(Long id);

	List<UIVendor> getVendorList();

	UIVendorDetail getVendorDetail(Long id);
}
