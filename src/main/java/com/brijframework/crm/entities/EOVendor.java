package com.brijframework.crm.entities;

import static com.brijframework.crm.contants.Constants.EMAIL_ADDRESS;
import static com.brijframework.crm.contants.Constants.EOVENDOR;
import static com.brijframework.crm.contants.Constants.MOBILE_NUMBER;
import static com.brijframework.crm.contants.Constants.NAME;
import static com.brijframework.crm.contants.Constants.PERMAMENT_ADDRESS;
import static com.brijframework.crm.contants.Constants.PHONE_NUMBER;
import static com.brijframework.crm.contants.Constants.PRESENT_ADDRESS;
import static com.brijframework.crm.contants.Constants.VENDOR;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOVENDOR)
public class EOVendor extends EOCrmObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = NAME)
	private String name;

	@Column(name = PHONE_NUMBER)
	private String phoneNumber;

	@Column(name = MOBILE_NUMBER)
	private String mobileNumber;

	@Column(name = EMAIL_ADDRESS)
	private String emailAddress;

	@Column(name = PERMAMENT_ADDRESS)
	@Lob
	private String permamentAddress;

	@Column(name = PRESENT_ADDRESS)
	@Lob
	private String presentAddress;
	
	@OneToMany(mappedBy = VENDOR)
	private List<EOEmployee> employeeList;
	
	@OneToMany(mappedBy = VENDOR)
	private List<EOSupplier> supplierList;

	@OneToMany(mappedBy = VENDOR)
	private List<EOCustomer> customerList;

	@OneToMany(mappedBy = VENDOR)
	private List<EOBusiness> businessList;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPermamentAddress() {
		return permamentAddress;
	}

	public void setPermamentAddress(String permamentAddress) {
		this.permamentAddress = permamentAddress;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public List<EOEmployee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<EOEmployee> employeeList) {
		this.employeeList = employeeList;
	}

	public List<EOSupplier> getSupplierList() {
		return supplierList;
	}

	public void setSupplierList(List<EOSupplier> supplierList) {
		this.supplierList = supplierList;
	}

	public List<EOCustomer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<EOCustomer> customerList) {
		this.customerList = customerList;
	}

	public List<EOBusiness> getBusinessList() {
		return businessList;
	}

	public void setBusinessList(List<EOBusiness> businessList) {
		this.businessList = businessList;
	}

}
