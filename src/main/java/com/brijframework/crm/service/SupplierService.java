package com.brijframework.crm.service;

import java.util.List;

import com.brijframework.crm.dto.UISupplier;
import com.brijframework.crm.dto.UISupplierDetail;

public interface SupplierService {

	UISupplier saveSupplier(Long vendorId, UISupplier uiSupplier);

	List<UISupplier> getSupplierList(Long vendorId);

	boolean deleteSupplier(Long id);

	UISupplier getSupplier(Long id);

	UISupplierDetail getSupplierDetail(Long id);

	List<UISupplier> getSupplierList();


}
