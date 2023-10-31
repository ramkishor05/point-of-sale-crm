package com.brijframework.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.crm.dto.UIEmployee;
import com.brijframework.crm.dto.UIEmployeeDetail;
import com.brijframework.crm.entities.EOEmployee;
import com.brijframework.crm.entities.EOVendor;
import com.brijframework.crm.mapper.EmployeeDetailMapper;
import com.brijframework.crm.mapper.EmployeeMapper;
import com.brijframework.crm.repository.EmployeeRepository;
import com.brijframework.crm.repository.VendorRepository;
import com.brijframework.crm.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private VendorRepository vendorRepository; 
	
	@Autowired
	private EmployeeMapper  employeeMapper;
	
	@Autowired
	private EmployeeDetailMapper employeeDetailMapper;
	
	@Override
	public UIEmployee saveEmployee(Long vendorId, UIEmployee uiEmployee) {
		EOEmployee eoEmployee=employeeMapper.mapToDAO(uiEmployee);
		EOVendor eoVendor = vendorRepository.findById(vendorId).orElseThrow(()-> new RuntimeException("Not fond vendor")) ;
		eoEmployee.setVendor(eoVendor);
		employeeRepository.save(eoEmployee);
		return employeeMapper.mapToDTO(eoEmployee);
	}

	@Override
	public UIEmployee getEmployee(Long id) {
		return employeeMapper.mapToDTO( employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Not fond")) );
	}

	@Override
	public boolean deleteEmployee(Long id) {
		EOEmployee eoEmployee = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Not fond")) ;
		eoEmployee.setRecordState(false);
		employeeRepository.save(eoEmployee);
		return true;
	}

	@Override
	public List<UIEmployee> getEmployeeList(Long vendorId) {
		return employeeMapper.mapToDTO( employeeRepository.findByVendorId(vendorId).orElse(new ArrayList<EOEmployee>()));
	}
	
	@Override
	public List<UIEmployee> getEmployeeList() {
		return employeeMapper.mapToDTO( employeeRepository.findAll() );
	}

	@Override
	public UIEmployeeDetail getEmployeeDetail(Long id) {
		return employeeDetailMapper.mapToDTO( employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Not fond")) );
	}

}
