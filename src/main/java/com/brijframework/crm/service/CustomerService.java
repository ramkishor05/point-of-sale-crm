package com.brijframework.crm.service;

import java.util.List;

import com.brijframework.crm.dto.UICustomer;
import com.brijframework.crm.dto.UICustomerDetail;

public interface CustomerService {

	UICustomer saveCustomer(Long id, UICustomer uiCustomer);

	UICustomer getCustomer(Long id);

	boolean deleteCustomer(Long id);

	List<UICustomer> getCustomerList(Long custAppId);

	UICustomerDetail getCustomerDetail(Long id);

	List<UICustomer> getCustomerList();
}
