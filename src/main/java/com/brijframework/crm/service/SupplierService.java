package com.brijframework.crm.service;

import java.util.List;

import com.brijframework.crm.dto.UISupplier;
import com.brijframework.crm.dto.UISupplierDetail;

public interface SupplierService {

	UISupplier saveSupplier(Long custAppId, UISupplier uiSupplier);

	List<UISupplier> getSupplierList(Long custAppId);

	boolean deleteSupplier(Long id);

	UISupplier getSupplier(Long id);

	UISupplierDetail getSupplierDetail(Long id);

	List<UISupplier> getSupplierList();


}
