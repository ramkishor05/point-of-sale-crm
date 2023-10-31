package com.brijframework.crm.service;

import java.util.List;

import com.brijframework.crm.dto.UIEmployee;
import com.brijframework.crm.dto.UIEmployeeDetail;

public interface EmployeeService {

	UIEmployee saveEmployee(Long id, UIEmployee uiEmployee);

	UIEmployee getEmployee(Long id);

	boolean deleteEmployee(Long id);

	List<UIEmployee> getEmployeeList(Long vendorId);

	UIEmployeeDetail getEmployeeDetail(Long id);

	List<UIEmployee> getEmployeeList();
}
