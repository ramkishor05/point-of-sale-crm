package com.brijframework.crm.entities;

import static com.brijframework.crm.contants.Constants.APP_ID;
import static com.brijframework.crm.contants.Constants.BUSINESS_ID;
import static com.brijframework.crm.contants.Constants.CUST_ID;
import static com.brijframework.crm.contants.Constants.CUST_BUSINESS_APP;
import static com.brijframework.crm.contants.Constants.EOCUST_BUSINESS_APP;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_BUSINESS_APP, uniqueConstraints = {
		@UniqueConstraint(columnNames = { APP_ID, CUST_ID, BUSINESS_ID }) })
public class EOCustBusinessApp extends EOCustObject {

	private static final long serialVersionUID = 1L;

	@Column(name = APP_ID, nullable = false)
	private long appId;

	@Column(name = CUST_ID, nullable = false)
	private long custId;

	@Column(name = BUSINESS_ID, nullable = false)
	private long businessId;

	@OneToMany(mappedBy = CUST_BUSINESS_APP)
	public Set<EOCustomer> customerList;

	@OneToMany(mappedBy = CUST_BUSINESS_APP)
	public Set<EOSupplier> supplierList;

	@OneToMany(mappedBy = CUST_BUSINESS_APP)
	public Set<EOEmployee> employeeList;

	public long getAppId() {
		return appId;
	}

	public void setAppId(long appId) {
		this.appId = appId;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(long businessId) {
		this.businessId = businessId;
	}

	public Set<EOCustomer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(Set<EOCustomer> customerList) {
		this.customerList = customerList;
	}

	public Set<EOSupplier> getSupplierList() {
		return supplierList;
	}

	public void setSupplierList(Set<EOSupplier> supplierList) {
		this.supplierList = supplierList;
	}

	public Set<EOEmployee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(Set<EOEmployee> employeeList) {
		this.employeeList = employeeList;
	}

}
