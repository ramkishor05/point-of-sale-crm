package com.brijframework.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.crm.dto.UICustomer;
import com.brijframework.crm.dto.UICustomerDetail;
import com.brijframework.crm.entities.EOCustBusinessApp;
import com.brijframework.crm.entities.EOCustomer;
import com.brijframework.crm.mapper.CustomerDetailMapper;
import com.brijframework.crm.mapper.CustomerMapper;
import com.brijframework.crm.repository.CustBusinessAppRepository;
import com.brijframework.crm.repository.CustomerRepository;
import com.brijframework.crm.repository.VendorRepository;
import com.brijframework.crm.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private VendorRepository vendorRepository; 
	
	@Autowired
	private CustomerMapper  customerMapper;
	
	@Autowired
	private CustomerDetailMapper customerDetailMapper;
	
	@Autowired
	private CustBusinessAppRepository custBusinessAppRepository;
	
	@Override
	public UICustomer saveCustomer(Long custAppId, UICustomer uiCustomer) {
		EOCustomer eoCustomer=customerMapper.mapToDAO(uiCustomer);
		EOCustBusinessApp eoCustBusinessApp = custBusinessAppRepository.findById(custAppId).orElseThrow(()-> new RuntimeException("Not fond app")) ;
		eoCustomer.setCustBusinessApp(eoCustBusinessApp);
		eoCustomer.setVendor(vendorRepository.getOne(eoCustBusinessApp.getCustId()));
		customerRepository.save(eoCustomer);
		return customerMapper.mapToDTO(eoCustomer);
	}

	@Override
	public UICustomer getCustomer(Long id) {
		return customerMapper.mapToDTO( customerRepository.findById(id).orElseThrow(()-> new RuntimeException("Not fond")) );
	}

	@Override
	public boolean deleteCustomer(Long id) {
		EOCustomer eoCustomer = customerRepository.findById(id).orElseThrow(()-> new RuntimeException("Not fond")) ;
		eoCustomer.setRecordState(false);
		customerRepository.save(eoCustomer);
		return true;
	}

	@Override
	public List<UICustomer> getCustomerList(Long custAppId) {
		return customerMapper.mapToDTO( customerRepository.findByCustAppId(custAppId).orElse(new ArrayList<EOCustomer>()));
	}
	
	@Override
	public List<UICustomer> getCustomerList() {
		return customerMapper.mapToDTO( customerRepository.findAll() );
	}

	@Override
	public UICustomerDetail getCustomerDetail(Long id) {
		return customerDetailMapper.mapToDTO( customerRepository.findById(id).orElseThrow(()-> new RuntimeException("Not fond")) );
	}

}
